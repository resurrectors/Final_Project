package com.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Address {
//	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	private String addrl1;
	private String addrl2;
	private String city;
	private String state;
	private String country;
	private String zipCode;
}
