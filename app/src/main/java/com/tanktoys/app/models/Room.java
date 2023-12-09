package com.tanktoys.app.models;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private List<String> _playerList = new ArrayList<String>();


    public List<String> GetplayerList(){
        return _playerList;
    }
    
    public void AddToPlayerList(String player){
        _playerList.add(player);
    }
}
