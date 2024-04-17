CREATE TABLE user(
    id varchar(36) not null,
    email varchar(100) not null,
    password varchar(50) not null,

    PRIMARY KEY (id)
) engine=InnoDB DEFAULT charset=utf8