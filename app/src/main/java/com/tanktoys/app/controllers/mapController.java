package com.tanktoys.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tanktoys.app.services.UserService;
import com.tanktoys.app.services.MapService;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@EnableAutoConfiguration
@Tag(name = "${mapPath}")
@RequestMapping("${mapPath}")
public class mapController {

    @Autowired
    MapService map;

    //--------------------------------------------------GET MAP BY ID--------------------------------------------------------

    @Operation(summary = "${mapPath}/{id}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getMapById(@PathVariable("id") int id) throws AddressNotValidException{
        return new ResponseEntity<String>(map.getMapById(id).toString(), HttpStatus.OK);
    }

    //--------------------------------------------------GET MAPS BY CREATOR ADDRESS--------------------------------------------------------

    @Operation(summary = "${mapPath}/creator/{address}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @GetMapping(value = "/creator/{address}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getMapsByCreatorAddress(@PathVariable("address") String address) throws AddressNotValidException{
        return new ResponseEntity<String>(map.getMapsByCreatorAddress(address).toString(), HttpStatus.OK);
    }

    //--------------------------------------------------INSERT MAP--------------------------------------------------------

    @Operation(summary = "${mapPath}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insertMap(){
        return null;
    }

    //--------------------------------------------------EDIT MAP--------------------------------------------------------

    @Operation(summary = "${mapPath}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @PutMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editMap(){
        return null;
    }

    //--------------------------------------------------DELETE MAP--------------------------------------------------------

    @Operation(summary = "${mapPath}/{id}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteMap(){
        return null;
    }
}
