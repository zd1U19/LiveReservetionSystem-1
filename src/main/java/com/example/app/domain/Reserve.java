package com.example.app.domain;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Reserve {

	private Integer reserveId;

	@NotBlank
	@Size(max = 45)
	private String name;

	@NotBlank
	@Size(max = 60)
	private String email;
	
	@NotBlank
	@Size(max = 20)
	private String phone;	

	private int liveId;

	@Size(max = 200)
	private String note;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime reservedAt;

}
