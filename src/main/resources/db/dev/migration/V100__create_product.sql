drop table if exists "product";

CREATE TABLE product
(
    "id"        integer primary key AUTOINCREMENT,
    name        VARCHAR(100)   NOT NULL,
    description TEXT,
    price       DECIMAL(10, 2) NOT NULL,
    type        VARCHAR(50)
);

