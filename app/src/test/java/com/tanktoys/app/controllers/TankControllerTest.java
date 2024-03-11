package com.tanktoys.app.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TankControllerTest {

    private String apiPath = "/api/v1/tank";

    @Autowired
    private MockMvc mvc;

    @Test
    public void testDeleteTank() {

    }

    @Test
    public void testEditTank() {

    }

    @Test
    public void testGetTankById() {

    }

    @Test
    public void testGetTanksByBullet() {

    }

    @Test
    public void testGetTanksByCannon() {

    }

    @Test
    public void testGetTanksByCreatorAddress() {

    }

    @Test
    public void testGetTanksByShell() {

    }

    @Test
    public void testGetTanksByTrackWheel() {

    }

    @Test
    public void testInsertTank() {

    }
}
