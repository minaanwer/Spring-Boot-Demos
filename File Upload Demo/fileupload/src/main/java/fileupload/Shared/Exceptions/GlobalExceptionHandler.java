package fileupload.Shared.Exceptions;

import fileupload.UI.Models.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(InvalidAttachmentException.class)
    public ResponseEntity<?> resourceNotFoundException(InvalidAttachmentException ex, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));

        ResponseModel<ErrorDetails> responseModel = new ResponseModel<>("001", ex.getMessage(), errorDetails);

        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
        //todo : remove exception message , return General Issue to the Customer , we keep it for debug purposes.
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        ResponseModel<ErrorDetails> responseModel = new ResponseModel<>("999", "Internal Server Error", errorDetails);
        return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
