package com.app.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Booking {
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	private User user;
	private Bed bed;
	private LocalDate start_date;
	private LocalDate end_date;
	private boolean rent_paid_status;
	private LocalDate transaction_date;
}
