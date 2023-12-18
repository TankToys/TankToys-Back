package com.tanktoys.app.models;

import java.sql.ResultSet;
import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.tanktoys.app.interfaces.IDatabaseItem;
import com.tanktoys.app.interfaces.ISerializable;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;
import com.tanktoys.app.utils.customExceptions.PositionNotValidException;

import jakarta.validation.constraints.NotNull;

@Component
public class Map implements IDatabaseItem, ISerializable{
    
    @NotNull(message = "Id cannot be null")
    private int _id;

    @NotNull(message = "ArrMap cannot be null")
    private ArrayMap _arrMap;

    @NotNull(message = "Creator cannot be null")
    private Address _creator;

    @NotNull(message = "Name cannot be null")
    private String _name;
    
    public Map(){
        _id = 0;
        _arrMap = null;
        _creator = null;
        _name = null;
    }

    public Map(int id, String[] positions, String creator, String name) throws PositionNotValidException, AddressNotValidException {
        _id = id;
        _arrMap = new ArrayMap(positions);
        _creator = new Address(creator);
        _name = name;
    }

    public int GetId() {
        return _id;
    }

    public ArrayMap GetArrMap(){
        return _arrMap;
    }

    public void SetArrMap(String[] positions) throws PositionNotValidException{
        _arrMap = new ArrayMap(positions);
    }

    public Address GetCreator(){
        return _creator;
    }

    public String GetName() {
        return _name;
    }

    public void SetName(String name) {
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
        return "INSERT INTO maps(id, arrmap, creator, name) VALUES('"+_id+"','"+_arrMap.GetPositions()+"','"+_creator.GetAddress()+"','"+_name+"')";
    }

    @Override
    public <T> String ToSELECT(T key) {
        return "SELECT * FROM maps WHERE id LIKE '"+key+"';";
    }

    @Override
    public <T> String ToUPDATE(T key) {
        return "UPDATE maps SET id='"+_id+"', arrmap='"+_arrMap.GetPositions()+"', creator='"+_creator.GetAddress()+"', name='"+_name+"' WHERE id LIKE '"+key+"';";
    }

    @Override
    public <T> String ToDELETE(T key) {
        return "DELETE FROM maps WHERE id LIKE '"+key+"';";
    }

    @Override
    public IDatabaseItem load(ResultSet rs, int rowNum) throws Exception {
        _id = rs.getInt(1);
        _arrMap.SetPositions((String[]) rs.getArray(2).getArray());
        _creator.SetAddress(rs.getString(3));
        _name = rs.getString(4);
        return this;
    }

}
