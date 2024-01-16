package com.tanktoys.app.models;

import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

import java.sql.ResultSet;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tanktoys.app.interfaces.IDatabaseItem;

@Component
public class Ranking implements IDatabaseItem {
    
    @JsonProperty("address")
    public Address address;
    @JsonProperty("modes")
    public Map<String, Integer> modes;

    public Ranking(){
        
    }

    public Ranking(@JsonProperty("address")String address, @JsonProperty("modes")Map<String, Integer> modes) throws AddressNotValidException {
        SetRanking(address, this.modes);
    }

    public void SetRanking(String address, Map<String, Integer> modes) throws AddressNotValidException {
        this.address = new Address(address);
        this.modes = modes;
    }

    public Map<String, Integer> GetModes(){
        return this.modes;
    }
    
    public void Setmodes(Map<String, Integer> modes){
        this.modes = modes;
    }

    public Address GetUser(){
        return this.address;
    }
    
    public void SetUser(Address address){
        this.address = address;
    }
    
    @Override
    public String ToINSERT() {
        return "INSERT INTO ranking(address, modes) VALUES('"+this.address.GetAddress()+"','"+this.modes.toString()+"')";
    }

    @Override
    public <T> String ToSELECT(T key) {
        return "SELECT * FROM ranking WHERE address = '"+key+"';";
    }

    @Override
    public <T> String ToSELECTKeyName(String keyName, T key) {
        return "SELECT * FROM ranking WHERE "+keyName+" = '"+key+"';";
    }

    @Override
    public <T> String ToDELETE(T key) {
        return "DELETE FROM ranking WHERE address = '"+key+"';";
    }
    
    @Override
    public <T> String ToUPDATE(T key) {
        return "UPDATE ranking SET address='"+this.address.GetAddress()+"', modes='"+this.modes.toString()+"' WHERE address = '"+key+"';";
    }

    @Override
    public IDatabaseItem load(ResultSet rs, int rowNum) throws Exception {
        this.address.SetAddress(rs.getString(1));
        // this.modes = rs.getString(2);
        return this;
    }

}
