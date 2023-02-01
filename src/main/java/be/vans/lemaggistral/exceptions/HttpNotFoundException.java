package be.vans.lemaggistral.exceptions;

import be.vans.lemaggistral.models.exceptions.HttpExceptionDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class HttpNotFoundException extends HttpException {

    public HttpNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);

    }
}
