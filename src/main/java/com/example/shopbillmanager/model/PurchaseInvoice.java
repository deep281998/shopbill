package com.example.shopbillmanager.model;

import com.example.shopbillmanager.Enum.TransactionType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Transaction;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "purchase_info")
public class PurchaseInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Enumerated(EnumType.STRING)
    TransactionType transaction;

    @CreationTimestamp
    Date billdate;

    @CreationTimestamp
    Date paymentdate;

    double amount;

    @ManyToOne
    @JoinColumn
    Vendor vendor;

    @ManyToMany
    @JoinTable
    List<Item> items = new ArrayList<>();
}
