package com.tanktoys.app.models;

public class TrackWheels {
    private int _speed;
    private String _terrain;
    private String _trackOrWheel;
    private String _tankType;
    private String _name;

    public TrackWheels(int speed, String terrain, String trackOrWheel, String tankType, String name) {
        SetTrackWheels(speed, terrain, trackOrWheel, tankType, name);
    }

    public void SetTrackWheels(int speed, String terrain, String trackOrWheel, String tankType, String name) {
        _speed = speed;
        _terrain = terrain;
        _trackOrWheel = trackOrWheel;
        _tankType = tankType;
        _name = name;
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
