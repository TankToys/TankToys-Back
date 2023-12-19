package com.tanktoys.app.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cannon {
    @JsonProperty("id")
    public int id;
    @JsonProperty("reloadSpeed")
    public int reloadSpeed;
    @JsonProperty("ammo")
    public int ammo;
    @JsonProperty("name")
    public String name;
    @JsonProperty("bulletType")
    public String bulletType;

    public Cannon(int id, int reloadSpeed, int amo, String name, String bulletType) {
        SetCannon(id, reloadSpeed, amo, name, bulletType);
    }

    public void SetCannon(int id, int reloadSpeed, int amo, String name, String bulletType) {
        this.id = id;
        this.reloadSpeed = reloadSpeed;
        this.ammo = amo;
        this.name = name;
        this.bulletType = bulletType;
    }

    public int GetId() {
        return this.id;
    }

    public void SetId(int id) {
        this.id = id;
    }

    public int GetSpeed() {
        return this.reloadSpeed;
    }

    public int GetAmo() {
        return this.ammo;
    }

    public String GetName() {
        return this.name;
    }

    public String GetBulletType() {
        return this.bulletType;
    }
}
