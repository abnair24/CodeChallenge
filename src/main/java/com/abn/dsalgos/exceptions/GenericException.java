package com.abn.dsalgos.exceptions;

/**
 * Created by aswathyn on 15/02/17.
 */
public class GenericException extends Exception {

    public GenericException() {

    }

    public GenericException(String message) {
        super(message);
    }

    public GenericException(String message, Throwable cause) {

        super(message, cause);
    }

    public GenericException(Throwable cause) {
        super(cause);
    }
}
