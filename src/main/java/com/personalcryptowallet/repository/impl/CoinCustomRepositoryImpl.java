package com.personalcryptowallet.repository.impl;

import com.personalcryptowallet.model.Coin;
import com.personalcryptowallet.model.Wallet;
import com.personalcryptowallet.model.projection.PortfolioSummaryProjection;
import com.personalcryptowallet.repository.CoinCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class CoinCustomRepositoryImpl implements CoinCustomRepository {
    private final EntityManager entityManager;

    public List<PortfolioSummaryProjection> findPortfolioSummary(UUID walletId){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PortfolioSummaryProjection> cq = cb.createQuery(PortfolioSummaryProjection.class);

        Root<Coin> coin = cq.from(Coin.class);
        Join<Coin, Wallet> walletJoin = coin.join("wallet");

        cq.where(cb.equal(walletJoin.get("id"), walletId));
        cq.groupBy(coin.get("idCoinMarketCap"), coin.get("slug"));

        cq.select(cb.construct(
                PortfolioSummaryProjection.class,
                coin.get("idCoinMarketCap"),
                coin.get("slug"),
                cb.sum(coin.get("quantity")),
                cb.sum(coin.get("contributionValue")),
                cb.avg(coin.get("price")).as(BigDecimal.class)
        ));

        TypedQuery<PortfolioSummaryProjection> query = entityManager.createQuery(cq);
        return query.getResultList();
    }
}
