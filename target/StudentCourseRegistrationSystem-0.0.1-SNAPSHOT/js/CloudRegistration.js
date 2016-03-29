function test(){
	alert("Hello");
	var first=$("#fname").val();
	var email=$("#email").val();
	var usertype=$('#usertype').find('option:selected').text();

	
	var username=$("#username").val();
	var password=$("#pass1").val();
	
	var last=$("#lname").val();
	var gender=$('input[name=Gender]:checked').val();
	
	var phoneno=$("#phone").val();
var testJson = {

		user_type:usertype,
		 email_id:email,
		 user_name:username,
		 password:password,
		 first_name:first,
		 last_name:last,
		gender:gender,
		phone_number:phoneno
				
	};
	
	var str=JSON.stringify(testJson);
	
	
	
	alert(str);
	$.ajax ({  
			type: "POST",
			url: "http://localhost:9080/StudentCourseRegistrationSystem/rest/cloudrest/adduser", 
			data: JSON.stringify(testJson),
			dataType:"text",
			contentType:"application/json",
			statusCode:{
				200:function(){
					
					alert("In success");
				}},
	
	
	
	
	
});
}