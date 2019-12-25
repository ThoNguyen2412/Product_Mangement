/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exrcise_spring_jpa_relationship_poduct.repositories;

import com.mycompany.exrcise_spring_jpa_relationship_poduct.entities.Shipping;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface ShippingRepository extends CrudRepository<Shipping, Integer>{
    
}
