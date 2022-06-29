package hu.application;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import hu.application.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UdemySpringJpaApplicationTests {

    @Autowired
    BookRepository bookRepository;

    @Test
    void testBookRepository() {

        long count = bookRepository.count();
        assertThat(count).isGreaterThan(0);

    }

    @Test
    void contextLoads() {
    }

}
