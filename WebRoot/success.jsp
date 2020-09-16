<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/back/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$(".aaa").mouseover(function(e) {//移入
				//1.获取原图片的大小
				var width = this.width * 2;
				var height = this.height * 2;

				//2.获取鼠标位置
				var x = e.pageX + 10;
				var y = e.pagey + 10;
				//3.创建一个div  //absolute表示绝对位置
				var div = $("<div id='bigDiv'/>").css({
					"position" : "absolute",
					"display" : "none",
					"width" : width,
					"height" : height,
					"top" : y,
					"left" : x,
					"border" : "1px solid yellow"

				});
				//4.创建放大的img
				var img = $("<img/>").css({
					"width" : width,
					"height" : height

				}).attr({
					"src" : this.src
				});

				//5.img放入到div
				div.append(img);

				//6.div放入到body
				$("body").append(div);
				div.show(1000);

			}).mousemove(function(e) {//移动
				//1.获取鼠标位置
				var x = e.pageX + 10;
				var y = e.pageY + 10;
				//2.鼠标位置赋值的div
				$("#bigDiv").css({
					"top" : y,
					"left" : x
				});
			}).mouseout(function(e) {//移出
				$("#bigDiv").remove();
			});
		});
	</script>
</head>

<body>
	<img class="aaa" src="${pageContext.request.contextPath }/back/img/1.jpg" />
	
</body>
</html>
