/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exrcise_spring_jpa_relationship_poduct.controller;

import com.mycompany.exrcise_spring_jpa_relationship_poduct.entities.Product;
import com.mycompany.exrcise_spring_jpa_relationship_poduct.service.CategoryService;
import com.mycompany.exrcise_spring_jpa_relationship_poduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HP
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = {"/", "home"}, method = RequestMethod.GET)
    public String home(Model model, @RequestParam(value = "message", required = false) String message,
            @RequestParam(value = "status", required = false) String status) {

        model.addAttribute("products", productService.getProducts());
        model.addAttribute("message", message);
        model.addAttribute("status", status);
        return "home";
    }

    @RequestMapping("/form-add-product")
    public String addProductForm(Model model) {
        model.addAttribute("action", "addProduct");
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("product", new Product());

        return "product-form";

    }

    @RequestMapping(value = {"addProduct"}, method = RequestMethod.POST)
    public String addProduct(Model model, @ModelAttribute("product") Product product) {

//    model.addAttribute("products",productService.saveProduct(product));
        product = productService.saveProduct(product);
        if (product.getId() > 0) {
            model.addAttribute("message", "Add Product is successful");
            model.addAttribute("status", "success");
            model.addAttribute("products", productService.sortProductByIdDes());

            return "home";
        } else {
            return "redirect:/home?message=Add Product is fail"
                    + "&status=fail";
        }
    }

    @RequestMapping("/update/{productId}")
    public String updateProductForm(Model model, @PathVariable("productId") int productId) {
        model.addAttribute("product", productService.findProductById(productId));
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("action", "updateProduct");
        return "product-form";
    }

    @RequestMapping(value = {"/updateProduct"}, method = RequestMethod.POST)
    public String updateProduct(Model model, @ModelAttribute("product") Product product) {
        product = productService.saveProduct(product);
        if (product.getId() > 0) {
            return "redirect:/home?message=Update Product is successful"
                    + "&status=success";
        } else {
            return "redirect:/home?message=Update Product is fail"
                    + "&status=fail";
        }
    }

    @RequestMapping("/delete/{productId}")
    public String deleteProduct(Model model, @PathVariable("productId") int productId) {
        if (!productService.deleteProduct(productId)) {
            return "redirect:/home?message=Delete Product is successful"
                    + "&status=success";
        } else {
            return "redirect:/home?message=Delete Product is fail"
                    + "&status=fail";
        }
    }
    
    @RequestMapping("/search")
    public String searchProduct(Model model, @ModelAttribute("searchTxt") String searchTxt){
    
    model.addAttribute("products", productService.searchProduct(searchTxt,searchTxt));
    return "home";
    }

}
