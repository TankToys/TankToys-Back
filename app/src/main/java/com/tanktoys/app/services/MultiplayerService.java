package com.tanktoys.app.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanktoys.app.models.Address;
import com.tanktoys.app.models.Room;
import com.tanktoys.app.models.Room.gameModes;

@Service
public class MultiplayerService {

    @Autowired
    DatabaseService db;

    @Autowired
    RoomService room;

    public String CreateRoom(Address host) {
        List<String> guestList = new ArrayList<String>();
        guestList.add(host.toString());

        Room thisRoom = new Room(
                ((Long)System.currentTimeMillis()).toString(),
                guestList,
                host.toString(),
                gameModes._1V1);
        boolean ok = room.insertRoom(thisRoom);

        if (ok) {
            System.out.println(thisRoom.id);
            return thisRoom.id;
        } else {
            return "";
        }
    }
}
