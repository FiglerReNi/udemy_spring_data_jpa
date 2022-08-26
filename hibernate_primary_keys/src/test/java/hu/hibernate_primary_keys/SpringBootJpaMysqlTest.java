package hu.hibernate_primary_keys;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import hu.hibernate_primary_keys.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

//ez önmagában még nem elég, mert ugyan mysql-t fog használni a lekérdezéseknél, de a H2 adatbázisba próbálkozik a @DataJpaTest miatt
@ActiveProfiles("local")
//Ez mindig a H2 adatbázist használja, ki kell kapcsolnunk, ahhoz, hogy működjön a local properties és a mysql adatbázis működjön
@DataJpaTest
//Ezzel kapcsoljuk ki az automatikus H2 használatot
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan(basePackages = {"hu.hibernate_primary_keys.bootstrap"})
public class SpringBootJpaMysqlTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void testAmountOfBooks() {

        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);

    }
}
