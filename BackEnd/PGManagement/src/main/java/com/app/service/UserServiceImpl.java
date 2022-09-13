package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dto.User;
import com.app.dto.UserDTO;
import com.app.dto.UserRegResponse;
import com.app.entities.AddressEntity;
import com.app.entities.UserEntity;
import com.app.repository.AddressRepository;
import com.app.repository.RoleRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private AddressRepository addrRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public UserRegResponse registerUser(UserDTO user) {
		// Objective : 1 rec inserted in users table n insert n recs in link table
		// user_roles
		// 1. Map dto --> entity
		UserEntity userEntity = mapper.map(user, UserEntity.class);
		// 2. Map Set<UserRole : enum> ---> Set<Role :entity> n assign it to the
		// transient user entity
		userEntity.setUserRoles(roleRepo.findByRoleNameIn(user.getRoles()));
		// 3. encode pwd
		userEntity.setPassword(encoder.encode(user.getPassword()));
		// 4 : Save user details
		UserEntity persistentUser = userRepo.save(userEntity);
		return new UserRegResponse("User registered successfully with ID " + persistentUser.getId());
	}

	@Override
	public User getUser(String email, String password) {
		Optional<UserEntity> userEntity = userRepo.findByEmailAndPassword(email, password);
		if(userEntity.isPresent())
			return mapper.map(userEntity.get(), User.class);
		return null;
	}

	@Override
	public User getUserByID(long userId) {
		return mapper.map(userRepo.getReferenceById(userId),User.class);
	}

	@Override
	public User updateUserByID(long userId, User newData) {
		UserEntity userEntity = userRepo.findById(userId).orElse(null);
		if(userEntity != null) {
			userEntity.setFirstName(newData.getFirstName());
			userEntity.setContact_no(newData.getContact_no());
			userEntity.setCountry_code(newData.getCountry_code());
			userEntity.setEmail(newData.getEmail());
			userEntity.setLastName(newData.getLastName());
			userEntity.setUser_addr(addrRepo.save(mapper.map(newData.getUser_addr(), AddressEntity.class)));
		}
		return mapper.map(userRepo.save(userEntity),User.class);
	}

	@Override
	public User deleteUserByID(long userId) {
		UserEntity userEntity = userRepo.findById(userId).orElse(null);
		if(userEntity != null) {
			userRepo.delete(userEntity);
		}
		return mapper.map(userEntity, User.class);
	}
}
