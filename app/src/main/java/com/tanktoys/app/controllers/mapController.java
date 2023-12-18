package com.tanktoys.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tanktoys.app.services.UserService;
import com.tanktoys.app.services.MapService;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

@RestController
@EnableAutoConfiguration
@RequestMapping("${mapPath}")
public class mapController {

    @Autowired
    MapService map;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getMapById(@PathVariable("id") int id) throws AddressNotValidException{
        return new ResponseEntity<String>(map.getMapById(id).toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "/creator/{address}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getMapsByCreatorAddress(@PathVariable("address") String address) throws AddressNotValidException{
        return new ResponseEntity<String>(map.getMapsByCreatorAddress(address).toString(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insertMap(){
        return null;
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editMap(){
        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteMap(){
        return null;
    }
}
