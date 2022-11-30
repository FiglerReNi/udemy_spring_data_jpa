package hu.hibernate_primary_keys.domain.composite;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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
public class AuthorEmbeddedCompositeKey {

    @EmbeddedId
    private FirstNameAndLastName firstNameAndLastName;
    private String title;

}
