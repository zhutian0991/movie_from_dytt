package com.guduke.entity;

public class MovieInfo {
	private int id;
	private String name;
	private String url;
	private String time;
	private String downloadUrl;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDownloadUrl() {
		return downloadUrl;
	}
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}
	public MovieInfo(int id, String name, String url, String time, String downloadUrl) {
		this.id = id;
		this.name = name;
		this.url = url;
		this.time = time;
		this.downloadUrl = downloadUrl;
	}
	public MovieInfo() {
		
	}
}
