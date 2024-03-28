package com.blueyonder.shopservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Integer prodId;
    private String prodName;
    private Integer price;
    private String description;
    private String categoryName;
}
