package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IBuildingService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BuildingService implements IBuildingService {

    /*BuildingRepository buildingRepository = new BuildingRepository();
    BuildingConverter buildingConverter = new BuildingConverter();
    IRentAreaRepository rentAreaRepository = new RentAreaRepository();
    IAssignmentBuildingRepository assignmentBuildingRepository = new AssignmentBuildingRepository();*/

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private BuildingConverter buildingConverter;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<BuildingDTO> findAll() {
        List<BuildingEntity> buildingEntities = buildingRepository.findAll();
        List<BuildingDTO> results = buildingEntities.stream().map(item -> buildingConverter.convertToDto(item)).collect(Collectors.toList());
        return results;
    }

    @Override
    public List<BuildingDTO> findByStaff(long staffId) {
        /*List<BuildingEntity> buildingEntities = buildingRepository.findByStaff(staffId);
        List<BuildingDTO> results = buildingEntities.stream().map(item ->  buildingConverter.convertToDto(item)).collect(Collectors.toList());
        return results;*/

        /*JPQL <-> HQL*/
        /*UserEntity userEntity = userRepository.findById(staffId);
        List<BuildingEntity> buildingEntities = userEntity.getBuildings();
        List<BuildingDTO> results = buildingEntities.stream().map(item -> buildingConverter.convertToDto(item)).collect(Collectors.toList());
        return results;*/

        /*spring data jpa*/
        List<BuildingEntity> buildingEntities = buildingRepository.findByStaffs_Id(staffId);
        List<BuildingDTO> results = buildingEntities.stream().map(item -> buildingConverter.convertToDto(item)).collect(Collectors.toList());
        return results;
    }

    @Override
    public List<BuildingDTO> findAll(BuildingSearchBuilder builder) {
        List<BuildingDTO> results = new ArrayList<>();
        Map<String, Object> params = convertDataToMap(builder);
        //logic lấy giá trị từ builder push vào map
        List<BuildingEntity> buildingEntities = buildingRepository.findAll(builder, params);
        for (BuildingEntity item : buildingEntities) {
            BuildingDTO buildingDTO = buildingConverter.convertToDto(item);
            results.add(buildingDTO);
        }
        return results;
    }

    private Map<String, Object> convertDataToMap(BuildingSearchBuilder builder) {
        Map<String, Object> results = new HashMap<>();
        try {
            Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
            for (Field field : fields) {
                if (!field.getName().startsWith("areaRent") && !field.getName().equals("types")
                        && !field.getName().startsWith("costRent")) {
                    field.setAccessible(true);
                    results.put(field.getName(), field.get(builder));
                }
            }
        } catch (Exception exception) {
            System.out.println(exception);
            return null;
        }
        return results;
    }

  /*  @Override
    public void update(BuildingDTO updateBuilding) {
//		BuildingEntity buildingEntity = new BuildingEntity();
//		buildingEntity.setId(updateBuilding.getId());
//		buildingEntity.setName(updateBuilding.getName());
//		buildingRepository.update(buildingEntity);
    }

    @Override
    public void insert(BuildingDTO newBuilding) {
        BuildingEntity buildingEntity = buildingConverter.convertToEntity(newBuilding);
        //type
        Long buildingId = buildingRepository.insert(buildingEntity);
        //rentarea
        String[] rentArea = new String[]{};
        if (rentArea != null && rentArea.length > 0) {
            for (String item : rentArea) {
                RentAreaEntity rentAreaEntity = new RentAreaEntity();
                rentAreaEntity.setBuildingid(buildingId);
                rentAreaEntity.setValue(Integer.parseInt(item));
                rentAreaRepository.insert(rentAreaEntity);
            }
        }
    }

    @Override
    public List<BuildingDTO> findAll(BuildingSearchBuilder builder) {
        List<BuildingDTO> results = new ArrayList<>();
        Map<String, Object> params = convertDataToMap(builder);
        //logic lấy giá trị từ builder push vào map
        List<BuildingEntity> buildingEntities = buildingRepository.findAll(builder, params);
        for (BuildingEntity item : buildingEntities) {
            BuildingDTO buildingDTO = buildingConverter.convertToDto(item);
            results.add(buildingDTO);
        }
        return results;
    }

    @Override
    public BuildingDTO findById(Long id) {
        BuildingEntity buildingEntity = buildingRepository.findById(id);
        BuildingDTO result = buildingConverter.convertToDto(buildingEntity);
        List<RentAreaEntity> rentAreaEntities = rentAreaRepository.findByBuilidingId(result.getId());

        return result;
    }

    @Override
    public void delete(long[] ids) {
        for (long item : ids) {
            rentAreaRepository.deleteByBuildingId(item);
            assignmentBuildingRepository.deleteByBuildingId(item);
            buildingRepository.delete(item);
        }

    }

    private Map<String, Object> convertDataToMap(BuildingSearchBuilder builder) {
        Map<String, Object> results = new HashMap<>();
        try {
            Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
            for (Field field : fields) {
                if (!field.getName().startsWith("areaRent") && !field.getName().equals("types")
                        && !field.getName().startsWith("costRent")) {
                    field.setAccessible(true);
                    results.put(field.getName(), field.get(builder));
                }
            }
        } catch (Exception exception) {
            System.out.println(exception);
            return null;
        }
        return results;
    }*/

}
