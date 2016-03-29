function test(){
	var user=$("#user").val();
	var pass=$("#pass").val();
	alert(user+pass);
	
	$.ajax({
		type:"GET",
		url:"http://localhost:9080/StudentCourseRegistrationSystem/rest/cloudrest/login?user="+user,
		//url:"http://localhost:8080/StudentCourseRegistrationSystem/rest/studentrest/status/checkcourses?studentid="+ids,
		dataType:"json",
		
		success:function(response){
			alert("In success");
		
			sessionStorage.username=user;
			sessionStorage.password=pass;
			if(pass==response.password){
				alert("login success");
			if(response.user_type=="Developer"){
				
				window.location.href="dtest.html";
				}
			if(response.user_type=="Tester"){
				alert("Hi I am Tester");
				window.location.href="vtestview .html";
			}	
			if(response.user_type=="Test Manager"){
				alert("Hi I am Test Manager");
				window.location.href="tmselect.html";
				}
			}	
			
			else{
				alert("Invalid Credential");
			}
		},
	error:function(data){
		alert("Invalid Credentials");
		}
	
});	
}