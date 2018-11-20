package com.in28minutes.unittesting.unittesting.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.unittesting.unittesting.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    
}
