package com.personalcryptowallet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal balance;

    @Column(nullable = false)
    private BigDecimal totalContribuition;

    @Column(nullable = false)
    private BigDecimal profitAndLose;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany
    @JoinTable(name = "wallet_coin",
            joinColumns = @JoinColumn(name = "wallet_id"),
            inverseJoinColumns = @JoinColumn(name = "coin_id"))
    private Set<Coin> coins = new HashSet<>();

    @PrePersist
    private void defaultZero(){
        if(this.balance == null){
            this.balance = BigDecimal.ZERO;
        }
        if(this.totalContribuition == null){
            this.totalContribuition = BigDecimal.ZERO;
        }
        if(this.profitAndLose == null){
            this.profitAndLose = BigDecimal.ZERO;
        }
    }

}
