package bip.online.coursework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IndexOfException extends RuntimeException{
    public IndexOfException(String message) {
        super(message);
    }
}
