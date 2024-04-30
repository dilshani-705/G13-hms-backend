package com.hms.hms.Fees.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hms.hms.Fees.Dto.FeeDto;
import com.hms.hms.Fees.service.FeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/fee")
@CrossOrigin(origins = "http://localhost:3000")
public class FeeController {

    private final FeeService feeService;

    @Autowired
    public FeeController(FeeService feeService) {
        this.feeService = feeService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeDto> createFee(
            @RequestParam("feeDto") String feeDtoJson,
            @RequestParam("proofImage") MultipartFile proofImage
    ) throws IOException {
        if (proofImage == null || proofImage.isEmpty()) {
            return ResponseEntity.badRequest().body(null); // Handle empty proofImage
        }
        // Convert JSON string to FeeDto object
        FeeDto feeDto = new ObjectMapper().readValue(feeDtoJson, FeeDto.class);

        // Set the proof image data in the feeDto
        feeDto.setProofImage(proofImage.getBytes());

        // Save the feeDto using the feeService
        FeeDto savedFee = feeService.createFee(feeDto);

        // Return ResponseEntity with the savedFee and CREATED status
        return new ResponseEntity<>(savedFee,HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FeeDto>> getAllFee() {
        List<FeeDto> fees = feeService.getAllFee();
        return ResponseEntity.ok(fees);
    }

    @PutMapping( value = "{id}",produces = "application/json")
    public ResponseEntity<FeeDto> updateFee(@PathVariable("id")Long feeId, @RequestBody FeeDto updateFee){
        FeeDto feeDto = feeService.updateFee(feeId, updateFee);
        return ResponseEntity.ok(feeDto);
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteFee(@PathVariable("id") Long feeId) {
        feeService.deleteFee(feeId);
        return ResponseEntity.ok("Fee details deleted successfully");
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<String> handleIOException(IOException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error processing file upload: " + ex.getMessage());
    }
}
