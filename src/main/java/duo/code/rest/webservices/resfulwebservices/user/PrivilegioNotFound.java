package duo.code.rest.webservices.resfulwebservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PrivilegioNotFound extends RuntimeException {

    public PrivilegioNotFound(String message) {
        super(message);
    }
}
