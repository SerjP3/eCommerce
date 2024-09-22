package com.moonlight.shopping_cart.repository;

import com.moonlight.shopping_cart.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long>{
    boolean existsByFileName(String fileName);

    Image findByName(String name);
}
