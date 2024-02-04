package com.example.shopbillmanager.dtos.reqdtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Setter
public class Itemreqdtos {

    String id;

    String name;

    String packaging;

    double price;

    double pur_price;

}
