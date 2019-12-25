/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exrcise_spring_jpa_relationship_poduct.repositories;

import com.mycompany.exrcise_spring_jpa_relationship_poduct.entities.OrderDetail;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface OrderDetailRepository extends CrudRepository<OrderDetail, Integer> {

    @Query(value = "Select * from order_detail od where od.product_id = ?1 ", nativeQuery = true)
    public List<OrderDetail> findOrderDetailByProductNative(int productId);

}
