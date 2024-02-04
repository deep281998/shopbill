package com.example.shopbillmanager.repository;

import com.example.shopbillmanager.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , String> {

    @Query(value = "select b from Customer b where b.mobno = :customer")
    Optional<Customer> getcustomerfrommobile(String customer);
}
