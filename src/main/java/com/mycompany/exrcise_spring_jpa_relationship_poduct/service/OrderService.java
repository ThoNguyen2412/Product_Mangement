/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exrcise_spring_jpa_relationship_poduct.service;

import com.mycompany.exrcise_spring_jpa_relationship_poduct.entities.OrderDetail;
import com.mycompany.exrcise_spring_jpa_relationship_poduct.entities.OrderProduct;
import com.mycompany.exrcise_spring_jpa_relationship_poduct.repositories.OrderDetailRepository;
import com.mycompany.exrcise_spring_jpa_relationship_poduct.repositories.OrderProductReposirory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class OrderService {

    @Autowired
    private OrderProductReposirory orderProductReposirory;
    @Autowired
    private OrderDetailRepository detailRepository;

    public List<OrderProduct> getOrderProducts() {
        return (List<OrderProduct>) orderProductReposirory.findAll();
    }
    
    public OrderProduct saveOrderProduct(OrderProduct orderProduct){
    return orderProductReposirory.save(orderProduct);
    }
    
    public OrderDetail saveOrderDetail(OrderDetail orderDetail){
    return detailRepository.save(orderDetail);
    }
    
}
