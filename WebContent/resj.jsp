<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String path=request.getContextPath(); %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/resj.js"></script>
<link rel="stylesheet" type="text/css" href="css/resj.css"/>
	<link rel="stylesheet" href="css/footer.css" />
</head>
<body>
<div>
		<div id="header">
			<img alt="" src="img/logo.png" id="i1">
			<h2>注册酒庄账户</h2>
			
			
		</div>
		<div id="forms">
			<div id="d2"><p id="p2">账号：</p><input type="text" id="code" placeholder="请输入4-20位的账户（字母，数字）" ><span id="scode"></span></div>
			<div id="d1"><p id="p2">姓名：</p><input type="text" id="username" placeholder="请输入姓名"><span id="sname"></span></div>
			<div id="d1"><p id="p2">密码：</p><input type="password" id="password" placeholder="请输入6-20位的密码（字母，数字）" ><span id="spassword"></span></div>
			<div id="d1"><p id="p2">性别：</p><select id="selects"><option>男</option><option>女</option></select><span id="ssex"></span></div>
			<div id="d1"><p id="p2">出生日期：</p><input type="date" id="brithday" placeholder="出生日期(1996/10/14)"><span id="sbrithday"></span></div>
			<div id="d1"><p id="p2">email：</p><input type="email" id="email" placeholder="请输入邮箱"><span id="semail"></span></div>
			<div id="d1"><p id="p2">手机号码：</p><input type="text" id="phone" placeholder="请输入11位的手机号码"><span id="sphone"></span></div>
			<input type="button" value="注册" onclick="ajax2();" id="button">
		</div>
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
