package com.sample_project.AdminApp.dto;

import java.io.Serializable;

public class Response<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	private T data;
	private String code;
	private String description;

	public Response() {
		super();
	}

	public Response(T data, String code) {
		super();
		this.data = data;
		this.code = code;
	}

	public Response(T data, String code, String description) {
		super();
		this.data = data;
		this.code = code;
		this.description = description;
	}

	public Response(String code, String description, T data) {
		super();
		this.data = data;
		this.code = code;
		this.description = description;
	}

	public Response(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Response [data=" + data + ", code=" + code + ", description=" + description + "]";
	}

}
