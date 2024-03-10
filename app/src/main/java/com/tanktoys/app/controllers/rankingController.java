package com.tanktoys.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tanktoys.app.models.Address;
import com.tanktoys.app.models.Ranking;
import com.tanktoys.app.models.Tank;
import com.tanktoys.app.services.RankingService;
import com.tanktoys.app.services.RoomService;
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
@Tag(name = "${rankingPath}")
@RequestMapping("${rankingPath}")
public class rankingController {

	@Autowired
	RankingService rankingService;

    //--------------------------------------------------GET TANKING--------------------------------------------------------
    
    @Operation(summary = "${rankingPath}")
    @CrossOrigin(origins = "${CORS_sources}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Ranking.class)))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ranking[]> getRanking() throws AddressNotValidException {
		return new ResponseEntity<Ranking[]>(rankingService.getAllRankings(), HttpStatus.OK);
    }

    //--------------------------------------------------GET RANKS BY ADDRESS--------------------------------------------------------

    @Operation(summary = "${rankingPath}/{address}")
    @CrossOrigin(origins = "${CORS_sources}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Ranking.class)))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @GetMapping(value = "/{address}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ranking[]> getRanksByAddress(@PathVariable("address") Address address) throws AddressNotValidException {
        return new ResponseEntity<Ranking[]>(rankingService.getRanksByAddress(address), HttpStatus.OK);
    }

    //--------------------------------------------------GET RANKS BY MODE--------------------------------------------------------

    @Operation(summary = "${rankingPath}/{mode}")
    @CrossOrigin(origins = "${CORS_sources}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Ranking.class)))
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @GetMapping(value = "/{mode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ranking[]> getRanksByMode(@PathVariable("mode") String mode) throws AddressNotValidException {
        return new ResponseEntity<Ranking[]>(rankingService.getRanksByMode(mode), HttpStatus.OK);
    }

    //--------------------------------------------------INSERT RANKING--------------------------------------------------------

    @Operation(summary = "${rankingPath}")
    @CrossOrigin(origins = "${CORS_sources}")
    @ApiResponses(value = { @ApiResponse(responseCode = "202",  content = {
            @Content(mediaType = "application/json")
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insertRanking(@RequestBody Ranking ranking) throws AddressNotValidException {
		if (rankingService.insertRanking(ranking)) {
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    //--------------------------------------------------EDIT RANKING--------------------------------------------------------

    @Operation(summary = "${rankingPath}")
    @CrossOrigin(origins = "${CORS_sources}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json")
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @PutMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editRanking(@RequestBody Ranking ranking) {
                if (rankingService.editRanking(ranking)) {
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    //--------------------------------------------------DELETE RANKING--------------------------------------------------------

    @Operation(summary = "${rankingPath}/{address}")
    @CrossOrigin(origins = "${CORS_sources}")
    @ApiResponses(value = { @ApiResponse(responseCode = "200",  content = {
            @Content(mediaType = "application/json")
    }),
            @ApiResponse(responseCode = "400",  content = @Content) })
    @DeleteMapping(value = "/{address}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteRanking(@PathVariable("address") Address address) throws AddressNotValidException {
                if (rankingService.deleteRanking(address)) {
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
