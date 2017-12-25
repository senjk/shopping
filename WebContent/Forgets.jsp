<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <script src="js/jquery-1.12.4.js" type="text/javascript" charset="utf-8"></script>

<script type="text/javascript" src="js/Forgets.js" ></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/Forgets.css" />
<title>Insert title here</title>
</head>
<body>
	<span id="dcodes" style="display: none;"></span>
		<div id="bodys">
		
			<div id="formcs">
				<h2>验证账户</h2>
				
				<a href="login.jsp">返回登录</a>
				
				<p id="p1">账号：</p><input type="text"  id="code" placeholder="请输入账号" required pattern="^[a-zA-z]{4,20}$"><br>
				<p id="p2">验证码：</p><input type="text"  id="yanma" placeholder="请输入验证码" required ><br>
				<input type="text"  id="yan" disabled="disabled" />
				<input id="putt" type="button" value="获取验证码" />
				
				
				<div id="massage"></div>
				<input type="button" value="确认"  id="button" >
			</div>
			<div id="upassword" style="display: none">
			<h2>修改密码</h2>
			 
				<a href="login.jsp">返回登录</a>
				<p id="p1">新密码：</p><input type="text"  id="password" placeholder="请输入6-20位的密码" required pattern="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$"><br>
				<p id="p2">确认密码：</p><input type="text"  id="repassword" placeholder="请重新输入密码" required pattern="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$"><br>
		

				<div id="massages"></div>
				<input type="button" value="确认修改"  id="rebutton" >
			</div>
		</div>
</body>
</html>