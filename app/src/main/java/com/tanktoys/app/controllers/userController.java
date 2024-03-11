package com.tanktoys.app.controllers;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tanktoys.app.models.Address;
import com.tanktoys.app.models.User;
import com.tanktoys.app.services.UserService;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@EnableAutoConfiguration
@Tag(name = "${userPath}")
@RequestMapping("${userPath}")
public class UserController {

    @Autowired
    UserService userService;

    //--------------------------------------------------GET USER BY ADDRESS--------------------------------------------------------

    @Operation(summary = "${userPath}/{address}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
    }),
            @ApiResponse(responseCode = "400", content = @Content) })
    @GetMapping(value = "/{address}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserByAddress(@PathVariable("address") Address address) throws AddressNotValidException {
        User user = userService.getUserByAddress(address);
		if (user.user != null) {
			return new ResponseEntity<User>(userService.getUserByAddress(address), HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    }

    //--------------------------------------------------INSERT USER--------------------------------------------------------

    @Operation(summary = "${userPath}")
    @ApiResponses(value = { @ApiResponse(responseCode = "201", content = {
            @Content(mediaType = "application/json")
    }),
            @ApiResponse(responseCode = "400", content = @Content) })
    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insertUser(@RequestBody User requestUser) throws JSONException, AddressNotValidException {
        if (userService.insertUser(requestUser)) {
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    //--------------------------------------------------EDIT USER--------------------------------------------------------

    @Operation(summary = "${userPath}")
    @ApiResponses(value = { @ApiResponse(responseCode = "202", content = {
            @Content(mediaType = "application/json")
    }),
            @ApiResponse(responseCode = "400", content = @Content) })
    @PutMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editUser(@RequestBody User requestUser) throws JSONException, AddressNotValidException {
        if (userService.editUser(requestUser)) {
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    //--------------------------------------------------DELETE USER--------------------------------------------------------

    @Operation(summary = "${userPath}/{address}")
    @ApiResponses(value = { @ApiResponse(responseCode = "202", content = {
            @Content(mediaType = "application/json")
    }),
            @ApiResponse(responseCode = "400", content = @Content) })
    @DeleteMapping(value = "/{address}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteUser(@PathVariable("address") Address address) throws AddressNotValidException {
        if (userService.deleteUser(address)) {
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
