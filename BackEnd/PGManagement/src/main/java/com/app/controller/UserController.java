package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.User;
import com.app.service.IUserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping("/{userEmail}")
	public ResponseEntity<?> getUserDetails(@PathVariable String userEmail) {
		log.info(this.getClass() + " method getEmpDetails");
		log.info("User id " + userEmail);
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByEmail(userEmail));
	}

	@PutMapping("/{userId}")
	public ResponseEntity<?> updateUserDetails(@PathVariable long userId, @RequestBody @Valid User newData) {
		log.info(this.getClass() + " method updateEmpDetails");
		log.info("User id " + userId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.updateUserByID(userId, newData));
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUserDetails(@PathVariable long userId){
		log.info(this.getClass() + " method deleteUserDetails");
		log.info("User id " + userId);
		return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUserByID(userId));
	}
}
