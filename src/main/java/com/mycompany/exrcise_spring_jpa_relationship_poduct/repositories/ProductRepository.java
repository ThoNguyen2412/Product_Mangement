/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exrcise_spring_jpa_relationship_poduct.repositories;

import com.mycompany.exrcise_spring_jpa_relationship_poduct.entities.Product;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    public List<Product> findAllByOrderByIdDesc();

    public List<Product> findAllByOrderByIdAsc();

    public List<Product> findByNameLikeOrDescription(String name,
            String description);

    @Query(value = "Select * from product p "
            + "inner join category c on p.category_id = c.id "
            + "where c.name Like ?1 "
            + "or p.name Like ?2",
            nativeQuery = true)
    public List<Product> findProductByCategoryNative(String category, String name);
}
