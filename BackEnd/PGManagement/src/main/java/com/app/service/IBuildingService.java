package com.app.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.app.dto.Building;

public interface IBuildingService {
	List<Building> getAllBuildings();

	Building addBuilding(Building building);
}
