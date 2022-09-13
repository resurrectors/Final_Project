package com.app.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
public class UserEntity extends BaseEntity{
	
	@Column(name = "first_name", length = 20)
	private String firstName;
	
	@Column(name = "last_name", length = 30)
	private String lastName;
	
	@Column(length = 3, nullable = true)
	private String country_code;
	
	@Column(length = 10, nullable = true)
	private String contact_no;
	
	@OneToOne
	@JoinColumn(name = "user_addr", nullable = true)
	private AddressEntity user_addr;
	
	@Column(length = 30, unique = true, nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@ManyToMany
	@JoinTable(name = "user_roles", 
	joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> userRoles = new HashSet<>();

}
