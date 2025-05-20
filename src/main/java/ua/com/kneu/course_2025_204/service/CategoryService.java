package ua.com.kneu.course_2025_204.service;

import org.hibernate.service.spi.InjectService;
import org.springframework.stereotype.Component;
import ua.com.kneu.course_2025_204.entity.Category;
import ua.com.kneu.course_2025_204.repository.CategoryRepository;

import java.util.List;

@Component
public class CategoryService {

    private final CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    public void deleteAll() {
        categoryRepository.deleteAll();
    }
}
