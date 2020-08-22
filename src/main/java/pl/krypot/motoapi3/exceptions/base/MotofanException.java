package pl.krypot.motoapi3.exceptions.base;

public class MotofanException extends Exception {

    public MotofanException() {
        super();
    }

    public MotofanException(String message) {
        super(message);
    }

    public MotofanException(String message, Throwable cause) {
        super(message, cause);
    }
}
