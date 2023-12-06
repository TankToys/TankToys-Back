package com.tanktoys.app.models;

public class User {

    // property definition
    private String _address;
    private String _user;

    // constructors
    public User(){
        
    }

    // Setters & Getters
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

    // Class specific methods
    public String toString(){
        return "address: "+_address+" , user: "+_user;
    }



}
