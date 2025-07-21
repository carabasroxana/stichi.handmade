package com.stichi.handmade.controller;

import com.stichi.handmade.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    private final ProductRepository repo;
    public ProductController(ProductRepository repo){
        this.repo = repo;
    }

@GetMapping("/products")
    public String listProducts (Model model){
        model.addAttribute("products", repo.findAll());
        return "products";
    }
}