package hu.hibernatewithmysql.bootstrap;

import hu.hibernatewithmysql.domain.Book;
import hu.hibernatewithmysql.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"local", "developmysql", "developh2", "default"})
@Component
public class DataInitializer implements CommandLineRunner {

    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {

        bookRepository.deleteAll();
        Book bookOne = Book.builder().title("Test One").isbn("111").publisher("Author One").build();
        System.out.println(bookOne.getId());
        Book bookOneSaved = bookRepository.save(bookOne);
        System.out.println(bookOneSaved.getId());
        System.out.println("--------------------------");

        Book bookTwo = Book.builder().title("Test Two").isbn("222").publisher("Author Two").build();
        bookRepository.save(bookTwo);

        bookRepository.findAll().forEach(b -> {
                    System.out.println(b.getId());
                    System.out.println(b.getTitle());
                    System.out.println(b.getIsbn());
                    System.out.println(b.getPublisher());
                    System.out.println("--------------------------");
                }
        );
    }
}
