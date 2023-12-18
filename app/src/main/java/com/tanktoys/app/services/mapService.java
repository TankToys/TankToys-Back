package com.tanktoys.app.services;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.tanktoys.app.models.Address;
import com.tanktoys.app.models.Map;
import com.tanktoys.app.models.User;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

public class mapService {
    
    @Autowired
    DatabaseService db;

    public List<Map> getAllMaps(){
        
        return null;
    }
    
    public User JSONToMap(String mapString) throws JSONException, AddressNotValidException{
        return null;
    }

    public Map getMapById(int id){
        return null;
    }

    public Map[] getMapsByCreatorAddress(String creator) throws AddressNotValidException{
        return null;
    }

    public boolean insertMap(Map map){
        return true;
    }

    public boolean editMap(Map map) {
        return true;
    }

    public boolean deleteMap(int id) {
        return true;
    }
}
