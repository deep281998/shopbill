package com.example.shopbillmanager.transformer;

import com.example.shopbillmanager.dtos.reqdtos.Contractorreqdtos;
import com.example.shopbillmanager.model.Contractor;

import static com.fasterxml.jackson.databind.util.ClassUtil.name;

public class ContractorTransformer {


    public static Contractor contractorreqdtostocontractor(Contractorreqdtos contractorreqdtos){
        String temp = contractorreqdtos.getMobno() + contractorreqdtos.getName().charAt(0);
        return Contractor.builder()
                .id(temp)
                .name(contractorreqdtos.getName())
                .mobno(contractorreqdtos.getMobno())
                .address(contractorreqdtos.getAddress())
                .build();
    }
}
