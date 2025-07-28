package com.stichi.handmade.service;

import com.stichi.handmade.dto.ProductRequestDto;
import com.stichi.handmade.model.Product;
import com.stichi.handmade.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public ProductRequestDto getProductDtoById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product " + id + " not found"));
        return new ProductRequestDto(
                product.getId(),
                product.getName(),
                product.getDescription()
        );


    }

    public List<ProductRequestDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(p -> toDto(p))
                .collect(Collectors.toList());
    }

        private ProductRequestDto toDto(Product p) {
            return new ProductRequestDto(p.getId(), p.getName(), p.getDescription());
        }
}

