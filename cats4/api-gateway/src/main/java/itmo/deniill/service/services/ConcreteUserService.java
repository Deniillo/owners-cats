package itmo.deniill.service.services;

import itmo.deniill.dao.models.MyUser;
import itmo.deniill.dao.repositories.UserRepository;
import itmo.deniill.service.dto.UserDto;
import itmo.deniill.service.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ConcreteUserService implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Autowired
    public ConcreteUserService(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }
    @Transactional
    public UserDto createUser(UserDto userDto) {
        MyUser user = new MyUser(
                userDto.getUsername(),
                encoder.encode(userDto.getPassword()),
                userDto.getRole(),
                userDto.getOwnerId());
        userRepository.save(user);
        return UserMapper.asDto(user);
    }

    @Override
    public UserDto getUserByUsername(String username) {
        return UserMapper.asDto(userRepository.findByUsername(username).orElseThrow());
    }

}
