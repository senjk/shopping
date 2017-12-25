/**
 * 
 */
function ajaxs1(){
			var datas={"code":$('#code').val(),"password":$('#password').val()};
			$.ajax({
				url:'LoginServlets',
				type:'post',
				dataType:'json',
				data:datas,
				success:success_function,
				error:error_function
			});
		}
		function success_function(ajaxData){
			if("0"==ajaxData){
				location.href="index.jsp";
			}else{
				$('#massage').html("用户名或密码错误！");
			}
		}
		function error_function(){
			alert("错误1");
		}