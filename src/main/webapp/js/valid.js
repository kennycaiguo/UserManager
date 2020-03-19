function validation() {
	
	var fname = document.getElementById('firstName').value;
	var lname = document.getElementById('lastName').value;
	var password = document.getElementById('password').value;
	var cpassword = document.getElementById('confirmPassword').value;
	var email = document.getElementById('Email').value;
	var contact = document.getElementById('Contact').value;
	var house = document.getElementById('house').value;
	var landmark = document.getElementById('landmark').value;
	var City = document.getElementById('City').value;
	var State = document.getElementById('State').value;
	var Country = document.getElementById('Country').value;
	var ZipCode = document.getElementById('ZipCode').value;

	
	if (fname == "") 
	{
		document.getElementById('FnameError').innerHTML = "* Required Field!!!";
		return false;
	}
	if (fname != "") 
	{
		document.getElementById('FnameError').innerHTML = "";
	}
	if (lname == "") 
	{
		document.getElementById('LnameError').innerHTML = "* Required Field!!!";
		return false;
	}
	if (lname != "") 
	{
		document.getElementById('LnameError').innerHTML = "";
	}
	if (password == "") 
	{
		document.getElementById('PasswordError').innerHTML = "* Required Field!!!";
		return false;
	}
	if (password != "") 
	{
		document.getElementById('PasswordError').innerHTML = "";
	}
	if (cpassword == "") 
	{
		document.getElementById('CpasswordError').innerHTML = "* Required Field!!!";
		return false;
	}
	if (cpassword != "") 
	{
		document.getElementById('CpasswordError').innerHTML = "";
	}
	if (email == "") 
	{
		document.getElementById('EmailError').innerHTML = "* Required Field!!!";
		return false;
	}
	if (email != "") 
	{
		document.getElementById('EmailError').innerHTML = "";
	}
	if (contact == "") 
	{
		document.getElementById('ContactError').innerHTML = "* Required Field!!!";
		return false;
	}
	if (contact != "") 
	{
		document.getElementById('ContactError').innerHTML = "";
	}
	if (house == "") 
	{
		document.getElementById('HouseError').innerHTML = "* Required Field!!!";
		return false;
	}
	if (house != "") 
	{
		document.getElementById('HouseError').innerHTML = "";
	}
	if (landmark == "") 
	{
		document.getElementById('Landmark2Error').innerHTML = "* Required Field!!!";
		return false;
	}
	if (landmark != "") 
	{
		document.getElementById('Landmark2Error').innerHTML = "";
	}
	if (City == "") 
	{
		document.getElementById('CityError').innerHTML = "* Required Field!!!";
		return false;
	}
	if (City != "") 
	{
		document.getElementById('CityError').innerHTML = "";
	}
	if (State == "") 
	{
		document.getElementById('StateError').innerHTML = "* Required Field!!!";
		return false;
	}
	if (State != "") 
	{
		document.getElementById('StateError').innerHTML = "";
	}
	if (Country == "") 
	{
		document.getElementById('CountryError').innerHTML = "* Required Field!!!";
		return false;
	}
	if (Country != "") 
	{
		document.getElementById('CountryError').innerHTML = "";
	}
	if (State == "") 
	{
		document.getElementById('StateError').innerHTML = "* Required Field!!!";
		return false;
	}
	if (State != "") 
	{
		document.getElementById('StateError').innerHTML = "";
	}
	if (ZipCode == "") 
	{
		document.getElementById('ZipCodeError').innerHTML = "* Required Field!!!";
		return false;
	}
	if (ZipCode != "") 
	{
		document.getElementById('ZipCodeError').innerHTML = "";
	}
}

function FnameValidate() {
	var fname = document.getElementById('firstName').value;

	var v = fname.trim();

	var number = false;
	var specialcaseLetter = false;

	for (var i = 0; i < v.length; i++) 
    	{
      var charCode = v.charCodeAt(i);

      if(charCode > 47 && charCode < 58)
        number = true;

      if((charCode > 32 && charCode < 48) || (charCode > 57 && charCode < 65) || (charCode > 90 && charCode < 97) || (charCode > 122 && charCode <= 126) || charCode == 64)
        specialcaseLetter   = true;
	}

	if (v == "") {
		document.getElementById('FnameError').innerHTML = "* Required Field !!!";
		return false;
	}
	if ((v.length <= 2) || (v.length > 20)) {
		document.getElementById('FnameError').innerHTML = "* Length should be 2 to 20 character !!!";
		return false;
	}
	if(v.split(' ').length > 1)
	{
		document.getElementById('FnameError').innerHTML="* Invalid : Space between name";
		return false;
	}
	if (number) {
		document.getElementById('FnameError').innerHTML="* Number Not Allowed..!!!";
		return false;
	}
	if (specialcaseLetter) {
		document.getElementById('FnameError').innerHTML="* Character input only..!!!";
		return false;
	}
	else
	{
		document.getElementById('FnameError').innerHTML = "";
		return false;
	}
}

