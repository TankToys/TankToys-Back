package com.tanktoys.app.models;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tanktoys.app.interfaces.IDatabaseItem;

public class Room implements IDatabaseItem{



    private List<String> _guestList = new ArrayList<String>();

    public List<String> GetGuestList(){
        return _guestList;
    }
    
    public void AddToGuestList(String guest){
        _guestList.add(guest);
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
    public IDatabaseItem load(ResultSet rs, int rowNum) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'load'");
    }
}
