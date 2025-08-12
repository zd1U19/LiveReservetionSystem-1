package com.example.app.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class Admin {

	private Integer adminId;
	
	@NotBlank
	@Size(max=20)
	private String loginId;
	
	@NotBlank
	@Size(max=60)
	private String loginPass;
}
