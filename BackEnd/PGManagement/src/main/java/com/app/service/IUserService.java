package com.app.service;

import com.app.dto.User;
import com.app.dto.UserDTO;
import com.app.dto.UserRegResponse;

public interface IUserService {

	UserRegResponse registerUser(UserDTO user);
	User getUser(String email, String password);
	User getUserByID(long userId);
	User updateUserByID(long userId, User newData);
	User deleteUserByID(long userId);

}
