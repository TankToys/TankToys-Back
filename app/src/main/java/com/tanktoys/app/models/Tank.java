package com.tanktoys.app.models;

import java.sql.ResultSet;

import com.tanktoys.app.interfaces.IDatabaseItem;
import com.tanktoys.app.interfaces.ISerializable;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

import jakarta.validation.constraints.NotNull;

public class Tank implements IDatabaseItem, ISerializable{

    @NotNull(message = "Id cannot be null")
    private int _id;

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
    
    public Tank(int id, Bullet bullet, Cannon cannon, Shell shell, TrackWheels trackWheels, String name, String creator) throws  AddressNotValidException {
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toJSON'");
    }

    @Override
    public ISerializable fromJSON(String JSON) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fromJSON'");
    }

    @Override
    public String ToINSERT() {
        return "INSERT INTO tank(id, bullet, cannon, shell, trackwheel, name, creator) VALUES ('"+_id+"', '"+_bullet.GetId()+"', '"
        +_cannon.GetId()+"', '"+_shell.GetId()+"', '"+_trackWheels.GetId()+"', '"+_name+"', '"+_creator.GetAddress()+"');";
    }

    @Override
    public <T> String ToSELECT(T key) {
        return "SELECT * FROM tank WHERE id LIKE '"+key+"';";
    }

    @Override
    public <T> String ToUPDATE(T key) {
        return "UPDATE tank SET id='"+_id+"', bullet='"+_bullet.GetId()+"', cannon='"
        +_cannon.GetId()+"', shell='"+_shell.GetId()+"', trackwheel='"+_trackWheels.GetId()+"', name='"+_name+"', creator='"+_creator.GetAddress()+"' WHERE id LIKE '"+key+"';";
    }

    @Override
    public <T> String ToDELETE(T key) {
        return "DELETE FROM tank WHERE id LIKE '"+key+"';";
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
