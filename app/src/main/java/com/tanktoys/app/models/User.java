package com.tanktoys.app.models;

import com.tanktoys.app.interfaces.IDatabaseItem;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

import jakarta.validation.constraints.NotNull;

public class User implements IDatabaseItem{

    @NotNull(message = "address cannot be null")
    private Address _address;
    
    @NotNull(message = "username cannot be null")
    private String _user;

    public User(){
        
    }

    public User(String address, String user) throws AddressNotValidException{
        _address = new Address(address);
        _user = user;
    }

    public String Getuser(){
        return _user;
    }
    
    public void Setuser(String user){
        _user = user;
    }
    public Address Getaddress(){
        return _address;
    }


    public String toString(){
        return "address: "+_address.Getaddress()+" , user: "+_user;
    }

    @Override
    public String ToINSERT() {
        return "INSERT ";
    }



    
}
