ALTER TABLE user COMMENT = 'Table user';
ALTER TABLE user MODIFY id VARCHAR(36) COMMENT 'Primary key of table user';
ALTER TABLE user MODIFY email VARCHAR(100) COMMENT 'Email of user';
ALTER TABLE user MODIFY password VARCHAR(50) COMMENT 'Password of user';

ALTER TABLE coin COMMENT = 'Table coin';
ALTER TABLE coin MODIFY id VARCHAR(36) COMMENT 'Primary key of table coin';
ALTER TABLE coin MODIFY id_coin_market_cap BIGINT COMMENT 'Coin id in search api';
ALTER TABLE coin MODIFY slug VARCHAR(30) COMMENT 'Coin name separated by dash if compound';
ALTER TABLE coin MODIFY symbol VARCHAR(15) COMMENT 'Coin symbol';
ALTER TABLE coin MODIFY price DECIMAL(10,2) COMMENT 'Coin price at the time of the search or at the time the user paid';
ALTER TABLE coin MODIFY quantity DECIMAL(12,8) COMMENT 'Number of coins purchased with the value stated';
ALTER TABLE coin MODIFY date_contribution DATETIME COMMENT 'Purchase date';
ALTER TABLE coin MODIFY broker_fee DECIMAL(10,2) COMMENT 'Fee paid by the centralized or decentralized broker at the time of purchase';

ALTER TABLE wallet COMMENT = 'Table wallet';
ALTER TABLE wallet MODIFY id VARCHAR(36) COMMENT 'Primary key of table wallet';
ALTER TABLE wallet MODIFY name VARCHAR(70) COMMENT 'Name of wallet';
ALTER TABLE wallet MODIFY balance DECIMAL(10,2) COMMENT 'Current balance value of all coins';
ALTER TABLE wallet MODIFY total_contribuition DECIMAL(10,2) COMMENT 'Total amount invested';
ALTER TABLE wallet MODIFY profit_and_lose DECIMAL(10,2) COMMENT 'Current profit or loss';
ALTER TABLE wallet MODIFY user_id VARCHAR(36) COMMENT 'Foreign key with table user';

ALTER TABLE wallet_coin COMMENT = 'Table wallet_coin';
ALTER TABLE wallet_coin MODIFY coin_id VARCHAR(36) COMMENT 'Primary key of table coin_wallet and foreign key from table coin';
ALTER TABLE wallet_coin MODIFY wallet_id VARCHAR(36) COMMENT 'Primary key of table coin_wallet and Foreign key with table wallet';