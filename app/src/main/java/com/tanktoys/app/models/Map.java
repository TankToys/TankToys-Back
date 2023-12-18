package com.tanktoys.app.models;

import org.springframework.stereotype.Component;

import com.tanktoys.app.utils.customExceptions.AddressNotValidException;
import com.tanktoys.app.utils.customExceptions.PositionNotValidException;

import jakarta.validation.constraints.NotNull;

@Component
public class Map {
    
    @NotNull(message = "arrMap cannot be null")
    private ArrayMap _arrMap;

    @NotNull(message = "creator cannot be null")
    private Address _creator;

    @NotNull(message = "name cannot be null")
    private String _name;
    
    public Map(int[][] positions, String creator, String name) throws PositionNotValidException, AddressNotValidException {
        _arrMap = new ArrayMap(positions);
        _creator = new Address(creator);
        _name = name;
    }

    public ArrayMap GetarrMap(){
        return _arrMap;
    }

    public void SetarrMap(int[][] positions) throws PositionNotValidException{
        _arrMap = new ArrayMap(positions);
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
