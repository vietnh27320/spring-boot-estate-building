package com.laptrinhjavaweb.api;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.service.impl.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserAPI {

    @Autowired
    private BuildingService buildingService;

    @GetMapping("/api/staff/{staffid}/buildings")
    public List<BuildingDTO> findAll(@PathVariable("staffid") long staffId) {
        return buildingService.findByStaff(staffId);
    }
}
