package com.simple.exceptions;

public class InvalidArgumentsException extends Exception {

    public static final String MESSAGE = "Invalid input arguments";
    public static final String ERROR_CODE = "CAL-0002";

    public InvalidArgumentsException() {
        super(MESSAGE);
    }

}
