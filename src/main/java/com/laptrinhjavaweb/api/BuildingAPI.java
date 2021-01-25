package com.laptrinhjavaweb.api;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.impl.BuildingService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/api/building")
public class BuildingAPI {

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private BuildingConverter buildingConverter;

    @GetMapping("/api/building")
    public List<BuildingDTO> findAll(@RequestParam Map<String, String> model) {
        BuildingSearchBuilder builder = new BuildingSearchBuilder.Builder()
                .setName((String) getKeyFromModel(model, "name"))
                .setWard((String) getKeyFromModel(model, "ward"))
                .setStreet((String) getKeyFromModel(model, "street"))
                .setFloorArea(StringUtils.isNotBlank(model.get("floorarea").toString()) ? Integer.parseInt(model.get("floorarea")) : null)
                .setNumberOfBasement(StringUtils.isNotBlank(model.get("numberofbasement").toString()) ? Integer.parseInt(model.get("numberofbasement")) : null)
//                .setStaffId(StringUtils.isNotBlank(model.get("staffid").toString()) ? Long.parseLong(model.get("staffid")) : null)
                .build();
        return buildingService.findAll(builder);
    }

    private Object getKeyFromModel(Map<String, String> model, String key) {
        if (model.containsKey(key)) {
            model.get(key);
        }
        return null;
    }

    @PostMapping("/api/add/building")
    public void add(@RequestBody BuildingDTO buildingDTO) {
        buildingService.create(buildingConverter.convertToEntity(buildingDTO));
    }

//    @PostMapping
//    public void createBuilding(@RequestBody BuildingDTO buildingDTO) {
//        buildingService.insert(buildingDTO);
//    }
//
//    @PutMapping
//    public BuildingDTO updateBuilding(@RequestBody BuildingDTO buildingDTO) {
//
//        return null;
//    }
//
//    @DeleteMapping
//    public void deleteBuilding(@RequestBody long[] ids) {
//        buildingService.delete(ids);
//    }
}
