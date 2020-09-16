<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<html>
	<head>
		<title>图书详情</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/front/css/book_detail.css"/>
		<link href="${pageContext.request.contextPath }/front/css/public_footer.css" rel="stylesheet" type="text/css" />

	</head>
	<body>
		<br/>
		<div>
			<h1>
				丛书名：${book.name }
			</h1>
			<hr/>
		</div>
		<table width="80%" border="0" align="center" cellspacing="0" cellpadding="5">
			<tr>
				<td rowspan="9" width="20%" valign="top"><img src="${pageContext.request.contextPath }/back/img/${book.cover}" width="240px" height="340px" /></td>
				<td colspan="2">作者：${book.author }></td>
			</tr>
			<tr>
				<td colspan="2">出版社：${book.press }</td>
			</tr>
			<tr>
				<td>出版时间：${book.press_date } </td>
				<td>字数：${book.word_num}</td>
			</tr>
			<tr>
				<td>版次：${book.edition }</td>
				<td>页数：${book.page_num }</td>
			</tr>
			<tr>
				<td>印刷时间：${book.print_date }</td>
				<td>开本：${book.size }</td>
			</tr>
			<tr>
				<td>印次：${book.impression }</td>
				<td>纸张：${book.paper }</td>
			</tr>
			<tr>
				<td>ISBN：${book.isbn }</td>
				<td>包装：${book.pack }</td>
			</tr>
			<tr>
				<td colspan="2">定价：￥${book.price }&nbsp;&nbsp;&nbsp;&nbsp;
				<font color="red">当当价：￥${book.dprice }</font>&nbsp;&nbsp;&nbsp;&nbsp;
				节省：￥${book.price-book.dprice }</td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="${pageContext.request.contextPath }/cart/addCart?id=${book.id}">
						<img src='${pageContext.request.contextPath }/front/images/buttom_goumai.gif' />
					</a>
				</td>
			</tr>
		</table>
		<hr style="border:1px dotted #666"/>
		<h2>编辑推荐:${book.editor_recommend }</h2>
		<p>&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>内容简介:${book.content_abstract }</h2>
		<p>&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>作者简介:${book.author_abstract }</h2>
		<p>&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>目录:${book.director }</h2>
		<p>&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>媒体评论:${book.media_commentary }</h2>
		<p>&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>书摘插图:</h2>
		<p>&nbsp;&nbsp;</p>
		<!--页尾开始 -->
		<div class="public_footer">
			<div class="public_footer_bottom">
				<div class="public_footer_icp" style="line-height: 48px;">
					Copyright (C) 当当网 2004-2008, All Rights Reserved
					<a href="#" target="_blank"><img class="book_cover" src="${pageContext.request.contextPath }/front/images/bottom/validate.gif" border="0" align="middle" /> </a>
					<a href="#" target="_blank" style="color: #666;">京ICP证041189号</a>
				</div>
			</div>
		</div>
		<!--页尾结束 -->
		
		<script type="text/javascript"
	src="${pageContext.request.contextPath }/back/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".book_cover").mouseover(function(e) {//移入
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
	</body>
</html>