function LnameValidate() {
	var name = document.getElementById('lastName').value;

	var v = name.trim();

	var number = false;
	var specialcaseLetter = false;

	for (var i = 0; i < v.length; i++) 
    	{
      var charCode = v.charCodeAt(i);

      if(charCode > 47 && charCode < 58)
        number = true;

      if((charCode > 32 && charCode < 48) || (charCode > 57 && charCode < 65) || (charCode > 90 && charCode < 97) || (charCode > 122 && charCode <= 126) || charCode == 64)
        specialcaseLetter   = true;
	}

	if (v == "") {
		document.getElementById('LnameError').innerHTML = "* Required Field !!!";
		 return false;
	}
	if ((v.length <= 2) || (v.length > 20)) {
		document.getElementById('LnameError').innerHTML = "* Length should be 2 to 20 character !!!";
		return false;
	}
	if(v.split(' ').length > 1)
	{
		document.getElementById('LnameError').innerHTML="* Invalid : Space between name";
		return false;
	}
	if (number) 
	{
		document.getElementById('LnameError').innerHTML="* Number Not Allowed..!!!";
		return false;
	}
	if (specialcaseLetter) 
	{
		document.getElementById('LnameError').innerHTML="* Character input only..!!!";
		return false;
	}
	else
	{
		document.getElementById('LnameError').innerHTML = "";
		return false;
	}
}

function pwdValidate() {
	var name = document.getElementById('password').value;

	var v = name.trim();

	var capital = true;
	var small = true;
	var number = true;
	var specialcaseLetter = true;

    for (var i = 0; i < v.length; i++) 
    {
      var charCode = v.charCodeAt(i);

      if(charCode > 47 && charCode < 58)
        number = false;

      if(charCode > 64 && charCode < 91)
        capital = false;

      if(charCode > 96 && charCode < 123)
        small = false;

      if((charCode > 32 && charCode < 48) || (charCode > 57 && charCode < 65) || (charCode > 90 && charCode < 97) || (charCode > 122 && charCode <= 126) || charCode == 64)
        specialcaseLetter   = false;
	}
	if(v =="")
	{
		document.getElementById("PasswordError").innerHTML="* Required Field !!!";
		return false;
	}
	else if((v.length <8) || (v.length >= 12))
	{
		document.getElementById('PasswordError').innerHTML="**Please enter the password between 8 to 12";
		return false;
	}
	else if(capital){
		document.getElementById('PasswordError').innerHTML="**Please At least 1 capital ";
		return false;
	}
	else if(small){
		document.getElementById('PasswordError').innerHTML="**Please At least 1 smallcap";
		return false;
	}
	else if(number){
		document.getElementById('PasswordError').innerHTML="**Please At least 1 numerical";
		return false;
	}
	else if(specialcaseLetter){
		document.getElementById('PasswordError').innerHTML="**Please At least 1 specialcaseLetter";
		return false;
	}
	else
	{
		document.getElementById('PasswordError').innerHTML = "";
		return false;
	}
}

function cpwdValidate() {
	var name1 = document.getElementById('password').value;
	var name2 = document.getElementById('confirmPassword').value;

	var v1 = name1.trim();
	var v2 = name2.trim();

	if (v2 == "") {
		document.getElementById('CpasswordError').innerHTML = "* Required Field !!!";
		 return false;
	}
	if (v1 != v2) {
		document.getElementById('CpasswordError').innerHTML = "* Password doesn't Match...!!!";
	}
	else
	{
		document.getElementById('CpasswordError').innerHTML = "";
		return false;
	}
}

