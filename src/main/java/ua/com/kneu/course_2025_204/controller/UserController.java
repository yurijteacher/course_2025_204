package ua.com.kneu.course_2025_204.controller;

import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.kneu.course_2025_204.entity.Customer;
import ua.com.kneu.course_2025_204.entity.Roles;
import ua.com.kneu.course_2025_204.entity.Users;
import ua.com.kneu.course_2025_204.service.CustomerService;
import ua.com.kneu.course_2025_204.service.UserService;

import java.util.Collections;

@Controller
public class UserController {

    private final UserService userService;
    private final CustomerService customerService;

    public UserController(UserService userService, CustomerService customerService) {
        this.userService = userService;
        this.customerService = customerService;
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {

        model.addAttribute("hello", "Hello!");

        return "login";
    }

    @GetMapping("/registration")
    public String getRegistrationPage(Model model) {

        model.addAttribute("users", new Users());
        model.addAttribute("customer", new Customer());

        return "registration";
    }

    @PostMapping("/registration")
    public String saveNewUser(

            @Valid @ModelAttribute("users") Users user,
            BindingResult bindingResult1,
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult2) {

        if (bindingResult1.hasErrors()) {
            return "registration";
        }

        if (bindingResult2.hasErrors()) {
            return "registration";
        }

        // login username!!

        if(userService.logicByUsername(user.getUsername())){
            return "redirect:/registration";
        }


        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        Users user1 = userService.save(user);
        user1.setRolesSet(Collections.singleton(new Roles(1L, "ROLE_USER")));

        customer.setUsers(user1);
        customerService.save(customer);


        return "redirect:/login";
    }


    @GetMapping("/403")
    public String get403Page(){
        return "error403";
    }
}
