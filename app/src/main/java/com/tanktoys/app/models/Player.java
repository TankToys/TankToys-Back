package com.tanktoys.app.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Player {
    @JsonProperty("address")
    public String address;

    @JsonProperty("posx")
    public int positionX;

    @JsonProperty("posy")
    public int positionY;

    public Player(Address addr){
        address = addr.toString();
    }

}
