package com.tanktoys.app.models;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class Shell {

    @JsonProperty("id")
    public int id;
    @JsonProperty("hp")
    public int hp;
    @JsonProperty("type")
    public String type;
    @JsonProperty("name")
    public String name;

    public Shell(int id, int hp, String type, String name) {
        SetShell(id, hp, type, name);
    }

    public void SetShell(int id, int hp, String type, String name) {
        this.id = id;
        this.hp = hp;
        this.type = type;
        this.name = name;
    }

    public int GetId() {
        return this.id;
    }

    public void SetId(int id) {
        this.id = id;
    }

    public int GetHp() {
        return this.hp;
    }

    public String GetType() {
        return this.type;
    }

    public String GetName() {
        return this.name;
    }
}
