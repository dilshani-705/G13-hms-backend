package com.hms.hms.Controller;

import com.hms.hms.Entity.MaintenanceDetail;
import com.hms.hms.Service.MaintenanceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenanceDetails")
public class MaintenanceDetailController {

    @Autowired
    private MaintenanceDetailService maintenanceDetailService;

    @GetMapping
    public List<MaintenanceDetail> getAllMaintenanceDetail(){
        return maintenanceDetailService.getAllMaintenanceDetails();
    }

    @PostMapping
    public MaintenanceDetail saveMaintenanceDetail(@RequestBody MaintenanceDetail maintenanceDetail){
        return maintenanceDetailService.saveMaintenanceDetail(maintenanceDetail);
    }

    @DeleteMapping("/{id}")
    public void deleteMaintenanceDetail(@PathVariable Long id){
        maintenanceDetailService.deleteMaintenanceDetail(id);
    }

}
