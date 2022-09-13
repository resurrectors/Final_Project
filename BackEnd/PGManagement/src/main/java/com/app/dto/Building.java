package com.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Building{
	
//	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	private String name;
	private Address building_addr;
	private User owner;
}
