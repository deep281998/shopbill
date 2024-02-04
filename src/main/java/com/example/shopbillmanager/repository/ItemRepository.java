package com.example.shopbillmanager.repository;

import com.example.shopbillmanager.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item , String> {
}
