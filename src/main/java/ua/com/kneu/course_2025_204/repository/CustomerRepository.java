package ua.com.kneu.course_2025_204.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kneu.course_2025_204.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
