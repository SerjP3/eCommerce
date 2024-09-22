package com.moonlight.shopping_cart.service.category;

import com.moonlight.shopping_cart.model.Category;
import com.moonlight.shopping_cart.model.Product;
import com.moonlight.shopping_cart.request.AddProductRequest;
import com.moonlight.shopping_cart.request.UpdateProductRequest;

import java.util.List;

public interface ICategoryService {

    Category addCategory(Category category);
    Category getCategoryById(Long id);
    Category getCategoryByName(String name); 
    void deleteCategoryById(Long id);
    Category updateCategory(Category category);
    List<Category> getAllCategories();

}
