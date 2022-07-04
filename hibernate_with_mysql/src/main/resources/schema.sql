DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS hibernate_sequence;

CREATE TABLE book (
id bigint(20) NOT NULL,
isbn varchar(255) DEFAULT NULL,
publisher varchar(255) DEFAULT NULL,
title varchar(250) DEFAULT NULL,
PRIMARY KEY (id)
)ENGINE = INNODB;

CREATE TABLE hibernate_sequence (
next_val bigint(20) DEFAULT NULL
)ENGINE = INNODB;

INSERT INTO hibernate_sequence values (1);

