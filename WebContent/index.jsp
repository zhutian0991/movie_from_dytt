<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>电影天堂爬虫</title>
</head>
<body>
	<h1 style="text-align: center;">电影天堂爬虫程序</h1>
	<a style="color:red;font-size: 20px" href="${pageContext.request.contextPath}/getMovie?type=latest">获取最新上架电影</a>
	<a style="color:red;font-size: 20px;padding-left: 200px;" href="${pageContext.request.contextPath}/getMovie?type=china">获取国内最新电影</a>
	<a style="color:red;font-size: 20px;padding-left: 200px;" href="${pageContext.request.contextPath}/getMovie?type=oumei">获取欧美最新电影</a>
	<a style="color:red;font-size: 20px;padding-left: 200px;" href="http://www.ygdy8.net/">访问电影天堂网站</a>
	<br><br>
	<c:if test="${requestScope.movies!=null }">
		<hr>
		<table border="1" cellpadding="1" cellspacing="0">
			<tr>
				<td style="text-align: center;">序号</td>
				<td style="text-align: center;">电影名</td>
				<td style="text-align: center;">下载地址</td>
				<td style="text-align: center;">上架时间</td>
			</tr>
			<c:forEach items="${requestScope.movies }" var="movie" varStatus="index">
				<tr>	
					<td style="font-size: 15px">${index.count}</td>
					<td style="font-size: 15px">${movie.name}</td>
					<td style="font-size: 15px"><a href="${movie.url}">${movie.url}</a></td>
					<td style="font-size: 15px">${movie.time}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>