package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.BookingEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, Long>{

}
