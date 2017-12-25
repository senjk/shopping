	/***********保存***********/
	function ajaxs(){
		/**密码验证***/
		var password=$("#password").val();
		var $spassword=$("#spassword");
		var regpassword=/^[a-zA-z0-9]{6,20}$/;
		if(regpassword.test(password)==false){
			$spassword.html("密码输入不正确");
			return false;
		}else{
			$spassword.html("");
		}
		/**邮箱验证***/
		var Email=$("#email").val();
		var $youx=$("#semail");
		var regEmail=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
		if(Email==""){
			$youx.html("邮箱不能为空");
			return false
		}else{
			$youx.html("");
		}
		if(regEmail.test(Email)==false){
			$youx.html("邮箱格式不正确");
			return false
		}else{
			$youx.html("");
		}
		/**手机验证**/
		var mobile = $("#phone").val();
		var $ts=$("#sphone");
		var regMobile=/^1(3|4|5|7|8)\d{9}$/;
		if(regMobile.test(mobile)==false){
			$ts.html("手机号码不正确");
			return false;
		}else{
			$ts.html("");
		}
		var sex = $("#selects").val();
		//var index=$("#selects option").index($('#selects option:selected'));
		var datas={"code":$('#forms #scode').text(),"username":$('#forms #sname').text(),"password":$('#forms #password').val(),"sex":$('#forms #selects').val(),"email":$('#forms #email').val(),"brithday":$('#forms #brithday').val(),"phone":$('#forms #phone').val()}
		$.ajax({
			url:'PersonServlet',
			type:'post',
			dataType:'json',
			data:datas,
			success:success_function,
			error:error_function
		});
	}
	/**********订单查询*********/
	function ajaxs2(){
		var datas={"code":$('#forms #scode').text(),"pageNo":1}
		$.ajax({
			url:'UserBuyServlet',
			type:'post',
			dataType:'json',
			data:datas,
			success:success_functions,
			error:error_function
		});	
	}
	function ajaxs3(){
		
		var datas={"code":$('#forms #scode').text(),"pageNo":1}
		$.ajax({
			url:'BuyCarServlet',
			type:'post',
			dataType:'json',
			data:datas,
			success:success_functionss,
			error:error_function
		});	
	}
	
	/**
	 * 
	 * @param ajax4
	 */
function ajaxs4(){
	$("#rightfiles #forms").hide();
	$("#rightfiles #cars").hide();
	$("#rightfiles #orders").hide();
	$("#rightfiles #forgets").load("Forgets.jsp").show();
	$("#leftfiles #forgets").css({"color":"rgb(204, 0, 0)"});
	$("#leftfiles #person").css({"color":"black"});
	$("#leftfiles #car").css({"color":"black"});
	$("#leftfiles #order").css({"color":"black"});
	}
	function success_functions(ajaxData){
		if("0"==ajaxData){
			$("#rightfiles #forms").hide();
			$("#rightfiles #cars").hide();
			$("#rightfiles #forgets").hide();
			$("#rightfiles #orders").load("UserBuy.jsp").show();
			$("#leftfiles #order").css({"color":"rgb(204, 0, 0)"});
			$("#leftfiles #person").css({"color":"black"});
			$("#leftfiles #car").css({"color":"black"});
			$("#leftfiles #forgetcs").css({"color":"black"});
		}else{
			alert("保存失败！");
		}
	}
	function success_functionss(ajaxData){
		if("0"==ajaxData){
			$("#rightfiles #forms").hide();
			$("#rightfiles #forgets").hide();
			$("#rightfiles #orders").hide();
			$("#rightfiles #cars").load("BuyCar.jsp").show();
			$("#leftfiles #car").css({"color":"rgb(204, 0, 0)"});
			$("#leftfiles #person").css({"color":"black"});
			$("#leftfiles #order").css({"color":"black"});
			$("#leftfiles #forgetcs").css({"color":"black"});
		}else{
			alert("保存失败！");
		}
	}
	
	function success_function(ajaxData){
		if("0"==ajaxData){
			alert("保存成功！");
			location.href="Person.jsp";
		}else{
			alert("保存失败！");
		}
	}
	
	function error_function(){
		alert("错误！");
	}
