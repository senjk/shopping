

        var flag;
		var id;
		function odata(flag, id){
			
			
				var idatas = {"flag":flag, "id":id};
				 $.ajax({
					  url:'USServlet',
					  type:'post',
					  dataType:'json',
					  data:idatas,
					  success:success_function,
					  error:error_function
				  });
				function success_function(odatas){
					if("0" == odatas){
						alert("付款成功！");
						location.href="Person.jsp";
						
					}
					if("5" == odatas){
						alert("移出购物车成功！");
						location.href="Person.jsp";
						
					}
				}
				function error_function(){
					alert("错误！");
				}
				return;
			}


/**
 * 
 * @param num
 */

function ajaxs(num){
		if(num==1){
			var datas={"code":$('#dcode').text(),"pageNo":1};
		}else if(num==2){
			var datas={"code":$('#dcode').text(),"pageNo":parseInt($('#table2 #pageNo').text())-1};
		}else if(num==3){
			var datas={"code":$('#dcode').text(),"pageNo":parseInt($('#table2 #pageNo').text())+1};
		}else{
			var datas={"code":$('#dcode').text(),"pageNo":$('#table2 #totalPage2').text()};
		}
		$.ajax({
			url:'BuyCarServlet',
			type:'post',
			dataType:'json',
			data:datas,
			success:success_function,
			error:error_function
		});
	}
	function success_function(ajaxData){
		if("0"==ajaxData){
			$("#rightfiles #cars").load("BuyCar.jsp");
		}else{
			alert("保存失败！");
		}
	}
	function error_function(){
		alert("错误！");
	}
