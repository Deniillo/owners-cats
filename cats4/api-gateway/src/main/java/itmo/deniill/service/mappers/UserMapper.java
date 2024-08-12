package itmo.deniill.service.mappers;

import itmo.deniill.dao.models.MyUser;
import itmo.deniill.service.dto.UserDto;

public class UserMapper {
    public static UserDto asDto(MyUser myUser) {
        return new UserDto(
                myUser.getId(),
                myUser.getUsername(),
                myUser.getPassword(),
                myUser.getRole(),
                myUser.getOwnerId()
        );
    }
}
