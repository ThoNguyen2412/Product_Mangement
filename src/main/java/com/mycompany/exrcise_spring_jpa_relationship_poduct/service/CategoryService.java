/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exrcise_spring_jpa_relationship_poduct.service;

import com.mycompany.exrcise_spring_jpa_relationship_poduct.entities.Category;
import com.mycompany.exrcise_spring_jpa_relationship_poduct.entities.Product;
import com.mycompany.exrcise_spring_jpa_relationship_poduct.repositories.CategoryRepository;
import com.mycompany.exrcise_spring_jpa_relationship_poduct.repositories.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository  repository;
    
    public List<Category> getCategories(){
    return  (List<Category>) repository.findAll();
    }
    
    
}
