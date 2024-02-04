package com.example.shopbillmanager.Controller;

import com.example.shopbillmanager.dtos.reqdtos.SellInvoiceItemreqdtos;
import com.example.shopbillmanager.model.Item;
import com.example.shopbillmanager.service.SellInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/sellinvoice")
public class SellInvoiceController {

    @Autowired
    SellInvoiceService sellInvoiceService;

    @PostMapping("/add")
    public ResponseEntity addbill(@RequestParam("id") String customer, @RequestBody List<SellInvoiceItemreqdtos> items) {
        return sellInvoiceService.addbill(customer, items);
    }

    @PutMapping("/removeitem")
    public ResponseEntity<String> removeitem(@RequestParam("id") int billid , @RequestParam("id1") String itemid){
        return sellInvoiceService.removeitem(billid , itemid);
    }

    @PutMapping("/additem")
    public ResponseEntity<String> additem(@RequestParam("id") int billid , @RequestBody SellInvoiceItemreqdtos sellInvoiceItemreqdtos){
        return sellInvoiceService.additem(billid , sellInvoiceItemreqdtos);
    }

}
