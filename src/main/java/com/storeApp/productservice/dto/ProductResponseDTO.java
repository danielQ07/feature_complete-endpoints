package com.storeApp.productservice.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {
    private String productCode;
    private Date creationDate;
    private Date lastUpdatedDate;
    private String description;
    private Integer quantity;
    private Double price;
    private String name;
}
