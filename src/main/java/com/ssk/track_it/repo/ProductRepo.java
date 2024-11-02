package com.ssk.track_it.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssk.track_it.models.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    List<Product> findByNameContainingIgnoreCase(String name);
}
