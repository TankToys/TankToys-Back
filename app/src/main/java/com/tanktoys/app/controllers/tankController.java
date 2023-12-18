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

    //--------------------------------------------------GET TANK BY ID--------------------------------------------------------

    @Operation(summary = "${tankPath}/{id}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Tank.class))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tank> getTankById(@PathVariable("id") int id) throws AddressNotValidException{
        return new ResponseEntity<Tank>(tank.getTankById(id), HttpStatus.OK);
    }

    //--------------------------------------------------GET TANKS BY CREATOR ADDRESS--------------------------------------------------------

    @Operation(summary = "${tankPath}/creator/{address}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Tank.class)))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @GetMapping(value = "/creator/{address}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tank[]> getTanksByCreatorAddress(@PathVariable("address") String address) throws AddressNotValidException{
        return new ResponseEntity<Tank[]>(tank.getTanksByCreatorAddress(address), HttpStatus.OK);
    }

    //--------------------------------------------------GET TANKS BY BULLET--------------------------------------------------------

    @Operation(summary = "${tankPath}/bullet/{name}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Tank.class)))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @GetMapping(value = "/bullet/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tank[]> getTanksByBullet(@PathVariable("bulletId") int bulletId){
        return new ResponseEntity<Tank[]>(tank.getTanksByBullet(bulletId) , HttpStatus.OK);
    }

    //--------------------------------------------------GET TANKS BY CANNON--------------------------------------------------------

    @Operation(summary = "${tankPath}/cannon/{name}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Tank.class)))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @GetMapping(value = "/cannon/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tank[]> getTanksByCannon(@PathVariable("cannonId") int cannonId){
        return new ResponseEntity<Tank[]>(tank.getTanksByCannon(cannonId), HttpStatus.OK);
    }

    //--------------------------------------------------GET TANKS BY SHELL--------------------------------------------------------

    @Operation(summary = "${tankPath}/shell/{name}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Tank.class)))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @GetMapping(value = "/shell/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tank[]> getTanksByShell(@PathVariable("shellId") int shellId){
        return new ResponseEntity<Tank[]>(tank.getTanksByShell(shellId), HttpStatus.OK);
    }

    //--------------------------------------------------GET TANKS BY TRACKWHEEL--------------------------------------------------------

    @Operation(summary = "${tankPath}/trackWheel/{name}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Tank.class)))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @GetMapping(value = "/trackWheel/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tank[]> getTanksByTrackWheel(@PathVariable("trackWheelId") int trackWheelId){
        return new ResponseEntity<Tank[]>(tank.getTanksByTrackWheel(trackWheelId), HttpStatus.OK);
    }

    //--------------------------------------------------INSET TANK--------------------------------------------------------

    @Operation(summary = "${tankPath}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insertTank(){
        return new ResponseEntity(HttpStatus.OK);
    }

    //--------------------------------------------------EDIT TANK--------------------------------------------------------

    @Operation(summary = "${tankPath}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @PutMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editTank(){
        return new ResponseEntity(HttpStatus.OK);
    }

    //--------------------------------------------------DELETE TANK--------------------------------------------------------

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
