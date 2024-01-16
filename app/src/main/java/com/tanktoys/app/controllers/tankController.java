package com.tanktoys.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public ResponseEntity<String> getTankById(@PathVariable("id") int id) throws AddressNotValidException, JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        return new ResponseEntity<String>(objectMapper.writeValueAsString(tank.getTankById(id)), HttpStatus.OK);
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
    public ResponseEntity<Tank[]> getTanksByBullet(@PathVariable("bulletId") int bulletId) throws AddressNotValidException{
        return new ResponseEntity<Tank[]>(tank.getTanksByBullet(bulletId) , HttpStatus.OK);
    }

    //--------------------------------------------------GET TANKS BY CANNON--------------------------------------------------------

    @Operation(summary = "${tankPath}/cannon/{name}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Tank.class)))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @GetMapping(value = "/cannon/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tank[]> getTanksByCannon(@PathVariable("cannonId") int cannonId) throws AddressNotValidException{
        return new ResponseEntity<Tank[]>(tank.getTanksByCannon(cannonId), HttpStatus.OK);
    }

    //--------------------------------------------------GET TANKS BY SHELL--------------------------------------------------------

    @Operation(summary = "${tankPath}/shell/{name}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Tank.class)))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @GetMapping(value = "/shell/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tank[]> getTanksByShell(@PathVariable("shellId") int shellId) throws AddressNotValidException{
        return new ResponseEntity<Tank[]>(tank.getTanksByShell(shellId), HttpStatus.OK);
    }

    //--------------------------------------------------GET TANKS BY TRACKWHEEL--------------------------------------------------------

    @Operation(summary = "${tankPath}/trackWheel/{name}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Tank.class)))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @GetMapping(value = "/trackWheel/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tank[]> getTanksByTrackWheel(@PathVariable("trackWheelId") int trackWheelId) throws AddressNotValidException{
        return new ResponseEntity<Tank[]>(tank.getTanksByTrackWheel(trackWheelId), HttpStatus.OK);
    }

    //--------------------------------------------------INSET TANK--------------------------------------------------------

    @Operation(summary = "${tankPath}")
    @ApiResponses(value = { @ApiResponse(responseCode = "201",  content = {
            @Content(mediaType = "application/json")
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insertTank(@RequestBody Tank requestTank){
        if (tank.insertTank(requestTank)) {
            return new ResponseEntity(HttpStatus.CREATED);
        }
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    //--------------------------------------------------EDIT TANK--------------------------------------------------------

    @Operation(summary = "${tankPath}")
    @ApiResponses(value = { @ApiResponse(responseCode = "202",  content = {
            @Content(mediaType = "application/json")
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @PutMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editTank(@RequestBody Tank requestTank){
        if (tank.editTank(requestTank)) {
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    //--------------------------------------------------DELETE TANK--------------------------------------------------------

    @Operation(summary = "${tankPath}/{id}")
    @ApiResponses(value = { @ApiResponse(responseCode = "202",  content = {
            @Content(mediaType = "application/json")
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @DeleteMapping(value = "/{tankId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteTank(@PathVariable("tankId") int tankId) throws AddressNotValidException{
        if (tank.deleteTank(tankId)) {
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
