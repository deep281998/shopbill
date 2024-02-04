package com.example.shopbillmanager.service;

import com.example.shopbillmanager.dtos.reqdtos.Customerreqdtos;
import com.example.shopbillmanager.exception.WrongMobileNumber;
import com.example.shopbillmanager.model.Contractor;
import com.example.shopbillmanager.model.Customer;
import com.example.shopbillmanager.repository.ContractorRepository;
import com.example.shopbillmanager.repository.CustomerRepository;
import com.example.shopbillmanager.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ContractorRepository contractorRepository;

    public String addcustomer(Customerreqdtos customerreqdtos) {
        if(customerreqdtos.getMobno().length() != 10){
            throw new WrongMobileNumber("Invalid mobile no");
        }
        Optional<Contractor> optionalContractor =
                contractorRepository.findById(customerreqdtos.getContractorid());
        Customer customer = CustomerTransformer.customerreqdtostocustomer(customerreqdtos);
        if(optionalContractor.isPresent()){
            customer.setContractor(optionalContractor.get());
            customerRepository.save(customer);
            return "Sucessfully created";
        }
        else {
            customer.setContractor(null);
            customerRepository.save(customer);
            return "successfull";
        }

    }
}
