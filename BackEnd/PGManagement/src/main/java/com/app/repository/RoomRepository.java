package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.RoomEntity;

public interface RoomRepository extends JpaRepository<RoomEntity, Long>{

}
