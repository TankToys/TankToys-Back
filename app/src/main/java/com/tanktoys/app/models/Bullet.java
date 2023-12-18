package com.tanktoys.app.models;

public class Bullet {
    public int _id;
    public int _speed;
    public int _dmg;
    public int _bounces;
    public String _name;
    public String _type;

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

    public void SetId(int id) {
        _id = id;
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
