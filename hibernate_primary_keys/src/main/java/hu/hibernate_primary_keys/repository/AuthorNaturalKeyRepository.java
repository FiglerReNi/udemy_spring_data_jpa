package hu.hibernate_primary_keys.repository;

import hu.hibernate_primary_keys.domain.AuthorNaturalKey;;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorNaturalKeyRepository extends JpaRepository<AuthorNaturalKey, String> {

}
