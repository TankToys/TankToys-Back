package com.tanktoys.app.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.tanktoys.app.interfaces.IDatabaseItem;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

import jakarta.validation.constraints.NotNull;

@Component
public class User implements IDatabaseItem{

    @NotNull(message = "address cannot be null")
    private Address _address;
    
    @NotNull(message = "username cannot be null")
    private String _user;

    public User() throws AddressNotValidException{
        _address = new Address("0x0000000000000000000000000000000000000000");
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

    @Override
    public String toString(){
        return "address: "+_address.Getaddress()+" , user: "+_user;
    }

    @Override
    public String ToINSERT() {
        return "INSERT INTO addresses(address,\"user\") VALUES('"+_address.toString()+"','"+_user+"')";
    }

    @Override
    public <T> String ToSELECT(T key) {
        return "SELECT * FROM addresses WHERE address LIKE '"+key+"'";
    }

    @Override
    public User load(ResultSet rs, int rowNum) throws AddressNotValidException, SQLException {
        _address.Setaddress(rs.getString(1));
        _user = rs.getString(2);   
        return this;
    }



    
}
