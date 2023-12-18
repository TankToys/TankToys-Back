package com.tanktoys.app.controllers;

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

import com.tanktoys.app.services.tankService;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

@RestController
@EnableAutoConfiguration
@RequestMapping("${tankPath}")
public class tankController {

    @Autowired
    tankService tank;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getTankById(@PathVariable("id") int id) throws AddressNotValidException{
        return new ResponseEntity<String>(tank.getTankById(id).toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "/creator/{address}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getTanksByCreatorAddress(@PathVariable("address") String address) throws AddressNotValidException{
        return new ResponseEntity<String>(tank.getTanksByCreatorAddress(address).toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "/bullet/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTanksByBullet(){
        return null;
    }

    @RequestMapping(value = "/cannon/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTanksByCannon(){
        return null;
    }

    @RequestMapping(value = "/shell/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTanksByShell(){
        return null;
    }

    @RequestMapping(value = "/trackWheel/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTanksByTrackWheel(){
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insertTank(){
        return null;
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editTank(){
        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteTank(){
        return null;
    }
}
