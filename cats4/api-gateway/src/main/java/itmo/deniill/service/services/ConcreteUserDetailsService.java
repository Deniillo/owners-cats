package itmo.deniill.service.services;

import itmo.deniill.dao.models.MyUser;
import itmo.deniill.dao.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConcreteUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public ConcreteUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            MyUser concreteUser = user.get();
            return User.builder()
                    .username(concreteUser.getUsername())
                    .password(concreteUser.getPassword())
                    .roles(concreteUser.getRole().toString())
                    .build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }


}
