CREATE TABLE wallet_coin(
    coin_id VARCHAR(36) NOT NULL,
    wallet_id VARCHAR(36) NOT NULL,

    PRIMARY KEY (coin_id, wallet_id),

    CONSTRAINT fk_wallet_coin_coin_id FOREIGN KEY (coin_id) REFERENCES coin(id),
    CONSTRAINT fk_wallet_coin_wallet_id FOREIGN KEY (wallet_id) REFERENCES wallet(id)
)engine=InnoDB DEFAULT charset=utf8