CREATE TABLE coin(
    id varchar(36) not null,
    idCoinMarketCap bigint not null,
    slug varchar(30) not null,
    symbol varchar(15) not null,
    price decimal(10,2) not null,
    quantity decimal(12,8) not null,
    dateContribution datetime not null,
    brokerFee decimal(10,2),

    primary key (id)
) engine=InnoDB default charset=utf8