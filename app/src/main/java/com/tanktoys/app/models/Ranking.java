package com.tanktoys.app.models;

<<<<<<< HEAD
import java.util.Set;

import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

import jakarta.validation.constraints.NotNull;

public class Ranking {
    @NotNull(message = "Address cannot be null")
    private Address _address;

    private int _rankModeA;

    private int _rankModeB;

    private int _rankModeC;

    public Ranking(String address, int rankModeA, int rankModeB, int rankModeC) throws AddressNotValidException {
        SetRanking(address, rankModeA, rankModeB, rankModeC);
    }

    public void SetRanking(String address, int rankModeA, int rankModeB, int rankModeC) throws AddressNotValidException {
        _address = new Address(address);
        _rankModeA = rankModeA;
        _rankModeB = rankModeB;
        _rankModeC = rankModeC;
    }
=======
import java.sql.ResultSet;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.tanktoys.app.interfaces.IDatabaseItem;

@Component
public class Ranking implements IDatabaseItem {

    private String _user;
    private Map<String, Integer> _modes;

    
    public Map<String, Integer> GetModes(){
        return _modes;
    }
    
    public void Setmodes(Map<String, Integer> modes){
        _modes = modes;
    }

    public String GetUser(){
        return _user;
    }
    
    public void SetUser(String user){
        _user = user;
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

>>>>>>> ef6cb3cb040d1b7896b72ad81a88513a4cc7e75a
}
