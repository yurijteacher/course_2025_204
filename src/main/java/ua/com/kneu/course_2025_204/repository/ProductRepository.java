package ua.com.kneu.course_2025_204.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kneu.course_2025_204.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
