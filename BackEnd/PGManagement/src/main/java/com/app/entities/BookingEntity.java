package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="booking_details")
@Getter
@Setter
public class BookingEntity extends BaseEntity{
	
	@ManyToOne(fetch = FetchType.LAZY) //MANDATORY --o.w will get org.hib.MappingExc
	@JoinColumn(name="user",nullable = false)
	private UserEntity user;
	
	@ManyToOne(fetch = FetchType.LAZY) //MANDATORY --o.w will get org.hib.MappingExc
	@JoinColumn(name="bed",nullable = false)
	private BedEntity bed;
	
	
	private LocalDate start_date;
	
	private LocalDate end_date;
	
	@Column(name="rent_paid_status")
	private boolean rent_paid_status;
	
	@Column(name="tran_date")
	private LocalDate transaction_date;
	
}
