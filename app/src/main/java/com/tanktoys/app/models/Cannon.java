package com.tanktoys.app.models;

public class Cannon {
    public int _id;
    public int _reloadSpeed;
    public int _amo;
    public String _name;
    public String _bulletType;

    public Cannon(int id, int reloadSpeed, int amo, String name, String bulletType) {
        SetCannon(id, reloadSpeed, amo, name, bulletType);
    }

    public void SetCannon(int id, int reloadSpeed, int amo, String name, String bulletType) {
        _id = id;
        _reloadSpeed = reloadSpeed;
        _amo = amo;
        _name = name;
        _bulletType = bulletType;
    }

    public int GetId() {
        return _id;
    }

    public void SetId(int id) {
        _id = id;
    }

    public int GetSpeed() {
        return _reloadSpeed;
    }

    public int GetAmo() {
        return _amo;
    }

    public String GetName() {
        return _name;
    }

    public String GetBulletType() {
        return _bulletType;
    }
}
