package com.hms.hms.Fines.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.hms.hms.Fines.Dto.FinesDto;
import com.hms.hms.Fines.service.FinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/fines")
@CrossOrigin(origins = "http://localhost:3000")
public class FinesController {
    private final FinesService finesService;

    @Autowired
    public FinesController(FinesService finesService) {this.finesService = finesService;}

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FinesDto> createFines(
            @RequestParam("finesDto") String finesDtoJson,
            @RequestParam("proofImage") MultipartFile proofImage
    ) throws IOException {
        if (proofImage == null || proofImage.isEmpty()) {
            return ResponseEntity.badRequest().body(null); // Handle empty proofImage
        }
        // Convert JSON string to FinesDto object
        FinesDto finesDto = new ObjectMapper().readValue(finesDtoJson, FinesDto.class);

        // Set the proof image data in the finesDto
        finesDto.setProofImage(proofImage.getBytes());

        // Save the finesDto using the feeService
        FinesDto savedFines = finesService.createFines(finesDto);

        // Return ResponseEntity with the savedFines and CREATED status
        return new ResponseEntity<>(savedFines,HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FinesDto>> getAllFines() {
        List<FinesDto> fines = finesService.getAllFines();
        return ResponseEntity.ok(fines);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FinesDto>> searchFinesByTgNumber(@RequestParam("tgNumber") String tgNumber) {
        List<FinesDto> fines = finesService.searchFinesByTgNumber(tgNumber);
        return ResponseEntity.ok(fines);
    }

    @GetMapping(value = "/status", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FinesDto>> filterFinesByStatus(@RequestParam String status) {
        List<FinesDto> fines = finesService.filterFinesByStatus(status);
        return ResponseEntity.ok(fines);
    }

    @GetMapping(value = "/status/null", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FinesDto>> filterFinesByNullStatus() {
        List<FinesDto> fines = finesService.filterFinesByNullStatus();
        return ResponseEntity.ok(fines);
    }

    @PutMapping( value = "{id}",produces = "application/json")
    public ResponseEntity<FinesDto> updateFines(@PathVariable("id")Long finesId, @RequestBody FinesDto updateFines){
        FinesDto finesDto = finesService.updateFines(finesId, updateFines);
        return ResponseEntity.ok(finesDto);
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteFines(@PathVariable("id") Long finesId) {
        finesService.deleteFines(finesId);
        return ResponseEntity.ok("Fines details deleted successfully");
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<String> handleIOException(IOException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error processing file upload: " + ex.getMessage());
    }
}
