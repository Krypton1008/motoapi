package pl.krypot.motoapi3.exceptions;


import pl.krypot.motoapi3.exceptions.base.MotofanException;

public class ItemNotFoundException extends MotofanException {

    public ItemNotFoundException() {
        super();
    }

    public ItemNotFoundException(String message) {
        super(message);
    }

    public ItemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
