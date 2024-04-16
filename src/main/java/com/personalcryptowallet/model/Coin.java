package com.personalcryptowallet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID id;

    @Column(nullable = false)
    private Long idCoinMarketCap;

    @Column(nullable = false)
    private String slug;

    @Column(nullable = false)
    private String symbol;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private BigDecimal quantity;

    @Column(nullable = false)
    private LocalDateTime dateContribution;

    @Column(nullable = false)
    private BigDecimal brokerFee;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "wallet_coin",
            joinColumns = @JoinColumn(name = "coin_id"),
            inverseJoinColumns = @JoinColumn(name = "wallet_id"))
    private Set<Wallet> wallet = new HashSet<>();

}
