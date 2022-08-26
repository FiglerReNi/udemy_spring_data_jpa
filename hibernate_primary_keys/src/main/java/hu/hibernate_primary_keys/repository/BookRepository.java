package hu.hibernate_primary_keys.repository;

import hu.hibernate_primary_keys.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
