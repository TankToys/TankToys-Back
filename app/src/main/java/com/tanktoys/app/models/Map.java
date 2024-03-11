package com.tanktoys.app.models;

import java.sql.ResultSet;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tanktoys.app.interfaces.IDatabaseItem;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;
import com.tanktoys.app.utils.customExceptions.PositionNotValidException;

import jakarta.validation.constraints.NotNull;

@Component
public class Map implements IDatabaseItem{
    
    @NotNull(message = "Id cannot be null")
    @JsonProperty("id")
    public int id;

    @NotNull(message = "ArrMap cannot be null")
    @JsonProperty("arrMap")
    public ArrayMap arrMap;

    @NotNull(message = "Creator cannot be null")
    @JsonProperty("creator")
    public Address creator;

    @NotNull(message = "Name cannot be null")
    @JsonProperty("name")
    public String name;
    
    public Map() throws AddressNotValidException, PositionNotValidException{
        this.id = 0;
        this.arrMap = new ArrayMap(new String[]{"Foo","Bar","Baz"});
        this.creator = new Address("0x0000000000000000000000000000000000000000");
        this.name = "null";
    }

    public Map(@JsonProperty("id")int id, @JsonProperty("positions")String[] positions, @JsonProperty("creator")String creator, @JsonProperty("name")String name) throws PositionNotValidException, AddressNotValidException {
        this.id = id;
        this.arrMap = new ArrayMap(positions);
        this.creator = new Address(creator);
        this.name = name;
    }

    public int GetId() {
        return this.id;
    }

    public ArrayMap GetArrMap(){
        return this.arrMap;
    }

    public void SetArrMap(String[] positions) throws PositionNotValidException{
        this.arrMap = new ArrayMap(positions);
    }

    public Address GetCreator(){
        return this.creator;
    }

    public String GetName() {
        return this.name;
    }

    public void SetName(String name) {
        this.name = name;
    }

    @Override
    public String ToINSERT() {
        return "INSERT INTO maps(id, arrmap, creator, name) VALUES('"+this.id+"','"+this.arrMap.GetPositions()+"','"+this.creator.GetAddress()+"','"+this.name+"')";
    }

    @Override
    public <T> String ToSELECT(T key) {
        return "SELECT * FROM maps WHERE id = '"+key+"';";
    }

    @Override
    public <T> String ToSELECTKeyName(String keyName, T key) {
        return "SELECT * FROM maps WHERE "+keyName+" = '"+key+"';";
    }

    @Override
    public <T> String ToUPDATE(T key) {
        return "UPDATE maps SET arrmap='"+this.arrMap.GetPositions()+"', creator='"+this.creator.GetAddress()+"', name='"+this.name+"' WHERE id = '"+key+"';";
    }

    @Override
    public <T> String ToDELETE(T key) {
        return "DELETE FROM maps WHERE id = '"+key+"';";
    }

    @Override
    public IDatabaseItem load(ResultSet rs, int rowNum) throws Exception {
        this.id = rs.getInt(1);
        this.arrMap.SetPositions((String[]) rs.getArray(2).getArray());
        this.creator.SetAddress(rs.getString(3));
        this.name = rs.getString(4);
        return this;
    }

}
