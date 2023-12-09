package com.tanktoys.app.models;

import com.tanktoys.app.utils.AddressValidator;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

public class Address {
    private String _address;

    public Address(String address) throws AddressNotValidException {
        Setaddress(address);
    }

    public String Getaddress() {
        if (_address != null) {
            return _address;
        } else {
            return null;
        }
    }

    public void Setaddress(String address) throws AddressNotValidException {
        if (AddressValidator.validate(address)) {
            _address = address;
        } else {
            throw new AddressNotValidException(address);
        }
    }
}
