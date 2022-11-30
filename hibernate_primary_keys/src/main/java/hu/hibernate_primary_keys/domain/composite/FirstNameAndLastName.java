package hu.hibernate_primary_keys.domain.composite;

import hu.hibernate_primary_keys.domain.AuthorUuidString;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
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
@Embeddable
public class FirstNameAndLastName implements Serializable {

    private String firstName;
    private String lastName;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FirstNameAndLastName firstNameAndLastName = (FirstNameAndLastName) o;

        if (!Objects.equals(firstName, firstNameAndLastName.firstName)) {
            return false;
        }
        return Objects.equals(lastName, firstNameAndLastName.lastName);
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
