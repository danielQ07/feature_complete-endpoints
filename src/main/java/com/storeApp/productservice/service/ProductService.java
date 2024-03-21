package com.storeApp.productservice.service;

import com.storeApp.productservice.dto.ProductRequestDTO;
import com.storeApp.productservice.dto.ProductResponseDTO;
import com.storeApp.productservice.model.Product;
import com.storeApp.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO){
        Date currentDate = Date.valueOf(LocalDate.now());
        Product newProduct = Product.builder()
                .creationDate(currentDate)
                .lastUpdatedDate(currentDate)
                .productCode(productRequestDTO.getProductCode())
                .description(productRequestDTO.getDescription())
                .price(productRequestDTO.getPrice())
                .quantity(productRequestDTO.getQuantity())
                .name(productRequestDTO.getName())
                .build();
        productRepository.save(newProduct);
        return ProductResponseDTO.builder()
                .creationDate(currentDate)
                .lastUpdatedDate(currentDate)
                .productCode(newProduct.getProductCode())
                .description(newProduct.getDescription())
                .price(newProduct.getPrice())
                .quantity(newProduct.getQuantity())
                .name(newProduct.getName())
                .build();
    }

    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll().stream().map(
            product -> ProductResponseDTO.builder()
                    .price(product.getPrice())
                    .lastUpdatedDate(product.getLastUpdatedDate())
                    .creationDate(product.getCreationDate())
                    .quantity(product.getQuantity())
                    .name(product.getName())
                    .description(product.getDescription())
                    .productCode(product.getProductCode())
                    .build()
        ).toList();
    }

    public ProductResponseDTO getProductByProductCode(String productCode) {
        Product product = productRepository.findByProductCode(productCode);
        return ProductResponseDTO.builder()
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .lastUpdatedDate(product.getLastUpdatedDate())
                .creationDate(product.getCreationDate())
                .quantity(product.getQuantity())
                .productCode(product.getProductCode())
                .build();
    }

    public ProductResponseDTO updateProduct(String productCode) {
        return null;
    }
}
