package com.tanktoys.app.models;

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

}
