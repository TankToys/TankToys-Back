package com.tanktoys.app.models;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tanktoys.app.interfaces.IDatabaseItem;


public class Room implements IDatabaseItem {

    public enum gameModes {
        _1V1,
        _PVP,
        GAMEMODE3
    }

    @JsonProperty("id")
    public String id;
    @JsonProperty("guestList")
    public List<String> guestList = new ArrayList<String>();
    @JsonProperty("host")
    public String host;
    @JsonProperty("gameMode")
    public gameModes gameMode;

    public Room(String id, List<String> guestList, String host, gameModes gameMode){
        this.id = id;
        this.guestList = guestList;
        this.host = host;
        this.gameMode = gameMode;
    }

    public String GetId() {
        return this.id;
    }

    public void SetId(String id) {
        this.id = id;
    }

    public gameModes GetGameMode() {
        return this.gameMode;
    }

    public void SetGameMode(gameModes gameMode) {
        this.gameMode = gameMode;
    }

    public String GetHost() {
        return this.host;
    }

    public void SetHost(String host) {
        this.host = host;
    }

    public List<String> GetGuestList() {
        return this.guestList;
    }

    public void AddToGuestList(String guest) {
        this.guestList.add(guest);
    }

    @Override
    public String ToINSERT() {
        return "INSERT INTO rooms (id, host, guests, gamemode) VALUES ('" + this.id + "', '" + this.host + "' ARRAY ["
                + String.join(", ", this.guestList) + "], " + this.gameMode.ordinal() + ");";
    }

    @Override
    public <T> String ToSELECT(T key) {
        return "SELECT * FROM rooms WHERE id = '"+key+"'";
    }

    @Override
    public <T> String ToSELECTKeyName(String keyName, T key) {
        return "SELECT * FROM rooms WHERE "+keyName+" = '"+key+"'";
    }

    @Override
    public <T> String ToDELETE(T key) {
        return "DELETE FROM rooms WHERE id = " + key;
    }

    @Override
    public <T> String ToUPDATE(T key) {
        return "UPDATE rooms SET host='" + this.host + "', ARRAY ["
                + String.join(", ", this.guestList) + "], gamemode='" + this.gameMode + "' WHERE id = " + key;
    }

    @Override
    public IDatabaseItem load(ResultSet rs, int rowNum) throws Exception {
        this.id = rs.getString(1);
        this.host = rs.getString(2);
        this.guestList = Arrays.asList((String[]) rs.getArray(3).getArray());
        this.gameMode = gameModes.values()[rs.getInt(4)];
        return this;
    }

}
