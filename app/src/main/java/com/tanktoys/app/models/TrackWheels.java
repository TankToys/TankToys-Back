package com.tanktoys.app.models;

public class TrackWheels {
    public int _id;
    public int _speed;
    public String _terrain;
    public String _trackOrWheel;
    public String _tankType;
    public String _name;

    public TrackWheels(int id, int speed, String terrain, String trackOrWheel, String tankType, String name) {
        SetTrackWheels(id, speed, terrain, trackOrWheel, tankType, name);
    }

    public void SetTrackWheels(int id, int speed, String terrain, String trackOrWheel, String tankType, String name) {
        _id = id;
        _speed = speed;
        _terrain = terrain;
        _trackOrWheel = trackOrWheel;
        _tankType = tankType;
        _name = name;
    }

    public int GetId() {
        return _id;
    }
    
    public void SetId(int id) {
        _id = id;
    }

    public int GetSpeed() {
        return _speed;
    }

    public String GetTerrain() {
        return _terrain;
    }

    public String GetTrackOrWheel() {
        return _trackOrWheel;
    }

    public String GetTankType() {
        return _tankType;
    }

    public String GetName() {
        return _name;
    }
}
