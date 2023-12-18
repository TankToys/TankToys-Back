package com.tanktoys.app.models;

import java.util.Set;

public class Shell {
    private int _hp;
    private String _type;
    private String _name;

    public Shell(int hp, String type, String name) {
        SetShell(hp, type, name);
    }

    public void SetShell(int hp, String type, String name) {
        _hp = hp;
        _type = type;
        _name = name;
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
