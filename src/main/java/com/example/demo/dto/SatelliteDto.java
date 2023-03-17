package com.example.demo.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SatelliteDto implements Serializable {
	private static final long serialVersionUID = 928865743810182747L;
	
	@NotNull
	private String name;
	@NotNull
	private Double distance;
	private List<String> message;
}
