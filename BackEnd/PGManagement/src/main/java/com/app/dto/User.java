package com.app.dto;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
//	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	private String firstName;
	private String lastName;
	private String country_code;
	private String contact_no;
	private Address user_addr;
	private String email;
}
