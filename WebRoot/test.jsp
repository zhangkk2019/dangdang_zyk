<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
  <head>
  	<script type="text/javascript"
	src="${pageContext.request.contextPath }/back/js/jquery-1.8.3.min.js"></script>
  </head>
  
  <script type="text/javascript">
  	window.parent.location.href="${pageContext.request.contextPath }/back/login.jsp";
  </script>
  <body>
    <img id="aaa"  src="${pageContext.request.contextPath }/back/img/1.jpg"/>请登录。
  </body>
</html>
