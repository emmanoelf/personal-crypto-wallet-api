set foreign_key_checks = 0;

delete from coin;

set foreign_key_checks = 1;

insert into coin (id, idCoinMarketCap, slug, symbol, price, quantity, dateContribution)
values('bad71db7-0028-49af-951c-a5695cf44df8', 1, 'bitcoin', 'BTC', 25391.49, 0.00122211, '2022-06-22T10:15:30');