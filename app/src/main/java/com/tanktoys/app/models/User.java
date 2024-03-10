package com.tanktoys.app.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tanktoys.app.interfaces.IDatabaseItem;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

import jakarta.validation.constraints.NotNull;

@Component
public class User implements IDatabaseItem{

    @NotNull(message = "address cannot be null")
    @JsonProperty("address")
    public String address;
    
    @NotNull(message = "username cannot be null")
    @JsonProperty("user")
    public String user;

    @NotNull(message = "level cannot be null")
    @JsonProperty("level")
    public int level;

    @JsonProperty("profileImage")
    public String profileImage;
    
    public User() throws AddressNotValidException{
        this.address = "0x0000000000000000000000000000000000000000";
        this.user = "default";
        this.level = 0;
    }

    public User(@JsonProperty("address")Address address, @JsonProperty("user")String user, @JsonProperty("level")int level, @JsonProperty("profileImage") String profileImage) throws AddressNotValidException{
        this.address = address.toString();
        this.user = user;
        this.level = level;
        this.profileImage = profileImage;
    }

    public String Getuser(){
        return this.user;
    }
    
    public void Setuser(String user){
        this.user = user;
    }
    public String Getaddress(){
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
        this.address = Address.parse(rs.getString(1)).toString();
        this.user = rs.getString(2);   
        this.level = rs.getInt(3);
        this.profileImage = rs.getString(4);
        return this;
    }
}
