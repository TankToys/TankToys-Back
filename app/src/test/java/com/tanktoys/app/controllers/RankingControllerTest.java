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
public class RankingControllerTest {

    private String apiPath = "/api/v1/ranking";

    @Autowired
    private MockMvc mvc;

    @Test
    public void testDeleteRanking() {

    }

    @Test
    public void testEditRanking() {

    }

    @Test
    public void testGetRanking() {

    }

    @Test
    public void testGetRanksByAddress() {

    }

    @Test
    public void testGetRanksByMode() {

    }

    @Test
    public void testInsertRanking() {

    }
}
