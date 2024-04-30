package com.hms.hms.Outgoing.controller;


import com.hms.hms.Outgoing.Dto.OutgoingDto;
import com.hms.hms.Outgoing.entity.Outgoing;
import com.hms.hms.Outgoing.mapper.OutgoingMapper;
import com.hms.hms.Outgoing.service.OutgoingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

}
