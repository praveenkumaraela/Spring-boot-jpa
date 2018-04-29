package customexceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.model.ErrorDetails;


@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(UserNotFoundException.class)
  public final ResponseEntity<ErrorDetails> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
    com.example.demo.model.ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
        request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
  }
  
  @ExceptionHandler(RuntimeException.class)
  public final ResponseEntity<ErrorDetails> handleMyRuntimeException(RuntimeException ex, WebRequest request){
	  com.example.demo.model.ErrorDetails errorDetails = new ErrorDetails(new Date(), "Hey exception happened!",
		        request.getDescription(false));
	  return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
  }
  
  /*@ExceptionHandler
	 public ResponseEntity<Object> handleException(MethodArgumentNotValidException exception) {
		
		 
			 ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed",
					 exception.getBindingResult().toString());
			 return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
		 
	 }*/
}
 