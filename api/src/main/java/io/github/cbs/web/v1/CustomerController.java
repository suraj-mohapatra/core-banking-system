package io.github.cbs.web.v1;

import io.github.cbs.domain.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @PostMapping("/api/v1/createCustomer")
    public String createCustomer(Customer customer){

        //CustomerService customerService = new CustomerService();
        return "customer created";
    }

}