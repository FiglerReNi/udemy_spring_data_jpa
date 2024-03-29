package hu.hibernate_primary_keys;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import hu.hibernate_primary_keys.domain.AuthorNaturalKey;
import hu.hibernate_primary_keys.domain.AuthorUuidBinary;
import hu.hibernate_primary_keys.domain.AuthorUuidString;
import hu.hibernate_primary_keys.domain.composite.AuthorCompositeKey;
import hu.hibernate_primary_keys.domain.composite.AuthorEmbeddedCompositeKey;
import hu.hibernate_primary_keys.domain.composite.FirstNameAndLastName;
import hu.hibernate_primary_keys.repository.AuthorCompositeRepository;
import hu.hibernate_primary_keys.repository.AuthorEmbeddedCompositeRepository;
import hu.hibernate_primary_keys.repository.AuthorNaturalKeyRepository;
import hu.hibernate_primary_keys.repository.AuthorUuidBinaryRepository;
import hu.hibernate_primary_keys.repository.AuthorUuidStringRepository;
import hu.hibernate_primary_keys.repository.BookRepository;
import org.junit.jupiter.api.Order;
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
    @Autowired
    AuthorUuidStringRepository authorUuidStringRepository;
    @Autowired
    AuthorUuidBinaryRepository authorUuidBinaryRepository;
    @Autowired
    AuthorNaturalKeyRepository authorNaturalKeyRepository;
    @Autowired
    AuthorCompositeRepository authorCompositeRepository;
    @Autowired
    AuthorEmbeddedCompositeRepository authorEmbeddedCompositeRepository;

    @Order(1)
    @Test
    void testAmountOfBooks() {

        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);

    }

    @Order(2)
    @Test
    void testSaveAuthorUuidString(){

       AuthorUuidString authorUuidString =
               authorUuidStringRepository.save(AuthorUuidString.builder().firstName("Author_Two").lastName("Two").build());
       assertThat(authorUuidString).isNotNull();
       assertThat(authorUuidString.getId()).isNotNull();

       AuthorUuidString authorUuidStringFromDb = authorUuidStringRepository.getReferenceById(authorUuidString.getId());
       assertThat(authorUuidStringFromDb).isNotNull();

    }

    @Order(3)
    @Test
    void testSaveAuthorUuidBinary(){

        AuthorUuidBinary authorUuidBinary =
                authorUuidBinaryRepository.save(AuthorUuidBinary.builder().firstName("Author_Two").lastName("Two").build());
        assertThat(authorUuidBinary).isNotNull();
        assertThat(authorUuidBinary.getId()).isNotNull();

        AuthorUuidBinary authorUuidBinaryFromDb = authorUuidBinaryRepository.getReferenceById(authorUuidBinary.getId());
        assertThat(authorUuidBinaryFromDb).isNotNull();

    }

    @Order(4)
    @Test
    void testSaveAuthorNaturalKey(){

        AuthorNaturalKey authorNaturalKey =
                authorNaturalKeyRepository.save(AuthorNaturalKey.builder().firstName("Author_Two").lastName("Two").build());
        AuthorNaturalKey authorNaturalKeyFromDb = authorNaturalKeyRepository.getReferenceById(authorNaturalKey.getFirstName());
        assertThat(authorNaturalKeyFromDb).isNotNull();

    }

    @Order(5)
    @Test
    void testSaveAuthorCompositeKey(){
        FirstNameAndLastName firstNameAndLastName = FirstNameAndLastName.builder().firstName("Author_Two").lastName("Two").build();
        authorCompositeRepository.save(AuthorCompositeKey.builder().firstName(firstNameAndLastName.getFirstName()).lastName(firstNameAndLastName.getLastName()).build());
        AuthorCompositeKey authorCompositeKeyFromDb = authorCompositeRepository.getReferenceById(firstNameAndLastName);
        assertThat(authorCompositeKeyFromDb).isNotNull();

    }

    @Order(6)
    @Test
    void testSaveAuthorEmbeddedCompositeKey(){
        FirstNameAndLastName firstNameAndLastName = FirstNameAndLastName.builder().firstName("Author_Two").lastName("Two").build();
        authorEmbeddedCompositeRepository.save(AuthorEmbeddedCompositeKey.builder().firstNameAndLastName(firstNameAndLastName).build());
        AuthorEmbeddedCompositeKey authorEmbeddedCompositeKeyFromDb =
                authorEmbeddedCompositeRepository.getReferenceById(firstNameAndLastName);
        assertThat(authorEmbeddedCompositeKeyFromDb).isNotNull();

    }



}
