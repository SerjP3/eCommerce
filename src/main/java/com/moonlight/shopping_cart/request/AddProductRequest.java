package com.moonlight.shopping_cart.request;

import com.moonlight.shopping_cart.model.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddProductRequest{

    private Long id;
    private String name;
    private String brand;
    private String description;
    private BigDecimal price;
    private int inventory;
    private Category category;
}
