package com.tanktoys.app.models;

import java.sql.ResultSet;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tanktoys.app.interfaces.IDatabaseItem;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

import jakarta.validation.constraints.NotNull;

@Component
public class Tank implements IDatabaseItem {

    @NotNull(message = "Id cannot be null")
    @JsonProperty("id")
    public int id;

    @NotNull(message = "Bullet cannot be null")
    @JsonProperty("bullet")
    public Bullet bullet;

    @NotNull(message = "Cannon cannot be null")
    @JsonProperty("cannon")
    public Cannon cannon;

    @NotNull(message = "Sheel cannot be null")
    @JsonProperty("shell")
    public Shell shell;

    @NotNull(message = "TrackWheels cannot be null")
    @JsonProperty("trackWheels")
    public TrackWheels trackWheels;

    @NotNull(message = "Name cannot be null")
    @JsonProperty("name")
    public String name;

    @NotNull(message = "Creator cannot be null")
    @JsonProperty("creator")
    public Address creator;

    public Tank() throws AddressNotValidException {
        this.id = 0;
        this.bullet = new Bullet(0, 0, 0, 0, "name", "name");
        this.cannon = new Cannon(0, 0, 0, "name", "name");
        this.shell = new Shell(0, 0, "name", "name");
        this.trackWheels = new TrackWheels(0, 0, "name", "name", "name", "name");
        this.name = "name";
        this.creator = new Address("0x0000000000000000000000000000000000000000");
    }

    public Tank(@JsonProperty("id") int id,
            @JsonProperty("bullet") Bullet bullet,
            @JsonProperty("cannon") Cannon cannon,
            @JsonProperty("shell") Shell shell,
            @JsonProperty("trackWheels") TrackWheels trackWheels,
            @JsonProperty("name") String name,
            @JsonProperty("creator") Address creator) throws AddressNotValidException {
        this.id = id;
        this.bullet = bullet;
        this.cannon = cannon;
        this.shell = shell;
        this.trackWheels = trackWheels;
        this.name = name;
        this.creator = creator;
    }

    public int GetId() {
        return this.id;
    }

    public Bullet GetBullet() {
        return this.bullet;
    }

    public void SetBullet(Bullet bullet) {
        this.bullet = bullet;
    }

    public Cannon GetCannon() {
        return this.cannon;
    }

    public void SetCannon(Cannon cannon) {
        this.cannon = cannon;
    }

    public Shell GetShell() {
        return this.shell;
    }

    public void SetShell(Shell shell) {
        this.shell = shell;
    }

    public TrackWheels GetTrackWheels() {
        return this.trackWheels;
    }

    public void SetTrackWheels(TrackWheels trackWheels) {
        this.trackWheels = trackWheels;
    }

    public Address Getscreator() {
        return this.creator;
    }

    public String Getname() {
        return this.name;
    }

    public void Setname(String name) {
        this.name = name;
    }

    @Override
    public String ToINSERT() {
        return "INSERT INTO tank( bullet, cannon, shell, trackwheel, name, creator) VALUES ('" + this.bullet.GetId()
                + "', '"
                + this.cannon.GetId() + "', '" + this.shell.GetId() + "', '" + this.trackWheels.GetId() + "', '"
                + this.name + "', '" + this.creator.GetAddress() + "');";
    }

    @Override
    public <T> String ToSELECT(T key) {
        return "SELECT * FROM tank WHERE id = '" + key + "';";
    }

    @Override
    public <T> String ToSELECTKeyName(String keyName, T key) {
        return "SELECT * FROM tank WHERE " + keyName + " = '" + key + "';";
    }

    @Override
    public <T> String ToUPDATE(T key) {
        return "UPDATE tank SET bullet='" + this.bullet.GetId() + "', cannon='"
                + this.cannon.GetId() + "', shell='" + this.shell.GetId() + "', trackwheel='" + this.trackWheels.GetId()
                + "', name='" + this.name + "', creator='" + this.creator.GetAddress() + "' WHERE id = '" + key + "';";
    }

    @Override
    public <T> String ToDELETE(T key) {
        return "DELETE FROM tank WHERE id = '" + key + "';";
    }

    @Override
    public IDatabaseItem load(ResultSet rs, int rowNum) throws Exception {
        this.id = rs.getInt(1);
        this.bullet.SetId(rs.getInt(2));
        this.cannon.SetId(rs.getInt(3));
        this.shell.SetId(rs.getInt(4));
        this.trackWheels.SetId(rs.getInt(5));
        this.name = rs.getString(6);
        this.creator.SetAddress(rs.getString(7));
        return this;
    }
}
