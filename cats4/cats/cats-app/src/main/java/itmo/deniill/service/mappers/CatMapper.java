package itmo.deniill.service.mappers;

import itmo.deniill.CatDto;
import itmo.deniill.dao.entities.Cat;

import java.util.ArrayList;
import java.util.List;

public class CatMapper {
    public static CatDto asDto(Cat catDto) {
        List<Integer> friends = new ArrayList<>();
        for (Cat cat : catDto.getFriends()) {
            friends.add(cat.getId());
        }
        return new CatDto(
                catDto.getId(),
                catDto.getName(),
                catDto.getBirthday(),
                catDto.getBreed(),
                catDto.getColour(),
                catDto.getOwnerId(),
                friends
        );
    }
}
