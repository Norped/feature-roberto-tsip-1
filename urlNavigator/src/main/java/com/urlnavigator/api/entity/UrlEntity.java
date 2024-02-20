package com.urlnavigator.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="url")
public class UrlEntity implements Serializable {

	private static final long serialVersionUID = 6885273875156861311L;

	@Id
	@GeneratedValue
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(nullable=false, length=500)
	private String url;
	
	@Column(nullable=true, length=100)
	private String description;
	
	@Column(nullable=false, length=2)
	private String status;
	
}
