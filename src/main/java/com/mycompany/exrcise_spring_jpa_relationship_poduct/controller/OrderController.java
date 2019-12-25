/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exrcise_spring_jpa_relationship_poduct.controller;

import com.mycompany.exrcise_spring_jpa_relationship_poduct.entities.OrderDetail;
import com.mycompany.exrcise_spring_jpa_relationship_poduct.entities.OrderProduct;
import com.mycompany.exrcise_spring_jpa_relationship_poduct.entities.Product;
import com.mycompany.exrcise_spring_jpa_relationship_poduct.service.OrderService;
import com.mycompany.exrcise_spring_jpa_relationship_poduct.service.ProductService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author HP
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/order/{productId}", method = RequestMethod.GET)
    public String orderProduct(Model model,
            @PathVariable("productId") int productId, HttpSession session) {

        Product product = productService.findProductById(productId);

        if (product != null) {
            float totalPrice = 0;
            OrderProduct order = (OrderProduct) session.getAttribute("order");
            if (order != null) {
                List<OrderDetail> orderDetails = order.getOrderDetails();
                if (orderDetails != null && orderDetails.size() > 0) {
                    int flagNotEqual = 1;
                    for (int i = 0; i < orderDetails.size(); i++) {

                        if (orderDetails.get(i).getProduct().getId() == productId) {
                            int temp = orderDetails.get(i).getQuantity();
                            orderDetails.get(i).setQuantity(temp + 1);
//                            orderService.saveOrderDetail(orderDetails.get(i));
                            flagNotEqual = 0;
                        }
                        totalPrice += (orderDetails.get(i).getQuantity()) * (orderDetails.get(i).getPrice());

                    }
                    if (flagNotEqual == 1) {
                        OrderDetail addOrderDetail = new OrderDetail();
                        addOrderDetail.setPrice(product.getPrice());
                        addOrderDetail.setQuantity(1);
                        addOrderDetail.setOrderProduct(order);
                        addOrderDetail.setProduct(product);
//                        addOrderDetail = orderService.saveOrderDetail(addOrderDetail);
                        orderDetails.add(addOrderDetail);
                        totalPrice += product.getPrice();
                    }
                    order.setPrice_total(totalPrice);
                    order.setOrderDetails(orderDetails);
                }
//                order = orderService.saveOrderProduct(order);
                session.removeAttribute("order");
                session.setAttribute("order", order);
                model.addAttribute("order", order);

            } else {
                order = new OrderProduct();
                order.setOrderDate(new Date());
                order.setStatus(true);
//                order = orderService.saveOrderProduct(order);
                List<OrderDetail> orderDetails = new ArrayList<>();
                OrderDetail detail = new OrderDetail();
                detail.setOrderProduct(order);
                detail.setPrice(product.getPrice());
                detail.setProduct(product);
                detail.setQuantity(1);
                detail.setOrderProduct(order);
//                detail = orderService.saveOrderDetail(detail);
                orderDetails.add(detail);
                order.setOrderDetails(orderDetails);
                order.setPrice_total(product.getPrice());
//                order = orderService.saveOrderProduct(order);
                session.setAttribute("order", order);
                model.addAttribute("order", order);
            }
        }
        return "order-home";

    }
}
