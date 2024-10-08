package com.moonlight.shopping_cart.service.category;

import com.moonlight.shopping_cart.exceptions.ResourceNotFoundException;
import com.moonlight.shopping_cart.model.Category;
import com.moonlight.shopping_cart.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryService implements ICategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {

        return Optional.of(category).filter(c -> !categoryRepository.existsByName(c.getName()))
                .map(categoryRepository :: save).orElseThrow(() -> new ResourceNotFoundException("Category " + category.getName() + " already exists"));
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResolutionException("Category not found"));
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.findById(id)
                .ifPresentOrElse(categoryRepository::delete,
                        () -> {
                            throw new ResourceNotFoundException("Category not found");
                        });
    }

    @Override
    public Category updateCategory(Category category, Long id) {

        return Optional.ofNullable(getCategoryById(id)).
                map(oldCategory ->
        {
            oldCategory.setName(category.getName());
            return categoryRepository.save(oldCategory);
        }).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
