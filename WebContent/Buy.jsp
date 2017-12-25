<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String path=request.getContextPath(); %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <script src="js/jquery-1.12.4.js" type="text/javascript" charset="utf-8"></script>
		
		<script type="text/javascript" src="js/Head.js" ></script>
		<script type="text/javascript" src="js/Buy.js" ></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/Head.css" />
		<link rel="stylesheet" href="css/Buy.css" />
		<link rel="stylesheet" href="css/footer.css" />
<title>Insert title here</title>
</head>
<body>
<header>
			<div class="top_right">
				<ul>
					<li class="top1"></li>
					<li id="link">
				<c:if test="${empty code }" var="result" scope="request"> 
					<a href="login.jsp" class="login">Hi,请登录</a>
				</c:if>
				<c:if test="${not empty code }" var="result" scope="request"> 
					Hi,<span id="names">${code}</span>&nbsp;
					<a href="login.jsp" style="color: grey">注销</a>
				</c:if>
			</li>
					<li class="top2"></li>
						<li id="link"><a href="resj.jsp" class="register">注册</a></li>
					<li class="top3"></li>
					<li id="link">
				<c:if test="${empty code }" var="result" scope="request"> 
					<a href="login.jsp" class="other">我的商城</a>
				</c:if>
				<c:if test="${not empty code }" var="result" scope="request"> 
					<a href="Person.jsp" class="other">我的商城</a>
				</c:if>
			</li>
			<li class="top4"></li>
			<li id="first">
				<span>网站导航&nbsp;<img src="img/1hd10.png"/></span>
				<ul>
					<li>网站联盟</li>
					<li>招商通道</li>
					<li>企业采购</li>
					<li>充值中心</li>
				</ul>	
			</li>
					
				</ul>
			</div>
			<div class="top_time">
				<span>
					你好，欢迎访问威诗朗酒庄！
				</span>
				<span id="time">
					
				</span>
				<span id="dcode" style="display: none;">${code}</span>
			</div>
			<div class="top_bottom">
				<ul>
					<li>
						<a href="index.jsp">
							首页
						</a>
					</li>
					<li>
						<a href="#">
							热门推荐
						</a>
					</li>
					<li>
						<a href="#">
							名酒特卖
						</a>
					</li>
					<li>
						<a href="#">
							老酒馆
						</a>
					</li>
					<li>
						<a href="#">
							超值抢购
						</a>
					</li>
					<li>
						<a href="#">
							全球海购
						</a>
					</li>
					<li>
						<a href="#">
							香港免税
						</a>
					</li>
					<li>
						<a href="#">
							精品闪购
						</a>
					</li>
					<li>
						
					</li>
				</ul>
			</div>
			
		<div id="headNextCenter">
			<input type="text" name="search" id="search" placeholder="   葡萄酒"/>
			<input type="button" name="button" id="button" value="搜索"/>
			
		</div>
		</header>
		<section id="bodys">
		<table border="1" rules="all" bordercolor="lightgrey" id="table1">
		<tr>
			<td width="330px" height="30px" style="cursor: pointer;">店铺宝贝</td>
			<td width="150px" height="30px" style="cursor: pointer;">价格</td>
			<td width="150px" height="30px" style="cursor: pointer;">数量</td>
			<td width="150px" height="30px" style="cursor: pointer;">优惠方式</td>
			<td width="150px" height="30px" style="cursor: pointer;">小计</td>
		</tr>
		<tr id="data">
			<td height="100px" id="order">
				<img alt="" src="${url}" id="urls">
				<span id="span1">${drink }</span>
			</td>
			<td height="100px" id="price">${price}</td>
			<td height="100px" id="number">${number}</td>
			<td height="100px">暂无优惠</td>
			<td height="100px" id="prices"><span>￥</span><span>${prices}</span></td>
		</tr>
	</table >
	<div id="pays">
		<div id="address">
			<p>寄送至：<span id="adds">${address}</span></p>
			<p>买家：<span id="name">${name}</span></p>
			<span style="display: none;" id="">${code}</span>
		</div>
		<p id="pay" onclick="ajaxs();">确认订单</p>
	</div>
		
		
		</section>
		<div class="lian">
				<ul>
					<li>
						友情链接:
					</li>
					<li>
						<a href="">百度</a>
					</li>
					<li>
						<a href="">Google</a>
					</li>
					<li>
						<a href="">雅虎</a>
					</li>
					<li>
						<a href="">淘宝 </a>
					</li>
					<li>
						<a href="">拍拍</a>
					</li>
					<li>
						<a href="">易趣</a>
					</li>
					<li>
						<a href="">当当</a>
					</li>
					<li>
						<a href="">京东商城</a>
					</li>
					<li>
						<a href="">迅雷</a>
					</li>
					<li>
						<a href="">新浪 </a>
					</li>
					<li>
						<a href="">凤凰网</a>
					</li>
				</ul>
				<hr />
			</div>
		
		<footer>
			 	COPYRIGHT &copy;  2003-2010 <a href="#">合肥市威诗朗酒庄</a> ALL RIGHT RESERVED<br />
  	  热线：400-66-13060 Email:service@prd.com<br />
  	  ICP：<a href="#">沪ICP备05021104号</a><br />
  	  <img src="img/img1.gif" alt="alt" />
  	  <img src="img/img2.gif" alt="alt" />
  	  <img src="img/img3.gif" alt="alt" />
  	  <img src="img/img4.gif" alt="alt" />
		</footer>
</body>
</html>