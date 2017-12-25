<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单页</title>
<script src="js/jquery-1.12.4.js" type="text/javascript" charset="utf-8"></script>
<script src="js/Person.js" type="text/javascript" charset="utf-8"></script>
<script src="js/UserBuy.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="css/Person.css"/>
<link rel="stylesheet" type="text/css" href="css/UserBuy.css"/>
</head>
<body>
	<table border="1" rules="all" bordercolor="grey" id="table1">
		<tr>
			<td width="110px" height="30px" style="cursor: pointer;">订单号</td>
			<td width="440px" height="30px" style="cursor: pointer;">商品</td>
			<td width="110px" height="30px" style="cursor: pointer;">总价钱</td>
			<td width="110px" height="30px" style="cursor: pointer;">数量</td>
			<td width="180px" height="30px" style="cursor: pointer;">收货地址</td>
			<td width="110px" height="30px" style="cursor: pointer;">完成状态</td>
            <td width="150px" height="30px" style="cursor: pointer;">操作</td> 
		</tr>
		<c:forEach var="userbuy" items="${page.data}" varStatus="status">
			<tr id="data">
				<td height="100px" id="ordernum">${userbuy.ordernum}</td>
				<td height="100px" id="order">
					<img alt="" src="${userbuy.url }">
					<span>${userbuy.drink}</span>
				</td>
				<td height="100px" id="price">${userbuy.price}</td>
				<td height="100px" id="number">${userbuy.number}</td>
				<td height="100px" id="address">${userbuy.address}</td>
				
				<c:if test="${userbuy.status ==1}" var="result" scope="request">
					<td height="100px" id="status">已付款，待发货</td>
					 <td><p onclick="" style="cursor: pointer; color: black;" >提醒商家</p></td> 
				</c:if>
				<c:if test="${userbuy.status ==2}" var="result" scope="request">
					<td height="100px" id="status">已发货，待收货</td>
					 <td><p onclick="odata('3',${userbuy.ordernum});" style="cursor: pointer; color: blue;" >确认收货</p></td> 
				</c:if>
				<c:if test="${userbuy.status ==3}" var="result" scope="request">
					<td height="100px" id="status">交易完成</td>
					<td><p onclick="odata('4',${userbuy.ordernum});" style="cursor: pointer; color: blue;" >删除记录</p></td>
				</c:if>
			</tr>
		</c:forEach>
	</table >

<div id="table2">
		<span id="dcode" style="display: none;">${code}</span>
  		 <p id="totalPage1" style="color: blue;">总共(${page.totalPage})页 </p>
  		 <p id="pageNo" style="color: red;">${page.pageNo}</p>
  		 <p id="xiegang">/</p>
  		 <p id="totalPage2">${page.totalPage}</p>
  		 <p id="fristpage" onclick="ajaxs(1)">首页</p>&nbsp;&nbsp;  
		 <c:choose>
		 <c:when test="${page.pageNo > 1}">
	   	 	<p id="uppage1" onclick="ajaxs(2)" style="color: blue; cursor: pointer;float: left;">上一页</p>&nbsp;&nbsp;
		 </c:when>
		 <c:otherwise><p id="uppage1">上一页 </p>&nbsp;&nbsp;</c:otherwise>
		 </c:choose>
		 <c:choose>
			 <c:when test="${page.pageNo < page.totalPage}">
	   			<p id="nextpage1" onclick="ajaxs(3)" style="color: blue; cursor: pointer;float: left;">下一页</p>&nbsp;&nbsp;
			 </c:when>
			 <c:otherwise><p id="nextpage1">下一页</p>&nbsp;&nbsp;</c:otherwise>
		 </c:choose>
  			<p id="lastpage" onclick="ajaxs(4)">尾页</p>             
   	</div> 
</body>
<!-- <script type="text/javascript">
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
			url:'UserBuyServlet',
			type:'post',
			dataType:'json',
			data:datas,
			success:success_function,
			error:error_function
		});
	}
	function success_function(ajaxData){
		if("0"==ajaxData){
			$("#rightfiles #orders").load("UserBuy.jsp");
		}else{
			alert("保存失败！");
		}
	}
	function error_function(){
		alert("错误！");
	}
</script> -->
</html>