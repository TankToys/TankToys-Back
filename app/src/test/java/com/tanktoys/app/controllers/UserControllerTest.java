package com.tanktoys.app.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.tanktoys.app.AppApplication;

@SpringBootTest(classes = UserController.class)
@AutoConfigureMockMvc
@ContextConfiguration( classes = AppApplication.class)
public class UserControllerTest {

    private String apiPath = "/api/v1/user";

    @Autowired
    private MockMvc mvc;
   
    @Test
    public void testDeleteUser() {

    }

    @Test
    public void testEditUser() {

    }

    @Test
    public void testGetUserByAddress() {

    }

    @Test
    public void testInsertUser() {

    }
}
