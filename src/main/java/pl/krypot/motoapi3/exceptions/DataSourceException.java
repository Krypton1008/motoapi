package pl.krypot.motoapi3.exceptions;


import pl.krypot.motoapi3.exceptions.base.MotofanException;

public class DataSourceException extends MotofanException {

    public DataSourceException() {
        super();
    }

    public DataSourceException(String message) {
        super(message);
    }

    public DataSourceException(String message, Throwable cause) {
        super(message, cause);
    }
}
