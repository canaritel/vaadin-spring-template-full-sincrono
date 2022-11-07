package es.televoip.backend.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = false)
public class ControllerExceptions extends RuntimeException {

    private final String message;
    private final HttpStatus httpStatus;

    public ControllerExceptions(String message, HttpStatus httpStatus) {
        super(message); //pasamos el mensaje de error a la clases superiores
        this.message = message;
        this.httpStatus = httpStatus;
    }

}
