package com.example.demo.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class RequestDto implements Serializable {
	private static final long serialVersionUID = 8596196304149677567L;
	
	private List<SatelliteDto> satellites;
	
}
