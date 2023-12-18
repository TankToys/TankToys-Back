package com.tanktoys.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanktoys.app.models.Address;
import com.tanktoys.app.models.Ranking;
import com.tanktoys.app.models.Tank;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

@Service
public class RankingService {
    @Autowired
    DatabaseService db;

    public Ranking[] getRanksByAddress(Address address) throws AddressNotValidException{
        return null;
    }

    public Ranking[] getRanksByMode(String modeName) throws AddressNotValidException{
        // Ranking ranking = new Ranking();
        // return (Address[])db.SelectByKey(ranking, "modes", modeName).toArray();
        return null;
    }

    public Tank[] getRankByModeAndAddress(String modeName, String address) throws AddressNotValidException {
        return null;
    }

    public Ranking[] getAllRankings() {
        return null;
    }

    public boolean insertRanking(Ranking ranking){
        return db.Insert(ranking);
    }

    public boolean editRanking(Ranking ranking) {
        return db.Update(ranking, ranking.GetUser());
    }

    public boolean deleteRanking(Address address) throws AddressNotValidException {
        Ranking ranking = new Ranking();
        return db.Delete(ranking, address.toString());
    }
}
