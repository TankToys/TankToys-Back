package com.tanktoys.app.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MapControllerTest {
    
    private String apiPath = "/api/v1/map";

    @Autowired
    private MockMvc mvc;

    @Test
    public void getMapByIdTest() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get(apiPath+"/0")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    @Test
    public void getMapsByCreatorAddressTest() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get(apiPath+"/creator/0x0000000000000000000")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    @Test
    public void insertMapTest() throws Exception{
        mvc.perform(MockMvcRequestBuilders.post(apiPath)
        .contentType(MediaType.APPLICATION_JSON)
        .content(""))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void editMapTest() throws Exception{
        mvc.perform(MockMvcRequestBuilders.put(apiPath)
        .contentType(MediaType.APPLICATION_JSON)
        .content(""))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void deleteMapTest() throws Exception{
        mvc.perform(MockMvcRequestBuilders.delete(apiPath)
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
