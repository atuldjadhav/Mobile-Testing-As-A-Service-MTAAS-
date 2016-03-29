$(document).ready(function(){
	var username=sessionStorage.username;
	$.ajax({
				type:"GET",
				url:"http://localhost:9080/StudentCourseRegistrationSystem/rest/cloudrest/getinfo?user="+username,
				//url:"http://localhost:8080/StudentCourseRegistrationSystem/rest/studentrest/status/checkcourses?studentid="+ids,
				dataType:"json",
				//contentType:"json",
				success:function(response){
					alert("In success");
					/*var len=response.length;
					for(i=0;i<response.length;i++){
						$("#fname").val(response[i].first_name);
					$("#email").val(response[i].email_id);
						$("#pass1").val(response.password);
						$("#lname").val(response.last_name);	
						$("#phone").val(response.phone_number);
					}*/
					
					//alert(response.first_name);
					$("#fname").val(response.first_name);
					$("#email").val(response.email_id);
					$("#password").val(response.password);
					$("#lname").val(response.last_name);	
					$("#phone").val(response.phone_number);
					
					},
					error:function(data){
						alert("In error");
						
					}
			});
			

});	

function test(){
	var username1=sessionStorage.username;
	alert("Insid update");
	var first=$("#fname").val();
	alert(first);
	var email=$("#email").val();
	alert(email);
	var password=$("#password").val();
	alert(password);
	var lname=$("#lname").val();
	alert(lname);
	var phone=$("#phone").val();
	alert(phone);
	
	var testJson = {
			 email_id:email,
			password:password,
			first_name:first,
			 last_name:lname,	
			phone_number:phone,
			user_name:username1
				
		};
	var str=JSON.stringify(testJson);
	
	alert(str);
	$.ajax ({  
		type: "POST",
		url: "http://localhost:9080/StudentCourseRegistrationSystem/rest/cloudrest/updateuser", 
		data: JSON.stringify(testJson),
		dataType:"json",
		contentType:"application/json",
		statusCode:{
			200:function(){
				
				alert("In success2");
			}}
		
});
}
	
	
	
	
	
	
	
	
	
	
	
	
