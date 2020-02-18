package com.example.springdata_mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mongo")
public class MainController {

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/add")
    public @ResponseBody String addSingle(@RequestParam String firstName, @RequestParam String lastName){
        Customer customer = new Customer();
        customer.firstName = firstName;
        customer.lastName = lastName;

        customerRepository.save(customer);
        return "saved";
    }

    @GetMapping("/find")
    public @ResponseBody String findByName (@RequestParam String name){
        return  customerRepository.findByFirstName(name).firstName;
    }



}
