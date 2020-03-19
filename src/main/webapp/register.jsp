<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>

	<!-- setting user data -->
	<c:set var="user" scope="request" value="${requestScope.userData}" />
	<c:set var="address" scope="request" value="${requestScope.addressData}" />

	<!-- Form area starts-->
	<div class="form" >
		<div class="container">
			<br>
			<div class="row">
				<div class="col-md-8 m-auto d-block">
					<h1 class="text-success text-center">Registration Form</h1>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-8 m-auto d-block">
					<form action="RegisterController" method="post" class="bg-light"  id="Form" enctype="multipart/form-data" >
						
						<div class="form-group">
							<br>
							<div class="circle">
								<img class="profile-pic" name="defaultImage" src="data:image/gif;base64,${user.displayImage}" />
								<input type="hidden" name="defaultImageValue" value="${user.displayImage}" />
							</div>
							<label>Upload Profile Picture </label>
							<i class="fa fa-camera upload-button"></i>
							<div class="p-image">
								<input class="file-upload" name="image_file" type="file" accept="image/*" />
							</div>
						</div>
						
						<div class="form-group">
							<label>First Name</label>
							<input type="text" name="firstNname" class="form-control" id="firstName" autocomplete="off" onblur="FnameValidate()" value="${empty requestScope.firstName ? user.firstName : firstName}">
							<span id="FnameError" class="text-danger font-weight-bold"></span>
							<span >${fnameErr}</span>
						</div>

						<div class="form-group">	
							<label>Last Name</label>
							<input type="text" name="lastNname" class="form-control" id="lastName" autocomplete="off" onblur="LnameValidate()" value="${empty requestScope.lastName ? user.lastName : lastName}">
							<span id="LnameError" class="text-danger font-weight-bold"></span>
							<span >${lnameErr}</span>
						</div>

						<div class="form-group">
							<label>Password</label>
							<input type="password" name="password" class="form-control" id="password" autocomplete="off"  onpaste="return false;" onblur="pwdValidate()" value="${user.password}">
							<span id="PasswordError" class="text-danger font-weight-bold"></span>
							<span >${passwordErr}</span>
						</div>

						<div class="form-group">
							<label>Confirm Password</label>
							<input type="password" name="Cpassword" class="form-control" id="confirmPassword" autocomplete="off"  onpaste="return false;" onblur="cpwdValidate()" value="${user.password}">
							<span id="CpasswordError" class="text-danger font-weight-bold"></span>
							<span >${confPasswordErr}</span>
						</div>

						<div class="form-group">
							<label>Email Address</label>
							<input type="text" name="email" class="form-control" id="Email" autocomplete="off" onblur="emailValidate()" value="${empty requestScope.email ? user.email : email}">
							<span id="EmailError" class="text-danger font-weight-bold"></span>
							<span >${emailErr}</span>
						</div>

						<div class="form-group">
							<label>Contact No.</label>
							<input type="text" name="contact" class="form-control" id="Contact" autocomplete="off" onblur="conValidate()" value="${empty requestScope.contact ? user.contact : contact}">
							<span id="ContactError" class="text-danger font-weight-bold"></span>
							<span >${contactErr}</span>
						</div>

						<div class="form-group"> 
							<label>Gender</label>
							<div class="form-check">
								<input class="form-check-input" type="radio" name="gender" id="male" value="male" ${user.gender == 'male' ? 'checked' : '' }>
								<label class="form-check-label" >
									Male
								</label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="radio" name="gender" id="female" value="female" ${user.gender == 'female' ? 'checked' : '' }>
								<label class="form-check-label" >
									Female
								</label>
							</div>
						</div>

						<div class="form-group">
							<label>Select Permission</label><br>
							<input type="checkbox" name="permission" value="Read" ${fn:contains(user.permission,'Read') ? 'checked' : ''}>	Read
							<input type="checkbox" name="permission" value="Write" ${fn:contains(user.permission,'Write') ? 'checked' : ''}>Write
							<input type="checkbox" name="permission" value="Execute" ${fn:contains(user.permission,'Execute') ? 'checked' : ''}>Execute
						</div>

						<div class="form-group">
							<label>Select You Like</label><br>
							<select name="hobby" id="t">
							    <option value="Read" ${user.hobbies=='Read' ? 'selected' : ''}>Read</option>
							    <option value="Write" ${user.hobbies=='Write' ? 'selected' : ''}>Write</option>
							    <option value="Execute" ${user.hobbies=='Execute' ? 'selected' : ''}>Execute</option>
						    </select>
						</div>

					<!-- to manage address number -->
					<c:set var="count" value="1" scope="page" />
					<c:forEach items="${addressData}" var="address">
						<div class="form-group">
							<label>Address ${count}:</label>
							<c:choose>
							    <c:when test="${count=='1'}">
									<button style="float: right" class = "btn btn-sm btn-primary" id="addButton">Add Address</button>
							    </c:when>    
							    <c:otherwise>
							    	<button style="float: right" class = "btn btn-sm btn-danger" id="removeField">Remove Address</button>
							    </c:otherwise>
							</c:choose>
							<input type="text" name="home" class="form-control" id="house" autocomplete="off" placeholder="Address Line1" onblur="HomeValidate()" value="${empty requestScope.home ? address[1] : home}">
							<span id="HouseError" class="text-danger font-weight-bold"></span>
							<span>${address1Err}</span>
						</div>						

						<div class="form-group">
							<input type="text" name="leandmark" class="form-control" id="landmark" autocomplete="off" placeholder="Address Line2" onblur="StreetValidate()" value="${empty requestScope.leandmark ? address[2] : leandmark}">
							<span id="Landmark2Error" class="text-danger font-weight-bold"></span>
							<span >${address2Err}</span>
						</div>
						
						<div class="row">
							<div class="col-md-6">
								<input type="text" name="City" class="form-control" id="City" autocomplete="off" placeholder="City" onblur="CityValidate()" value="${empty requestScope.city ? address[3] : city}">
								<span id="CityError" class="text-danger font-weight-bold"></span>
								<span >${cityErr}</span>
							</div>
							<div class="col-md-6">
								<input type="text" name="State" class="form-control" id="State" autocomplete="off" placeholder="State" onblur="StateValidate()" value="${empty requestScope.state ? address[4] : state}">
								<span id="StateError" class="text-danger font-weight-bold"></span>
								<span >${stateErr}</span>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-md-6">
								<input type="text" name="Country" class="form-control" id="Country" autocomplete="off" placeholder="Country" onblur="CountryValidate()" value="${empty requestScope.country ? address[5] : country}">
								<span id="CountryError" class="text-danger font-weight-bold"></span>
								<span>${countryErr}</span>
							</div>
							<div class="col-md-6">
								<input type="text" name="ZipCode" class="form-control" id="ZipCode" autocomplete="off" placeholder="ZipCode" onblur="ZipCodeValidate()" value="${empty requestScope.zipCode ? address[6] : zipCode}">
								<span id="ZipCodeError" class="text-danger font-weight-bold"></span>
								<span >${zipCodeErr}</span>
							</div>
						</div>
						<input type="hidden" name="addressId" value="${address[0]}" />
						<br>
						<c:set var="count" value="${count + 1}" scope="page"/>
					</c:forEach>
						<div class="input_fields_wrap">
						
						</div>
						
						<br>	
						<input type="hidden" name="uid" value="${requestScope.userId}" />
						<input type="hidden" name="userRole" value="${requestScope.userRole}" />
			
						<span style="color:red" class="text-danger font-weight-bold">${errMassage}</span><br>
						<button type="submit" name="Register" value="<c:out value="${empty requestScope.operation ? 'Register' : operation}" />" class="btn btn-success" form="Form" id="btn-submit" onclick="return validation()">
							<c:out value="${empty requestScope.operation ? 'Register' : operation}" />
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- Form area ends-->

	<!-- Script -->
	<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="js/popper.min.js"></script>
	<script type="text/javascript" src="js/custom.js"></script>
	<!-- <script type="text/javascript" src="js/valid.js"></script> -->
	<script type="text/javascript" src="js/ajax.js"></script>
	<script type="text/javascript" src="js/appendAddress.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	
</body>
</html>