package com.tanktoys.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tanktoys.app.models.Address;
import com.tanktoys.app.models.Room;
import com.tanktoys.app.models.User;
import com.tanktoys.app.services.RoomService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@EnableAutoConfiguration
@Tag(name = "${roomPath}")
@RequestMapping("${roomPath}")
public class roomController {

	@Autowired
	RoomService roomService;

	@Operation(summary = "${roomPath}/{id}")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = Room.class))
	}),
			@ApiResponse(responseCode = "400", content = @Content) })
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Room> getRoom(@PathVariable("id") int id) {
		return new ResponseEntity<Room>(roomService.getRoomById(id), HttpStatus.OK);
	}

	@Operation(summary = "${roomPath}")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = {
			@Content(mediaType = "application/json")
	}),
			@ApiResponse(responseCode = "400", content = @Content) })
	@PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity insertRoom(@RequestBody Room requestRoom) {
		if (roomService.editRoom(requestRoom)) {
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@Operation(summary = "${roomPath}")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = {
			@Content(mediaType = "application/json")
	}),
			@ApiResponse(responseCode = "400", content = @Content) })
	@PutMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity editRoom(@RequestBody Room requestRoom) {
		if (roomService.editRoom(requestRoom)) {
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@Operation(summary = "${roomPath}")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = {
			@Content(mediaType = "application/json")
	}),
			@ApiResponse(responseCode = "400", content = @Content) })
	@DeleteMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity deleteRoom(@PathVariable("id") int id) {
		if (roomService.deleteRoom(id)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
}
