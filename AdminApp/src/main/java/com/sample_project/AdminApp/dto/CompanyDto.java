package com.sample_project.AdminApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CompanyDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	Long id;
	String name;
	String location;
}

