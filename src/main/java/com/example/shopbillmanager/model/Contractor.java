package com.example.shopbillmanager.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "contractor_info")
@Builder
public class Contractor {

    @Id
    @Column(unique = true , nullable = false)
    String id;

    String name;

    String mobno;

    String address;

    @OneToMany(mappedBy = "contractor" , cascade = CascadeType.ALL)
    List<Customer> customers = new ArrayList<>();


}
