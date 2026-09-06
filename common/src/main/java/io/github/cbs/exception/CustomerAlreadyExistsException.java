package io.github.cbs.exception;

public class CustomerAlreadyExistsException extends BusinessException {

    public CustomerAlreadyExistsException() {
        super("Customer registration failed: customer already exists");
    }

    public CustomerAlreadyExistsException(String message) {
        super(message);
    }
}
