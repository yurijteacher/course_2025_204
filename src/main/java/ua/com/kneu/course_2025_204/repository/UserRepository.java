package ua.com.kneu.course_2025_204.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kneu.course_2025_204.entity.Users;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {

    List<Users> findAllByUsername(String username);


}
