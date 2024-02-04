package com.example.shopbillmanager.service;

import com.example.shopbillmanager.dtos.reqdtos.Itemreqdtos;
import com.example.shopbillmanager.model.Item;
import com.example.shopbillmanager.repository.ItemRepository;
import com.example.shopbillmanager.transformer.Itemtransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;


    public String additem(Itemreqdtos itemreqdtos) {
        Item item = Itemtransformer.Itemreqdtostoitem(itemreqdtos);
        itemRepository.save(item);
        return "Successfully added";
    }

    public Item updatequantity(String id, int quantity) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if(optionalItem.isPresent()){
            Item item = optionalItem.get();
            item.setQuantity(item.getQuantity() + quantity);
            itemRepository.save(item);
            return item;
        }
        return null;
    }
}
