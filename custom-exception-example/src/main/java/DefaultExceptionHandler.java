import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Pratik Ambani on 5/08/17.
 */

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    public final ResponseEntity<ErrorMessage> somethingWentWrong(HttpServletRequest request, Exception e) {
        System.out.println("Inside exception");
        ErrorMessage excRes = new ErrorMessage(e.getMessage(), "Hahahahahahahaha");
        return new ResponseEntity(excRes, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

class ErrorMessage {

    private String message;
    private String details;

    public ErrorMessage(String details, String message) {
        super();
        this.details = details;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
