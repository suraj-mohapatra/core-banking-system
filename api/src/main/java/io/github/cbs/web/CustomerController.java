package io.github.cbs.web;

import io.github.cbs.domain.entity.Customer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @PostMapping("/createCustomer")
    public String createCustomer(Customer customer){

        //CustomerService customerService = new CustomerService();
        return "customer cteated";
    }

}