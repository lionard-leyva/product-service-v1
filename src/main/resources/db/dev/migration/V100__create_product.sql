CREATE SCHEMA IF NOT EXISTS productdb;

CREATE TABLE productdb.product (
                                   id SERIAL PRIMARY KEY,
                                   name VARCHAR(100) NOT NULL,
                                   description TEXT,
                                   price DECIMAL(10, 2) NOT NULL,
                                   type VARCHAR(50)
);