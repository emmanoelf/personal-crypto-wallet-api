package com.personalcryptowallet.service.impl;

import com.personalcryptowallet.client.CoinMarketCapClient;
import com.personalcryptowallet.dto.CoinDto;
import com.personalcryptowallet.dto.CoinResponseDto;
import com.personalcryptowallet.dto.PortfolioSummaryCoinDto;
import com.personalcryptowallet.dto.PortfolioSummaryDto;
import com.personalcryptowallet.dto.coinMarketCap.CoinMarketCapResponseDto;
import com.personalcryptowallet.mapper.CoinMapper;
import com.personalcryptowallet.model.Coin;
import com.personalcryptowallet.model.Wallet;
import com.personalcryptowallet.model.projection.PortfolioSummaryProjection;
import com.personalcryptowallet.repository.CoinRepository;
import com.personalcryptowallet.repository.WalletRepository;
import com.personalcryptowallet.service.CoinWalletService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CoinWalletServiceImpl implements CoinWalletService {

    private final CoinMarketCapClient coinMarketCapClient;
    private final CoinRepository coinRepository;
    private final WalletRepository walletRepository;

    @Override
    public CoinMarketCapResponseDto getCoin(String slug) {
        return this.coinMarketCapClient.getCoin(slug);
    }

    @Override
    public CoinResponseDto addCoin(UUID walletId, CoinDto coinDto) {
        Coin coin = CoinMapper.toModel(coinDto);

        Wallet wallet = this.walletRepository.findWithoutCoin(walletId);
        coin.setWallet(Collections.singleton(wallet));

        Coin savedCoin = this.coinRepository.save(coin);

        return CoinMapper.toDto(savedCoin);
    }

    @Override
    public PortfolioSummaryDto showSummary(UUID walletId) {
        List<PortfolioSummaryProjection> portfolio = this.coinRepository.findPortfolioSummary(walletId);
        List<PortfolioSummaryCoinDto> portfolioSummaryCoins = new ArrayList<>();

        BigDecimal totalInvested = BigDecimal.ZERO;
        BigDecimal balance = BigDecimal.ZERO;
        BigDecimal profitOrLoss = BigDecimal.ZERO;

        for(PortfolioSummaryProjection portfolioSummaryProjection : portfolio){
            CoinMarketCapResponseDto coin = this.getCoin(portfolioSummaryProjection.slug());
            BigDecimal currentCoinPrice = coin.getData().get(0).getQuote().getUsd().getPrice();

            totalInvested = totalInvested.add(portfolioSummaryProjection.totalInvested());

            balance = balance.add(this.calculateBalance(
                    currentCoinPrice,
                    portfolioSummaryProjection.totalQuantity(),
                    portfolioSummaryProjection.totalInvested()
            ));

            profitOrLoss = profitOrLoss.add(this.calculateProfitOrLoss(
                    portfolioSummaryProjection.totalQuantity(),
                    currentCoinPrice,
                    portfolioSummaryProjection.totalInvested()
            ));

            BigDecimal current = this.calculateProfitOrLoss(
                    portfolioSummaryProjection.totalQuantity(),
                    currentCoinPrice,
                    portfolioSummaryProjection.totalInvested()
            );

            PortfolioSummaryCoinDto summaryCoin = new PortfolioSummaryCoinDto(
                    portfolioSummaryProjection.slug(),
                    currentCoinPrice,
                    this.calculateBalance(
                            currentCoinPrice,
                            portfolioSummaryProjection.totalQuantity(),
                            portfolioSummaryProjection.totalInvested()
                            ),
                    portfolioSummaryProjection.totalQuantity(),
                    portfolioSummaryProjection.totalInvested(),
                    portfolioSummaryProjection.averagePrice(),
                    current,
                    this.convertProfitOrLossToPercentage(current, portfolioSummaryProjection.totalInvested())
            );

            portfolioSummaryCoins.add(summaryCoin);
        }

        PortfolioSummaryDto summary = new PortfolioSummaryDto(
                totalInvested,
                balance,
                profitOrLoss,
                this.convertProfitOrLossToPercentage(profitOrLoss, totalInvested),
                portfolioSummaryCoins
        );

        return summary;
    }

    private BigDecimal calculateProfitOrLoss(BigDecimal totalQuantity, BigDecimal currentPrice, BigDecimal totalInvested){
        return (currentPrice.multiply(totalQuantity)).subtract(totalInvested).setScale(2, RoundingMode.CEILING);
    }

    private String convertProfitOrLossToPercentage(BigDecimal profitOrLoss, BigDecimal baseValue){
        BigDecimal ONE_HUNDRED = new BigDecimal(100);
        BigDecimal percentageValue = profitOrLoss.divide(baseValue,RoundingMode.CEILING).multiply(ONE_HUNDRED);
        return percentageValue.toString() + "%";
    }

    private BigDecimal calculateBalance(BigDecimal currentPriceCoin, BigDecimal totalQuantity, BigDecimal totalIntested){
        return currentPriceCoin.multiply(totalQuantity).add(totalIntested).setScale(2, RoundingMode.CEILING);
    }

}
