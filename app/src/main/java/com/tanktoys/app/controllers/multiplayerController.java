package com.tanktoys.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanktoys.app.models.Address;
import com.tanktoys.app.models.RoomBody;
import com.tanktoys.app.services.MultiplayerService;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@EnableAutoConfiguration
@Tag(name = "${multiplayerPath}")
@RequestMapping("${multiplayerPath}")
public class multiplayerController {

    @Autowired
    MultiplayerService multiplayerService;

    // --------------------------------------------------CREATE_ROOM--------------------------------------------------------

    @Operation(summary = "${multiplayerPath}/createRoom")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", content = {
            @Content(mediaType = "application/json")
    }),
            @ApiResponse(responseCode = "400", content = @Content) })
    @PostMapping(value = "/createRoom", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createRoom(@RequestBody RoomBody body) throws AddressNotValidException {
        return new ResponseEntity<String>(multiplayerService.CreateRoom(Address.parse(body.playerId), body.gamemode), HttpStatus.OK);
    }

    // --------------------------------------------------ADD_TO_ROOM--------------------------------------------------------

    @Operation(summary = "${multiplayerPath}/joinRoom")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", content = {
            @Content(mediaType = "application/json")
    }),
            @ApiResponse(responseCode = "400", content = @Content) })
    @PostMapping(value = "/joinRoom",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addToRoom(@RequestBody RoomBody body) throws AddressNotValidException {
        if (multiplayerService.AddGuestToRoom(body.roomId, Address.parse(body.playerId))) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @Operation(summary = "${multiplayerPath}/closeRoom")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", content = {
            @Content(mediaType = "application/json")
    }),
            @ApiResponse(responseCode = "400", content = @Content) })
    @PostMapping(value = "/closeRoom",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity closeRoom(@RequestBody RoomBody body) throws AddressNotValidException {
        if (multiplayerService.closeRoom(body.roomId, Address.parse(body.playerId))) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }



    //TODO: https://www.baeldung.com/spring-cache-tutorial
    //TODO: implement cache to store Player objects per active room
    //TODO: Async method of cleaning any room with more than 2 days
    
}
