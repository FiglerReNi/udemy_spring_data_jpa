package hu.hibernate_primary_keys.bootstrap;

import hu.hibernate_primary_keys.domain.Author;
import hu.hibernate_primary_keys.domain.AuthorNaturalKey;
import hu.hibernate_primary_keys.domain.AuthorUuidBinary;
import hu.hibernate_primary_keys.domain.AuthorUuidString;
import hu.hibernate_primary_keys.domain.Book;
import hu.hibernate_primary_keys.domain.composite.AuthorCompositeKey;
import hu.hibernate_primary_keys.domain.composite.FirstNameAndLastName;
import hu.hibernate_primary_keys.repository.AuthorCompositeRepository;
import hu.hibernate_primary_keys.repository.AuthorNaturalKeyRepository;
import hu.hibernate_primary_keys.repository.AuthorRepository;
import hu.hibernate_primary_keys.repository.AuthorUuidBinaryRepository;
import hu.hibernate_primary_keys.repository.AuthorUuidStringRepository;
import hu.hibernate_primary_keys.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"local", "default"})
@Component
public class DataInitializer implements CommandLineRunner {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private AuthorUuidStringRepository authorUuidStringRepository;
    private AuthorUuidBinaryRepository authorUuidBinaryRepository;
    private AuthorNaturalKeyRepository authorNaturalKeyRepository;
    private AuthorCompositeRepository authorCompositeRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Autowired
    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @Autowired
    public void setAuthorUuidStringRepository(AuthorUuidStringRepository authorUuidStringRepository) {
        this.authorUuidStringRepository = authorUuidStringRepository;
    }
    @Autowired
    public void setAuthorUuidBinaryRepository(AuthorUuidBinaryRepository authorUuidBinaryRepository) {
        this.authorUuidBinaryRepository = authorUuidBinaryRepository;
    }
    @Autowired
    public void setAuthorNaturalKeyRepository(AuthorNaturalKeyRepository authorNaturalKeyRepository) {
        this.authorNaturalKeyRepository = authorNaturalKeyRepository;
    }
    @Autowired
    public void setAuthorCompositeRepository(AuthorCompositeRepository authorCompositeRepository) {
        this.authorCompositeRepository = authorCompositeRepository;
    }

    @Override
    public void run(String... args) {
        bookRepository.deleteAll();
        authorRepository.deleteAll();
        Author authorOne = Author.builder().firstName("Author").lastName("One").build();
        authorRepository.save(authorOne);
        Author authorTwo = Author.builder().firstName("Author").lastName("Two").build();
        authorRepository.save(authorTwo);
        Author authorThree = Author.builder().firstName("Author").lastName("Three").build();
        authorRepository.save(authorThree);

        Book bookOne =
                Book.builder().title("Test One").isbn("111").publisher("Author One").author(authorRepository.findByLastName("One")).build();
        System.out.println(bookOne.getId());
        Book bookOneSaved = bookRepository.save(bookOne);
        System.out.println(bookOneSaved.getId());
        System.out.println("--------------------------");

        Book bookTwo =
                Book.builder().title("Test Two").isbn("222").publisher("Author Two").author(authorRepository.findByLastName("Two")).build();
        bookRepository.save(bookTwo);

        bookRepository.findAll().forEach(b -> {
                    System.out.println(b.getId());
                    System.out.println(b.getTitle());
                    System.out.println(b.getIsbn());
                    System.out.println(b.getPublisher());
                    System.out.println("--------------------------");
                }
        );

        AuthorUuidString authorUuidString = AuthorUuidString.builder().firstName("Author").lastName("One").build();
        AuthorUuidString savedAuthorUuidString = authorUuidStringRepository.save(authorUuidString);
        System.out.println(savedAuthorUuidString.getId());

        AuthorUuidBinary authorUuidBinary = AuthorUuidBinary.builder().firstName("Author").lastName("One").build();
        AuthorUuidBinary savedAuthorUuidBinary = authorUuidBinaryRepository.save(authorUuidBinary);
        System.out.println(savedAuthorUuidBinary.getId());

        AuthorNaturalKey authorNaturalKey = AuthorNaturalKey.builder().firstName("Author").lastName("One").build();
        AuthorNaturalKey savedAuthorNaturalKey = authorNaturalKeyRepository.save(authorNaturalKey);
        String savedAuthorIdNatural = savedAuthorNaturalKey.getFirstName();
        System.out.println(authorNaturalKeyRepository.existsById(savedAuthorIdNatural));

        FirstNameAndLastName firstNameAndLastName = FirstNameAndLastName.builder().firstName("Author").lastName("One").build();
        AuthorCompositeKey authorCompositeKey =
                AuthorCompositeKey.builder().firstName(firstNameAndLastName.getFirstName()).lastName(firstNameAndLastName.getLastName()).build();
        authorCompositeRepository.save(authorCompositeKey);
        System.out.println(authorCompositeRepository.existsById(firstNameAndLastName));
    }
}
