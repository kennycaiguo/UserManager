<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<!-- including header  -->
<%@ include file="header.jsp"%>


</head>
<body>



	<!-- Admin profile section starts -->
	<c:if test="${Login == 'admin'}">

		<!-- css -->
		<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css" >
		<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" >
		<!-- <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/responsive/2.2.3/css/responsive.bootstrap4.min.css" > -->

		<div class="container">
			<table id="example" class="table table-striped " style="width:100%;">
				<thead>
					<tr>
						<th>User ID</th>
						<th>First Name</th>
						<th>Last name</th>
						<th>Email</th>
						<th>Contact</th>
						<th>Profile</th>
						<th>Gender</th>
						<th>Permission</th>
						<th>Hobbies</th>
						<th>Address</th>
						<th>Manage User</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userList}" var="user">
						<tr>
							<td><c:out value="${user.userRId}" /></td>
							<td><c:out value="${user.firstName}" /></td>
							<td><c:out value="${user.lastName}" /></td>
							<td><c:out value="${user.email}" /></td>
							<td><c:out value="${user.contact}" /></td>
							<td><img src="data:image/gif;base64,${user.displayImage}" alt="profilePhoto" width="70px" height="70px" /></td>
							<td><c:out value="${user.gender}" /></td>
							<td><c:out value="${user.permission}" /></td>
							<td><c:out value="${user.hobbies}" /></td>
							<td>
								
								<!-- Button trigger modal -->
								<button type="button" id="displaybtn" class="btn btn-primary" value="${user.userRId}" data-toggle="modal" data-target="#exampleModalLong${user.userRId}">
								  Display
								</button>
								
								<!-- Modal -->
								<div class="modal fade" id="exampleModalLong${user.userRId}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
								  <div class="modal-dialog" role="document">
								    <div class="modal-content">
								      <div class="modal-header">
								        <h5 class="modal-title" id="exampleModalLongTitle">${user.firstName}'s Address List</h5>
								        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
								          <span aria-hidden="true">&times;</span>
								        </button>
								      </div>
								      <div class="modal-body">
								        <span id="password${user.userRId}">asa</span>
								      </div>
								      <div class="modal-footer">
								        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
								      </div>
								    </div>
								  </div>
								</div>
								
							</td> 
							<td>
								<button class = "btn btn-sm btn-success btn">
									<a href="RegisterController?role=admin&operaton=Update&id=<c:out value='${user.userRId}' />" style="color:white">Edit</a>
								</button> 
								| 
								<button id = "delbtn" value = '${user.userRId}' class = "btn btn-sm btn-danger btn"> Delete</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<!-- Script -->
		<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
		<!-- <script type="text/javascript" src="https://cdn.datatables.net/responsive/2.2.3/js/dataTables.responsive.min.js"></script> -->
		<!-- <script type="text/javascript" src="https://cdn.datatables.net/responsive/2.2.3/js/responsive.bootstrap4.min.js"></script> -->
		<script type="text/javascript" src="js/dataTable.js"></script>
		<script type="text/javascript" src="js/ajax.js"></script>

	</c:if>
	<!-- Admin profile section ends -->

	<!-- User profile section starts -->
	<c:if test="${Login == 'user' }">

		<!-- css -->
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="css/userprofile.css">
		<link rel="stylesheet" type="text/css" href="css/style.css">

		<!-- setting user data -->
		<c:set var="user" scope="request" value="${requestScope.userData}" />
		<c:set var="address" scope="request" value="${requestScope.addressData}" />

		<!-- User data display starts -->
		<div class="container emp-profile">
			<form method="post">
				<div class="row">
					<div class="col-md-4">
						<div class="profile-img">
							<img src="data:image/gif;base64,${user.displayImage}"
								alt="profilePhoto" />
						</div>
					</div>
					<div class="col-md-6">
						<div class="profile-head">
							<h5>
								<c:out value="${user.firstName}"></c:out>
							</h5>
							<br>
							<ul class="nav nav-tabs" id="myTab" role="tablist">
								<li class="nav-item"><a class="nav-link active"
									id="home-tab" data-toggle="tab" href="#home" role="tab"
									aria-controls="home" aria-selected="true">About</a></li>
							</ul>
						</div>
					</div>
					<div class="col-md-2">
						<button type="submit" class="profile-edit-btn" name="btnAddMore">
							<a href="RegisterController?operaton=Update&id=<c:out value='${user.userRId}' />">Edit Profile</a>
						</button>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<!-- Add something to show under the profile picture -->
						<span id="errorMassage" ></span>
					</div>
					<div class="col-md-8">
						<div class="tab-content profile-tab" id="myTabContent">
							<div class="tab-pane fade show active" id="home" role="tabpanel"
								aria-labelledby="home-tab">
								<div class="row">
									<div class="col-md-6">
										<label>First Name</label>
									</div>
									<div class="col-md-6">
										<p>
											<c:out value="${user.firstName}"></c:out>
										</p>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<label>Last Name</label>
									</div>
									<div class="col-md-6">
										<p>
											<c:out value="${user.lastName}"></c:out>
										</p>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<label>Email</label>
									</div>
									<div class="col-md-6">
										<p>
											<c:out value="${user.email}"></c:out>
										</p>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<label>Phone</label>
									</div>
									<div class="col-md-6">
										<p>
											<c:out value="${user.contact}"></c:out>
										</p>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<label>Gender</label>
									</div>
									<div class="col-md-6">
										<p>
											<c:out value="${user.gender}"></c:out>
										</p>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<label>Permission</label>
									</div>
									<div class="col-md-6">
										<p>
											<c:out value="${user.permission}"></c:out>
										</p>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<label>Hobby</label>
									</div>
									<div class="col-md-6">
										<p>
											<c:out value="${user.hobbies}"></c:out>
										</p>
									</div>
								</div>
								<div class="row">
									<!-- Button trigger modal -->
									<button style="float: right" type="button" class="btn btn-primary" data-toggle="modal" data-target="#newAddressModel">
									  Add New Address
									</button>
									
									<!-- Modal -->
									<div class="modal fade" id="newAddressModel" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
									  <div class="modal-dialog" role="document">
									    <div class="modal-content">
									      <div class="modal-header">
									        <h5 class="modal-title" id="exampleModalLabel">Add New Address</h5>
									        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
									          <span aria-hidden="true">&times;</span>
									        </button>
									      </div>
									      <div class="modal-body">

													<div class="container">
															<div class="form-group">
																<input type="text" name="home" class="form-control" id="house" autocomplete="off" placeholder="Address Line1" onblur="HomeValidate()">
																<span id="HouseError" class="text-danger font-weight-bold"></span>
															</div>
															<div class="form-group">
																<input type="text" name="leandmark" class="form-control" id="landmark" autocomplete="off" placeholder="Address Line2" onblur="StreetValidate()">
																<span id="Landmark2Error" class="text-danger font-weight-bold"></span>
															</div>
															<div class="row">
																<div class="col-md-6">
																	<input type="text" name="City" class="form-control" id="City" autocomplete="off" placeholder="City" onblur="CityValidate()">
																	<span id="CityError" class="text-danger font-weight-bold"></span>
																</div>
																<div class="col-md-6">
																	<input type="text" name="State" class="form-control" id="State" autocomplete="off" placeholder="State" onblur="StateValidate()">
																	<span id="StateError" class="text-danger font-weight-bold"></span>
																</div>
															</div>
															<br>
															<div class="row">
																<div class="col-md-6">
																	<input type="text" name="Country" class="form-control" id="Country" autocomplete="off" placeholder="Country" onblur="CountryValidate()">
																	<span id="CountryError" class="text-danger font-weight-bold"></span>
																</div>
																<div class="col-md-6">
																	<input type="text" name="ZipCode" class="form-control" id="ZipCode" autocomplete="off" placeholder="ZipCode" onblur="ZipCodeValidate()">
																	<span id="ZipCodeError" class="text-danger font-weight-bold"></span>
																</div>
															</div>
															
															<input type="hidden" name="userId" id="userId" value="${userId }"/>
													</div>

									      </div>
									      <div class="modal-footer">
									        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
									        <button type="button" class="btn btn-primary" id="addAddress" data-dismiss="modal" >Add </button>
									      </div>
									    </div>
									  </div>
									</div>
								</div>
								<!-- to manage address number -->
								<c:set var="count" value="1" scope="page" />
								<c:forEach items="${addressData}" var="addresslist">
									<div class="row">
										<div class="col-md-6">
											<label>Address ${count}:</label>
											<input type="hidden" name="addressId" value="${addresslist[0]}" />
										</div>
										<div class="col-md-6">
											<div class="row">
												<div class="col-md-6">
													<label>House</label>
												</div>
												<div class="col-md-6">
													<p>
														<c:out value="${addresslist[1] }"></c:out>
													</p>
												</div>
											</div>
											<div class="row">
												<div class="col-md-6">
													<label>Locality</label>
												</div>
												<div class="col-md-6">
													<p>
														<c:out value="${addresslist[2]}"></c:out>
													</p>
												</div>
											</div>
											<div class="row">
												<div class="col-md-6">
													<label>City</label>
												</div>
												<div class="col-md-6">
													<p>
														<c:out value="${addresslist[3] }"></c:out>
													</p>
												</div>
											</div>
											<div class="row">
												<div class="col-md-6">
													<label>State</label>
												</div>
												<div class="col-md-6">
													<p>
														<c:out value="${addresslist[4] }"></c:out>
													</p>
												</div>
											</div>
											<div class="row">
												<div class="col-md-6">
													<label>Country</label>
												</div>
												<div class="col-md-6">
													<p>
														<c:out value="${addresslist[5] }"></c:out>
													</p>
												</div>
											</div>
											<div class="row">
												<div class="col-md-6">
													<label>ZipCode</label>
												</div>
												<div class="col-md-6">
													<p>
														<c:out value="${addresslist[6]}"></c:out>
													</p>
												</div>
											</div>
											<div class="row">
												<div class="col-md-6">
													<button id = "removebtn" value = '${addresslist[0]}' class = "btn btn-danger"> Remove</button>
												</div>
												<div class="col-md-6">
													<%-- <button id = "updatebtn" value = '${addresslist[0]}' class = "btn btn-success" data-target="#newAddressModel"> Update</button> --%>
													
													<!-- Button trigger modal -->
													<button type="button" class="btn btn-success" data-toggle="modal" data-target="#exampleModalLong${addresslist[0]}">
													  Update
													</button>
													
													<!-- Modal -->
													<div class="modal fade" id="exampleModalLong${addresslist[0]}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
													  <div class="modal-dialog" role="document">
													    <div class="modal-content">
													      <div class="modal-header">
													        <h5 class="modal-title" id="exampleModalLongTitle">Update Address</h5>
													        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
													          <span aria-hidden="true">&times;</span>
													        </button>
													      </div>
													      <div class="modal-body">
																	<div class="container">
																		<div class="form-group">
																			<input type="text" name="home${addresslist[0]}" class="form-control" id="house" autocomplete="off" placeholder="Address Line1" onblur="HomeValidate()" value="${addresslist[1]}">
																				<span id="HouseError" class="text-danger font-weight-bold"></span>
																		</div>
																		<div class="form-group">
																			<input type="text" name="leandmark${addresslist[0]}" class="form-control" id="landmark" autocomplete="off" placeholder="Address Line2" onblur="StreetValidate()" value="${addresslist[2]}">
																			<span id="Landmark2Error" class="text-danger font-weight-bold"></span>
																		</div>
																		<div class="row">
																			<div class="col-md-6">
																				<input type="text" name="City${addresslist[0]}" class="form-control" id="City" autocomplete="off" placeholder="City" onblur="CityValidate()" value="${addresslist[3] }">
																				<span id="CityError" class="text-danger font-weight-bold"></span>
																			</div>
																			<div class="col-md-6">
																				<input type="text" name="State${addresslist[0]}" class="form-control" id="State" autocomplete="off" placeholder="State" onblur="StateValidate()" value="${addresslist[4] }">
																				<span id="StateError" class="text-danger font-weight-bold"></span>
																			</div>
																		</div>
																		<br>
																		<div class="row">
																			<div class="col-md-6">
																				<input type="text" name="Country${addresslist[0]}" class="form-control" id="Country" autocomplete="off" placeholder="Country" onblur="CountryValidate()" value="${addresslist[5] }"> 
																					<span id="CountryError" class="text-danger font-weight-bold"></span>
																			</div>
																			<div class="col-md-6">
																				<input type="text" name="ZipCode${addresslist[0]}" class="form-control" id="ZipCode" autocomplete="off" placeholder="ZipCode" onblur="ZipCodeValidate()" value="${addresslist[6] }"> 
																					<span id="ZipCodeError" class="text-danger font-weight-bold"></span>
																			</div>
																			<input type="hidden" name="addressId" id="addressId" value="${addresslist[0]}" />
																		</div>
																	</div>
																</div>
													      <div class="modal-footer">
													        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
													        <button type="button" class="btn btn-primary" id = "updatebtn" value = '${addresslist[0]}' data-dismiss="modal">Update</button>
													      </div>
													    </div>
													  </div>
													</div>
												
												</div>
											</div>
										</div>
									</div>
									<hr>
									<c:set var="count" value="${count + 1}" scope="page"/>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>

		<!-- script -->
		<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
		<script type="text/javascript" src="js/popper.min.js"></script>
		<script type="text/javascript" src="js/ajax.js"></script>
		<script type="text/javascript" src="js/valid.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		

	</c:if>
	<!-- User profile section ends -->

	<!-- including footer -->
	<%@ include file="footer.jsp"%>

</body>
</html>