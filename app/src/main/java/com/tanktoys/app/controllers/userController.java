package com.tanktoys.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tanktoys.app.models.User;

@RestController
@EnableAutoConfiguration
@RequestMapping("${userPath}")
public class userController {

    @Autowired
    User user;

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String test(@PathVariable("username") String username){
        
        return "functiona" + username;
    }
}
