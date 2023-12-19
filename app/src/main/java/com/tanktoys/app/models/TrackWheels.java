package com.tanktoys.app.models;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class TrackWheels {
    
    @JsonProperty("id")
    public int id;
    @JsonProperty("speed")
    public int speed;
    @JsonProperty("terrain")
    public String terrain;
    @JsonProperty("trackOrWheel")
    public String trackOrWheel;
    @JsonProperty("tankType")
    public String tankType;
    @JsonProperty("name")
    public String name;

    public TrackWheels(int id, int speed, String terrain, String trackOrWheel, String tankType, String name) {
        SetTrackWheels(id, speed, terrain, trackOrWheel, tankType, name);
    }

    public void SetTrackWheels(int id, int speed, String terrain, String trackOrWheel, String tankType, String name) {
        this.id = id;
        this.speed = speed;
        this.terrain = terrain;
        this.trackOrWheel = trackOrWheel;
        this.tankType = tankType;
        this.name = name;
    }

    public int GetId() {
        return id;
    }
    
    public void SetId(int id) {
        this.id = id;
    }

    public int GetSpeed() {
        return this.speed;
    }

    public String GetTerrain() {
        return this.terrain;
    }

    public String GetTrackOrWheel() {
        return this.trackOrWheel;
    }

    public String GetTankType() {
        return this.tankType;
    }

    public String GetName() {
        return this.name;
    }
}
