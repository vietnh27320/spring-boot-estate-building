package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.custom.BuildingRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Long>, BuildingRepositoryCustom {
    //    List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder, Map<String, Object> params);
//    void deleteBuilding(long[] ids);
    List<BuildingEntity> findByStaffs_Id(long staffId);

    List<BuildingEntity> findByNameContainingAndFloorArea(String name, Integer floorArea);

    List<BuildingEntity> findByNameContaining(String name);

    List<BuildingEntity> findByFloorArea(Integer floorArea);

}