function emailValidate() {
	var name = document.getElementById('Email').value;

	var v = name.trim();

	var number = false;
	var specialcaseLetter = false;

	for (var i = 0; i < v.length; i++) 
    	{
      var charCode = v.charCodeAt(i);

      if(charCode > 47 && charCode < 58)
        number = true;
      
      if((charCode > 32 && charCode < 46) || (charCode > 57 && charCode < 64) || (charCode > 90 && charCode < 97) || (charCode > 122 && charCode <= 126) || charCode == 47)
        specialcaseLetter   = true;
	}
	
	if(v =="")
	{
		document.getElementById('EmailError').innerHTML="* Required Field !!!";
		return false;
	}
	var res = v.split('@');

	if(v.split('@').length != 2)
	{
		document.getElementById('EmailError').innerHTML="**Please enter the valid number of @..!!!";
		return false;
	}

	var part1=res[0];
	var part2=res[1];

	 if(part1.length < 3)
	{
		document.getElementById('EmailError').innerHTML="* Three character before the '@' required...!!!";
		return false;
	}
	 if(part1.split(' ').length>1)
	{
		document.getElementById('EmailError').innerHTML="* Invalid : Space before @";
		return false;
	}

	var dotsplt=part2.split(".");  //alert(“After @ :”+part2);

	 if(part2.split('.').length<2)
	{
		document.getElementById('EmailError').innerHTML="* '.' Missing..!!!";
		return false;
	}
	 if(dotsplt[0].length < 3 )
	{
		console.log('demo',v);
		document.getElementById('EmailError').innerHTML="* Three character before the '.' required...!!!";
		return false;
	}
	 if(dotsplt[0].split(' ').length>1)
	{
		document.getElementById('EmailError').innerHTML="* Invalid : Space before '.'...!!!!";
		return false;
	}
	 if(dotsplt[1].length<2 ||dotsplt[1].length>3)
	{
		document.getElementById('EmailError').innerHTML="* character aftr '.' must be in between 2 to 3 ...!!!";
		return false;
	}
	if(dotsplt[1].split('specialcaseLetter')>1)
	{
		document.getElementById('EmailError').innerHTML="* Number aftr '.' Not Allowed ...!!!";
		return false;
	}
	if (specialcaseLetter) 
	{
		document.getElementById('EmailError').innerHTML="* Special Character Not Allowed...!!!";
		return false;
	}
	if (true)
	{
		document.getElementById('EmailError').innerHTML="";
		return false;
	}
}

function conValidate() {

	var name = document.getElementById('Contact').value;

	var v = name.trim();

	if(v =="")
	{
		document.getElementById('ContactError').innerHTML="* Required Field !!!";
		return false;
	}
	else if(v.split(' ').length > 1)
	{
		document.getElementById('ContactError').innerHTML="* Invalid : Space between Number...!!!";
		return false;
	}
	else if ((v.length < 10) ) {
		document.getElementById('ContactError').innerHTML = "* Length must be 10 digits only....!!!";
		return false;
	}
	else if ((v.length > 10)) {
		document.getElementById('ContactError').innerHTML = "* Length should be 10 digits only....!!!";
		return false;
	}
	else if(isNaN(v))
	{
		document.getElementById('ContactError').innerHTML="**Please enter the number only";
		return false;
	}
	else
	{
		document.getElementById('ContactError').innerHTML="";
		return false;
	}
}

function HomeValidate() {
	var name = document.getElementById('house').value;

	var v = name.trim();

	if (v == "") {
		document.getElementById('HouseError').innerHTML = "* Required Field !!!";
	}
	else if ((v.length <= 5) || (v.length > 30)) {
		document.getElementById('HouseError').innerHTML = "* Length should be 5 to 30 character !!!";
		return false;
	}
	else
	{
		document.getElementById('HouseError').innerHTML = "";
		return false;
	}
	
}

function StreetValidate() {
	var name = document.getElementById('landmark').value;

	var v = name.trim();

	if (v == "") {
		document.getElementById('Landmark2Error').innerHTML = "* Required Field !!!";
	}
	else if ((v.length <= 5) || (v.length > 30)) {
		document.getElementById('Landmark2Error').innerHTML = "* Length should be 5 to 30 character !!!";
		return false;
	}
	else
	{
		document.getElementById('Landmark2Error').innerHTML = "";
		return false;
	}
}

