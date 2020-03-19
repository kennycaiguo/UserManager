package com.savan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.savan.model.RegisterAddressModel;
import com.savan.model.RegisterUserModel;
import com.savan.service.RegisterAddressService;
import com.savan.service.RegisterUserService;
import com.savan.service.impl.RegisterAddressServiceImpl;
import com.savan.service.impl.RegisterUserServiceImpl;
/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//session creation happens here
		
		
		//userModel instantiation
		RegisterUserModel userModel = new RegisterUserModel();
		
		//addressModel instantiation
		RegisterAddressModel addressModel = new RegisterAddressModel();
		
		//userService instantiation
		RegisterUserService userService = new RegisterUserServiceImpl();
		
		//addresService instantiation
		RegisterAddressService addressService = new RegisterAddressServiceImpl();

		//getting user id and set it to model class 
		userModel.setUserId(userService.getUserId(request.getParameter("uname")));

		//getting user role and set it to model class
		userModel.setUserRole(userService.getUserRole(request.getParameter("uname")));
		
		int userId = userModel.getUserId();
		int userRole = userModel.getUserRole();
				
		if(userRole == 2) {
			
			//to manage user view
			String user = "user";
			
			//get user info from database
			userModel = userService.getUserInfo(userId);
			
			//get user Address from database
			JSONObject usdrAddress = addressService.getAddressInfo(userId);
			
			request.setAttribute("userData", userModel);
			request.setAttribute("addressData", usdrAddress);
			request.setAttribute("Login", user);
			request.setAttribute("userId", userId);
			
			RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
			if (rd != null) {
				rd.forward(request, response);
			}
			else {
				System.out.println("Unexpected error......!!!");
			}
			
			
		}
		else {
			
			//to manage admin view
			String admin = "admin";
			
			//getting all user info
			List<RegisterUserModel> userList = userService.getAllUser();
			
			//getting all users address
			List<List<String>> userAddressList = addressService.getAllUserAddress();
			
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
		
	}

}
