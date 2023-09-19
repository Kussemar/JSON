package dat;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Person {
    private String firstname;
    private String lastname;
    private String birthDate;

    public Person(String firstname, String lastname, String birthDate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDate = birthDate;
    }
}
