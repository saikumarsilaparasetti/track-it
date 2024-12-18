package com.ssk.track_it.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssk.track_it.models.Product;
import com.ssk.track_it.services.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    ProductService service;

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        System.err.println(product);
        try {
            Thread.sleep(3000);
            return new ResponseEntity<Product>( service.createProduct(product), HttpStatus.OK);    
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id){
        try {
            // if(id == null){
            //     return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            // }

            return new ResponseEntity<Product>(service.getProductById(id), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/getall")
    public ResponseEntity<?> getAllProducts(@RequestParam String query ){
        try {
            System.err.println("=>product/getall");
            Thread.sleep(1000);
            if(query != null && !query.isEmpty() && query != ""){
                
                System.err.println("Query is:  "+query);
                return new ResponseEntity<>(service.getAllProductsByQuery(query), HttpStatus.OK);
            }
            return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
            
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable int id){
        try {
            System.err.println("Id is: "+id);
            return new ResponseEntity<>(service.updateProduct(id, product), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
