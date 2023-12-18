package com.tanktoys.app.controllers;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tanktoys.app.models.Address;
import com.tanktoys.app.services.UserService;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

@RestController
@EnableAutoConfiguration
@RequestMapping("${userPath}")
public class userController {

    @Autowired
    UserService user;

    @RequestMapping(value = "/{address}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getUserByAddress(@PathVariable("address") String address) throws AddressNotValidException{
        return new ResponseEntity<String>(user.getUserByAddress(address).toJSON(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insertUser(@RequestBody String requestUser) throws JSONException, AddressNotValidException{
        if (user.insertUser(user.JSONToUser(requestUser))) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editUser(@RequestBody String requestUser) throws JSONException, AddressNotValidException{
        if (user.editUser(user.JSONToUser(requestUser))) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteUser(@RequestBody String address) throws AddressNotValidException{
        if (user.deleteUser(new Address(address))) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
