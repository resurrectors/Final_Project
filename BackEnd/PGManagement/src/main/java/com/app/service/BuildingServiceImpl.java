package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.Building;
import com.app.entities.AddressEntity;
import com.app.entities.BuildingEntity;
import com.app.entities.UserEntity;
import com.app.repository.AddressRepository;
import com.app.repository.BuildingRepository;
import com.app.repository.UserRepository;
@Service
@Transactional
public class BuildingServiceImpl implements IBuildingService {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private AddressRepository addrRepo;
	
	@Autowired
	private BuildingRepository buildRepo;

	@Autowired UserRepository userRepo;
	
	@Override
	public List<Building> getAllBuildings() {
		return buildRepo.findAll().stream().map(b -> mapper.map(b, Building.class)).collect(Collectors.toList());
	}

	@Override
	public Building addBuilding(Building building) {
		AddressEntity a = addrRepo.save(mapper.map(building.getBuilding_addr(), AddressEntity.class));
		BuildingEntity b = mapper.map(building, BuildingEntity.class);
		b.setBuilding_addr(a);
		b.setOwner(mapper.map(building.getOwner(), UserEntity.class));
		return mapper.map(buildRepo.save(b),Building.class);
	}
	
}
