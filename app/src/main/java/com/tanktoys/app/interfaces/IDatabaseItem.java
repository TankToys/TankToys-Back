package com.tanktoys.app.interfaces;

import java.sql.ResultSet;

public interface IDatabaseItem{

    // sql generation methods
    public String ToINSERT();
    public <T> String ToSELECT(T key);
    public <T> String ToSELECTKeyName(String keyName, T key);
    public <T> String ToUPDATE(T key);
    public <T> String ToDELETE(T key);

    //data ingesting from rowMap
    public IDatabaseItem load(ResultSet rs, int rowNum) throws Exception;
}
