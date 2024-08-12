package itmo.deniill.dao.entities;

import itmo.deniill.Breed;
import itmo.deniill.Colour;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "cats")
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate birthday;
    @Enumerated(EnumType.STRING)
    private Breed breed;
    @Enumerated(EnumType.STRING)
    private Colour colour;
    private Integer ownerId;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Cat> friends;

    public Cat(
            String name,
            LocalDate birthday,
            Breed breed,
            Colour colour,
            Integer ownerId,
            List<Cat> friends
    ) {
        this.name = name;
        this.birthday = birthday;
        this.breed = breed;
        this.colour = colour;
        this.ownerId = ownerId;
        this.friends = friends;
    }

    public void addFriend(Cat cat) {
        if (!friends.contains(cat)) {
            friends.add(cat);
        }
    }

    public void deleteFriend(Cat cat) {
        friends.remove(cat);
    }
}
