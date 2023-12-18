package com.tanktoys.app.services;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanktoys.app.models.Address;
import com.tanktoys.app.models.Map;
import com.tanktoys.app.models.User;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

@Service
public class MapService {
    
    @Autowired
    DatabaseService db;

    public List<Map> getAllMaps(){
        
        return null;
    }
    
    public User JSONToMap(String mapString) throws JSONException, AddressNotValidException{
        return null;
    }

    public Map getMapById(int id){
        Map map = new Map();
        db.SelectByKey(map, id);
        return map;
    }

    public Map[] getMapsByCreatorAddress(String creator) throws AddressNotValidException{
        return null;
    }

    public boolean insertMap(Map map){
        return db.Insert(map);
    }

    public boolean editMap(Map map) {
        return db.Update(map, map.GetId());
    }

    public boolean deleteMap(int id) {
        Map map = new Map();
        return db.Delete(map, id);
    }
}
