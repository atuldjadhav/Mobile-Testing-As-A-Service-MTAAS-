$(document).ready(function(){
	var username=sessionStorage.username;
	alert(username);
	$.ajax({
				type:"GET",
				url:"http://localhost:9080/StudentCourseRegistrationSystem/rest/cloudrest/getResult?user="+username,
				//url:"http://localhost:8080/StudentCourseRegistrationSystem/rest/studentrest/status/checkcourses?studentid="+ids,
				dataType:"json",
				//contentType:"json",
				success:function(response){
					alert("In success");
				
					var len=response.length;
					for(i=0;i<response.length;i++){
						var status;
						var Totalbugs;
						alert(JSON.stringify(response[i]));
						if(response[i].lowbugs==undefined || response[i].Approved!="2" ){
							response[i].lowbugs="0";
						}
						if(response[i].mediumbugs==undefined || response[i].Approved!="2"){
							response[i].mediumbugs="0";
						}
						if(response[i].highbugs==undefined || response[i].Approved!="2"){
							response[i].highbugs="0";
						}
						
						 Totalbugs=parseInt(response[i].lowbugs)+parseInt(response[i].mediumbugs)+parseInt(response[i].highbugs);
						/*if(response[i].priority=="High"){
							var Totalbill=parseInt(response[i].lowbugs)*2+parseInt(response[i].mediumbugs)*3+parseInt(response[i].highbugs)*4;
							
							alert(Totalbill);
								}
					if(response[i].priority=="Medium"){
						var Totalbill=parseInt(response[i].lowbugs)*1+parseInt(response[i].mediumbugs)*2+parseInt(response[i].highbugs)*3;
						alert(Totalbill);
					}
					if(response[i].priority=="Low"){
						var Totalbill=parseInt(response[i].lowbugs)*0.5+parseInt(response[i].mediumbugs)*1+parseInt(response[i].highbugs)*2;
						alert(Totalbill);
					}*/
					if(response[i].status_id=="1"){
					 status="Yet to Start"	;
					}
					if(response[i].status_id=="2"){
						 status="Assigned"	;
						}
					if(response[i].status_id=="3"){
						 status="In Progress"	;
						}
					if(response[i].status_id=="4"){
						 status="Test Completed";
					}
					if(response[i].finalamount==undefined){
						response[i].finalamount="0";
					}
					
					$("#resultid").append("<tr><td align='center'>"+response[i].Appid+"</td>"
							+"<td align='center'>"+response[i].app_name+"</td>"+
							"<td align='center'>"+response[i].lowbugs+"</td>"+
							"<td align='center'>"+response[i].mediumbugs+"</td>"+
							"<td align='center'>"+response[i].highbugs+"</td>"+
							"<td align='center'>"+Totalbugs+"</td>"+
							"<td align='center'>"+response[i].finalamount+"</td>"+
							"<td align='center'>"+status+"</td></tr>");
						//	"<td>"+response[i].grade+"</td>"+
							
					//		"<td>"+inp1+"</td></tr>");
					
					
					}
					},
					error:function(data){
						alert("In error");
						
					}
			});
})