package com.tanktoys.app.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tanktoys.app.interfaces.IDatabaseItem;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

import jakarta.validation.constraints.NotNull;

@Component
public class User implements IDatabaseItem{

    @NotNull(message = "address cannot be null")
    @JsonProperty("address")
    public Address address;
    
    @NotNull(message = "username cannot be null")
    @JsonProperty("user")
    public String user;

    @NotNull(message = "level cannot be null")
    @JsonProperty("level")
    public int level;
    
    public User() throws AddressNotValidException{
        address = new Address("0x0000000000000000000000000000000000000000");
        level = 0;
    }

    public User(@JsonProperty("address")String address, @JsonProperty("user")String user, @JsonProperty("level")int level) throws AddressNotValidException{
        this.address = new Address(address);
        this.user = user;
        this.level = level;
    }

    public String Getuser(){
        return this.user;
    }
    
    public void Setuser(String user){
        this.user = user;
    }
    public Address Getaddress(){
        return this.address;
    }
    
    public int GetLevel(){
        return this.level;
    }
    
    public void SetLevel(int level){
        this.level = level;
    }


    @Override
    public String ToINSERT() {
        return "INSERT INTO addresses(address, username, level) VALUES('"+this.address.toString()+"','"+this.user+"', 0)";
    }

    @Override
    public <T> String ToSELECT(T key) {
        return "SELECT * FROM addresses WHERE address = '"+key+"'";
    }

    @Override
    public <T> String ToSELECTKeyName(String keyName, T key) {
        return "SELECT * FROM addresses WHERE "+keyName+" = '"+key+"'";
    }  

    @Override
    public <T> String ToUPDATE(T key) {
        return "UPDATE addresses SET address='"+this.address.toString()+"', username='"+this.user+"', level='"+this.level+"' WHERE address = '"+key+"'";
    }

    @Override
    public <T> String ToDELETE(T key) {
        return "DELETE FROM addresses WHERE address = '"+key+"'";
    }

    @Override
    public User load(ResultSet rs, int rowNum) throws AddressNotValidException, SQLException {
        this.address.SetAddress(rs.getString(1));
        this.user = rs.getString(2);   
        this.level = rs.getInt(3);
        return this;
    }
}
