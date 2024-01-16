package com.tanktoys.app.utils.customExceptions;

public class AddressNotValidException extends Exception { 

    public static String ExceptionBody = " is not a valid address";

    public AddressNotValidException(String address) {
        super(address + ExceptionBody);
    }
}