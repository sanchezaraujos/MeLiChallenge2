package com.example.demo.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionDto implements Serializable{
	private static final long serialVersionUID = -3928222184299508084L;
	
	@JsonProperty("x")
	private Double xPosition;
	@JsonProperty("y")
	private Double yPosition;

}
