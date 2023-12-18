package com.tanktoys.app.models;

import com.tanktoys.app.utils.AddressValidator;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

public class Address {
    private String _address;

    public Address(String address) throws AddressNotValidException {
        SetAddress(address);
    }

    public String GetAddress() {
        if (_address != null) {
            return _address;
        } else {
            return null;
        }
    }

    @Override
    public String toString(){
        return _address;
    }

    public void SetAddress(String address) throws AddressNotValidException {
        if (AddressValidator.validate(address)) {
            _address = address;
        } else {
            throw new AddressNotValidException(address);
        }
    }
}
