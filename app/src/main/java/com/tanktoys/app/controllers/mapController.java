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

    @Operation(summary = "${mapPath}/{id}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "${}", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400", description = "${}", content = @Content) })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getMapById(@PathVariable("id") int id) throws AddressNotValidException{
        return new ResponseEntity<String>(map.getMapById(id).toString(), HttpStatus.OK);
    }

    @Operation(summary = "${mapPath}/creator/{address}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "${}", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400", description = "${}", content = @Content) })
    @GetMapping(value = "/creator/{address}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getMapsByCreatorAddress(@PathVariable("address") String address) throws AddressNotValidException{
        return new ResponseEntity<String>(map.getMapsByCreatorAddress(address).toString(), HttpStatus.OK);
    }

    @Operation(summary = "${mapPath}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "${}", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400", description = "${}", content = @Content) })
    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insertMap(){
        return null;
    }

    @Operation(summary = "${mapPath}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "${}", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400", description = "${}", content = @Content) })
    @PutMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editMap(){
        return null;
    }

    @Operation(summary = "${mapPath}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "${}", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400", description = "${}", content = @Content) })
    @DeleteMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteMap(){
        return null;
    }
}
