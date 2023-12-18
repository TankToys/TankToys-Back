package com.tanktoys.app.services;

import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;

import com.tanktoys.app.models.Address;
import com.tanktoys.app.models.Tank;
import com.tanktoys.app.models.User;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

public class RankingService {
    @Autowired
    DatabaseService db;

    public int[] getRanksByAddress(String address) throws AddressNotValidException{
        return null;
    }

    public Address[] getRanksByMode(String modeName) throws AddressNotValidException{
        return null;
    }

    public Tank[] getRankByModeAndAddress(String modeName, String address) throws AddressNotValidException {
        return null;
    }
}
