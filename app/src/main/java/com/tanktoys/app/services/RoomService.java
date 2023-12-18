package com.tanktoys.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanktoys.app.models.Room;

@Service
public class RoomService {

    @Autowired
    DatabaseService db;

    public Room getRoomById(int id) {
        Room room = new Room();
        db.SelectByKey(room, id);
        return room;
    }

    public boolean editRoom(Room room) {
        return db.Update(room, room.GetId());
    }

    public boolean deleteRoom(int id) {
        Room room = new Room();
        return db.Delete(room, id);
    }
    
}
