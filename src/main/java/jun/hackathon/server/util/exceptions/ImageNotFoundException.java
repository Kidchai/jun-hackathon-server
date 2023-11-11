package jun.hackathon.server.util.exceptions;

public class ImageNotFoundException extends Exception {
    public ImageNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
