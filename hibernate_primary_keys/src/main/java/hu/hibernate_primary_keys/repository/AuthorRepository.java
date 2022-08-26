package hu.hibernate_primary_keys.repository;

import hu.hibernate_primary_keys.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
