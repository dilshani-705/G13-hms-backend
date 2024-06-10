package com.hms.hms.Controller;

import com.hms.hms.Entity.Complaint;
import com.hms.hms.Service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {
    @Autowired
    private ComplaintService complaintService;

    @GetMapping
    public List<Complaint> getAllComplaints(){
        return complaintService.getAllComplaints();
    }

    @PostMapping
    public Complaint saveComplaint(@RequestBody Complaint complaint){
        return complaintService.saveComplaint(complaint);
    }

    @DeleteMapping("/{id}")
    public void deleteComplaint(@PathVariable Long id){
        complaintService.deleteComplaint(id);
    }
}
