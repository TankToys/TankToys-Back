package com.tanktoys.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tanktoys.app.models.Room;
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

	//--------------------------------------------------GET ROOM BY ID--------------------------------------------------------

	@Operation(summary = "${roomPath}/{id}")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = Room.class))
	}),
			@ApiResponse(responseCode = "400", content = @Content) })
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Room> getRoom(@PathVariable("id") String id) {
		return new ResponseEntity<Room>(roomService.getRoomById(id), HttpStatus.OK);
	}

	//--------------------------------------------------INSERT ROOM--------------------------------------------------------

	@Operation(summary = "${roomPath}")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", content = {
			@Content(mediaType = "application/json")
	}),
			@ApiResponse(responseCode = "400", content = @Content) })
	@PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity insertRoom(@RequestBody Room requestRoom) {
		if (roomService.editRoom(requestRoom)) {
			return new ResponseEntity(HttpStatus.CREATED);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	//--------------------------------------------------EDIT ROOM--------------------------------------------------------

	@Operation(summary = "${roomPath}")
	@ApiResponses(value = { @ApiResponse(responseCode = "202", content = {
			@Content(mediaType = "application/json")
	}),
			@ApiResponse(responseCode = "400", content = @Content) })
	@PutMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity editRoom(@RequestBody Room requestRoom) {
		if (roomService.editRoom(requestRoom)) {
			return new ResponseEntity(HttpStatus.ACCEPTED);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	//--------------------------------------------------DELETE ROOM--------------------------------------------------------

	@Operation(summary = "${roomPath}/{id}")
	@ApiResponses(value = { @ApiResponse(responseCode = "202", content = {
			@Content(mediaType = "application/json")
	}),
			@ApiResponse(responseCode = "400", content = @Content) })
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity deleteRoom(@PathVariable("id") String id) {
		if (roomService.deleteRoom(id)) {
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
}
