package com.tanktoys.app.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Bullet {
    
    @JsonProperty("id")
    public int id;
    @JsonProperty("speed")
    public int speed;
    @JsonProperty("dmg")
    public int dmg;
    @JsonProperty("bounces")
    public int bounces;
    @JsonProperty("name")
    public String name;
    @JsonProperty("type")
    public String type;

    public Bullet(@JsonProperty("id")int id, @JsonProperty("speed")int speed, @JsonProperty("dmg")int dmg, @JsonProperty("bounces")int bounces, @JsonProperty("name")String name, @JsonProperty("type")String type) {
        SetBullet(id, speed, dmg, bounces, name, type);
    }

    public void SetBullet(@JsonProperty("id")int id, @JsonProperty("speed")int speed, @JsonProperty("dmg")int dmg, @JsonProperty("bounces")int bounces, @JsonProperty("name")String name, @JsonProperty("type")String type) {
        this.id = id;
        this.speed = speed;
        this.dmg = dmg;
        this.bounces = bounces;
        this.name = name;
    }

    public int GetId() {
        return this.id;
    }

    public void SetId(int id) {
        this.id = id;
    }

    public int GetSpeed() {
        return this.speed;
    }

    public int GetDmg() {
        return this.dmg;
    }

    public int GetBounces() {
        return this.bounces;
    }

    public String GetName() {
        return this.name;
    }

    public String GetType() {
        return this.type;
    }
}
