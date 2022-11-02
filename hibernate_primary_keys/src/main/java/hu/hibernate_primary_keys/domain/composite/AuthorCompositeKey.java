package hu.hibernate_primary_keys.domain.composite;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@IdClass(FirstNameAndLastName.class)
public class AuthorCompositeKey {

    @Id
    private String firstName;
    @Id
    private String lastName;
    private String title;
}
