package com.tanktoys.app.controllers;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.auth0.jwt.exceptions.JWTCreationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.tanktoys.app.models.Address;
import com.tanktoys.app.models.User;
import com.tanktoys.app.services.UserService;
import com.tanktoys.app.utils.CustomJWT;
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
    @CrossOrigin(origins = "${CORS_sources}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
    }),
            @ApiResponse(responseCode = "400", content = @Content) })
    @GetMapping(value = "/{address}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getUserByAddress(@PathVariable("address") String address) 
        throws 
            AddressNotValidException, 
            NoSuchAlgorithmException, 
            JsonProcessingException, 
            IllegalArgumentException, 
            JWTCreationException {
        User user = userService.getUserByAddress(address);
		if (user.user != null) {
            String k = CustomJWT.encode(user);
			return new ResponseEntity<String>(k, HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
    }

    //--------------------------------------------------INSERT USER--------------------------------------------------------

    @Operation(summary = "${userPath}")
    @CrossOrigin(origins = "${CORS_sources}")
    @ApiResponses(value = { @ApiResponse(responseCode = "201", content = {
            @Content(mediaType = "application/json")
    }),
            @ApiResponse(responseCode = "400", content = @Content) })
    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> insertUser(@RequestBody User requestUser) throws JSONException, AddressNotValidException {
        if (userService.insertUser(requestUser)) {
            return new ResponseEntity<User>(requestUser, HttpStatus.CREATED);
        }
        return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
    }

    //--------------------------------------------------EDIT USER--------------------------------------------------------

    @Operation(summary = "${userPath}")
    @CrossOrigin(origins = "${CORS_sources}")
    @ApiResponses(value = { @ApiResponse(responseCode = "202", content = {
            @Content(mediaType = "application/json")
    }),
            @ApiResponse(responseCode = "400", content = @Content) })
    @PutMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> editUser(@RequestBody User requestUser) throws JSONException, AddressNotValidException {
        if (userService.editUser(requestUser)) {
            return new ResponseEntity<User>(requestUser, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
    }

    //--------------------------------------------------DELETE USER--------------------------------------------------------

    @Operation(summary = "${userPath}/{address}")
    @CrossOrigin(origins = "${CORS_sources}")
    @ApiResponses(value = { @ApiResponse(responseCode = "202", content = {
            @Content(mediaType = "application/json")
    }),
            @ApiResponse(responseCode = "400", content = @Content) })
    @DeleteMapping(value = "/{address}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("address") Address address) throws AddressNotValidException {
        if (userService.deleteUser(address)) {
            return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
    }
}
