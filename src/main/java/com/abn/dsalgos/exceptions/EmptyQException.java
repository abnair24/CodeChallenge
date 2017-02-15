package com.abn.dsalgos.exceptions;

/**
 * Created by aswathyn on 15/02/17.
 */
public class EmptyQException extends GenericException {

    public EmptyQException() {
    }

    public EmptyQException(String message) {
        super(message);
    }

    public EmptyQException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyQException(Throwable cause) {
        super(cause);
    }
}
