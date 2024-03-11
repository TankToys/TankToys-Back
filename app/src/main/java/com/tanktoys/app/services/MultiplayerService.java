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

    public String CreateRoom(Address host, Room.gameModes gameMode) {
        List<String> guestList = new ArrayList<String>();
        guestList.add(host.toString());

        Room thisRoom = new Room(
                ((Long)System.currentTimeMillis()).toString(),
                guestList,
                host.toString(),
                gameMode);
        if (room.insertRoom(thisRoom)) {
            System.out.println(thisRoom.id);
            return thisRoom.id;
        } else {
            return "";
        }
    }

    public boolean AddGuestToRoom(String roomId, Address guest){
        Room thisRoom = room.getRoomById(roomId);

        if (thisRoom.host == null) {
            return false;
        }

        if (thisRoom.GetGuestList().size() > 3) {
            return false;
        }

        if (thisRoom.GetGuestList().contains(guest.toString())) {
            return true;
        }

        thisRoom.AddToGuestList(guest.toString());

        if (room.editRoom(thisRoom)) {
            return true;
        }
        return false;
    }

    public boolean closeRoom(String roomId, Address playerId) {
        Room thisRoom = room.getRoomById(roomId);

        if (thisRoom.host == null || playerId == null) {
            return false;
        }

        if (!thisRoom.host.equals(playerId.toString())) {
            return false;
        }

        if (!room.deleteRoom(thisRoom)){
            return false;
        }

        return true;
    }
}
