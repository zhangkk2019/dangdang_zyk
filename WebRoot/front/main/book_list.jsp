<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	
<title>当当图书 – 全球最大的中文网上书店</title>
<link href="${pageContext.request.contextPath }/front/css/book.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/front/css/second.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath }/front/css/secBook_Show.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/front/css/list.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/front/js/prototype-1.6.0.3.js"></script>
	
	
</head>

<body>
	&nbsp;

	<!-- 头部开始 -->
	<%@include file="/front/common/head.jsp"%>
	<!-- 头部结束 -->

	<div style="width: 962px; margin: auto;">
		<a href="#"><img
			src="${pageContext.request.contextPath }/front/images/default/book_banner_081203.jpg"
			border="0" /> </a>
	</div>
	<div class='your_position'>
		您现在的位置:&nbsp; <a href='${pageContext.request.contextPath }/user/main'>当当图书
		</a> &gt; <font style='color: #cc3300'><strong>小说</strong> </font>
	</div>

	<div class="book">

		<!--左栏开始-->
		<div id="left" class="book_left">
			<div id="__fenleiliulan">
				<div class=second_l_border2>
					<h2>分类浏览</h2>
					<ul>
						<li>
							<div>
								<div class=second_fenlei>
									&middot;全部&nbsp;(23)
								</div>
							</div>
						</li>
						<div class="clear"></div>

						<!-- if(sid==cate.id){
									
								} -->

						<!--2级分类开始-->
						<c:forEach items="${category.cateList }" var="cate">
							<li>
								<div>
									<div class=second_fenlei>&middot;</div>
									<div class=second_fenlei>
										<a href="#">${cate.name }名字&nbsp;(10)</a>
									</div>
								</div>
							</li>
							<div class="clear"></div>
						</c:forEach>
						<!--2级分类结束-->

						<li>
							<div></div>
						</li>
					</ul>
				</div>
			</div>
		</div>

		<!--左栏结束-->

		<!--中栏开始-->
		<div class="book_center">

			<!--图书列表开始-->
			<div id="divRight" class="list_right">

				<div id="book_list" class="list_r_title">
					<div class="list_r_title_text">排序方式</div>
					<select onchange='' name='select_order' size='1'
						class='list_r_title_ml'>
						<option value="">按上架时间 降序</option>
					</select>
					<div id="divTopPageNavi" class="list_r_title_text3">

						<!--分页导航开始-->

							<c:if test="${pageNum>1 }">
								<div class='list_r_title_text3a'>
									<a name=link_page_next href="${pageContext.request.contextPath }/user/selectSecondPage?fid=${fid }&sid=${sid }&pageNum=1">
									<img src='${pageContext.request.contextPath }/front/images/page_up.gif' /> 
									</a>
								</div>
		
								<div class='list_r_title_text3a'>
									<a name=link_page_next href="${pageContext.request.contextPath }/user/selectSecondPage?fid=${fid }&sid=${sid }&pageNum=${pageNum-1}">
									<img src='${pageContext.request.contextPath }/front/images/page_up.gif' />
									</a>
								</div>
							</c:if>
							
							<c:if test="${pageNum<=1 }">
								<div class='list_r_title_text3a'>
									<img src='${pageContext.request.contextPath }/front/images/page_up_gray.gif' /> 
								</div>
	
								<div class='list_r_title_text3a'>
									<img src='${pageContext.request.contextPath }/front/images/page_up_gray.gif' />
								</div>
							</c:if>
							
				
							<div class='list_r_title_text3b'>
								第${pageNum }页/共${total }页
							</div>
							
							<c:if test="${pageNum<total }">
								<div class='list_r_title_text3a'>
								<a name=link_page_next href="${pageContext.request.contextPath }/user/selectSecondPage?fid=${fid }&sid=${sid }&pageNum=${pageNum+1}">
									<img src='${pageContext.request.contextPath }/front/images/page_down.gif' /> 
								</a>
								</div>
				
								<div class='list_r_title_text3a'>
									<a name=link_page_next href="${pageContext.request.contextPath }/user/selectSecondPage?fid=${fid }&sid=${sid }&pageNum=${total}">
									<img src='${pageContext.request.contextPath }/front/images/page_down.gif' />
									</a>
								</div>
							</c:if>
							
							<c:if test="${pageNum>=total }">
								<div class='list_r_title_text3a'>
									<img src='${pageContext.request.contextPath }/front/images/page_down_gray.gif' />
								</div>
				
								<div class='list_r_title_text3a'>
									<img src='${pageContext.request.contextPath }/front/images/page_down_gray.gif' />
								</div>
							</c:if>
						<!--分页导航结束-->
					</div>
				</div>

				<!--商品条目开始-->

				<div class="list_r_line"></div>
				<c:forEach items="${books }" var="book">
					<div class="clear"></div>
					<div class="list_r_list">
						<span class="list_r_list_book"> <a name="link_prd_img"
							href='${pageContext.request.contextPath }/user/selectOneBook?bookId=${book.id}'> <img class="book_cover"  src="${pageContext.request.contextPath }/back/img/${book.cover}" />
						</a>
						</span>
						<h2>
							<a name="link_prd_name" href='${pageContext.request.contextPath }/user/selectOneBook?bookId=${book.id}'>${book.name }</a>
						</h2>
						<h3>顾客评分：100</h3>
						<h4 class="list_r_list_h4">
							作 者: <a href='#' name='作者'>${book.author }</a>
						</h4>
						<h4>
							出版社： <a href='#' name='出版社'>${book.press }</a>
						</h4>
						<h4>出版时间：${book.press_date }</h4>
						<h5>内容简介：${book.content_abstract }</h5>
						<div class="clear"></div>
						<h6>
							<span class="del">￥${book.price }</span> <span class="red">￥${book.dprice }</span>
							节省：￥${book.price-book.dprice }
						</h6>
						<span class="list_r_list_button"> <a href="${pageContext.request.contextPath }/cart/addCart?id=${book.id}"> <img
								src='${pageContext.request.contextPath }/front/images/buttom_goumai.gif' />
						</a> <span id="cartinfo"></span>
					</div>
					<div class="clear"></div>
				</c:forEach>
				<!--商品条目结束-->

				<div class="clear"></div>
				<div id="divBottomPageNavi" class="fanye_bottom"></div>

			</div>
			<!--图书列表结束-->

		</div>
		<!--中栏结束-->
		<div class="clear"></div>
	</div>

	<!--页尾开始 -->
	<%@include file="/front/common/foot.jsp"%>
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
