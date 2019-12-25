/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exrcise_spring_jpa_relationship_poduct.service;

import com.mycompany.exrcise_spring_jpa_relationship_poduct.entities.OrderDetail;
import com.mycompany.exrcise_spring_jpa_relationship_poduct.repositories.OrderDetailRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class OrderDetailService {
    
    @Autowired
    private OrderDetailRepository detailRepository;
    
    public List<OrderDetail> getOrderDetail(){
    return (List<OrderDetail>) detailRepository.findAll();
    }
    
    public List<OrderDetail> searchDetailbyProductId(int productId){
    
        return  (List<OrderDetail>) detailRepository.findOrderDetailByProductNative(productId);
    }
    
    
}
