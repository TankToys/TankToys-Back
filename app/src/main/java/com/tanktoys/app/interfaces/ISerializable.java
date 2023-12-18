package com.tanktoys.app.interfaces;

public interface ISerializable {
    public String toJSON();
    public ISerializable fromJSON(String JSON) throws Exception;
}
