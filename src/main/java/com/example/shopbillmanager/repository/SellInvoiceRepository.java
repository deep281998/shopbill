package com.example.shopbillmanager.repository;

import com.example.shopbillmanager.model.Sellinvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellInvoiceRepository extends JpaRepository<Sellinvoice ,Integer> {
}
