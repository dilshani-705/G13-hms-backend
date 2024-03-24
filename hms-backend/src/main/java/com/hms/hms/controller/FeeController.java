package com.hms.hms.controller;

import com.hms.hms.Dto.FeeDto;
import com.hms.hms.service.FeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/fee")
public class FeeController {
    private FeeService feeService;

    @GetMapping
    public ResponseEntity<List<FeeDto>>getAllFee(){
        List<FeeDto> fee=feeService.getAllFee();
        return ResponseEntity.ok(fee);
    }
}
