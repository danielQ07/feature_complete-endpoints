package com.storeApp.productservice.model;

import jakarta.persistence.*;

@Entity

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productCode;
    private String description;
    private Integer quantity;
    private Double price;
}
