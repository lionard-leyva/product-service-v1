CREATE SCHEMA IF NOT EXISTS productdb;

CREATE TABLE IF NOT EXISTS productdb.product(
                                   id SERIAL PRIMARY KEY,
                                   name VARCHAR(100) NOT NULL,
                                   description TEXT,
                                   price DECIMAL(10, 2) NOT NULL,
                                   final_price DECIMAL(10, 2),
                                   type VARCHAR(50)
);