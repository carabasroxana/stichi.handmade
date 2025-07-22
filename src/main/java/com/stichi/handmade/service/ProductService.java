package com.stichi.handmade.service;

import com.stichi.handmade.dto.ProductRequestDto;
import com.stichi.handmade.model.Product;
import com.stichi.handmade.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    public ProductRequestDto getProductDtoById(Long id) {
        Product productEntity = productRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Product "+id+" not found"));
        return ProductRequestDto.builder()
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .build();
    }
}