package com.tanktoys.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tanktoys.app.models.Tank;
import com.tanktoys.app.services.TankService;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@EnableAutoConfiguration
@Tag(name = "${tankPath}")
@RequestMapping("${tankPath}")
public class tankController {

    @Autowired
    TankService tank;

    @Operation(summary = "${tankPath}/{id}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Tank.class))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tank> getTankById(@PathVariable("id") int id) throws AddressNotValidException{
        return new ResponseEntity<Tank>(tank.getTankById(id), HttpStatus.OK);
    }

    @Operation(summary = "${tankPath}/creator/{address}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Tank.class)))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @GetMapping(value = "/creator/{address}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tank[]> getTanksByCreatorAddress(@PathVariable("address") String address) throws AddressNotValidException{
        return new ResponseEntity<Tank[]>(tank.getTanksByCreatorAddress(address), HttpStatus.OK);
    }

    @Operation(summary = "${tankPath}/bullet/{name}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @GetMapping(value = "/bullet/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTanksByBullet(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @Operation(summary = "${tankPath}/cannon/{name}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @GetMapping(value = "/cannon/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTanksByCannon(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @Operation(summary = "${tankPath}/shell/{name}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @GetMapping(value = "/shell/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTanksByShell(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @Operation(summary = "${tankPath}/trackWheel/{name}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @GetMapping(value = "/trackWheel/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTanksByTrackWheel(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @Operation(summary = "${tankPath}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insertTank(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @Operation(summary = "${tankPath}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @PutMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editTank(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @Operation(summary = "${tankPath}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @DeleteMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteTank(){
        return new ResponseEntity(HttpStatus.OK);
    }
}
