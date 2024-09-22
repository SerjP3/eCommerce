package com.moonlight.shopping_cart.service.image;

import com.moonlight.shopping_cart.model.Image;

import java.util.List;

public interface IImageService{

    Image addImage(Image image);
    Image getImageById(Long id);
    Image getImageByName(String name);
    Image updateImage(Image image, Long id);
    void deleteImageById(Long id);
    List<Image> getAllImages();

}
