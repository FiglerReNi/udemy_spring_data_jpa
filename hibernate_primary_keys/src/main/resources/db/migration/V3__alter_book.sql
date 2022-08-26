ALTER TABLE book
    ADD author_id BIGINT NOT NULL;

ALTER TABLE book
    ADD CONSTRAINT fk_author_id_book
        FOREIGN KEY (author_id)
            REFERENCES author (id);
