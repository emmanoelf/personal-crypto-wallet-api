CREATE TABLE wallet(
    id VARCHAR(36) NOT NULL,
    name VARCHAR(70) NOT NULL,
    balance DECIMAL (10,2) NOT NULL,
    totalContribuition DECIMAL (10,2) NOT NULL,
    profitAndLose DECIMAL (10,2) NOT NULL,
    user_id VARCHAR(36) NOT NULL,

    PRIMARY KEY (id),
    CONSTRAINT fk_user_wallet FOREIGN KEY (user_id) REFERENCES user(id)
) engine=InnoDB DEFAULT charset=utf8