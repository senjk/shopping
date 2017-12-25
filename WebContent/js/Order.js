

function ajaxs1(num){
		var index1=$("#address #select1 option").index($('#address #select1 option:selected'));
		var index2=$("#address #select2 option").index($('#address #select2 option:selected'));
		var datas={"drink":$('#rightbodys #drink').text(),
			"url":$('#leftbodys #urls')[0].src,
			"price":$('#rightbodys #prices #price').text(),
			"add1":$('#address #select1 option:eq('+index1+')').text(),
			"add2":$('#address #select2 option:eq('+index2+')').text(),
			"add3":$('#address #street').val(),
			"number":$('#rightbodys #number').val(),
			"status":num,
			"code":$('.top_time #dcode').text()
		}
		$.ajax({
			url:'BuyServlet',
			type:'post',
			dataType:'json',
			data:datas,
			success:success_function,
			error:error_function
		});
	}
	function success_function(ajaxData){
		if("0"==ajaxData){
			location.href="Buy.jsp";
		}else{
			alert("购买失败！");
		}
	}
	function error_function(){
		alert("错误！");
	}
	/************购物车****************/
	
	function ajaxs2(num){
			var index1=$("#address #select1 option").index($('#address #select1 option:selected'));
			var index2=$("#address #select2 option").index($('#address #select2 option:selected'));
			var datas={"drink":$('#rightbodys #drink').text(),
					"url":$('#leftbodys #urls')[0].src,
					"price":$('#rightbodys #prices #price').text(),
					"add1":$('#address #select1 option:eq('+index1+')').text(),
					"add2":$('#address #select2 option:eq('+index2+')').text(),
					"add3":$('#address #street').val(),
					"number":$('#rightbodys #number').val(),
					"status":num,
					"code":$('.top_time #dcode').text()
				}
			$.ajax({
				url:'Buycar',
				type:'post',
				dataType:'json',
				data:datas,
				success:success_functions,
				error:error_function
			});
	}
	function success_functions(ajaxData){
		if("0"==ajaxData){
			alert("亲！已成功加入购物车，您可以在订单中查询。");
			location.href="Person.jsp";
		}else{
			alert("加入失败！");
		}
	}