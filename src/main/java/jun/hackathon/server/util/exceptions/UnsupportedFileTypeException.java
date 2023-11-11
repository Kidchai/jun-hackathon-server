package jun.hackathon.server.util.exceptions;

import java.io.IOException;

public class UnsupportedFileTypeException extends IOException {
    public UnsupportedFileTypeException(String errorMessage) {
        super(errorMessage);
    }
}
