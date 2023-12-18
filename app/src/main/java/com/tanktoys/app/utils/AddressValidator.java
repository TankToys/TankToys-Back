package com.tanktoys.app.utils;

public class AddressValidator {

    public static final String Regex = "^0x[a-fA-F0-9]{40}$";

    public static boolean validate(String addr) {
        if (addr.matches(Regex)) {
            return true;
        }
        return false;
    }

}
