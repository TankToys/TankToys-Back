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
import com.tanktoys.app.models.Ranking;
import com.tanktoys.app.services.MultiplayerService;
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
@Tag(name = "${multiplayerPath}")
@RequestMapping("${multiplayerPath}")
public class multiplayerController {
    @Autowired
    MultiplayerService multiplayerService;

    // --------------------------------------------------GET_TANKING--------------------------------------------------------

    @Operation(summary = "${multiplayerPath}/room")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Ranking.class)))
    }),
            @ApiResponse(responseCode = "400", content = @Content) })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createRoom(@RequestBody String hostId) throws AddressNotValidException {
        return new ResponseEntity<String>(multiplayerService.CreateRoom(new Address(hostId)), HttpStatus.OK);
    }

}
