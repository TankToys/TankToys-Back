package com.tanktoys.app.models;

public class Bullet {
    private int _id;
    private int _speed;
    private int _dmg;
    private int _bounces;
    private String _name;
    private String _type;

    public Bullet(int id, int speed, int dmg, int bounces, String name, String type) {
        SetBullet(id, speed, dmg, bounces, name, type);
    }

    public void SetBullet(int id, int speed, int dmg, int bounces, String name, String type) {
        _id = id;
        _speed = speed;
        _dmg = dmg;
        _bounces = bounces;
        _name = name;
    }

    public int GetId() {
        return _id;
    }

    public int GetSpeed() {
        return _speed;
    }

    public int GetDmg() {
        return _dmg;
    }

    public int GetBounces() {
        return _bounces;
    }

    public String GetName() {
        return _name;
    }

    public String GetType() {
        return _type;
    }
}
