/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exrcise_spring_jpa_relationship_poduct.service;

import com.mycompany.exrcise_spring_jpa_relationship_poduct.entities.Product;
import com.mycompany.exrcise_spring_jpa_relationship_poduct.repositories.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getProducts() {
        return (List<Product>) repository.findAll();
    }

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> sortProductByIdDes() {

        return repository.findAllByOrderByIdDesc();
//         return repository.findAllByOrderByIdAsc();
    }

    public Product findProductById(int id) {
        Product product = repository.findOne(id);
        if (product == null) {
            return new Product();
        } else {
            return product;
        }
    }

    public Boolean deleteProduct(int productId) {
        repository.delete(productId);
        return repository.exists(productId);
    }

    public List<Product> searchProduct(String name, String category) {

        return repository.findProductByCategoryNative(name,category);
//    return repository.findByNameLikeOrDescription(name, description);
    }
}
