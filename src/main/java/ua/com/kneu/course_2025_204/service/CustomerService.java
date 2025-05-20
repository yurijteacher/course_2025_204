package ua.com.kneu.course_2025_204.service;

import org.springframework.stereotype.Service;
import ua.com.kneu.course_2025_204.entity.Customer;
import ua.com.kneu.course_2025_204.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    public void deleteAll() {
        customerRepository.deleteAll();
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

}
