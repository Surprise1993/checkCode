<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script type = "text/javascript">
	function reloadCode() {
		/* 为了防止缓存的作用使验证码无法刷新，创建time变量，使得提交请求时每次的路径都不一样 */
		var time = new Date().getTime();
		document.getElementById("imagecode").src = "<%= request.getContextPath()%>/servlet/ImageServlet?d=" + time;
	}
	
	function changeR(node) {
		node.src = "randomcode.jpg?time =" + new Date().getTime();
	}
</script>

<body>

<form action="<%= request.getContextPath()%>/servlet/LoginServlet" method = "get">
验证码：<input type="text" name="checkcode"/>
<img alt = "验证码" id = "imagecode" src = "<%= request.getContextPath()%>/servlet/ImageServlet"/>
<a href = "javascript:reloadCode();">看不清楚</a><br>
<input type = "submit" value = "提交"/>
<input type = "reset" value = "重置"/>
</form>

<hr>
<h2>kaptcha实现验证码</h2>
<img alt="random" src="randomcode.jpg" onclick="changeR(this)" style="cursor: pointer;">
<form action="check.jsp">
	<input type="text" name="r">
	<input type="submit" value="s">
</form>


</body>
</html>