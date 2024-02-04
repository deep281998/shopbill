package com.example.shopbillmanager.model;

import com.example.shopbillmanager.Enum.TransactionType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "sellinvoice")
public class Sellinvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Enumerated(EnumType.STRING)
    TransactionType transactiontype;

    @CreationTimestamp
    Date dateofbilling;

    Date dateofpayment;

    double amount;

    List<Integer> quant = new ArrayList<>();


    @ManyToOne
    @JoinColumn
    Customer customer;


    @ManyToMany
    @JoinTable
    List<Item> items = new ArrayList<>();
}
