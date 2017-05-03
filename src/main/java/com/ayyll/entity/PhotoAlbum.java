package com.ayyll.entity;

import java.sql.Timestamp;

public class PhotoAlbum {
	private int id;
	private int user_id;
	private String name;
	private String description;
	private Timestamp create_time;
	
	public PhotoAlbum() {
		super();
	}
	
	public PhotoAlbum(int user_id, String name, String description,
			Timestamp create_time) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.description = description;
		this.create_time = create_time;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	@Override
	public String toString() {
		return "PhotoAlbum [id=" + id + ", user_id=" + user_id + ", name="
				+ name + ", description=" + description + ", create_time="
				+ create_time + "]\n";
	}
	
	
}
