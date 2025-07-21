package com.stichi.handmade.controller;

import com.stichi.handmade.model.Product;
import com.stichi.handmade.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    private final ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", repo.findAll());
        return "products";
    }

    @GetMapping("/products/new")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    @PostMapping("/products")
    public String save(Product product) {
        repo.save(product);
        return "redirect:/products";
    }
}
