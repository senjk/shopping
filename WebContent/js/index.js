$(document).ready(function(){
	var datas=null;
	$.ajax({
		url:'DrinkServlet',
		type:'post',
		dataType:'json',
		data:datas,
		success:function(ajaxData){
			if("0"==ajaxData){
			}
		},
		error:function(){
			alert("错误！");
		}
	});
    var page = 1;
    var i = 5; //每版放4个图片
    //向后 按钮
   $("#next").click(function(){ //绑定click事件
        
    	var content = $(".show"); 
	   	var content_list = $("#bodyshow");
	   	var v_width = content.width();
	   	var len = content_list.find("div").length;
	   	var page_count = Math.ceil(len / i)+1 ;   //只要不是整数，就往大的方向取最小的整数
	   	if( !content_list.is(":animated") ){    //判断“内容展示区域”是否正在处于动画
	    	if( page == page_count ){  //已经到最后一个版面了,如果再向后，必须跳转到第一个版面。
	    		content_list.animate({ left : '0px'}, "slow"); //通过改变left值，跳转到第一个版面
	    		page = 1;
	    	}else{
	    		content_list.animate({ left : '-='+v_width }, "slow");  //通过改变left值，达到每次换一个版面
	    		page++;
	    	}
	   	}
	});
    //往前 按钮
  $("#prev").click(function(){
    	
    	var content = $(".show"); 
   		var content_list = $("#bodyshow");
   		var v_width = content_list.width();
   		var len = content.find("div").length;
   		var page_count = Math.ceil(len / i) ;   //只要不是整数，就往大的方向取最小的整数
   		if(!content_list.is(":animated") ){    //判断“内容展示区域”是否正在处于动画
     		if(page == 1 ){  //已经到第一个版面了,如果再向前，必须跳转到最后一个版面。
//   			content_list.animate({ left : '-='+v_width*(page_count-1) }, "slow");
//  			page = page_count;
				content_list.animate({ left : '0px'}, "slow"); //通过改变left值，跳转到第一个版面
	    		page = 1;
   			}else{
//  			content_list.animate({ left : '+='+v_width }, "slow");
//  			page--;
				content_list.animate({ left : '0px'}, "slow"); //通过改变left值，跳转到第一个版面
	    		page = 1;
   			}
  		}
    });



/**
 * show2
 */

$("#next1").click(function(){ //绑定click事件
    
	var content = $(".show21"); 
   	var content_list = $("#bodyshow1");
   	var v_width = content.width();
   	var len = content_list.find("div").length;
   	var page_count = Math.ceil(len / i) ;   //只要不是整数，就往大的方向取最小的整数
   	if( !content_list.is(":animated") ){    //判断“内容展示区域”是否正在处于动画
    	if( page == page_count ){  //已经到最后一个版面了,如果再向后，必须跳转到第一个版面。
    		content_list.animate({ left : '0px'}, "slow"); //通过改变left值，跳转到第一个版面
    		page = 1;
    	}else{
    		content_list.animate({ left : '-='+v_width }, "slow");  //通过改变left值，达到每次换一个版面
    		page++;
    	}
   	}
});
//往前 按钮
$("#prev1").click(function(){
	
	var content = $(".show21"); 
		var content_list = $("#bodyshow1");
		var v_width = content_list.width();
		var len = content.find("div").length;
		var page_count = Math.ceil(len / i) +1;   //只要不是整数，就往大的方向取最小的整数
		if(!content_list.is(":animated") ){    //判断“内容展示区域”是否正在处于动画
 		if(page == 1 ){  //已经到第一个版面了,如果再向前，必须跳转到最后一个版面。
//			content_list.animate({ left : '-='+v_width*(page_count-1) }, "slow");
//			page = page_count;
			content_list.animate({ left : '0px'}, "slow"); //通过改变left值，跳转到第一个版面
    		page = 1;
			}else{
//			content_list.animate({ left : '+='+v_width }, "slow");
//			page--;
			content_list.animate({ left : '0px'}, "slow"); //通过改变left值，跳转到第一个版面
    		page = 1;
			}
		}
});

});

/**
 * 
 */
$(document).ready(function(){
	
	$("#bodyshow #drink .drinkk").click(function(){
		if($('#link .login').length>0){
			alert("请先登录");
			location.href="login.jsp";
		}else{
			var index=$("#bodyshow #drink .drinkk").index(this);
			var datas={"url":$("#bodyshow div:eq("+index+") .urls")[0].src,"drink":$("#bodyshow div:eq("+index+") .drinkk").text(),"price":$("#bodyshow div:eq("+index+") #price").text()};
			$.ajax({
				url:'OrderServlet',
				type:'post',
				dataType:'json',
				data:datas,
				success:function(ajaxData){
							if("0"==ajaxData){
								location.href="Order.jsp";
							}
						},
				error:function(){
						  alert("错误！");
					  }
			}); 
		}
	});
	/**
	 * show2
	 */
	$("#bodyshow1 #drink1 .drinkk1").click(function(){
		if($('#link .login').length>0){
			alert("请先登录");
			location.href="login.jsp";
		}else{
			var index=$("#bodyshow1 #drink1 .drinkk1").index(this);
			var datas={"url":$("#bodyshow1 div:eq("+index+") .urls1")[0].src,"drink":$("#bodyshow1 div:eq("+index+") .drinkk1").text(),"price":$("#bodyshow1 div:eq("+index+") #price1").text()};
			$.ajax({
				url:'OrderServlet',
				type:'post',
				dataType:'json',
				data:datas,
				success:function(ajaxData){
							if("0"==ajaxData){
								location.href="Order.jsp";
							}
						},
				error:function(){
						  alert("错误！");
					  }
			}); 
		}
	});
})