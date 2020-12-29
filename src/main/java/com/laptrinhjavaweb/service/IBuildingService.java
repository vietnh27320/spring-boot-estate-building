package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;

import java.util.List;

public interface IBuildingService {
	List<BuildingDTO> findAll();
	List<BuildingDTO> findByStaff(long staffId);
	List<BuildingDTO> findAll(BuildingSearchBuilder builder);
}
