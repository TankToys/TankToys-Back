package com.tanktoys.app.services;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.tanktoys.app.models.Room;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration
public class RoomServiceTest {
    @Autowired
    RoomService service;

    @Test
    public void testDeleteRoom() {
        assertTrue(service.deleteRoom(new Room("1710175857199", null, null, null)));
    }

    @Test
    public void testEditRoom() {
        assertTrue(service.editRoom(new Room("1710175857199", null, null, null)));
    }

    @Test
    public void testInsertRoom() {
        assertTrue(service.insertRoom(new Room("1710175857199", null, null, null)));
    }
}
