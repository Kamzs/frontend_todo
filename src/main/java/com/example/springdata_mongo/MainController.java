package com.example.springdata_mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/findFirstName")
    public @ResponseBody Customer findByFirstName (@RequestParam String firstName){
        return  customerRepository.findByFirstName(firstName);
    }

    @GetMapping("/findLastName")
    public @ResponseBody List<Customer> findByLastName (@RequestParam String lastName) {
/*        for (Customer customer : customerRepository.findByLastName(lastName)) {
            System.out.println(customer);
        }*/
        return customerRepository.findByLastName(lastName);
    }
}
