package com.example.shopbillmanager.service;

import com.example.shopbillmanager.dtos.reqdtos.Contractorreqdtos;
import com.example.shopbillmanager.exception.AlreadyExist;
import com.example.shopbillmanager.exception.WrongMobileNumber;
import com.example.shopbillmanager.model.Contractor;
import com.example.shopbillmanager.repository.ContractorRepository;
import com.example.shopbillmanager.transformer.ContractorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractorService {

    @Autowired
    ContractorRepository contractorRepository;

    public String addcontractor(Contractorreqdtos contractorreqdtos) {
        Optional<Contractor> optionalContractor = contractorRepository.findById(contractorreqdtos.getMobno()+contractorreqdtos.getName().charAt(0));
        if(optionalContractor.isPresent()){
            throw new AlreadyExist("Contractor already exist");
        }
        if(contractorreqdtos.getMobno().length() != 10){
            throw new WrongMobileNumber("Invalid mobile number");
        }
        Contractor contractor = ContractorTransformer.contractorreqdtostocontractor(contractorreqdtos);
        contractorRepository.save(contractor);
        return "Sucessfully added";
    }
}
