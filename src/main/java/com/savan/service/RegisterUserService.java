/**
 * 
 */
package com.savan.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.savan.model.RegisterUserModel;

/**
 * @author SAVAN
 *
 */
public interface RegisterUserService {

	//user service method
	public boolean userService(HttpServletRequest request, HttpServletResponse response);
	
	//method to get last index id
	public int getIndex();
	
	//get user id
	public int getUserId(String email);
	
	//get role
	public int getUserRole(String email);
	
	//get user data
	public RegisterUserModel getUserInfo(int userId);
	
	//get all user
	public List<RegisterUserModel> getAllUser();
	
	//update user
	public boolean updateUser(HttpServletRequest request, HttpServletResponse response,int userId);
	
	//delete user 
	public boolean deleteUser(int userId);

	//check user exists
	public boolean userExists(String email);
	
	//Find password
	public String findPassword(String name);
	
	
}
