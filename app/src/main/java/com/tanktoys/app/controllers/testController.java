package com.tanktoys.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tanktoys.app.models.User;
import com.tanktoys.app.services.databaseService;

@RestController
@EnableAutoConfiguration
@RequestMapping("${testPath}")
public class testController {

    @Autowired
    databaseService db;

    @RequestMapping(method = RequestMethod.GET)
    public String testMethod() throws Exception {
        // String userList = "";
        // for (User user : db.run()) {
        //     if (user != null) {
        //         userList += "; "+user.toString();
        //     }
        // }

        User user = new User();
        db.SelectByKey(user, "0x16a19a03F7769c83Cae545e34fe0580ad8d6c27A");

        return user.toString();
    }

}
