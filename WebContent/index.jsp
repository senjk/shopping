<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String path=request.getContextPath(); %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>威诗朗酒庄</title>
		<link rel="stylesheet" href="css/Head.css" />
		<link rel="stylesheet" href="css/lunbo.css" />
		<link rel="stylesheet" href="css/footer.css" />
		<link rel="stylesheet" href="css/drinkshow.css" />
		<script type="text/javascript" src="js/jquery-1.12.4.js" ></script>
		
		<script type="text/javascript" src="js/lunbo.js" ></script>
		<script type="text/javascript" src="js/Head.js" ></script>
		<script type="text/javascript" src="js/index.js" ></script>
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
		<section>
 	<div class="slider"> 
 		<ul class="slider-main">  
  			<li class="slider-panel"><a href="" target="_blank"><img  src="img/lunbo1.jpg"></a> </li> 
  			<li class="slider-panel"><a href="" target="_blank"><img  src="img/lunbo2.jpg"></a> </li> 
 			<li class="slider-panel"><a href="" target="_blank"><img  src="img/lunbo3.jpg"></a> </li> 
 			<li class="slider-panel"><a href="" target="_blank"><img  src="img/lunbo4.jpg"></a> </li>
 			<li class="slider-panel"><a href="" target="_blank"><img  src="img/lunbo5.jpg"></a> </li>
 			<li class="slider-panel"><a href="" target="_blank"><img  src="img/lunbo6.jpg"></a> </li>
 			<li class="slider-panel"><a href="" target="_blank"><img  src="img/lunbo7.jpg"></a> </li>
 		</ul> 
 		<div class="slider-extra"> 
  			<ul class="slider-nav"> 
				<li class="slider-item"></li> 
				<li class="slider-item"></li> 
				<li class="slider-item"></li> 
				<li class="slider-item"></li> 
				<li class="slider-item"></li> 
				<li class="slider-item"></li> 
				<li class="slider-item"></li> 
			</ul> 
  			<div class="slider-page"> 
  				<a class="slider-pre" href="javascript:;;">&lt;</a> 
  				<a class="slider-next" href="javascript:;;">></a> 
  			</div> 
 		</div> 
 	</div> 
			</section>
			<section class="drinkshow">
			
			<div class="show1">
			<hr />
			<h3>精选白酒</h3>
			<hr />
			<span id="prev"> &lt; </span> 
			<span id="next"> &gt;</span>
			<div class="show">
			 
	 		<div id="bodyshow">
	 			<c:forEach var="drink" items="${listDrink}" varStatus="status">
		 			<div id="drink">
		 				<img class="urls" src="${drink.url }"/>
		 				<p class="drinkk">${drink.drink}</p>
		 				<p id="m">￥</p>
		 				<p id="price">${drink.price}</p>
		 			</div>
	 			</c:forEach>
	 			
	 		</div>
	 		 
			</div>
			
			</div>
			
				<div class="show2">
				
			<hr />
			<h3>精选红酒</h3>
			<hr />
			<span id="prev1"> &lt; </span> 
			<span id="next1"> &gt;</span>
			<div class="show21">
			 
	 		<div id="bodyshow1">
	 			<c:forEach var="drink" items="${listDrinks}" varStatus="status">
		 			<div id="drink1">
		 				<img class="urls1" src="${drink.url }"/>
		 				<p class="drinkk1">${drink.drink}</p>
		 				<p id="m1">￥</p>
		 				<p id="price1">${drink.price}</p>
		 			</div>
	 			</c:forEach>
	 		</div>
	 		 
			</div>
			
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
