function register(x){
	var StudentId=sessionStorage.studentid;
	var Term="Fall 2015";
var coursename = $(x).closest("tr").find('td:eq(0)').text();
var coursecode = $(x).closest("tr").find('td:eq(1)').text();
var credits = $(x).closest("tr").find('td:eq(2)').text();
var sectionid = $(x).closest("tr").find('td:eq(3)').text();
var location = $(x).closest("tr").find('td:eq(4)').text();
var price=$(x).closest("tr").find('td:eq(5)').text();
var starttime=$(x).closest("tr").find('td:eq(6)').text();

alert(coursename+coursecode+credits+sectionid+location+price+starttime);
	var testJson = {
			studentid:StudentId,
			sectionid:sectionid,
			coursecode:coursecode,
			term:Term,
			grade:"NA"
				
	};
	var str=JSON.stringify(testJson);
	alert(str);
	//alert(testJson.sectionid);
	function make_base_auth(user, password) {
		  var tok = user + ':' + password;
		  var hash = btoa(tok);
		  return "Basic " + hash;
		 // alert("Hello DEREG");
		}
	ajaxObj = {  
			type: "POST",
			url: "http://localhost:9080/StudentCourseRegistrationSystem/rest/studentrest/status", 
			data: JSON.stringify(testJson),
			dataType:'text',
			contentType:"application/json",
			async: false,
			
			  beforeSend: function (xhr){ 
			      xhr.setRequestHeader('Authorization', make_base_auth(sessionStorage.username, sessionStorage.password)); 
			  },
			success: function(data) { 
	alert("You have successfully registered for the course. please check your mail for payment details");
	window.location.href="http://localhost:9080/StudentCourseRegistrationSystem/VCOURSE.html";
	//alert("Removing Row");
	 $(x).closest('tr').remove();
	},
	error:function(data){
		alert("You have already registered for this course");
	}
	}
	$.ajax(ajaxObj);
	
}
	
function test(){
	//alert(sessionStorage.studentid);
	var course= $("#Coursename").val();
	var pricepage= $("#Price").val();
	var locationpage= $("#Location").val();
	var timepage= $("#Time").val();
	if(course!=""&&pricepage==""&&locationpage==""&&timepage=="")
	{
	//alert(course);
	//alert(pricepage);
	var geturl2='http://localhost:9080/StudentCourseRegistrationSystem/rest/studentrest/status/findcourses?coursename='+course;
	callservice(geturl2);
	}
	else if(course==""&&pricepage!=""&&locationpage==""&&timepage=="")
	{//alert(pricepage);
	var geturl3='http://localhost:9080/StudentCourseRegistrationSystem/rest/studentrest/status/findprice?price='+pricepage;
	callservice(geturl3);
	}
	else if(course==""&&pricepage==""&&locationpage!=""&&timepage=="")
	{//alert(timepage);
	var geturl4='http://localhost:9080/StudentCourseRegistrationSystem/rest/studentrest/status/findlocation?bylocation='+locationpage;
	callservice(geturl4);
	}
	else if(course!=""&&pricepage!=""&&locationpage!=""&&timepage!="")
	{	
	//var geturl6='http://localhost:8080/StudentCourseRegistrationSystem/rest/studentrest/status/findbyfields?bylocation='+locationpage+'&byprice='+pricepage+'&bystarttime='+timepage+'&bycourse='+course;
	var geturl6="http://localhost:9080/StudentCourseRegistrationSystem/rest/studentrest/status/findbyfields?bylocation=SanJose&byprice=501&bystarttime=18:00:00&bycourse=JavaProgramming";
	callservice(geturl6);
	}
	
	else if(course==""&&pricepage==""&&locationpage==""&&timepage!="")
	{//alert(timepage);
	var geturl5='http://localhost:9080/StudentCourseRegistrationSystem/rest/studentrest/status/findtime?bytime='+timepage;
	callservice(geturl5);
	}else if(course!=""&&pricepage!=""&&locationpage!=""&&timepage=="")
	{//alert(timepage);
		alert("New");
		var geturl7="http://localhost:9080/StudentCourseRegistrationSystem/rest/studentrest/status/findbyfield?bylocation=SanJose&byprice=501&bycourse=JavaProgramming";
		callservice(geturl7);}
	else{
		alert("Nothing");
	}
	
}




function callservice(testurl){
	//alert("Inside call service");
	function make_base_auth(user, password) {
		  var tok = user + ':' + password;
		  var hash = btoa(tok);
		  return "Basic " + hash;
		 // alert("Hello DEREG");
		}
$.ajax({
		
		type:"GET",
		url:testurl,
		dataType:"json",
		async: false,
		  data: '{}',
		  beforeSend: function (xhr){ 
		      xhr.setRequestHeader('Authorization', make_base_auth(sessionStorage.username, sessionStorage.password)); 
		  },
		
		success:function(response){
			$("#studentTable").css("visibility","visible");
			alert("Hello");
			var len=response.length;
	for(i=0;i<response.length;i++){
		

		var inp1="<button type='button'  onclick='register(this)'>Register</button>";
		//<button type="button" class="use-address" onclick="test(this);">Use</button>
		$("#resultid").append("<tr><td>"+response[i].CourseName+"</td>"+
		"<td>"+response[i].CourseCode+"</td>"+
		"<td>"+response[i].Credits+"</td>"+
		"<td>"+response[i].SectionID+"</td>"+
		"<td>"+response[i].Location+"</td>"+
		"<td>"+response[i].Price+"</td>"+
		"<td>"+response[i].StartTime+"</td>"+
		"<td>"+inp1+"</td></tr>");
		$("#resultid").show();
		alert("Hello2");
	}		
			
	
			
		},
		error:function(data){
			
			alert("Please Contact Customer Care");		
		}
	})
	
	
	
	
}





