package ua.com.kneu.course_2025_204.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kneu.course_2025_204.entity.Category;
import ua.com.kneu.course_2025_204.service.CategoryService;

@Controller
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String getHomePage(Model model){

        model.addAttribute("hello", "Hello!");

        model.addAttribute("categories", categoryService.findAll());
        return "home";
    }

    @PostMapping("/saveNewCategory")
    public String saveNewCategory(@RequestParam(name = "name") String name,
                                  @RequestParam(name = "description") String description,
                                  @RequestParam(name = "image") String image){

        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        category.setImage(image);

        categoryService.save(category);

        return "redirect:/";

    }


    @GetMapping("/admin")
    public String getAdminPage(Model model){
        model.addAttribute("hello", "Admin Page!");

        return "admin";
    }

    @GetMapping("/users")
    public String getUserPage(Model model){
        model.addAttribute("hello", "User Page!");

        return "users";
    }

}
