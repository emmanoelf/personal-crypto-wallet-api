package com.personalcryptowallet.repository;

import com.personalcryptowallet.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, UUID> {
    @Query("from Wallet where user.id = :userId")
    List<Wallet> findAllByUserId(UUID userId);

    Optional<Wallet> findByName(String name);
}
