package itmo.deniill.service.services;

import itmo.deniill.service.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserByUsername(String username);
}
