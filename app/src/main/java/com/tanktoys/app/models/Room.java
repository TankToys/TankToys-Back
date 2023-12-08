package com.tanktoys.app.models;

import java.util.List;

public class Room {

    private List<String> _playerList;
    public List<String> GetplayerList(){
        return _playerList;
    }
    
    public void SetplayerList(List<String> playerList){
        _playerList = playerList;
    }
}
