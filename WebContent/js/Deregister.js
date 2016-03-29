
$(document).ready(function()
		{
	function make_base_auth(user, password) {
		  var tok = user + ':' + password;
		  var hash = btoa(tok);
		  return "Basic " + hash;
		  alert("Hello DEREG");
		}
$.ajax({
	type:"GET",
	url:"http://localhost:9080/StudentCourseRegistrationSystem/rest/studentrest/status/checkcourses?studentid="+sessionStorage.studentid,
	dataType:"json",
	async: false,
    data: '{}',
    beforeSend: function (xhr){ 
        xhr.setRequestHeader('Authorization', make_base_auth(sessionStorage.username, sessionStorage.password)); 
    },
	
	success:function(response){
		
		var len=response.length;
for(i=0;i<response.length;i++){
	

	//var inp = "<input id='sno' type='button' name='id' value='delete'>"+delete+"</input>";
	var inp1="<button type='button' id='delete'  onclick='test(this)'>Delete</button>";
	//<button type="button" class="use-address" onclick="test(this);">Use</button>
	if(response[i].Flag==true){
	$("#resultid").append("<tr><td>"+response[i].StudentID+"</td>"+
	"<td>"+response[i].SectionID+"</td>"+
	"<td>"+response[i].CourseCode+"</td>"+
	"<td>"+response[i].Term+"</td>"+
	"<td>"+response[i].grade+"</td>"+
	
	"<td>"+inp1+"</td></tr>"

	);
	}
	
}		
		
		
		
	},
	error:function(data){
		alert("Please contact the Customer Care Service");
		console.log(error);
		
		
	}

});

		});
 function test(x){
	 
	//var x = $('input:radio[name=id]:checked').val();
	var id1 = $(x).closest("tr").find('td:eq(0)').text();
	var id2 = $(x).closest("tr").find('td:eq(2)').text();
	var id3 = $(x).closest("tr").find('td:eq(1)').text();
	function make_base_auth(user, password) {
		  var tok = user + ':' + password;
		  var hash = btoa(tok);
		  return "Basic " + hash;
		  alert("Hello DEREG");
		}
	//alert(sessionStorage.studentid);
	
	/*alert(id1);
	alert(id2);
	alert(id3);*/
	var url = "http://localhost:9080/StudentCourseRegistrationSystem/rest/studentrest/status/dropcourses?studentid="+id1+"&coursecode="+id2+"&sectionid="+id3;
	
	$.ajax({
		type:"GET",
		url: url,
		dataType:"json",
		async: false,
	    data: '{}',
	    beforeSend: function (xhr){ 
	        xhr.setRequestHeader('Authorization', make_base_auth(sessionStorage.username, sessionStorage.password)); 
	    },
		statusCode:{
			200:function(){
				
				window.location.href="http://localhost:9080/StudentCourseRegistrationSystem/DCOREG.html";
			}},
		

	
		})
} 






