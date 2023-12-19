package com.tanktoys.app.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tanktoys.app.utils.AddressValidator;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

public class Address {
    @JsonProperty("address")
    public String address;

    public Address(String address) throws AddressNotValidException {
        SetAddress(address);
    }

    public String GetAddress() {
        if (this.address != null) {
            return this.address;
        } else {
            return null;
        }
    }

    @Override
    public String toString(){
        return this.address;
    }

    public void SetAddress(String address) throws AddressNotValidException {
        if (AddressValidator.validate(address)) {
            this.address = address;
        } else {
            throw new AddressNotValidException(address);
        }
    }
}
