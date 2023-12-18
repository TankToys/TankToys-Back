package com.tanktoys.app.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.tanktoys.app.models.Address;
import com.tanktoys.app.models.Ranking;
import com.tanktoys.app.models.Tank;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

public class RankingService {
    @Autowired
    DatabaseService db;

    public Map<String, Integer> getRanksByAddress(String address) throws AddressNotValidException{
        return null;
    }

    public Address[] getRanksByMode(String modeName) throws AddressNotValidException{
        // Ranking ranking = new Ranking();
        // return (Address[])db.SelectByKey(ranking, "modes", modeName).toArray();
        return null;
    }

    public Tank[] getRankByModeAndAddress(String modeName, String address) throws AddressNotValidException {
        return null;
    }
}
