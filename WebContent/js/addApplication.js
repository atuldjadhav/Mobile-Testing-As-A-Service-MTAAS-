function add(){
	var app_name=$("#appname").val();
	var priority=$('input[name=priority]:checked').val();
	var platform="Android";
	var tester_id="";
	var Description=$("#description").val();
	var username=sessionStorage.username;
	
	if(app_name!=""&&Description!="")
		{
		
		
		/*//$("input:radio[name=Gender]").click(function() {
		    var gender = $(this).val();
		});*/
		//var gender=$("#male").val();
		//alert($("#appname").val());
	var testJson = {

			app_name:app_name,
			 priority:priority,
			 platform:platform,
			 description:Description,
			 status_id:1,
			 tester_id:tester_id,
			 username:username
					
		};
		
		var str=JSON.stringify(testJson);
		
		
		
		alert(str);
		$.ajax ({  
				type: "POST",
				url: "http://localhost:9080/StudentCourseRegistrationSystem/rest/cloudrest/addtest", 
				data: str,
				dataType:"text",
				contentType:"application/json",
				statusCode:{
					200:function(){
		alert("Your Test is submitted successfully");				
						alert("In success");
					}},	
	})
}
else{
	alert("Please Enter all the fields");
}
}