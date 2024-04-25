package RollingRolling.RollingMindBackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class BadRequestException extends Exception {
    public BadRequestException(String message){
        super(message);
    }
}