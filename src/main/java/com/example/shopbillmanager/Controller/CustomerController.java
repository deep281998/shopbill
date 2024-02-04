package com.example.shopbillmanager.Controller;

import com.example.shopbillmanager.dtos.reqdtos.Customerreqdtos;
import com.example.shopbillmanager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity addcustomer(@RequestBody Customerreqdtos customerreqdtos){
        String response = customerService.addcustomer(customerreqdtos);
        return new ResponseEntity<>(response , HttpStatus.CREATED);
    }
}
