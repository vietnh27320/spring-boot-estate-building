package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;

import java.util.List;

public interface IBuildingService {
	List<BuildingDTO> findAll();
	List<BuildingDTO> findByStaff(long staffId);
	List<BuildingDTO> findAll(BuildingSearchBuilder builder);
	void delete(long staffid);
	void create(BuildingEntity buildingEntity);
}
