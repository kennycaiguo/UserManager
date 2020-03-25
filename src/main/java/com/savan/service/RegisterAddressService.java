/**
 * 
 */
package com.savan.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

/**
 * @author SAVAN
 *
 */
public interface RegisterAddressService {

	// Add User Address
	public boolean addressService(HttpServletRequest request, HttpServletResponse response , int lastId);
	
	//get user address
	public JSONObject getAddressInfo(int userId);

	//update user's Addresses
	public boolean updateUserAddress(HttpServletRequest request, HttpServletResponse response, int userId);
	
	//delete user's All Address
	public boolean deleteUserAddress(int userId);
	
	//delete selected User address
	public boolean deleteSelectedAddress(int addressId);
	
	//get number of address count
	public boolean getAddressCount(int userId);
}
