package com.tanktoys.app.models;

public class Cannon {
    private int _reloadSpeed;
    private int _amo;
    private String _name;
    private String _bulletType;

    public Cannon(int reloadSpeed, int amo, String name, String bulletType) {
        SetCannon(reloadSpeed, amo, name, bulletType);
    }

    public void SetCannon(int reloadSpeed, int amo, String name, String bulletType) {
        _reloadSpeed = reloadSpeed;
        _amo = amo;
        _name = name;
        _bulletType = bulletType;
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
