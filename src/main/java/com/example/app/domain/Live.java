package com.example.app.domain;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class Live {

	private Integer liveId;

	@NotBlank
	@Size(max = 60)
	private String liveName;

	@NotNull
	private LocalDateTime eventDate;

	@NotNull
	@Range(min = 0, max = 1000)
	private Integer capacity;

	@NotBlank
	@Size(max = 45)
	private String place;

	@Size(max = 255)
	private String address;

	private LocalDateTime createdAt;

}
