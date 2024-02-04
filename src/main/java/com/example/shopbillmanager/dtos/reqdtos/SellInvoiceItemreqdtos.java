package com.example.shopbillmanager.dtos.reqdtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Setter
public class SellInvoiceItemreqdtos {

    String id;

    int quantity;
}
