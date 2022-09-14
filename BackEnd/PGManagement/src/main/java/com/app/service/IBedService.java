package com.app.service;

import java.util.List;

import javax.validation.Valid;

import com.app.dto.Bed;

public interface IBedService {
	List<Bed> getAllBedsInRoom(Long roomId);

	Bed addBedInRoom(Long roomId, Bed bed);

	Bed deleteBed(Long bedId);
}
