package ru.netology.myproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    private final CustomersRepository repository;


    public Controller(CustomersRepository repository){
        this.repository = repository;
    }

    @GetMapping("/products/fetch-product")
    public List<String> getListProductName(String name) {
        return repository.getProductName(name);
    }
}
