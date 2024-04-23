package com.hms.hms.Outgoing.controller;

import com.hms.hms.Outgoing.Dto.OutgoingDto;
import com.hms.hms.Outgoing.service.OutgoingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/outgoing")
@CrossOrigin(origins = "http://localhost:3000")
public class OutgoingController {
    private OutgoingService outgoingService;


    @PostMapping
    public ResponseEntity<OutgoingDto>createOutgoing(@RequestBody OutgoingDto outgoingDto) {
        OutgoingDto savedOutgoing=outgoingService.createOutgoing(outgoingDto);
        return new ResponseEntity<>(savedOutgoing, HttpStatus.CREATED);
    }
}