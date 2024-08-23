CREATE SCHEMA IF NOT EXISTS productdb;
drop table if exists "product";

-- V100__create_product.sql
CREATE TABLE product
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(100)   NOT NULL,
    description TEXT,
    price       DECIMAL(10, 2) NOT NULL,
    type        VARCHAR(50)
);

