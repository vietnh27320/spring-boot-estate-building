package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuildingConverter {

	@Autowired
	private ModelMapper modelMapper;

	public BuildingDTO convertToDto(BuildingEntity entity) {
		BuildingDTO dto = modelMapper.map(entity, BuildingDTO.class);
		return dto;
	}

	public BuildingEntity convertToEntity(BuildingDTO dto) {
		BuildingEntity entity = modelMapper.map(dto, BuildingEntity.class);
		return entity;
	}
}
