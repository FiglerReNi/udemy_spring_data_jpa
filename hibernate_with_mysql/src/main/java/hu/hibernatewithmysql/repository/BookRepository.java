package hu.hibernatewithmysql.repository;

import hu.hibernatewithmysql.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
