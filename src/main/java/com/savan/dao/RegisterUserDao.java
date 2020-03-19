/**
 * 
 */
package com.savan.dao;

import java.sql.ResultSet;

import com.savan.model.RegisterUserModel;

/**
 * @author SAVAN
 *
 */
public interface RegisterUserDao {

	//Register User 
	public boolean insert(RegisterUserModel UserModel);
	
	//validate logging user
	public boolean validate(String userName, String password);
	
	//get last inserted row 
	public int lastRow();
	
	//check email exist or not
	public boolean isEmailExist(String email);
	
	//get user id
	public int getUserId(String email);
	
	//get role
	public int getUserRole(String email);
	
	//get user data
	public RegisterUserModel fetchUser(int userId);
	
	// get all users
	public ResultSet fetchAllUser();
	
	//update user
	public boolean editUser(RegisterUserModel userModel,int userId);

	//deleting user 
	public boolean removeUser(int userId);

	//Fatch Password 
	public String fatchPassword(String name);

}
