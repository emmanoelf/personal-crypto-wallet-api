set foreign_key_checks = 0;

delete from coin;
delete from user;
delete from wallet;
delete from wallet_coin;

set foreign_key_checks = 1;

insert into coin (id, id_coin_market_cap, slug, symbol, price, contribution_value, quantity, date_contribution)
values('bad71db7-0028-49af-951c-a5695cf44df8', 1, 'bitcoin', 'BTC', 25391.49, 100.00, 0.00122211, '2022-06-22T10:15:30');

insert into coin (id, id_coin_market_cap, slug, symbol, price, contribution_value, quantity, date_contribution)
values('9a397bf5-4ec0-465b-8f28-853802ee4aee', 1027, 'ethereum', 'ETH', 1500.00, 600.00, 0.4, '2022-06-22T10:15:30');

insert into coin (id, id_coin_market_cap, slug, symbol, price, contribution_value, quantity, date_contribution)
values('71d61cae-46e0-491f-b7cb-b885175ec3bc', 1027, 'ethereum', 'ETH', 2998.54, 299.85, 0.1, '2022-06-22T10:15:30');

insert into user(id, email, password) values ('f2558033-f618-4a9f-87e5-2e799b178808', 'test@test.com', '1234');

insert into wallet (id, name, balance, total_contribuition, profit_and_lose, user_id)
values('b8a6e2cf-469a-48d9-9d47-6f5bbb2017a0', 'hold forever', 0, 0, 0, 'f2558033-f618-4a9f-87e5-2e799b178808');

insert into wallet_coin(coin_id, wallet_id) values ('bad71db7-0028-49af-951c-a5695cf44df8', 'b8a6e2cf-469a-48d9-9d47-6f5bbb2017a0');
insert into wallet_coin(coin_id, wallet_id) values ('9a397bf5-4ec0-465b-8f28-853802ee4aee', 'b8a6e2cf-469a-48d9-9d47-6f5bbb2017a0');
insert into wallet_coin(coin_id, wallet_id) values ('71d61cae-46e0-491f-b7cb-b885175ec3bc', 'b8a6e2cf-469a-48d9-9d47-6f5bbb2017a0');