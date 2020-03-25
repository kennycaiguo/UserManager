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
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

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

		//session creation
		HttpSession session = request.getSession();

		// userModel instantiation
		RegisterUserModel userModel = new RegisterUserModel();

		// userService instantiation
		RegisterUserService userService = new RegisterUserServiceImpl();

		// addresService instantiation
		RegisterAddressService addressService = new RegisterAddressServiceImpl();

		if (request.getParameter("operaton").equals("Update")) {

			//getting user id for identify user
			int userId = Integer.parseInt(request.getParameter("id"));

			// get user info from database
			userModel = userService.getUserInfo(userId);

			// get user Address from database
			JSONObject userAddressModel = addressService.getAddressInfo(userId);
			
			//setting data into session 
			session.setAttribute("userData", userModel);
			session.setAttribute("addressData", userAddressModel);
			session.setAttribute("operation", request.getParameter("operaton"));
			session.setAttribute("userId", request.getParameter("id"));
			session.setAttribute("userRole", request.getParameter("role"));
			
			//redirect ot register.jsp
			response.sendRedirect("register.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)how to differentiate
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//session creation
		HttpSession session = request.getSession();
		
		// User Register object
		RegisterUserService userRegister = new RegisterUserServiceImpl();

		// redirect to the Register Address
		RegisterAddressService addressRegister = new RegisterAddressServiceImpl();
		
		// Validation utility class object
		 validateUser valid = new validateUser();

		/*
		 * 
		 * Update User Details
		 * 
		 */
		if (request.getParameter("operation").contentEquals("Update")) {
			
				//userModel instantiation
				RegisterUserModel userModel = new RegisterUserModel();
		
				// getting userId
				int userId = Integer.parseInt(request.getParameter("uid"));
				
				// updating userData
				boolean isUserUpdated = userRegister.updateUser(request, response, userId);
				
				
				if (isUserUpdated) {
					
					// updating user Address Data
					boolean isAddressUpdated = addressRegister.updateUserAddress(request, response, userId);
					
					if (isAddressUpdated) {
						
						//Select view to response from the update request
						if (request.getParameter("userRole").contentEquals("admin")) {
														
							//getting all user info
							List<RegisterUserModel> userList = userRegister.getAllUser();
							
							//setting values to session 
							session.setAttribute("role", "admin");
							session.setAttribute("userList", userList);
							
							//set max session time till brouser closed
							session.setMaxInactiveInterval(-1);
							
							//redirect to result.jsp
							response.sendRedirect("result.jsp");
						}
						else {
							
							//get user info from database
							userModel = userRegister.getUserInfo(userId);
							
							// get user Address from database 
							JSONObject userAddress = addressRegister.getAddressInfo(userId);

							//setting values to session 
							session.setAttribute("role", "user");
							session.setAttribute("addressData", userAddress);
							session.setAttribute("userData", userModel);
							
							//set max session time to 30 Minutes
							session.setMaxInactiveInterval(30 * 60);
										
							//redirect to result.jsp
							response.sendRedirect("result.jsp");
						}
					} else {
						System.out.println("Address Updated fail....");
					}
					
				} else {
					System.out.println("User Updated fail....");
				}
			
		 }
		
		/*
		 * 
		 * Add new Address for existing user
		 * 
		 */
		 if (request.getParameter("operation").contentEquals("newAddress")) {

				// validate user Address details
				String isDataValid = valid.validateAddress(request, response);
				
				if (isDataValid != "success") {
					response.getWriter().write("Invalid Address Formate...!!");
				}
				else {

					//getting userId
					int userId = Integer.parseInt(request.getParameter("userId"));
					
					// add user address to database
					boolean isadded = addressRegister.addressService(request, response, userId);
					
					if (isadded) {
						
						// get user Address from database 
						JSONObject userAddress = addressRegister.getAddressInfo(userId);
						
						//update the session value
						session.setAttribute("addressData", userAddress);
						
						response.getWriter().write("Address added successfully...!!");
					}
					else {
						response.getWriter().write("Fail to Added Address...!!");
					}
				}
		}
		 
		/*
		 * 
		 * Delete User Address
		 * 
		 */ 
		if (request.getParameter("operation").contentEquals("deleteAddress")) {

			//fatching the Userid to delete address
			int userId = Integer.parseInt(request.getParameter("userId"));

			//check address count 
			boolean isAlloweToDelete = addressRegister.getAddressCount(userId);

			if (isAlloweToDelete) {
				
				//fatching the addressid to delete address
				int addressId = Integer.parseInt(request.getParameter("addressId"));
				
				//delete the address from the databse
				boolean idDeleted = addressRegister.deleteSelectedAddress(addressId);
				
				if (idDeleted) {
					
					// get user Address from database 
					JSONObject userAddress = addressRegister.getAddressInfo(userId);
					
					//update the session value
					session.setAttribute("addressData", userAddress);
					
					response.getWriter().write("Address successfully Removed ...!!");
				}
				else {
					response.getWriter().write("Fail to Remove Rddress...!!");
				}
			}
			else {
				response.getWriter().write("One Address Is Required...!!");
			}
			
		}
		
		/*
		 * 
		 * Update User Address
		 * 
		 */
		if (request.getParameter("operation").contentEquals("updateAddress")) {

			// check user details
			String isDataValid = valid.validateAddress(request, response);
			
			if (isDataValid != "success") {
				
				response.getWriter().write("Invalid Address Formate...!!");
			}
			else {
				
				//get userId 
				int userId = Integer.parseInt(request.getParameter("userId"));
				
				// updating user Address Data
				boolean isAddressUpdated = addressRegister.updateUserAddress(request, response, userId);
				
				if (isAddressUpdated) {
					
					// get user Address from database 
					JSONObject userAddress = addressRegister.getAddressInfo(userId);
					
					//update the session value
					session.setAttribute("addressData", userAddress);
					
					response.getWriter().write("User Address Update Success full.........");
				}
				else {
					response.getWriter().write("Fail to Update Address...!!");
				}
			}
			
		}
		
		/*
		 * 
		 * Fatch User Addresses
		 * 
		 */
		if (request.getParameter("operation").contentEquals("fatchAllAddresses")) {
			
			//get userId 
			int userId = Integer.parseInt(request.getParameter("userId"));
			
			// updating user Address Data
			JSONObject addressList = addressRegister.getAddressInfo(userId);
			
			response.setContentType("application/json");
			
			response.getWriter().write(addressList.toString());
			
		}
		
		/*
		 * 
		 * Remove User
		 * 
		 */
		if (request.getParameter("operation").contentEquals("removeUser")) {
			
			//get userId 
			int userId = Integer.parseInt(request.getParameter("userId"));
			
			// delete user Address
			boolean isuserAddressDeleted = addressRegister.deleteUserAddress(userId);

			if (isuserAddressDeleted) {

				// deleting user
				boolean isuserDeleted = userRegister.deleteUser(userId);

				if (isuserDeleted) {
					response.getWriter().write("User Deletion Success full.........");
				} 
				else {
					response.getWriter().write("Fail to Delelte User.........");
				}
			} 
			else {
				response.getWriter().write("Fail to Delelte User.........");
			}
		}
		
		/*
		 * 
		 * Forgot Password
		 * 
		 */
		if (request.getParameter("operation").contentEquals("forgotPassword")) {
			
			//passeord fatched from the database
			String password = userRegister.findPassword(request.getParameter("userEmail"));
			
			if(password != null) {
				response.getWriter().write("Your Password Is : "+password);
			}
			else {
				response.getWriter().write("Please Enter Valide Enail Id..!!");
			}
			
		}
		
		/*
		 * 
		 * Register New User
		 * 
		 */
		if (request.getParameter("operation").contentEquals("Register")) {

			// check user details
			String isDataValid = valid.validateUserDetails(request, response);
			
			//check if data is invalid 
			if (isDataValid != "success") {
				
				//set error massage
				session.setAttribute("errMassage", isDataValid);
				
				//set form values 
				session.setAttribute("firstName", request.getParameter("firstNname")); 
				session.setAttribute("lastName", request.getParameter("lastNname"));
				session.setAttribute("email", request.getParameter("email"));
				session.setAttribute("contact", request.getParameter("contact"));
				session.setAttribute("home", request.getParameter("home"));
				session.setAttribute("leandmark", request.getParameter("leandmark"));
				session.setAttribute("city", request.getParameter("City"));
				session.setAttribute("state", request.getParameter("State"));
				session.setAttribute("country", request.getParameter("Country"));
				session.setAttribute("zipCode", request.getParameter("ZipCode"));
				
				//redirect to register
				response.sendRedirect("register.jsp");
			}
			else{
				
				// add user to database
				boolean isregister = userRegister.userService(request, response);
	
				// if registered then login
				if (isregister) {
	
					// get Id of last inserted row
					int lastId = userRegister.getIndex();
	
					// add user address to database
					boolean isadded = addressRegister.addressService(request, response, lastId);
	
					if (isadded) {
						
						//Success Massage
						request.setAttribute("loginMsg", "*Login with your e-mail and password");
	
						// redirecting user to login
						RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
						rd.forward(request, response);
					}
					else {
						
						// deleting user
						boolean isuderDeleted = userRegister.deleteUser(lastId);
	
						if (isuderDeleted) {
							
							//Failure Massage
							request.setAttribute("errMassage", "Process Fail Please Try Again....");
							
							// writing the error massage of validation
							RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
							rd.forward(request, response);
						}
					}
				} 
				else {
					
					//Failure Massage
					request.setAttribute("errMassage", "Process Fail Please Try Again....");
					
					// writing the error massage of validation
					RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
					rd.forward(request, response);
				}
			}

		}
	}
}
