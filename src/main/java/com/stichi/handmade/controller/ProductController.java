package com.stichi.handmade.controller;

import com.stichi.handmade.dto.ProductRequestDto;
import com.stichi.handmade.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController (ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public String viewProduct(@PathVariable Long id, Model model) {
        ProductRequestDto dto = productService.getProductDtoById(id);
        model.addAttribute("product", dto);
        return "products/detail";
    }

    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products/list";
    }
}