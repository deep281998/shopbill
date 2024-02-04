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
@Table(name = "vendor_info")
public class Vendor {

    @Id
    @Column(unique = true , nullable = false)
    String id;

    String firmname;

    String mobno;

    String gst;

    String address;

    @OneToMany(mappedBy = "vendor" , cascade = CascadeType.ALL)
    List<PurchaseInvoice> purchaseInvoices = new ArrayList<>();
}
