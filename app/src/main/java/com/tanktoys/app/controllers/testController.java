package com.tanktoys.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tanktoys.app.models.User;
import com.tanktoys.app.services.Database;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/v1/test")
public class testController {

    @Autowired
    Database db;

    @RequestMapping(method = RequestMethod.GET)
    public String testMethod() throws Exception {
        String userList = "";
        for (User user : db.run()) {
            userList += "; "+user.toString();
        }
        return userList;
    }

}
