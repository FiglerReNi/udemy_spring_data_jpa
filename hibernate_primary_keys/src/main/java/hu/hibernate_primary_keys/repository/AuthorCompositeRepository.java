package hu.hibernate_primary_keys.repository;

import hu.hibernate_primary_keys.domain.composite.AuthorCompositeKey;
import hu.hibernate_primary_keys.domain.composite.FirstNameAndLastName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorCompositeRepository extends JpaRepository<AuthorCompositeKey, FirstNameAndLastName> {

}
