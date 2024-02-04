package com.example.shopbillmanager.dtos.reqdtos;

import com.example.shopbillmanager.model.Contractor;
import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customerreqdtos {

    String name;

    String mobno;

    String address;

    @Column(nullable = true)
    String gst;

    String contractorid;
}
