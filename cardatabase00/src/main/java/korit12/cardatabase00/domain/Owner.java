package korit12.cardatabase00.domain;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.List;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ownerId;

    public Owner() {
    }

    @NonNull
    private String firstName, lastName;

    public Owner(@NonNull String firstName, @NonNull String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Car> cars;
}
