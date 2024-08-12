package itmo.deniill.service.mappers;

import itmo.deniill.OwnerDto;
import itmo.deniill.dao.entities.Owner;

public class OwnerMapper {
    public static OwnerDto asDto(Owner owner) {
        return new OwnerDto(
                owner.getId(),
                owner.getName(),
                owner.getBirthday()
        );
    }
}
