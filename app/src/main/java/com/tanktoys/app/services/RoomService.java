package com.tanktoys.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanktoys.app.models.Room;

@Service
public class RoomService {

    @Autowired
    DatabaseService db;

    public Room getRoomById(String id) {
        Room room = new Room(id, null, null, null);
        db.SelectByKey(room, id);
        return room;
    }

    public boolean insertRoom(Room room){
        return db.Insert(room);
    }

    public boolean editRoom(Room room) {
        return db.Update(room, room.GetId());
    }

    public boolean deleteRoom(String id) {
        Room room = new Room(id, null, null, null);
        return db.Delete(room, id);
    }
    
}
