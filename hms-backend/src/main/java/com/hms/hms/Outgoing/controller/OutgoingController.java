package com.hms.hms.Outgoing.controller;


import com.hms.hms.Fees.Dto.FeeDto;
import com.hms.hms.Outgoing.Dto.OutgoingDto;
import com.hms.hms.Outgoing.entity.Outgoing;
import com.hms.hms.Outgoing.mapper.OutgoingMapper;
import com.hms.hms.Outgoing.service.OutgoingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/outgoing")
@CrossOrigin(origins = "http://localhost:3000")
public class OutgoingController {
    private OutgoingService outgoingService;


    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<OutgoingDto>createOutgoing(@RequestBody OutgoingDto outgoingDto) {
        OutgoingDto savedOutgoing=outgoingService.createOutgoing(outgoingDto);
        return new ResponseEntity<>(savedOutgoing, HttpStatus.CREATED);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<OutgoingDto>> getAllOutgoing() {
        List<OutgoingDto> outgoing=outgoingService.getAllOutgoing();
        return ResponseEntity.ok(outgoing);
    }

    @PutMapping( value = "{id}",produces = "application/json")
    public ResponseEntity<OutgoingDto> updateOutgoing(@PathVariable("id")Long outgoingId,@RequestBody OutgoingDto updateOutgoing){
        OutgoingDto outgoingDto = outgoingService.updateOutgoing(outgoingId, updateOutgoing);
        return ResponseEntity.ok(outgoingDto);
    }

    // Delete Outgoing by Id
    @DeleteMapping(value = "{id}", produces = "application/json")
    public ResponseEntity<String> deleteOutgoing(@PathVariable("id") Long outgoingId) {
        outgoingService.deleteOutgoing(outgoingId);
        return ResponseEntity.ok("Outgoing details deleted successfully");
    }

    @GetMapping(value = "/type/{type}", produces = "application/json")
    public ResponseEntity<List<OutgoingDto>> getOutgoingByType(@PathVariable("type") String selectOutgoingType) {
        List<OutgoingDto> outgoing = outgoingService.getOutgoingByType(selectOutgoingType);
        return ResponseEntity.ok(outgoing);
    }

    @GetMapping(value = "/hostel/{type}", produces = "application/json")
    public ResponseEntity<List<OutgoingDto>> getOutgoingByHostelType(@PathVariable("type") String selectHostelType) {
        List<OutgoingDto> outgoing = outgoingService.getOutgoingByHostelType(selectHostelType);
        return ResponseEntity.ok(outgoing);
    }

//    @GetMapping("/null-arrival-date")
//    public List<OutgoingDto> getOutgoingsWithNullArrivalDate() {
//        return outgoingService.findOutgoingsWithNullArrivalDate();
//    }

    @GetMapping(value = "/arrival-date/null", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OutgoingDto>> findOutgoingsWithNullArrivalDate() {
        List<OutgoingDto>outgoing = outgoingService.findOutgoingsWithNullArrivalDate();
        return ResponseEntity.ok(outgoing);
    }
}
