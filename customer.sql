CREATE DATABASE customers;

USE customers;

DROP TABLE customer;

CREATE TABLE IF NOT EXISTS customer (
	id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name_customer varchar(100) NOT NULL,
    address varchar(200)
);

SELECT * FROM customer;