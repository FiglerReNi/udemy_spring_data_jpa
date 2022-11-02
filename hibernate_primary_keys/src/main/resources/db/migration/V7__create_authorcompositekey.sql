CREATE TABLE author_composite_key (
                                    first_name varchar(255) NOT NULL,
                                    last_name varchar(255) NOT NULL,
                                    title varchar(255) DEFAULT NULL,
                                    PRIMARY KEY (first_name, last_name)
)ENGINE = INNODB;
