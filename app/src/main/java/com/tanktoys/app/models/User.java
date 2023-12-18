package com.tanktoys.app.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.tanktoys.app.interfaces.IDatabaseItem;
import com.tanktoys.app.interfaces.ISerializable;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

import jakarta.validation.constraints.NotNull;

@Component
public class User implements IDatabaseItem, ISerializable{

    @NotNull(message = "address cannot be null")
    private Address _address;
    
    @NotNull(message = "username cannot be null")
    private String _user;

    @NotNull(message = "level cannot be null")
    private int _level;
    
    public User() throws AddressNotValidException{
        _address = new Address("0x0000000000000000000000000000000000000000");
        _level = 0;
    }

    public User(String address, String user, int level) throws AddressNotValidException{
        _address = new Address(address);
        _user = user;
        _level = level;
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
    
    public int GetLevel(){
        return _level;
    }
    
    public void SetLevel(int level){
        _level = level;
    }


    @Override
    public String ToINSERT() {
        return "INSERT INTO addresses(address, username, level) VALUES('"+_address.toString()+"','"+_user+"', 0)";
    }

    @Override
    public <T> String ToSELECT(T key) {
        return "SELECT * FROM addresses WHERE address LIKE '"+key+"'";
    }

    @Override
    public <T> String ToUPDATE(T key) {
        return "UPDATE addresses SET address='"+_address.toString()+"', username='"+_user+"', level='"+_level+"' WHERE address LIKE '"+key+"'";
    }

    @Override
    public <T> String ToDELETE(T key) {
        return "DELETE FROM addresses WHERE address LIKE '"+key+"'";
    }

    @Override
    public User load(ResultSet rs, int rowNum) throws AddressNotValidException, SQLException {
        _address.Setaddress(rs.getString(1));
        _user = rs.getString(2);   
        return this;
    }

    @Override
    public String toJSON() {
        JSONObject jsonObject = new JSONObject();
        Map<String, Object> userMap = new HashMap<String, Object>();
        userMap.put("address", _address.Getaddress());
        userMap.put("user", _user);
        userMap.put("level", _level);
        jsonObject.put("user", userMap);
        return jsonObject.toString();
    }

    @Override
    public User fromJSON(String JSON) throws JSONException, AddressNotValidException{
        JSONObject object = new JSONObject(JSON);
        _address.Setaddress(object.getString("address"));
        _user = object.getString("user");
        _level = object.getInt("level");
        return this;
    }    
}
