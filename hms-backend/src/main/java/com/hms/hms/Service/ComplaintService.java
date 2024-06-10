package com.hms.hms.Service;

import com.hms.hms.Entity.Complaint;
import com.hms.hms.Repo.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintService {
    @Autowired
    private ComplaintRepository complaintRepository;

    public List<Complaint> getAllComplaints(){
        return complaintRepository.findAll();
    }

    public Complaint saveComplaint(Complaint complaint){
        return complaintRepository.save(complaint);
    }

    public void deleteComplaint(Long id){
        complaintRepository.deleteById(id);
    }
}
