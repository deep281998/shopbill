package com.example.shopbillmanager.transformer;

import com.example.shopbillmanager.dtos.reqdtos.Customerreqdtos;
import com.example.shopbillmanager.model.Customer;

public class CustomerTransformer {

    public static Customer customerreqdtostocustomer(Customerreqdtos customerreqdtos){
        String temp = customerreqdtos.getMobno() + customerreqdtos.getName().charAt(0);
        if(customerreqdtos.getGst() == null){
            return Customer.builder()
                    .id(temp)
                    .name(customerreqdtos.getName())
                    .mobno(customerreqdtos.getMobno())
                    .address(customerreqdtos.getAddress())
                    .build();
        }
        return Customer.builder()
                .id(temp)
                .name(customerreqdtos.getName())
                .mobno(customerreqdtos.getMobno())
                .address(customerreqdtos.getAddress())
                .gst(customerreqdtos.getGst())
                .build();
    }
}
