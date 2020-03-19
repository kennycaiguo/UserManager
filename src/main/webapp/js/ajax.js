$(document).ready(function() {

	//Delete user from admin
	$("[id^=del]").click(function() {
		var data = $(this).val();
		var a = $('#example6').DataTable();
		a.row($(this).closest("tr")).remove();
		$(this).closest("tr").remove();
		$.ajax({
			type : "GET",
			url : "RegisterController",
			data : {
				operaton : $(this).val()
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
	
	//Delete address
	$("[id^=remove]").click(function() {
		alert("inside delete");
		$.ajax({
			type : "POST",
			url : "RegisterController",
			data : {
				operation : 'deleteAddress',
				addressId : $(this).val()
			},
			success : function(data) {
				alert("Address deleted");
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
		//getting addressId
		var x = $(this).val();

		$.ajax({
			type : "POST",
			url : "RegisterController",
			data : {
				operation : 'updateAddress',
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
	$("#addAddress").click(function() {
		
		$.ajax({
			type : "POST",
			url : "RegisterController",
			data : {
				
				operation : 'newAddress',
				home : $("#house").val(),
				leandmark : $("#landmark").val(),
				City : $("#City").val(),
				State : $("#State").val(),
				Country : $("#Country").val(),
				ZipCode : $("#ZipCode").val(),
				userId : $("#userId").val()
				
			},
			success : function(data) {
				alert("Address added");
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
			url : "LogoutController",
			data : {
				userEmail : $("#userEmail").val()
			},
			success : function(data) {
				$('#password').text(data);
			},
			error : function(data) {
				$('#password').text("Some Thing Went Wrong Please Try Again...!!");
			}
		});
	});	
	
	//Get All address of user
	$("[id^=display]").click(function() {
		alert("inside display address");
		$.ajax({
			type : "POST",
			url : "RegisterController",
			data : {
				operation : 'fatchAllAddresses',
				userId : $(this).val()
			},
			success : function(data) {
				$('[id^=password]').text(data.addressList);
				console.log(data.addressList[0].country);
			},
			error : function(data) {
				$('#password').text("Some Thing Went Wrong Please Try Again...!!");
			}
		});
	});
	
	
});