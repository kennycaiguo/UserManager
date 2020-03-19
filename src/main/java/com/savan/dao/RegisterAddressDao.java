/**
 * 
 */
package com.savan.dao;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.savan.model.RegisterAddressModel;

/**
 * @author SAVAN
 *
 */
public interface RegisterAddressDao {

	//Register User Address
	public boolean insert(List<List<String>> addressList,int lastId);
	
	//Fetching user address from the database
	public JSONObject fatchAddress(int userId);

	//getting all users address
	public List<List<String>> fetchAllUserAddress();

	//update user address
	public boolean update(List<List<String>> addressList, int userId);

	//deleting user Address
	public boolean remoeUserAddress(int userId);
	
	//delete address
	public boolean remoeSelectedAddress(int addressId);
	
}
