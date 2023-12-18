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
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "${}", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Tank.class))
    }),
            @ApiResponse(responseCode = "400", description = "${}", content = @Content) })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tank> getTankById(@PathVariable("id") int id) throws AddressNotValidException{
        return new ResponseEntity<Tank>(tank.getTankById(id), HttpStatus.OK);
    }

    @Operation(summary = "${tankPath}/creator/{address}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "${}", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400", description = "${}", content = @Content) })
    @GetMapping(value = "/creator/{address}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getTanksByCreatorAddress(@PathVariable("address") String address) throws AddressNotValidException{
        return new ResponseEntity<String>(tank.getTanksByCreatorAddress(address).toString(), HttpStatus.OK);
    }

    @Operation(summary = "${tankPath}/bullet/{name}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "${}", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400", description = "${}", content = @Content) })
    @GetMapping(value = "/bullet/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTanksByBullet(){
        return null;
    }

    @Operation(summary = "${tankPath}/cannon/{name}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "${}", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400", description = "${}", content = @Content) })
    @GetMapping(value = "/cannon/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTanksByCannon(){
        return null;
    }

    @Operation(summary = "${tankPath}/shell/{name}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "${}", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400", description = "${}", content = @Content) })
    @GetMapping(value = "/shell/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTanksByShell(){
        return null;
    }

    @Operation(summary = "${tankPath}/trackWheel/{name}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "${}", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400", description = "${}", content = @Content) })
    @GetMapping(value = "/trackWheel/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTanksByTrackWheel(){
        return null;
    }

    @Operation(summary = "${tankPath}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "${}", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400", description = "${}", content = @Content) })
    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insertTank(){
        return null;
    }

    @Operation(summary = "${tankPath}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "${}", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400", description = "${}", content = @Content) })
    @PutMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editTank(){
        return null;
    }

    @Operation(summary = "${tankPath}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "${}", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400", description = "${}", content = @Content) })
    @DeleteMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteTank(){
        return null;
    }
}
