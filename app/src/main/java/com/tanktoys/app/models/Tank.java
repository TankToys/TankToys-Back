package com.tanktoys.app.models;

import com.tanktoys.app.utils.customExceptions.AddressNotValidException;
import com.tanktoys.app.utils.customExceptions.PositionNotValidException;

import jakarta.validation.constraints.NotNull;

public class Tank {

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
    
    public Tank(Bullet bullet, Cannon cannon, Shell shell, TrackWheels trackWheels, String name, String creator) throws  AddressNotValidException {
        _bullet = bullet;
        _cannon = cannon;
        _shell = shell;
        _trackWheels = trackWheels;
        _name = name;
        _creator = new Address(creator);
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
}
