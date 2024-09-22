package com.moonlight.shopping_cart.service.image;

import com.moonlight.shopping_cart.exceptions.ResourceNotFoundException;
import com.moonlight.shopping_cart.model.Image;
import com.moonlight.shopping_cart.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class ImageService implements IImageService{

    private final ImageRepository imageRepository;
    @Override
    public Image addImage(Image image) {
        return Optional.of(image).filter(i -> !imageRepository.existsByFileName(i.getFileName()))
                .map(imageRepository :: save).orElseThrow(() -> new ResourceNotFoundException("Image " + image.getFileName() + " already exists"));
    }

    @Override
    public Image getImageById(Long id) {
        return imageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Image not found"));
    }

    @Override
    public Image getImageByName(String name) {
        return imageRepository.findByName(name);
    }

    @Override
    public Image updateImage(Image image, Long id) {
        return Optional.ofNullable(getImageById(id))
                .map(oldImage ->
                {
                    oldImage.setFileName(image.getFileName());
                    return imageRepository.save(oldImage);
                }).orElseThrow(() -> new ResourceNotFoundException("Image not found"));
    }

    @Override
    public void deleteImageById(Long id) {
        imageRepository.findById(id)
                .ifPresentOrElse(imageRepository::delete,
                        () ->
                        {
                            throw new ResourceNotFoundException("Image not found");
                        });
    }

    @Override
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }
}
