package hu.hibernate_primary_keys.repository;

import hu.hibernate_primary_keys.domain.AuthorUuidString;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorUuidStringRepository extends JpaRepository<AuthorUuidString, UUID> {

}
