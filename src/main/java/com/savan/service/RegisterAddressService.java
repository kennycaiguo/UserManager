/**
 * 
 */
package com.savan.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.savan.model.RegisterAddressModel;

/**
 * @author SAVAN
 *
 */
public interface RegisterAddressService {

	// addUser Address Service
	public boolean addressService(HttpServletRequest request, HttpServletResponse response , int lastId);
	
	//get user address
	public JSONObject getAddressInfo(int userId);

	//getting all users address
	public List<List<String>> getAllUserAddress();
	
	//update user Address
	public boolean updateUserAddress(HttpServletRequest request, HttpServletResponse response, int userId);
	
	//delete user Address
	public boolean deleteUserAddress(int userId);
	
	//delete address
	public boolean deleteSelectedAddress(int addressId);
}
