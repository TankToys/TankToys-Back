package com.tanktoys.app.utils.customExceptions;

public class AddressNotValidException extends Exception { 

    private static String ExceptionBody = " is not a valid address";

    public AddressNotValidException(String address) {
        super(address + ExceptionBody);
    }
}