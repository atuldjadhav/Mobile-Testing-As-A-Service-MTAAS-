$(document).ready(function(){
	var username=sessionStorage.username;
	$.ajax({
				type:"GET",
				url:"http://localhost:9080/StudentCourseRegistrationSystem/rest/cloudrest/getpending?user="+username,
				//url:"http://localhost:8080/StudentCourseRegistrationSystem/rest/studentrest/status/checkcourses?studentid="+ids,
				dataType:"json",
				//contentType:"json",
				success:function(response){
					alert("In success");
					
					var len=response.length;
					for(i=0;i<response.length;i++){
						var status;
						
					
					$("#resultid").append("<tr><td align='center'>"+response[i].Appid+"</td>"+
							"<td align='center'>"+response[i].platform+"</td>"+
							"<td align='center'>"+response[i].priority+"</td>"+
							"<td align='center'>"+response[i].app_name+"</td>"+
							"<td align='center'>"+"Yet to Start"+"</td></tr>")
						
						//	"<td>"+response[i].grade+"</td>"+
							
					//		"<td>"+inp1+"</td></tr>");
					
									}
					},
					error:function(data){
						alert("In error");
						
					}
			});
})