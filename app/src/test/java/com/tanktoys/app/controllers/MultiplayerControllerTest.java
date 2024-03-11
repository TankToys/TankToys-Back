package com.tanktoys.app.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = MultiplayerController.class)
@AutoConfigureMockMvc
public class MultiplayerControllerTest {

    private String apiPath = "/api/v1/multiplayer";

    @Autowired
    private MockMvc mvc;

    @Test
    public void testAddToRoom() {

    }

    @Test
    public void testCloseRoom() {

    }

    @Test
    public void testCreateRoom() {

    }
}
