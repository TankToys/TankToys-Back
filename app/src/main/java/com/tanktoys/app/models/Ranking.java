package com.tanktoys.app.models;

import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

import jakarta.validation.constraints.NotNull;

import java.sql.ResultSet;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.tanktoys.app.interfaces.IDatabaseItem;

@Component
public class Ranking implements IDatabaseItem {

    private Address _address;
    private Map<String, Integer> _modes;

    public Ranking(){
        
    }

    public Ranking(String address, Map<String, Integer> modes) throws AddressNotValidException {
        SetRanking(address, _modes);
    }

    public void SetRanking(String address, Map<String, Integer> modes) throws AddressNotValidException {
        _address = new Address(address);
        _modes = modes;
    }

    public Map<String, Integer> GetModes(){
        return _modes;
    }
    
    public void Setmodes(Map<String, Integer> modes){
        _modes = modes;
    }

    public Address GetUser(){
        return _address;
    }
    
    public void SetUser(Address address){
        _address = address;
    }
    
    @Override
    public String ToINSERT() {
        return "INSERT INTO ranking(address, modes) VALUES('"+_address+"','"+_modes.toString()+"')";
    }

    @Override
    public <T> String ToSELECT(T key) {
        return "SELECT * FROM ranking WHERE address LIKE '"+key+"';";
    }

    @Override
    public <T> String ToDELETE(T key) {
        return "DELETE FROM ranking WHERE address LIKE '"+key+"';";
    }
    
    @Override
    public <T> String ToUPDATE(T key) {
        return "UPDATE ranking SET address='"+_address+"', modes='"+_modes+"' WHERE address LIKE '"+key+"';";
    }

    @Override
    public IDatabaseItem load(ResultSet rs, int rowNum) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'load'");
    }

}
