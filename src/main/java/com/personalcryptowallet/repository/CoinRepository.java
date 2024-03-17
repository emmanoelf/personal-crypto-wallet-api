package com.personalcryptowallet.repository;

import com.personalcryptowallet.model.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CoinRepository extends JpaRepository<Coin, UUID> {
}
