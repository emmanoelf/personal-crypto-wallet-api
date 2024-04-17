set foreign_key_checks = 0;

delete from coin;
delete from user;

set foreign_key_checks = 1;

insert into coin (id, idCoinMarketCap, slug, symbol, price, quantity, dateContribution)
values('bad71db7-0028-49af-951c-a5695cf44df8', 1, 'bitcoin', 'BTC', 25391.49, 0.00122211, '2022-06-22T10:15:30');

insert into user(id, email, password) values ('f2558033-f618-4a9f-87e5-2e799b178808', 'test@test.com', '1234');