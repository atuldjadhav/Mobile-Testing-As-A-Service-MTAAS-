$(document).ready(function(){
	var username=sessionStorage.username;
	alert(username);
	var totalcost;
	var status;
	$.ajax({
				type:"GET",
				url:"http://localhost:9080/StudentCourseRegistrationSystem/rest/cloudrest/testhistory?user="+username,
				//url:"http://localhost:8080/StudentCourseRegistrationSystem/rest/studentrest/status/checkcourses?studentid="+ids,
				dataType:"json",
				//contentType:"json",
				success:function(response){
					alert("In success");
				
					var len=response.length;
					for(i=0;i<response.length;i++){
						
						if(response[i].status_id=="1"){
							status="Yet to Start";	
						}
						if(response[i].status_id=="2"){
							status="Assigned";	
						}
						if(response[i].status_id=="3"){
							status="Completed";	
						}
						if(response[i].status_id=="4"){
							status="Report Approved";	
						}
						if(response[i].TesterCost==undefined){
							
							totalcost="Not Billed Yet";
						}
if(response[i].TesterCost!=undefined){
							
							totalcost=response[i].TesterCost;
						}
						
					
					$("#resultid").append("<tr><td align='center'>"+response[i].Appid+"</td>"+
							"<td align='center'>"+response[i].app_name+"</td>"+
							"<td align='center'>"+status+"</td>"+
							"<td align='center'>"+totalcost+"</td></tr>");
						
						//	"<td>"+response[i].grade+"</td>"+
							
					//		"<td>"+inp1+"</td></tr>");
					
									}
					},
					error:function(data){
						alert("In error");
						
					}
			});
})