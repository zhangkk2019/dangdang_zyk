<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>生成订单 - 当当网</title>
		<link href="${pageContext.request.contextPath }/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/front/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/front/js/jquery-1.8.3.min.js"></script>
	</head>
	<body>
		<%@include file="/front/common/head1.jsp"%>
		<div class="login_step">
			生成订单骤: 1.确认订单 >
			<span class="red_bold"> 2.填写送货地址</span> > 3.订单成功
		</div>
		<div class="fill_message">
			<p>
				选择地址：
				<select name="addressid" id="address" onchange="test('${param.id}')">
					<option value="">填写新地址</option>
					<c:forEach items="${requestScope.addressList }" var="oldAddr">
						<option value="${oldAddr.id }">${oldAddr.name}</option>
					</c:forEach>
				</select>
			</p>
			<form name="ctl00" method="get" action="${pageContext.request.contextPath }/address/addOrder" id="f">
				<input type="hidden" value="${requestScope.address.id }" name="address.id" id="addressId" />
				<input type="hidden" value="${requestScope.address.user_id }" name="address.user_id" id="addressId" />

				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
							收件人姓名：
						</td>
						<td>
							<input type="text" value="${requestScope.address.name }" class="text_input" name="address.name" id="receiveName" />
							<div class="text_left" id="nameValidMsg">
								<p>
									请填写有效的收件人姓名
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							收件人详细地址：
						</td>
						<td>
							<input type="text" value="${requestScope.address.local }" name="address.local" class="text_input" id="fullAddress" />
							<div class="text_left" id="addressValidMsg">
								<p>
									请填写有效的收件人的详细地址
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							邮政编码
						</td>
						<td>
							<input type="text" value="${requestScope.address.zip_code }" class="text_input" name="address.zip_code" id="postalCode" />
							<div class="text_left" id="codeValidMsg">
								<p>
									请填写有效的收件人的邮政编码
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							电话
						</td>
						<td>
							<input type="text" value="${requestScope.address.phone }" class="text_input" name="address.phone" id="phone" />
							<div class="text_left" id="phoneValidMsg">
								<p>
									请填写有效的收件人的电话
								</p>
							</div>
						</td>
					</tr>
					
				</table>

				<div class="login_in">
					<a href="order_info.jsp">
						<input id="btnClientRegister" class="button_1" name="submit" type="submit" value="取消" />
					</a>			
				<input id="btnClientRegister" class="button_1" name="submit" type="submit" value="下一步" />
				</div>
			</form>
		</div>
		<%@include file="/front/common/foot1.jsp"%>
		
		<script type="text/javaScript">
			function test(id){
				var value = $("#address").prop("value");
				console.log(value);
				window.location.href="${pageContext.request.contextPath }/address/selectAddress?addressid="+value+"&id="+id;
			};
		</script>
	</body>
</html>

