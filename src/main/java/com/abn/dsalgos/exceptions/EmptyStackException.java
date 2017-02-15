package com.abn.dsalgos.exceptions;

/**
 * Created by aswathyn on 15/02/17.
 */
public class EmptyStackException extends GenericException {

    public EmptyStackException() {
    }

    public EmptyStackException(String message) {
        super(message);
    }

    public EmptyStackException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyStackException(Throwable cause) {
        super(cause);
    }

}