function CityValidate() {
	var fname = document.getElementById('City').value;

	var v = fname.trim();

	var number = false;
	var specialcaseLetter = false;

	for (var i = 0; i < v.length; i++) 
    	{
      var charCode = v.charCodeAt(i);

      if(charCode > 47 && charCode < 58)
        number = true;

      if((charCode > 32 && charCode < 48) || (charCode > 57 && charCode < 65) || (charCode > 90 && charCode < 97) || (charCode > 122 && charCode <= 126) || charCode == 64)
        specialcaseLetter   = true;
	}

	if(v =="")
	{
		document.getElementById('CityError').innerHTML="* Required Field !!!";
		return false;
	}
	if ((v.length < 5) || (v.length >= 10)) {
		document.getElementById('CityError').innerHTML = "* Length should be 5 to 10 character !!!";
		return false;
	}
	if(v.split(' ').length > 1)
	{
		document.getElementById('CityError').innerHTML="* Invalid : Space between name";
		return false;
	}
	if (number) {
		document.getElementById('CityError').innerHTML="* Number Not Allowed..!!!";
		return false;
	}
	if (specialcaseLetter) {
		document.getElementById('CityError').innerHTML="* Character input only..!!!";
		return false;
	}
	else
	{
		document.getElementById('CityError').innerHTML = "";
		return false;
	}
}

function StateValidate() {
	var fname = document.getElementById('State').value;

	var v = fname.trim();

	var number = false;
	var specialcaseLetter = false;

	for (var i = 0; i < v.length; i++) 
    	{
      var charCode = v.charCodeAt(i);

      if(charCode > 47 && charCode < 58)
        number = true;

      if((charCode > 32 && charCode < 48) || (charCode > 57 && charCode < 65) || (charCode > 90 && charCode < 97) || (charCode > 122 && charCode <= 126) || charCode == 64)
        specialcaseLetter   = true;
	}

	if(v =="")
	{
		document.getElementById('StateError').innerHTML="* Required Field !!!";
		return false;
	}
	if ((v.length < 5) || (v.length >= 10)) {
		document.getElementById('StateError').innerHTML = "* Length should be 5 to 10 character !!!";
		return false;
	}
	if(v.split(' ').length > 1)
	{
		document.getElementById('StateError').innerHTML="* Invalid : Space between name";
		return false;
	}
	if (number) {
		document.getElementById('StateError').innerHTML="* Number Not Allowed..!!!";
		return false;
	}
	if (specialcaseLetter) {
		document.getElementById('StateError').innerHTML="* Character input only..!!!";
		return false;
	}
	else
	{
		document.getElementById('StateError').innerHTML = "";
		return false;
	}
}

function CountryValidate() {
	var fname = document.getElementById('Country').value;

	var v = fname.trim();

	var number = false;
	var specialcaseLetter = false;

	for (var i = 0; i < v.length; i++) 
    	{
      var charCode = v.charCodeAt(i);

      if(charCode > 47 && charCode < 58)
        number = true;

      if((charCode > 32 && charCode < 48) || (charCode > 57 && charCode < 65) || (charCode > 90 && charCode < 97) || (charCode > 122 && charCode <= 126) || charCode == 64)
        specialcaseLetter   = true;
	}

	if(v =="")
	{
		document.getElementById('CountryError').innerHTML="* Required Field !!!";
		return false;
	}
	if ((v.length < 4) || (v.length >= 10)) {
		document.getElementById('CountryError').innerHTML = "* Length should be 4 to 10 character !!!";
		return false;
	}
	if(v.split(' ').length > 1)
	{
		document.getElementById('CountryError').innerHTML="* Invalid : Space between name";
		return false;
	}
	if (number) {
		document.getElementById('CountryError').innerHTML="* Number Not Allowed..!!!";
		return false;
	}
	if (specialcaseLetter) {
		document.getElementById('CountryError').innerHTML="* Character input only..!!!";
		return false;
	}
	else
	{
		document.getElementById('CountryError').innerHTML = "";
		return false;
	}
}

function ZipCodeValidate() {

	var name = document.getElementById('ZipCode').value;

	var v = name.trim();

	if(v =="")
	{
		document.getElementById('ZipCodeError').innerHTML="* Required Field !!!";
		return false;
	}
	else if(v.split(' ').length > 1)
	{
		document.getElementById('ZipCodeError').innerHTML="* Invalid : Space between Number...!!!";
		return false;
	}
	else if ((v.length <= 5) || (v.length > 10)) {
		document.getElementById('ZipCodeError').innerHTML = "* Length should be 5 to 10 digits only....!!!";
		return false;
	}
	else if(isNaN(v))
	{
		document.getElementById('ZipCodeError').innerHTML="**Please enter the number only";
		return false;
	}
	else
	{
		document.getElementById('ZipCodeError').innerHTML="";
		return false;
	}
}
