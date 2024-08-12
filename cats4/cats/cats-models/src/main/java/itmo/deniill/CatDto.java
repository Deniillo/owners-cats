package itmo.deniill;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;
import java.util.List;

@Data
@Jacksonized
@NoArgsConstructor
@Builder
@ToString
public class CatDto {
    private int id;
    private String name;
    private LocalDate birthday;
    private Breed breed;
    private Colour colour;
    private int ownerId;
    private List<Integer> friendsId;

    public CatDto(
            int id,
            String name,
            LocalDate birthday,
            Breed breed,
            Colour colour,
            int ownerId,
            List<Integer> friendsId) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.breed = breed;
        this.colour = colour;
        this.ownerId = ownerId;
        this.friendsId = friendsId;
    }
    public CatDto(
            int id,
            String name,
            LocalDate birthday,
            String breed,
            String colour,
            int ownerId,
            List<Integer> friendsId) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.breed = Breed.valueOf(breed);
        this.colour = Colour.valueOf(colour);
        this.ownerId = ownerId;
        this.friendsId = friendsId;
    }
}
