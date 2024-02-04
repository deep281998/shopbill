package com.example.shopbillmanager.Controller;

import com.example.shopbillmanager.dtos.reqdtos.Contractorreqdtos;
import com.example.shopbillmanager.service.ContractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contractor")
public class ContractorController {

    @Autowired
    ContractorService contractorService;

    @PostMapping("/add")
    public ResponseEntity addcontractor(@RequestBody Contractorreqdtos contractorreqdtos){
        String response = contractorService.addcontractor(contractorreqdtos);
        return new ResponseEntity<>(response , HttpStatus.CREATED);
    }
}
