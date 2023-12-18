package com.tanktoys.app.models;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.tanktoys.app.interfaces.IDatabaseItem;
import com.tanktoys.app.interfaces.ISerializable;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

@Component
public class Room implements IDatabaseItem, ISerializable {

    public enum gameModes {
        GAMEMODE1,
        GAMEMODE2,
        GAMEMODE3
    }

    private int _id;
    private List<String> _guestList = new ArrayList<String>();
    private String _host;
    private gameModes _gameMode;

    public int GetId() {
        return _id;
    }

    public void SetId(int id) {
        _id = id;
    }

    public gameModes GetGameMode() {
        return _gameMode;
    }

    public void SetGameMode(gameModes gameMode) {
        _gameMode = gameMode;
    }

    public String GetHost() {
        return _host;
    }

    public void SetHost(String host) {
        _host = host;
    }

    public List<String> GetGuestList() {
        return _guestList;
    }

    public void AddToGuestList(String guest) {
        _guestList.add(guest);
    }

    @Override
    public String ToINSERT() {
        return "INSERT INTO rooms (host, guests, gamemode) VALUES ('" + _host + "', ARRAY ["
                + String.join(", ", _guestList) + "], " + _gameMode + ");";
    }

    @Override
    public <T> String ToSELECT(T key) {
        return "SELECT * FROM rooms";
    }

    @Override
    public <T> String ToDELETE(T key) {
        return "DELETE FROM rooms WHERE id = " + key;
    }

    @Override
    public <T> String ToUPDATE(T key) {
        return "UPDATE rooms SET host='" + _host + "', ARRAY ["
                + String.join(", ", _guestList) + "], gamemode='" + _gameMode + "' WHERE id = " + key;
    }

    @Override
    public IDatabaseItem load(ResultSet rs, int rowNum) throws Exception {
        _id = rs.getInt(1);
        _host = rs.getString(2);
        _guestList = Arrays.asList((String[]) rs.getArray(3).getArray());
        _gameMode = gameModes.values()[rs.getInt(4)];
        return this;
    }

    @Override
    public String toJSON() {
        JSONObject jsonObject = new JSONObject();
        Map<String, Object> roomMap = new HashMap<String, Object>();
        roomMap.put("id", _id);
        roomMap.put("host", _host);
        roomMap.put("guestList", _guestList);
        roomMap.put("gameMode", _gameMode);
        jsonObject.put("room", roomMap);
        return jsonObject.toString();
    }

    @Override
    public Room fromJSON(String JSON) throws JSONException, AddressNotValidException{
        JSONObject object = new JSONObject(JSON);
        _id = object.getInt("id");
        _host = object.getString("host");
        for(Object a:object.getJSONArray("guestList").toList()){
            _guestList.add(String.valueOf(a));
        }
        _gameMode = gameModes.values()[object.getInt("gameMode")];
        return this;
    }

}
