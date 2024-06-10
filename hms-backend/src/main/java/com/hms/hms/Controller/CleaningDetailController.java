package com.hms.hms.Controller;

import com.hms.hms.Entity.CleaningDetail;
import com.hms.hms.Service.CleaningDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cleaning")
public class CleaningDetailController {
    @Autowired
    private CleaningDetailService cleaningDetailService;

    @GetMapping
    public List<CleaningDetail> getAllCleaningDetails(){
        return cleaningDetailService.getAllCleaningDetails();
    }

    @DeleteMapping("/{id}")
    public void deleteCleaningDetail(@PathVariable Long id){
        cleaningDetailService.deleteCleaningDetail(id);
    }

}
