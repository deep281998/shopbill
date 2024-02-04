package com.example.shopbillmanager.Controller;

import com.example.shopbillmanager.dtos.reqdtos.Itemreqdtos;
import com.example.shopbillmanager.model.Item;
import com.example.shopbillmanager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping("/add")
    public ResponseEntity additem(@RequestBody Itemreqdtos itemreqdtos){
        String response = itemService.additem(itemreqdtos);
        return new ResponseEntity<>(response , HttpStatus.CREATED);
    }

    @PutMapping("/updatequantity")
    public ResponseEntity updatequantity(@RequestParam("id") String id , @RequestParam("quantity") int quantity){
        Item item = itemService.updatequantity(id , quantity);
        if(item != null){
            return new ResponseEntity<>("Successfull" , HttpStatus.CREATED);
        }
        return new ResponseEntity<>("wrong id" , HttpStatus.NOT_FOUND);
    }
}
