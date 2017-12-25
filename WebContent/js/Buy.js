function ajaxs(){
		var datas={"status":1,"code":$('.top_time #dcode').text(),"drink":$('#data #span1').text()};
		$.ajax({
			url:'PayServlet',
			type:'post',
			dataType:'json',
			data:datas,
			success:success_function,
			error:error_function
		});
	}
	function success_function(ajaxData){
		if("0"==ajaxData){
			alert("亲，你已成功购买，我们将尽快为您发货，您还可以在订单页面查看详细信息");
			location.href="Person.jsp";
		}else{
			alert("购买失败！");
		}
	}
	function error_function(){
		alert("错误");
	}