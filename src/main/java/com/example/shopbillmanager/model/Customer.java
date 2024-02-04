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
@Table(name = "customer")
@Builder
public class Customer {

    @Id
    String id;

    String name;

    String mobno;

    String address;

    @Column(nullable = true)
    String gst;

    @ManyToOne
    @JoinColumn
    Contractor contractor;

    @OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL)
    List<Sellinvoice> sellinvoices = new ArrayList<>();


}
