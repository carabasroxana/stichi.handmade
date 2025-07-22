package com.stichi.handmade.controller;

import com.stichi.handmade.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController (ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public String viewProduct (@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductDtoById(id));
        return "products/detail";
    }
}