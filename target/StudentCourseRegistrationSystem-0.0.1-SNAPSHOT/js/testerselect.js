$(document).ready(function(){
	$.ajax({
				type:"GET",
				url:"http://localhost:9080/StudentCourseRegistrationSystem/rest/cloudrest/assigntester",
				//url:"http://localhost:8080/StudentCourseRegistrationSystem/rest/studentrest/status/checkcourses?studentid="+ids,
				dataType:"json",
				//contentType:"json",
				success:function(response){
					alert("In success");
					
					var len=response.length;
					for(i=0;i<response.length;i++){
						var status;
						
						var inp1="<button type='button' id='assign'  onclick='test(this)'>Assign</button>";
					$("#resultid").append("<tr><td align='center'>"+response[i].Appid+"</td>"+
							"<td align='center'>"+response[i].app_name+"</td>"+
							"<td align='center'>"+"<input type='text' id='testerid' style='border:none'>"
							+"</td>"+
							"<td align='center'>"+inp1+"</td></tr>");
						
						//	"<td>"+response[i].grade+"</td>"+
							
					//		"<td>"+inp1+"</td></tr>");
					
									}
					},
					error:function(data){
						alert("In error");
						
					}
			});
})
function test(x){
	 
	//var x = $('input:radio[name=id]:checked').val();
	var appid = $(x).closest("tr").find('td:eq(0)').text();
	var testerid = $(x).closest("tr").find('td input').val();
	var testJson = {
			app_id:appid,
			tester_id:testerid
	};
	var str=JSON.stringify(testJson);
	alert(str);
	$.ajax ({  
		type: "POST",
		url: "http://localhost:9080/StudentCourseRegistrationSystem/rest/cloudrest/assigntesters", 
		data: JSON.stringify(testJson),
		dataType:"json",
		contentType:"application/json",
		statusCode:{
			200:function(){

				window.location.href="http://localhost:9080/StudentCourseRegistrationSystem/tmselect.html";
				alert("In success2");
			}}
		
});
}




