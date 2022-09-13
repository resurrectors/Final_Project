package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.dto.Building;
import com.app.repository.BuildingRepository;

public class BuildingServiceImpl implements IBuildingService {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private BuildingRepository buildRepo;

	@Override
	public List<Building> getAllBuildings() {
		return buildRepo.findAll().stream().map(b -> mapper.map(b, Building.class)).collect(Collectors.toList());
	}
	
}
