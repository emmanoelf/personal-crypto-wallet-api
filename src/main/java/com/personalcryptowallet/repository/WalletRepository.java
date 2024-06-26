package com.personalcryptowallet.repository;

import com.personalcryptowallet.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, UUID> {
    Optional<Wallet> findByNameAndUserId(String name, UUID userId);
    Optional<Wallet> findByIdAndUserId(UUID walletId, UUID userId);
    Long deleteWalletByIdAndUserId(UUID walletId, UUID userId);

    @Query("""
    select new Wallet(id, name, balance, totalContribuition, profitAndLose, user) from Wallet where id =:walletId
""")
    Wallet findWithoutCoin(@Param("walletId") UUID walletId);
}
