package com.example.shopbillmanager.repository;

import com.example.shopbillmanager.model.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractorRepository extends JpaRepository<Contractor , String> {
}
