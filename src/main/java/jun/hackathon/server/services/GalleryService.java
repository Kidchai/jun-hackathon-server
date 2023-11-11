package jun.hackathon.server.services;

import jun.hackathon.server.models.Image;
import jun.hackathon.server.repositories.ImageRepository;
import jun.hackathon.server.storage.ImageStorage;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.util.UUID;

@Service
public class GalleryService {

    private final ImageStorage imageStorage;
    private final ImageRepository imageRepository;

    public GalleryService(ImageStorage imageStorage, ImageRepository imageRepository) {
        this.imageStorage = imageStorage;
        this.imageRepository = imageRepository;
    }

    public String uploadImage(MultipartFile file) throws IOException {
        BufferedImage image = ImageIO.read(file.getInputStream());
        String imageId = UUID.randomUUID().toString();
        String filename = imageId + ".png";
        String path = imageStorage.addImage(image, filename);

        Image imageEntity = new Image();
        imageEntity.setImageId(imageId);
        imageEntity.setPath(path);
        imageRepository.save(imageEntity);

        return imageId;
    }

}
