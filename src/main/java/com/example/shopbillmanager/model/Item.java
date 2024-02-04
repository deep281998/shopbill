package com.example.shopbillmanager.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "Item-Info")
@Builder
public class Item {

    @Id
    String id;

    String name;

    int quantity;

    String packaging;

    double price;

    double pur_price;


    @ManyToMany
    @JoinTable
    List<Sellinvoice> sellinvoices = new ArrayList<>();

    @ManyToMany
    @JoinTable
    List<PurchaseInvoice> purchaseInvoices = new ArrayList<>();

}
