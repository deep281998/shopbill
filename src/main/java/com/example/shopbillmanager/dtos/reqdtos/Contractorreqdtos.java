package com.example.shopbillmanager.dtos.reqdtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Contractorreqdtos {

    String name;

    String mobno;

    String address;
}
