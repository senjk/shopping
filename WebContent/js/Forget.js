$(document).ready(function(){
	$("#forms #putt").click(function(){
		
		ajaxforget();
	
		
	});
	$("#forms #button").click(function(){
	
		var num1=$("#yan").val();
	
		var num2=$("#yanma").val();
		
		if(num1===num2){
			$('#massage').html("");
			$("#bodys #forms").hide();
			$("#bodys #upassword").show();
			
		}else{
			$('#massage').html("验证码不一致");
		}
		
	});
	
	
	$("#upassword #rebutton").click(function(){
		
		var num3=$("#upassword #password").val();
	
		var num4=$("#upassword #repassword").val();
		
		if(num3==num4){
			$('#upassword #massages').html("");
			ajaxre();
			
		}else{
			$('#upassword #massages').html("两次密码不一致");
		}
		
	});
	
	function ajaxforget(){
	 var id="1";
		var datas={"code":$('#code').val(),"id":id};
		$.ajax({
			url:'ForgetServlet',
			type:'post',
			dataType:'json',
			data:datas,
			success:success_function,
			error:error_function
		});
	};
	function success_function(ajaxData){
		if("0"==ajaxData){
			$('#massage').html("");
			MathRand();
		}else{
			$("#yan").val(""); 
			$('#massage').html("用户名错误！");
		}
	};
	function error_function(){
		alert("错误1");
	};
	
	function MathRand() 
	{ 
	var codes=$("#code").val();
	$("#dcodes").html(codes);
	var Num=""; 
	for(var i=0;i<4;i++) 
	{ 
	Num+=Math.floor(Math.random()*10); 
	} 
	$("#yan").val(Num); 
	
	ajaxmail(Num);

	};
	
	
	function ajaxre(){
		var id="2";
		var datas={"code":$('#dcodes').text(),"pwd":$('#password').val(),"id":id};
		$.ajax({
			url:'ForgetServlet',
			type:'post',
			dataType:'json',
			data:datas,
			success:success_functionaq,
			error:error_functionaq
		});
	};
	function success_functionaq(ajaxData){
		if("0"==ajaxData){
			alert("密码修改成功，返回登录界面");
			location.href="login.jsp";
		}else{
			$('#massage').html("修改密码失败！");
		}
	};
	function error_functionaq(){
		alert("错误1");
	}
	
	
	
	function ajaxmail(Num){
		
		var nums=Num;
			var datas={"code":$('#code').val(),"messsage":nums};
			$.ajax({
				url:'EmailServlet',
				type:'post',
				dataType:'json',
				data:datas,
				success:success_functionmail,
				error:error_functionmail
			});
		};
		function success_functionmail(ajaxData){
			if("0"==ajaxData){
				alert("验证码已发送至您的邮箱");
			}else{
				alert("失败");
			}
		};
		function error_functionmail(){
			alert("错误3");
		};
	
})
