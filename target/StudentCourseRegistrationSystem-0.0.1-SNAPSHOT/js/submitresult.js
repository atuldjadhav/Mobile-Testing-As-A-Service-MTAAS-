function test(){
	var app_name=$("#appname").val();
	//alert("Hello");
	var lowbugs=$("#low").val();
	var mediumbugs=$("#medium").val();
	var highbugs=$("#high").val();
	var costl=$("#lbug").val();
	var costm=$("#mbug").val();
	var costh=$("#hbug").val();
	//alert(app_name+lowbugs+mediumbugs+highbugs+costl+costm+costh);
	var testJson = {

			app_id:app_name,
			 lowbugs:lowbugs,
			 mediumbugs:mediumbugs,
			 highbugs:highbugs,
			highbugcost:costh,
			lowbugcost:costl,
			mediumbugcost:costm
					
		};
		
		var str=JSON.stringify(testJson);
	alert(str);
	$.ajax ({  
		type: "POST",
		url: "http://localhost:9080/StudentCourseRegistrationSystem/rest/cloudrest/enterresult", 
		data: str,
		dataType:"text",
		contentType:"application/json",
		statusCode:{
			200:function(){
				
				alert("Result added Successfully");
			}
	},
});
}	
	
	
	
	
	
	
	
	
