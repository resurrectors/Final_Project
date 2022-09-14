package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.Building;
import com.app.service.IBuildingService;

@RestController
@RequestMapping("/building")
public class BuildingController {

	@Autowired
	private IBuildingService buildingService;

	@GetMapping
	public ResponseEntity<?> getListOfBuildings() {
		return ResponseEntity.ok(buildingService.getAllBuildings());
	}
	
	@PostMapping
	public ResponseEntity<?> addBuilding(@RequestBody @Valid Building building) {
		return ResponseEntity.ok(buildingService.addBuilding(building));
	}
	
//	@DeleteMapping("/{buildingId}")        PENDING
//	public ResponseEntity<?> deleteBuilding(@PathVariable Long buildingId){
//		return ResponseEntity.ok(buildingId);
//	}
}
