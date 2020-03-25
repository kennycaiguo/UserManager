$(document).ready(function() {
	var max_fields      = 100; //maximum input boxes allowed
	var wrapper   		= $(".input_fields_wrap"); //Fields wrapper
	
	var x = 1; //initlal text box count
	$("#addButton").click(function(e){ //on add input button click
		e.preventDefault();
		if(x < max_fields){ //max input box allowed
			x++; //text box increment
			//add input box
			$(wrapper).append('<div><br><label>Address'+ x +'</label><button style="float: right" class = "btn btn-sm btn-danger" id="removeField">Remove Address</button><div class="form-group"><input type="text" name="home" class="form-control" id="house'+ x +'" autocomplete="off" placeholder="Address Line1"><span id="HouseError" class="text-danger font-weight-bold"></span></div><div class="form-group"><input type="text" name="leandmark" class="form-control" id="landmark'+ x +'" autocomplete="off" placeholder="Address Line2"><span id="Landmark2Error" class="text-danger font-weight-bold"></span></div><div class="row"><div class="col-md-6"><input type="text" name="City" class="form-control" id="City'+ x +'" autocomplete="off" placeholder="City" ><span id="CityError" class="text-danger font-weight-bold"></span></div><div class="col-md-6"><input type="text" name="State" class="form-control" id="State'+ x +'" autocomplete="off" placeholder="State"><span id="StateError" class="text-danger font-weight-bold"></span></div></div><br><div class="row"><div class="col-md-6"><input type="text" name="Country" class="form-control" id="Country'+ x +'" autocomplete="off" placeholder="Country" ><span id="CountryError" class="text-danger font-weight-bold"></span></div><div class="col-md-6"><input type="text" name="ZipCode" class="form-control" id="ZipCode'+ x +'" autocomplete="off" placeholder="ZipCode"  ><span id="ZipCodeError" class="text-danger font-weight-bold"></span></div>	</div></div>');
		}
	});
	
	$(wrapper).on("click","#removeField", function(e){ //user click on remove text
		e.preventDefault(); 
		$(this).parent('div').remove(); 
		x--;
	})
});