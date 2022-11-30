CREATE TABLE book(
    id        bigint(20) NOT NULL AUTO_INCREMENT,
    isbn      varchar(255) DEFAULT NULL,
    publisher varchar(255) DEFAULT NULL,
    title     varchar(250) DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE = INNODB;

