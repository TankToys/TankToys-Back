package com.tanktoys.app.models;

import java.sql.ResultSet;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tanktoys.app.interfaces.IDatabaseItem;
import com.tanktoys.app.interfaces.ISerializable;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

import jakarta.validation.constraints.NotNull;

public class Tank implements IDatabaseItem, ISerializable{

    @NotNull(message = "Id cannot be null")
    public int _id;

    @NotNull(message = "Bullet cannot be null")
    public Bullet _bullet;

    @NotNull(message = "Cannon cannot be null")
    public Cannon _cannon;

    @NotNull(message = "Sheel cannot be null")
    public Shell _shell;

    @NotNull(message = "TrackWheels cannot be null")
    public TrackWheels _trackWheels;

    @NotNull(message = "Name cannot be null")
    public String _name;

    @NotNull(message = "Creator cannot be null")
    public Address _creator;
    
    public Tank() throws AddressNotValidException{
        _id = 0;
        _bullet = new Bullet(0, 0, 0, 0, "_name", "_name");
        _cannon = new Cannon(0, 0, 0, "_name", "_name");
        _shell = new Shell(0, 0, "_name", "_name");
        _trackWheels = new TrackWheels(0, 0, "_name", "_name", "_name", "_name");
        _name = "name";
        _creator = new Address("0x0000000000000000000000000000000000000000");
    }

    public Tank(@JsonProperty("_id")int id, @JsonProperty("_bullet")Bullet bullet, @JsonProperty("_cannon")Cannon cannon, @JsonProperty("_shell")Shell shell, @JsonProperty("_trackWheels")TrackWheels trackWheels, @JsonProperty("_name")String name, @JsonProperty("_creator")String creator) throws  AddressNotValidException {
        _id = id;
        _bullet = bullet;
        _cannon = cannon;
        _shell = shell;
        _trackWheels = trackWheels;
        _name = name;
        _creator = new Address(creator);
    }

    public int GetId() {
        return _id;
    }

    public Bullet GetBullet(){
        return _bullet;
    }

    public void SetBullet(Bullet bullet){
        _bullet = bullet;
    }

    public Cannon GetCannon(){
        return _cannon;
    }

    public void SetCannon(Cannon cannon){
        _cannon = cannon;
    }

    public Shell GetShell(){
        return _shell;
    }

    public void SetShell(Shell shell){
        _shell = shell;
    }

    public TrackWheels GetTrackWheels(){
        return _trackWheels;
    }

    public void SetTrackWheels(TrackWheels trackWheels){
        _trackWheels = trackWheels;
    }

    public Address Getscreator(){
        return _creator;
    }

    public String Getname() {
        return _name;
    }

    public void Setname(String name) {
        _name = name;
    }

    @Override
    public String toJSON() {
        throw new UnsupportedOperationException("Unimplemented method 'toJSON'");
    }

    @Override
    public ISerializable fromJSON(String JSON) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'fromJSON'");
    }

    @Override
    public String ToINSERT() {
        return "INSERT INTO tank( bullet, cannon, shell, trackwheel, name, creator) VALUES ('"+_bullet.GetId()+"', '"
        +_cannon.GetId()+"', '"+_shell.GetId()+"', '"+_trackWheels.GetId()+"', '"+_name+"', '"+_creator.GetAddress()+"');";
    }

    @Override
    public <T> String ToSELECT(T key) {
        return "SELECT * FROM tank WHERE id = '"+key+"';";
    }

    @Override
    public <T> String ToSELECTKeyName(String keyName, T key) {
        return "SELECT * FROM tank WHERE "+keyName+" = '"+key+"';";
    }

    @Override
    public <T> String ToUPDATE(T key) {
        return "UPDATE tank SET id='"+_id+"', bullet='"+_bullet.GetId()+"', cannon='"
        +_cannon.GetId()+"', shell='"+_shell.GetId()+"', trackwheel='"+_trackWheels.GetId()+"', name='"+_name+"', creator='"+_creator.GetAddress()+"' WHERE id = '"+key+"';";
    }

    @Override
    public <T> String ToDELETE(T key) {
        return "DELETE FROM tank WHERE id = '"+key+"';";
    }

    @Override
    public IDatabaseItem load(ResultSet rs, int rowNum) throws Exception {
        _id = rs.getInt(1);
        _bullet.SetId(rs.getInt(2));
        _cannon.SetId(rs.getInt(3));
        _shell.SetId(rs.getInt(4));
        _trackWheels.SetId(rs.getInt(5));
        _name = rs.getString(6);
        _creator.SetAddress(rs.getString(7));
        return this;
    }
}
