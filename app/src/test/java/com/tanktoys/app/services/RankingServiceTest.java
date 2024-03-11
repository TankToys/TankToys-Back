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

import com.tanktoys.app.models.Address;
import com.tanktoys.app.models.Ranking;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration
public class RankingServiceTest {
    @Autowired
    RankingService service;

    @Test
    public void testDeleteRanking() throws AddressNotValidException {
        assertTrue(service.deleteRanking(Address.parse("0xc07921125b826D28453C6d4512bb7e41E0326Aa2")));
    }

    @Test
    public void testEditRanking() {
        assertTrue(service.editRanking(new Ranking()));
    }

    @Test
    public void testInsertRanking() {
        assertTrue(service.insertRanking(new Ranking()));
    }
}
