function ajax2(){
		/***账号验证**/
		var code=$("#code").val();
		var $scode=$("#scode");
		var regcode=/^[a-zA-z0-9]{4,20}$/;
		if(regcode.test(code)==false){
			$scode.html("账号输入不正确");
			return false;
		}else{
			$scode.html("");
		}
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
		
		
		var index=$("#selects option").index($('#selects option:selected'));
		var datas={"code":$('#code').val(),"username":$('#username').val(),"password":$('#password').val(),"sex":$('#selects option:eq('+index+')').text(),"email":$('#email').val(),"brithday":$('#brithday').val(),"phone":$('#phone').val()}
		$.ajax({
			url:'RegisterServlets',
			type:'post',
			dataType:'json',
			data:datas,
			success:success_function,
			error:error_function
		});
	}
	
	function success_function(ajaxData){
		if("0"==ajaxData){
			alert("注册成功！");
			location.href="login.jsp";
		}else{
			alert("注册失败！");
		}
	}
	
	function error_function(){
		alert("错误！");
	}