package com.tanktoys.app.models;

public class Shell {
    private int _id;
    private int _hp;
    private String _type;
    private String _name;

    public Shell(int id, int hp, String type, String name) {
        SetShell(id, hp, type, name);
    }

    public void SetShell(int id, int hp, String type, String name) {
        _id = id;
        _hp = hp;
        _type = type;
        _name = name;
    }

    public int GetId() {
        return _id;
    }

    public void SetId(int id) {
        _id = id;
    }

    public int GetHp() {
        return _hp;
    }

    public String GetType() {
        return _type;
    }

    public String GetName() {
        return _name;
    }
}
