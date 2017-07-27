package com.guduke.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.guduke.entity.MovieInfo;
import com.guduke.util.InfoTools;

public class MovieService {

	private static final String LATEST = "http://www.ygdy8.net";
	private static final String CHINA = "http://www.ygdy8.net/html/gndy/china/index.html";
	private static final String OUMEI = "http://www.ygdy8.net/html/gndy/oumei/index.html";
	private InfoTools infoTools = new InfoTools();
	public List<MovieInfo> getMovie(String type) throws IOException{
		List<MovieInfo> movies = new ArrayList<>();
		String address = null;
		switch (type) {
		case "latest":
			address = MovieService.LATEST;
			movies = infoTools.getLatestMovie(address);
			break;
		case "china":
			address = MovieService.CHINA;
			movies = infoTools.getMovies(address);
			break;
		case "oumei":
			address = MovieService.OUMEI;
			movies = infoTools.getMovies(address);
			break;
		default:
			System.out.println("接受参数错误");
			break;
		}
		return movies;
	}
}
