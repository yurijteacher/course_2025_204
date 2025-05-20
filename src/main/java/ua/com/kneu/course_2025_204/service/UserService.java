package ua.com.kneu.course_2025_204.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.com.kneu.course_2025_204.entity.Users;
import ua.com.kneu.course_2025_204.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users save(Users user) {
        return userRepository.save(user);
    }

    public boolean logicByUsername(String username) {
        return userRepository.findAllByUsername(username).size() > 0 ? true : false ;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = userRepository.findAllByUsername(username).get(0);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;


    }
}
