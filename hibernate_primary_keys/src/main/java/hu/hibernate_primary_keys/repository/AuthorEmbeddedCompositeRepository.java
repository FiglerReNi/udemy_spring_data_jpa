package hu.hibernate_primary_keys.repository;

import hu.hibernate_primary_keys.domain.composite.AuthorEmbeddedCompositeKey;
import hu.hibernate_primary_keys.domain.composite.FirstNameAndLastName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorEmbeddedCompositeRepository extends JpaRepository<AuthorEmbeddedCompositeKey, FirstNameAndLastName> {

}
