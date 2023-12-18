package com.tanktoys.app.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@EnableAutoConfiguration
@Tag(name = "${rankingPath}")
@RequestMapping("${rankingPath}")
public class rankingController {

    @Operation(summary = "${rankingPath}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getRanking() {
        return null;
    }

    @Operation(summary = "${rankingPath}/{address}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @GetMapping(value = "/{address}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getRanksByAddress() {
        return null;
    }

    @Operation(summary = "${rankingPath}/{mode}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @GetMapping(value = "/{mode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getRanksByMode() {
        return null;
    }

    @Operation(summary = "${rankingPath}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insertRanking() {
        return null;
    }

    @Operation(summary = "${rankingPath}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @PutMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editRanking() {
        return null;
    }

    @Operation(summary = "${rankingPath}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @DeleteMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteRanking() {
        return null;
    }
}
