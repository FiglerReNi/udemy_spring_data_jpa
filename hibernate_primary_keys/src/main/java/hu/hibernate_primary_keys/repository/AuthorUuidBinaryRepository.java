package hu.hibernate_primary_keys.repository;

import hu.hibernate_primary_keys.domain.AuthorUuidBinary;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorUuidBinaryRepository extends JpaRepository<AuthorUuidBinary, UUID> {

}
