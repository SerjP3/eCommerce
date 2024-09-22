package com.moonlight.shopping_cart.service.product;

import com.moonlight.shopping_cart.model.Product;
import com.moonlight.shopping_cart.request.AddProductRequest;
import com.moonlight.shopping_cart.request.UpdateProductRequest;

import java.util.List;

public interface IProductService{

    Product addProduct(AddProductRequest product);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    void deleteProductById(Long id);
    Product updateProduct(UpdateProductRequest product, Long productId);
    List<Product> getProductsByCategory(String category);
    List<Product> getProductByBrand(String brand);
    List<Product> getProductsByCategoryAndBrand(String category, String brand);
    List<Product> getProductsByName(String name);
    List<Product> getProductsByBrandAndName(String brand, String name);
    Long countProductsByBrandAndName(String brand, String name);
}
