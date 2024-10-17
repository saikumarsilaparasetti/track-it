package com.ssk.track_it.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssk.track_it.models.Product;
import com.ssk.track_it.services.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    ProductService service;

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        System.err.println(product);
        try {
            return new ResponseEntity<Product>( service.createProduct(product), HttpStatus.OK);    
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        

    }

    @PostMapping("/getall")
    public ResponseEntity<?> getAllProducts(){
        try {
            return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
