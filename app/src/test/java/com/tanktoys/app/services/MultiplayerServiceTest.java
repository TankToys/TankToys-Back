package com.tanktoys.app.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.tanktoys.app.AppApplication;
import com.tanktoys.app.models.Address;
import com.tanktoys.app.models.Room;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = AppApplication.class)
public class MultiplayerServiceTest {
    @Autowired
    MultiplayerService service;

    @Test
    @Order(2)
    public void testAddGuestToRoom() {
        assertEquals(service.AddGuestToRoom("1710175857199", Address.parse("0xc07921125b826D28453C6d4512bb7e41E0326Aa2") ), true);

    }

    @Test
    @Order(1)
    public void testCreateRoom() {
        assertNotEquals(service.CreateRoom(Address.parse("0xc07921125b826D28453C6d4512bb7e41E0326Aa2"), Room.gameModes._1V1), "");
    }

    @Test
    @Order(3)
    public void testCloseRoom() {
        assertEquals(service.closeRoom("1710175857199", Address.parse("0xc07921125b826D28453C6d4512bb7e41E0326Aa2")), true);
    }
}
