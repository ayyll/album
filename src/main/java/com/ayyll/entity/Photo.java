package com.ayyll.entity;

import java.sql.Timestamp;

public class Photo {
	private int id;
	private int user_id;
	private String type;
	private String url;
	private Timestamp create_time; 
	
	public Photo(int user_id, String type, String url, Timestamp create_time) {
		super();
		this.user_id = user_id;
		this.type = type;
		this.url = url;
		this.create_time = create_time;
	}

	public Timestamp getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	public Photo() {
		super();
	}

	public Photo(int user_id, String type, String url) {
		super();
		this.user_id = user_id;
		this.type = type;
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Photo [id=" + id + ", user_id=" + user_id + ", type=" + type
				+ ", url=" + url + ", create_time=" + create_time + "]";
	}
		
}
