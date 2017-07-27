package com.guduke.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import com.guduke.entity.MovieInfo;

public class InfoTools {

	//获取国内及欧美最新的电影
	public List<MovieInfo> getMovies(String address) throws IOException{
		List<MovieInfo> list = new ArrayList<>();
		Document document = Jsoup.connect(address).get();
		//获取影片对应的table元素
		Elements select = document.select("table[class='tbspan']");
		for (int i = 0; i < select.size(); i++) {
			//获取影片地址
			String url = select.get(i).select("a:eq(1)").attr("href");
			//获取影片下载地址
			url = getDownloadUrl(url);
			//获取发布时间
			String time = select.get(i).select("tr").eq(2).select("td:eq(1)").text();
			time = time.substring(3, time.indexOf(" "));
			//获取影片名
			String name = select.get(i).select("a:eq(1)").text();
			MovieInfo movieInfo = new MovieInfo(i, name, url, time);
			list.add(movieInfo);
		}
		return list;
	}
	
	//获取影片的实际下载地址
	public String getDownloadUrl(String url) throws IOException{
		url = "http://www.ygdy8.net/"+url;
		Document doc = Jsoup.connect(url).get();
		//获取所有的a元素
		Elements elements = doc.select("a");
		for (int i = 0; i < elements.size(); i++) {
			//判断a标签的href属性是否包含“ftp”字符串
			if(elements.get(i).attr("href").contains("ftp")){
				String downloadUrl = elements.get(i).attr("href");
				return downloadUrl;
			}
		}
		return null;
	}
	
	//获取电影天堂首页最新的电影
	public List<MovieInfo> getLatestMovie(String address) throws IOException{
		List<MovieInfo> list = new ArrayList<>();
		Document doc = Jsoup.connect(address).get();
		//获取影片对应位置的tr 
		Elements select = doc.select("table").eq(1).select("tr");
		for (int i = 0; i < select.size(); i++) {
			String url = select.get(i).select("a:eq(1)").attr("href");
			url = getDownloadUrl(url);
			String name = select.get(i).select("a:eq(1)").text();
			String time = select.get(i).select("td:eq(1)").text();
			MovieInfo movieInfo = new MovieInfo(i, name, url, time);
			list.add(movieInfo);
		}
		return list;	
	}
}
