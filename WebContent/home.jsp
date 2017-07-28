<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>电影天堂爬虫</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.min.js"></script>
<link href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<h2><p class="text-center">电影天堂爬虫程序</p></h2>
	<br><br>
	<div class="btn-group btn-group-justified" role="group" aria-label="...">
	  <div class="btn-group" role="group">
	    <button type="button" class="btn btn-primary">
	    	<a href="${pageContext.request.contextPath}/getMovie?type=latest" style="color: white;" >
	    		<font size="4px">最新上架电影</font>
	    	</a>
	    </button>
	  </div>
	  <div class="btn-group" role="group">
	    <button type="button" class="btn btn-primary">
	    	<a href="${pageContext.request.contextPath}/getMovie?type=china" style="color: white;" >
	    		<font size="4px">国内最新电影</font>
			</a>
	    </button>
	  </div>
	  <div class="btn-group" role="group">
	    <button type="button" class="btn btn-primary">
	    	<a href="${pageContext.request.contextPath}/getMovie?type=oumei" style="color: white;" >
	    		<font size="4px">欧美最新电影</font>
	    	</a>
	    </button>
	  </div>
	  <div class="btn-group" role="group">
	    <button type="button" class="btn btn-primary">
	    	<a href="http://www.ygdy8.net/" style="color: white;" >
	    		<font size="4px">访问电影天堂网站</font>
	    	</a>
	    </button>
	  </div>
	</div>

	<c:if test="${requestScope.movies!=null }">
		<table class="table table-hover">
			<tr>
				<td style="font-size: 18px;text-align: center;">序号</td>
				<td style="font-size: 18px;text-align: center;">电影名</td>
				<td style="font-size: 18px;text-align: center;">下载地址</td>
				<td style="font-size: 18px;text-align: center;">上架时间</td>
			</tr>
			<c:forEach items="${requestScope.movies }" var="movie" varStatus="index">
				<tr>	
					<td style="font-size: 15px;width: 50px;"><p class="text-center">${index.count}</p></td>
					<td style="font-size: 15px;width: 300px;"><p class="text-center"><a href="${movie.url}">${movie.name}</a></p></td>
					<td style="font-size: 15px;width: 300px;">${movie.downloadUrl}</td>
					<td style="font-size: 15px;width: 100px;"><p class="text-center">${movie.time}</p></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>