package com.ssk.track_it.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ssk.track_it.models.Product;
import com.ssk.track_it.repo.ProductRepo;



@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

    
    public Product createProduct(Product product){
        return repo.save(product);
    }
    
    
    public List<Product> getAllProducts(){
        return repo.findAll();
    }
}
