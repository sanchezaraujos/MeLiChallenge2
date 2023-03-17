package com.example.demo.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ResponseDto implements Serializable{
	private static final long serialVersionUID = 1535100379805778106L;
	
	private PositionDto position;
	private String message;
}
