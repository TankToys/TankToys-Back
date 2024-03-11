package com.tanktoys.app.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.tanktoys.app.models.Map;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;
import com.tanktoys.app.utils.customExceptions.PositionNotValidException;


@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration
public class MapServiceTest {
    @Autowired
    MapService service;

    @Test
    public void testDeleteMap() throws AddressNotValidException, PositionNotValidException {
        assertTrue(service.deleteMap(0));
    }

    @Test
    public void testEditMap() throws AddressNotValidException, PositionNotValidException {
        assertTrue(service.editMap(new Map()));
    }

    @Test
    public void testGetMapById() throws AddressNotValidException, PositionNotValidException {
        assertNotNull(service.getMapById(0));
    }

    @Test
    public void testInsertMap() throws AddressNotValidException, PositionNotValidException {
        assertTrue(service.insertMap(new Map()));
    }
}
