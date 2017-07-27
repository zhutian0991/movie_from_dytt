package com.guduke.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guduke.entity.MovieInfo;
import com.guduke.service.MovieService;

public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieService movieService = new MovieService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取请求参数
		String type = request.getParameter("type");
		//获取电影集合
		List<MovieInfo> movies = movieService.getMovie(type);
		//若获取的电影集合为空时，重定向到错误页面
		if(movies==null||movies.isEmpty()){
			response.sendRedirect("error.jsp");
			return;
		}
		//设置请求域属性
		request.setAttribute("movies", movies);
		//转发到首页
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
