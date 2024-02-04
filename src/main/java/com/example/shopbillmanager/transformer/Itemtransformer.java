package com.example.shopbillmanager.transformer;

import com.example.shopbillmanager.dtos.reqdtos.Itemreqdtos;
import com.example.shopbillmanager.model.Item;

public class Itemtransformer {

    public static Item Itemreqdtostoitem(Itemreqdtos itemreqdtos){
        return Item.builder()
                .id(itemreqdtos.getId())
                .name(itemreqdtos.getName())
                .price(itemreqdtos.getPrice())
                .pur_price(itemreqdtos.getPur_price())
                .packaging(itemreqdtos.getPackaging())
                .build();
    }
}
