CREATE TABLE coin(
    id varchar(36) not null,
    id_coin_market_cap bigint not null,
    slug varchar(30) not null,
    symbol varchar(15) not null,
    price decimal(10,2) not null,
    quantity decimal(12,8) not null,
    date_contribution datetime not null,
    broker_fee decimal(10,2),

    primary key (id)
) engine=InnoDB default charset=utf8