package com.hms.hms.Controller;

import com.hms.hms.Entity.Complaint;
import com.hms.hms.Repo.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/complaints")
@CrossOrigin(origins = "http://localhost:3000")
public class ComplaintController {

    @Autowired
    private ComplaintRepository complaintRepository;

    @PostMapping
    public Complaint createComplaint(@RequestBody Complaint complaint) {
        return complaintRepository.save(complaint);
    }
}