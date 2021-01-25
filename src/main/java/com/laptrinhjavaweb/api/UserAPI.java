package com.laptrinhjavaweb.api;

import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.impl.BuildingService;
import com.laptrinhjavaweb.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserAPI {

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    @GetMapping("/api/staff/{staffid}/buildings")
    public List<BuildingDTO> findAll(@PathVariable("staffid") long staffId) {
        return buildingService.findByStaff(staffId);
    }

    @GetMapping("/api/all/staff/buildings")
    public List<BuildingDTO> findAll() {
        return buildingService.findAll();
    }

    @DeleteMapping("/api/user/{userid}/deleting")
    public void deleteUser(@PathVariable("userid") long userid) {
        userService.deleteByUserr(userid);
    }

    @PostMapping("/api/add/user")
    public void insertUser(@RequestBody UserDTO userDTO) {
        userService.insertUser(userConverter.convertToEntity(userDTO));
    }

    @GetMapping("/api/user")
    public OutPut showUser(@RequestParam int page,
                           @RequestParam int limit) {
        OutPut result = new OutPut();
        result.setPage(page);
        Pageable pageable = new PageRequest(page, limit);
        result.setListResult(userService.findAll(pageable));
        result.setTotalPage((int) Math.ceil((double) userService.totalitem() / limit));
        return result;
    }


}
