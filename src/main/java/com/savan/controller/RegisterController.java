package com.savan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.savan.model.RegisterAddressModel;
import com.savan.model.RegisterUserModel;
import com.savan.service.RegisterAddressService;
import com.savan.service.RegisterUserService;
import com.savan.service.impl.RegisterAddressServiceImpl;
import com.savan.service.impl.RegisterUserServiceImpl;
import com.savan.util.validateUser;

/**
 * Servlet implementation class RegisterController
 */
@MultipartConfig
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		// userModel instantiation
		RegisterUserModel userModel = new RegisterUserModel();

		// addressModel instantiation
		RegisterAddressModel addressModel = new RegisterAddressModel();

		// userService instantiation
		RegisterUserService userService = new RegisterUserServiceImpl();

		// addresService instantiation
		RegisterAddressService addressService = new RegisterAddressServiceImpl();

		if (request.getParameter("operaton").equals("Update")) {

			int userId = Integer.parseInt(request.getParameter("id"));

			// get user info from database
			userModel = userService.getUserInfo(userId);

			// get user Address from database
			JSONObject userAddressModel = addressService.getAddressInfo(userId);

			request.setAttribute("userData", userModel);
			request.setAttribute("addressData", userAddressModel);
			request.setAttribute("operation", request.getParameter("operaton"));
			request.setAttribute("userId", request.getParameter("id"));
			request.setAttribute("userRole", request.getParameter("role"));

			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			if (rd != null) {
				rd.forward(request, response);
			} else {
				System.out.println("Unexpected error......!!!");
			}
		}
		else {

			int userId = Integer.parseInt(request.getParameter("operaton"));
			System.out.println("user id to delet"+userId);
			
			// delete user Address
			boolean isuserAddressDeleted = addressService.deleteUserAddress(userId);

			if (isuserAddressDeleted) {

				// deleting user
				boolean isuserDeleted = userService.deleteUser(userId);

				if (isuserDeleted) {
					System.out.println("Successfully user deleted....");
				} else {
					System.out.println("fail to delelte user.....");
				}

			} else {
				System.out.println("fail to delelte user Address.....");
			}

		}
		


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)how to differentiate
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// User Register object
		RegisterUserService userRegister = new RegisterUserServiceImpl();

		// redirect to the Register Address
		RegisterAddressService addressRegister = new RegisterAddressServiceImpl();

		// Validation utility class object
		/*validateUser valid = new validateUser();

		// check user details
		String isDataValid = valid.validateUserDetails(request, response);
		
		if (isDataValid != "success") {
			System.out.println("4");
			
			request.setAttribute("errMassage", isDataValid);
			request.setAttribute("firstName", request.getParameter("firstNname")); 
			request.setAttribute("lastName", request.getParameter("lastNname"));
			request.setAttribute("email", request.getParameter("email"));
			request.setAttribute("contact", request.getParameter("contact"));
			request.setAttribute("home", request.getParameter("home"));
			request.setAttribute("leandmark", request.getParameter("leandmark"));
			request.setAttribute("city", request.getParameter("City"));
			request.setAttribute("state", request.getParameter("State"));
			request.setAttribute("country", request.getParameter("Country"));
			request.setAttribute("zipCode", request.getParameter("ZipCode"));
			
			
			// writing the error massage of validation
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
		}*/
		
		/*else if (request.getParameter("Register").contentEquals("Update")) {
			
			//userModel instantiation
			RegisterUserModel userModel = new RegisterUserModel();
			
			//addressModel instantiation
			RegisterAddressModel addressModel = new RegisterAddressModel();
			
			// getting userId
			int userId = Integer.parseInt(request.getParameter("uid"));

			// updating userData
			boolean isUserUpdated = userRegister.updateUser(request, response, userId);


			if (isUserUpdated) {
				System.out.println("User Sucess fully updated....");
				
				// updating user Address Data
				boolean isAddressUpdated = addressRegister.updateUserAddress(request, response, userId);
				
				if (isAddressUpdated) {
					System.out.println("Address Sucess fully updated....");

					if (request.getParameter("userRole").equals("admin")) {
						
						//to manage admin view
						String admin = "admin";
						
						//getting all user info
						List<RegisterUserModel> userList = userRegister.getAllUser();
						
						//getting all users address
						List<List<String>> userAddressList = addressRegister.getAllUserAddress();
						
						request.setAttribute("userAddressList", userAddressList);
						request.setAttribute("userList", userList);
						request.setAttribute("Login", admin);
						
						RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
						if (rd != null) {
							rd.forward(request, response);
						}
						else {
							System.out.println("Unexpected error......!!!");
						}
					}
					else {
						
						//to manage user view
						String user = "user";
						
						//get user info from database
						userModel = userRegister.getUserInfo(userId);
						
						//get user Address from database
						List<List<String>> userAddressModel = addressRegister.getAddressInfo(userId);
						
						request.setAttribute("userData", userModel);
						request.setAttribute("addressData", userAddressModel);
						request.setAttribute("Login", user);
						
						RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
						if (rd != null) {
							rd.forward(request, response);
						}
						else {
							System.out.println("Unexpected error......!!!");
						}
					}
				} else {
					System.out.println("Address Updated fail....");
				}
				
			} else {
				System.out.println("User Updated fail....");
			}

		}*/
		 if (request.getParameter("operation").equals("newAddress")) {
			
			//getting userId
			int userId = Integer.parseInt(request.getParameter("userId"));
			
			// add user address to database
			boolean isadded = addressRegister.addressService(request, response, userId);
			
			if (isadded) {
				System.out.println("User Address Added Success full.........");
			}
			else {
				response.getWriter().write("Fail to Added Address...!!");
			}
		}
		if (request.getParameter("operation").equals("deleteAddress")) {

			//fatching the addressid to delete address
			int addressId = Integer.parseInt(request.getParameter("addressId"));
			
			//delete the address from the databse
			boolean idDeleted = addressRegister.deleteSelectedAddress(addressId);
			
			if (idDeleted) {
				System.out.println("User Address Deleteed Success full.........");
			}
			else {
				response.getWriter().write("Fail to Remove Rddress...!!");
			}
		}
		if (request.getParameter("operation").equals("updateAddress")) {
			System.out.println("address Id "+request.getParameter("addressId"));
			
			int addressId = Integer.parseInt(request.getParameter("addressId"));
			
			// updating user Address Data
			boolean isAddressUpdated = addressRegister.updateUserAddress(request, response, addressId);
			
			if (isAddressUpdated) {
				System.out.println("User Address Update Success full.........");
				response.getWriter().write("User Address Update Success full.........");
			}
			else {
				response.getWriter().write("Fail to Update Address...!!");
			}
		}
		if (request.getParameter("operation").equals("fatchAllAddresses")) {
			System.out.println("address Id "+request.getParameter("userId"));
			
			int userId = Integer.parseInt(request.getParameter("userId"));
			
			// updating user Address Data
			JSONObject addressList = addressRegister.getAddressInfo(userId);
			
			response.setContentType("application/json");
			
			System.out.println(new Gson().toJson(addressList));
			response.getWriter().write(addressList.toString());
			
			/* new Gson().toJson(addressList, response.getWriter()); */
			
			/*if (isAddressUpdated) {
				System.out.println("User Address Update Success full.........");
				response.getWriter().write("User Address Update Success full.........");
			}
			else {
				response.getWriter().write("Fail to Update Address...!!");
			}*/
		}
		/*else {

			// add user to database
			boolean isregister = userRegister.userService(request, response);

			// if registered then login
			if (isregister) {

				System.out.println("User Detail Success full.........");

				// get Id of last inserted row
				int lastId = userRegister.getIndex();

				// add user address to database
				boolean isadded = addressRegister.addressService(request, response, lastId);

				if (isadded) {
					System.out.println("User Address Success full.........");

					// redirecting user to login
					String massge = "*Login with your e-mail and password";
					request.setAttribute("loginMsg", massge);

					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				}
				else {
					
					// deleting user
					boolean isuderDeleted = userRegister.deleteUser(lastId);

					if (isuderDeleted) {
						System.out.println("User Address registeration Fail.........");
						
						request.setAttribute("errMassage", "Process Fail Please Try Again....");
						
						// writing the error massage of validation
						RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
						rd.forward(request, response);
					}
				}
			} 
			else {
				System.out.println("User registeration Fail.........");
				
				request.setAttribute("errMassage", "Process Fail Please Try Again....");
				
				// writing the error massage of validation
				RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
				rd.forward(request, response);
			}

		}*/
	}
}
