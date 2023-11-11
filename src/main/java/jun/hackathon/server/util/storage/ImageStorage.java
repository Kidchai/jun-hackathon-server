package jun.hackathon.server.util.storage;

import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class ImageStorage {

    private final Path rootLocation;

    public ImageStorage() {
        this.rootLocation = Paths.get("/tmp/uploaded-images");
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Can't create storage for images", e);
        }
    }

    public String addImage(BufferedImage image, String filename, String formatName) throws IOException {
        File outputFile = rootLocation.resolve(filename).toFile();
        ImageIO.write(image, formatName, outputFile);
        return outputFile.getAbsolutePath();
    }
}
