package com.tanktoys.app.services;

import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanktoys.app.models.Tank;
import com.tanktoys.app.models.User;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

@Service
public class TankService {
    @Autowired
    DatabaseService db;

    public List<Tank> getAllTanks(){
        
        return null;
    }
    
    public User JSONToTank(String tankString) throws JSONException{
        return null;
    }

    public Tank getTankById(int id){
        return null;
    }

    public Tank[] getTanksByCreatorAddress(String creator) throws AddressNotValidException{
        return null;
    }

    public Tank[] getTanksByBullet(int bulletId){
        return null;
    }

    public Tank[] getTanksByCannon(int cannonId){
        return null;
    }

    public Tank[] getTanksByShell(int shellId){
        return null;
    }

    public Tank[] getTanksByTrackWheel(int trackWheelId){
        return null;
    }

    public boolean insertTank(Tank Tank){
        return true;
    }

    public boolean editTank(Tank Tank) {
        return true;
    }

    public boolean deleteTank(int id) {
        return true;
    }
}
