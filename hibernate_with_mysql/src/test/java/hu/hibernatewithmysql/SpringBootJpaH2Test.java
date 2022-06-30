package hu.hibernatewithmysql;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import hu.hibernatewithmysql.domain.Book;
import hu.hibernatewithmysql.repository.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
/*Ezzel az osztály csak az adatbázis műveletekhez szükséges contextet húzza be, ezért a
  DataInitializer osztályt nem, tehát az adatbázis üres lenne a teszteléskor*/
@DataJpaTest
/*Ezzel be lehet húzni más bean-eket is egyesével, amik az adott package osztályaiban vannak*/
@ComponentScan(basePackages = {"hu.hibernatewithmysql.bootstrap"})
public class SpringBootJpaH2Test {

    @Autowired
    BookRepository bookRepository;

    @Commit
    //@Rollback(value = false)
    @Order(1)
    @Test
    void testSaveNewBook() {

        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);
        bookRepository.save(Book.builder().title("Test Three").isbn("333").publisher("Author Three").build());
        long countAfter = bookRepository.count();
        assertThat(countBefore).isLessThan(countAfter);

    }

    @Order(2)
    @Test
    void testAmountOfBooks() {

        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(3);

    }
}
