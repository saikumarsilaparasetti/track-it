package com.ssk.track_it.services;

import java.util.List;

import java.util.Optional;
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

    public Product updateProduct(int id, Product product){
        try {
            Optional<Product> existingProductOpt = repo.findById(id);
            if(existingProductOpt.isPresent()){
                Product existingProduct = existingProductOpt.get();
                if(product.getName() !=null){
                    existingProduct.setName(product.getName());
                }
                if(product.getCategory() !=null){
                    existingProduct.setCategory(product.getCategory());
                }

                if(product.getDescription() !=null){
                    existingProduct.setDescription(product.getDescription());
                }

                if(product.getBrand() !=null){
                    existingProduct.setBrand(product.getBrand());
                }

                if(product.getMrp() !=0){
                    existingProduct.setMrp(product.getMrp());
                }

                if(product.getDiscount() !=0){
                    existingProduct.setDiscount(product.getDiscount());
                }
                if(product.getQuantity() !=0){
                    existingProduct.setQuantity(product.getQuantity());
                }
                System.out.println("get rating   "+product.getRating());
                if(product.getRating() >=0){
                    existingProduct.setRating(product.getRating());
                }

                return repo.save(existingProduct);
            }else{
                throw new RuntimeException("Product not found with id: " + id);
            }
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}
