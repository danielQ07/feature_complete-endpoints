package com.storeApp.productservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

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
    @Column(updatable = false)
    private String productCode;
    @Column(updatable = false)
    private Date creationDate;
    private String name;
    private Date lastUpdatedDate;
    private String description;
    private Integer quantity;
    private Double price;
}
