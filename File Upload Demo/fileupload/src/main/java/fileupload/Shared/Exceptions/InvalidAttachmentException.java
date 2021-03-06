package fileupload.Shared.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidAttachmentException extends Exception {

    private static final long serialVersionID = 1L;

    public InvalidAttachmentException(String message) {
        super(message);
    }
}
