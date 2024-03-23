package com.storeApp.productservice.controller;

import com.storeApp.productservice.dto.ProductRequestDTO;
import com.storeApp.productservice.dto.ProductResponseDTO;
import com.storeApp.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductResponseDTO> getAllProducts(){
        return productService.getAllProducts();
    }

    @DeleteMapping("/{productCode}")
    public ResponseEntity<String> deleteProduct(@PathVariable String productCode){
        return ResponseEntity.status(200).body(productService.deleteProduct(productCode));
    }

    @GetMapping("/{productCode}")
    public ProductResponseDTO getProductBySkuCode(@PathVariable String productCode){
        return productService.getProductByProductCode(productCode);
    }

    @PatchMapping("/{productCode}")
    public ProductResponseDTO updateProduct(@PathVariable String productCode){
        return productService.updateProduct(productCode);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO){
        return ResponseEntity.status(201).body(productService.createProduct(productRequestDTO));
    }
}
