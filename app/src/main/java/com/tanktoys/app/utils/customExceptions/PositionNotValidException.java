package com.tanktoys.app.utils.customExceptions;

public class PositionNotValidException extends Exception {
    public static String ExceptionBody = "Map lengths are not valid";

    public PositionNotValidException() {
        super(ExceptionBody);
    }
}
