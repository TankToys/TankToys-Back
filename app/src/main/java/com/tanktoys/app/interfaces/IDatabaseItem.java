package com.tanktoys.app.interfaces;

import java.sql.ResultSet;

public interface IDatabaseItem{

    // sql generation methods
    public String ToINSERT();
    public <T> String ToSELECT(T key);

    //data ingesting from rowMap
    public IDatabaseItem load(ResultSet rs, int rowNum) throws Exception;
}
