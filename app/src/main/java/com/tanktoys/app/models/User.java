package com.tanktoys.app.models;

import com.tanktoys.app.services.interfaces.IDatabaseItem;

import jakarta.validation.constraints.NotNull;

public class User implements IDatabaseItem{

    @NotNull(message = "address cannot be null")
    private String _address;
    
    @NotNull(message = "username cannot be null")
    private String _user;

    public User(){
        
    }

    public User(String address, String user){
        _address = address;
        _user = user;
    }

    public String Getuser(){
        return _user;
    }
    
    public void Setuser(String user){
        _user = user;
    }
    public String Getaddress(){
        return _address;
    }
    
    public void Setaddress(String address){
        _address = address;
    }

    public String toString(){
        return "address: "+_address+" , user: "+_user;
    }

    @Override
    public String ToINSERT() {
        return "INSERT ";
    }



}
