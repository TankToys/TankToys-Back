package com.tanktoys.app.models;
import java.util.Set;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ToINSERT'");
    }

    @Override
    public <T> String ToSELECT(T key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ToSELECT'");
    }

    @Override
    public <T> String ToDELETE(T key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ToDELETE'");
    }

    @Override
    public IDatabaseItem load(ResultSet rs, int rowNum) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'load'");
    }

    @Override
    public <T> String ToUPDATE(T key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ToUPDATE'");
    }
}
