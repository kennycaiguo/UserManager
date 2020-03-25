$(document).ready(function() {

	//Delete user from admin
	$("[id^=del]").click(function() {
		
		//get button value
		var data = $(this).val();
		
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

		//getting button value
		var id = $(this).val();
		
		$.ajax({
			type : "POST",
			url : "RegisterController",
			data : {
				operation : 'deleteAddress',
				addressId : id,
				userId : $("#userId"+id).val()
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

		//getting addressId
		var id = $(this).val();
		
		$.ajax({
			type : "POST",
			url : "RegisterController",
			data : {
				operation : 'updateAddress',
				userId : $('[name="userId'+id+'"]').val(),
				addressId : id,
				home : $('[name="home'+id+'"]').val(),
				leandmark : $('[name="leandmark'+id+'"]').val(),
				City : $('[name="City'+id+'"]').val(),
				State : $('[name="State'+id+'"]').val(),
				Country : $('[name="Country'+id+'"]').val(),
				ZipCode : $('[name="ZipCode'+id+'"]').val()
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
	
	//add new address
	$("[id^=addAddress]").click(function() {

		//getting button value
		var id = $(this).val();
		
		$.ajax({
			type : "POST",
			url : "RegisterController",
			data : {
				
				operation : 'newAddress',
				home : $("#house"+id).val(),
				leandmark : $("#landmark"+id).val(),
				City : $("#City"+id).val(),
				State : $("#State"+id).val(),
				Country : $("#Country"+id).val(),
				ZipCode : $("#ZipCode"+id).val(),
				userId : id
				
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
		
		//getting button value
		var id = $(this).val();

		$.ajax({
			type : "POST",
			url : "RegisterController",
			data : {
				operation : 'deleteAddress',
				addressId : id,
				userId : $("#userId"+id).val()
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
		
		//getting button value
		var id = $(this).val();
		
		$.ajax({
			type : "POST",
			url : "RegisterController",
			data : {
				operation : 'fatchAllAddresses',
				userId : id
			},
			success : function(data) {
				console.log(data);
				//Fields wrapper
				var wrapper  = $(".input_fields_wrap"); 
				
				//appendin user addresses
				$.each(data.addressList, function(index,data) {
					
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
										'<input type="hidden" id="userId'+data.AddressId+'" value="'+id+'" />'+
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