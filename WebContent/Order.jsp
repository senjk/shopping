<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String path=request.getContextPath(); %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="js/jquery-1.12.4.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="js/Head.js" ></script>
<script type="text/javascript" src="js/Order.js" ></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="css/Head.css" />
   <link rel="stylesheet" href="css/Order.css" />
  <link rel="stylesheet" href="css/footer.css" />
<title>购买页</title>
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
		<div id="leftbodys">
			<img alt="" src="${url}" id="urls">
		</div>
		<div id="rightbodys">
			<p id="drink">${drink}</p>
			<div id="prices">
				<span>价格：&nbsp;&nbsp;&nbsp;&nbsp;￥</span>
				<span id="price">${price}</span>
			</div>
			<p id="p1">酿造日期：见箱底</p>
			<p id="p1">酒庄：威诗朗</p>
			<p id="p1">运费：&nbsp;&nbsp;&nbsp;&nbsp;免运费</p>
			<div id="address">
				<span>收货地址：</span>
				<select id="select1">
					<option>安徽省</option>
				</select>
				<select id="select2">
					<option>合肥市</option>
					<option>芜湖市</option>
					<option>蚌埠市</option>
					<option>淮南市</option>
					<option>马鞍山市</option>
					<option>淮北市</option>
					<option>铜陵市</option>
					<option>安庆市</option>
					<option>黄山市</option>
					<option>滁州市</option>
					<option>六安市</option>
					<option>亳州市</option>
				</select>
				<input type="text" id="street" placeholder="具体地区/街道">
			</div>
			<p id="numbers">购买数量：<input type="text" id="number"></p>
			<span id="buy" onclick="ajaxs1(0);">立即购买</span>
			<span id="orders" onclick="ajaxs2(0);">加入购物车</span>
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