package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;

import java.util.List;
import java.util.Map;

public interface BuildingRepositoryCustom {
    List<BuildingEntity> findByStaff(Long staffId);
    List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder, Map<String, Object> params);


}

