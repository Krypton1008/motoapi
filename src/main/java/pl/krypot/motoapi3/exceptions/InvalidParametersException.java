package pl.krypot.motoapi3.exceptions;

import pl.krypot.motoapi3.exceptions.base.MotofanException;

public class InvalidParametersException extends MotofanException {

    public InvalidParametersException() {
        super();
    }

    public InvalidParametersException(String message) {
        super(message);
    }

    public InvalidParametersException(String message, Throwable cause) {
        super(message, cause);
    }
}
