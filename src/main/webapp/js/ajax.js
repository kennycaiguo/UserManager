$(document).ready(function() {

	//Delete user from admin
	$("[id^=del]").click(function() {
		var data = $(this).val();
		alert(data);
		
		//removing the row fromthe datatable
		var a = $('#example6').DataTable();
		a.row($(this).closest("tr")).remove();
		$(this).closest("tr").remove();
		
		$.ajax({
			type : "POST",
			url : "RegisterController",
			data : {
				operation : 'removeUser',
				userId : $(this).val()
			},
			success : function(data) {
				var a = $('#example6').DataTable();
				a.draw();
			},
			error : function(data) {
				alert("error");
			}
		});
	});
	
	//Delete User address
	$("[id^=remove]").click(function() {
		alert("inside delete");
		var x = $(this).val();
		$.ajax({
			type : "POST",
			url : "RegisterController",
			data : {
				operation : 'deleteAddress',
				addressId : x,
				userId : $("#userId"+x).val()
			},
			success : function(data) {
				alert(data);
				location.reload();
			},
			error : function(data) {
				alert("Something went wrong Please try again");
			}
		});
		return false;
	});
	
	
	//Update address
	$("[id^=update]").click(function() {
		alert("inside update");

		//getting addressId
		var x = $(this).val();
		
		$.ajax({
			type : "POST",
			url : "RegisterController",
			data : {
				operation : 'updateAddress',
				userId : $('[name="userId'+x+'"]').val(),
				addressId : x,
				home : $('[name="home'+x+'"]').val(),
				leandmark : $('[name="leandmark'+x+'"]').val(),
				City : $('[name="City'+x+'"]').val(),
				State : $('[name="State'+x+'"]').val(),
				Country : $('[name="Country'+x+'"]').val(),
				ZipCode : $('[name="ZipCode'+x+'"]').val()
			},
			success : function(data) {
				alert("Address updated");
				$("#errorMassage").text(data);
				location.reload();
			},
			error : function(data) {
				alert("Something went wrong Please try again");
			}
		});
		return false;
	});
	
	//add new address
	$("[id^=addAddress]").click(function() {
		alert("addnewAddress");
		//getting userId
		var x = $(this).val();
		
		alert(x);
		
		$.ajax({
			type : "POST",
			url : "RegisterController",
			data : {
				
				operation : 'newAddress',
				home : $("#house"+x).val(),
				leandmark : $("#landmark"+x).val(),
				City : $("#City"+x).val(),
				State : $("#State"+x).val(),
				Country : $("#Country"+x).val(),
				ZipCode : $("#ZipCode"+x).val(),
				userId : x
				
			},
			success : function(data) {
				alert(data);
				window.location.reload();
			},
			error : function(data) {
				alert("Something went wrong Please try again");
			}
		});
		
	});
	
	//Frogot Password
	$("#forgotPassword").click(function() {
		
		$.ajax({
			type : "POST",
			url : "RegisterController",
			data : {
				operation : 'forgotPassword',
				userEmail : $("#userEmail").val()
			},
			success : function(data) {
				$('#password').text(data);
			},
			error : function(data) {
				$('#password').text("Some Thing Went Wrong Please Try Again...!!");
			}
		});
		return false;
	});	
	
	//remove address from the admin side
	$(".input_fields_wrap").on('click', '#removebtn' ,function(){
		
		var x = $(this).val();

		$.ajax({
			type : "POST",
			url : "RegisterController",
			data : {
				operation : 'deleteAddress',
				addressId : x,
				userId : $("#userId"+x).val()
			},
			success : function(data) {
				alert(data);
				location.reload();
			},
			error : function(data) {
				alert("Something went wrong Please try again");
			}
		});
	})
	
	//Get All address of user
	$("[id^=display]").click(function() {
		
		var x = $(this).val();
		
		$.ajax({
			type : "POST",
			url : "RegisterController",
			data : {
				operation : 'fatchAllAddresses',
				userId : $(this).val()
			},
			success : function(data) {
				console.log(data);
				//Fields wrapper
				var wrapper  = $(".input_fields_wrap"); 
				
				//appendin user addresses
				$.each(data.addressList, function(index,data) {
					
					/*$(wrapper).append('<div class="container"><div class="form-group"><input type="text" name="home'+data.AddressId+'" class="form-control"id="house" autocomplete="off"onblur="HomeValidate()" value="'+data.home+'"><span id="HouseError" class="text-danger font-weight-bold"></span></div><div class="form-group"><input type="text" name="leandmark'+data.AddressId+'"class="form-control" id="landmark" autocomplete="off"onblur="StreetValidate()"value="'+data.landmark+'"><span id="Landmark2Error" class="text-danger font-weight-bold"></span></div><div class="row"><div class="col-md-6"><input type="text" name="City'+data.AddressId+'" class="form-control"id="City" autocomplete="off"onblur="CityValidate()" value="'+data.city+'"><span id="CityError" class="text-danger font-weight-bold"></span></div><div class="col-md-6"><input type="text" name="State'+data.AddressId+'" class="form-control"id="State" autocomplete="off"onblur="StateValidate()" value="'+data.state+'"><span id="StateError" class="text-danger font-weight-bold"></span></div></div><br><div class="row"><div class="col-md-6"><input type="text" name="Country'+data.AddressId+'"class="form-control" id="Country" autocomplete="off"onblur="CountryValidate()"value="'+data.country+'"><span id="CountryError" class="text-danger font-weight-bold"></span></div><div class="col-md-6"><input type="text" name="ZipCode'+data.AddressId+'"class="form-control" id="ZipCode" autocomplete="off"onblur="ZipCodeValidate()"value="'+data.zipcode+'"><span id="ZipCodeError" class="text-danger font-weight-bold"></span></div><br><div class="row"><div class="col-md-6"><button id="removebtn" value='+data.AddressId+' class="btn btn-danger">Remove</button></div><div class="col-md-6"><button type="button" class="btn btn-success" id = "updatebtn" value = '+data.AddressId+' data-dismiss="modal">Update</button></div></div><br></div></div>');*/
					/*$(wrapper).append('<div class="row"><div class="col-md-6"><button id="removebtn" value='+data.AddressId+' class="btn btn-danger">Remove</button></div><div class="col-md-6"><button type="button" class="btn btn-success" id = "updatebtn" value = '+data.AddressId+' data-dismiss="modal">Update</button></div></div>');*/
					
					$(wrapper).append(
							
							'<div class="row">'+
							'<div class="col-md-4">'+
								'<label>Address '+(index+1)+'</label>'+ 
							'</div>'+
							'<div class="col-md-8">'+
								'<div class="row">'+
									'<div class="col-md-4">'+
										'<label>House</label>'+
									'</div>'+
									'<div class="col-md-8">'+
										'<p>'+data.home+'</p>'+
									'</div>'+
								'</div>'+
								'<div class="row">'+
									'<div class="col-md-4">'+
										'<label>Locality</label>'+
									'</div>'+
									'<div class="col-md-8">'+
										'<p>'+data.landmark+'</p>'+
									'</div>'+
								'</div>'+
								'<div class="row">'+
									'<div class="col-md-4">'+
										'<label>City</label>'+
									'</div>'+
									'<div class="col-md-8">'+
										'<p>'+data.city+'</p>'+
									'</div>'+
								'</div>'+
								'<div class="row">'+
									'<div class="col-md-4">'+
										'<label>State</label>'+
									'</div>'+
									'<div class="col-md-8">'+
										'<p>'+data.state+'</p>'+
									'</div>'+
								'</div>'+
								'<div class="row">'+
									'<div class="col-md-4">'+
										'<label>Country</label>'+
									'</div>'+
									'<div class="col-md-8">'+
										'<p>'+data.country+'</p>'+
									'</div>'+
								'</div>'+
								'<div class="row">'+
									'<div class="col-md-4">'+
										'<label>ZipCode</label>'+
									'</div>'+
									'<div class="col-md-8">'+
										'<p>'+data.zipcode+'</p>'+
									'</div>'+
								'</div>'+
								'<div class="row">'+
									'<div class="col-md-4">'+
										'<input type="hidden" id="userId'+data.AddressId+'" value="'+x+'" />'+
										'<button id = "removebtn" value = '+data.AddressId+' class = "btn btn-danger" data-dismiss="modal" onclick="removeAddress()"> Remove</button>'+
									'</div>'+
								'</div>'+
								'<hr>'+
							'</div>'
					)
				});
			},
			error : function(data) {
				$('#password').text("Some Thing Went Wrong Please Try Again...!!");
			}
		});
	});
	
	//clear modelpopup 
	$('[id^=userAddressList]').on('hidden.bs.modal', function () {
	    $(".input_fields_wrap").empty();
	});
	
	return false;
	
});