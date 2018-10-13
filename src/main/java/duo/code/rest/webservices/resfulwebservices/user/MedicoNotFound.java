package duo.code.rest.webservices.resfulwebservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MedicoNotFound extends RuntimeException {
    public MedicoNotFound(String message) {
        super(message);
    }
}