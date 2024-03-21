package com.storeApp.productservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(
        uniqueConstraints = @UniqueConstraint(
           name = "unique_productCode",
           columnNames = "productCode"
        )
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productCode;
    private String description;
    private Integer quantity;
    private Double price;
}
