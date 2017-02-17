package com.abn.dsalgos.exceptions;

/**
 * Created by aswathyn on 17/02/17.
 */
public class EmptyLinkedListException extends GenericException {

    public EmptyLinkedListException() {
    }

    public EmptyLinkedListException(String message) {
        super(message);
    }

    public EmptyLinkedListException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyLinkedListException(Throwable cause) {
        super(cause);
    }
}
