package com.example.demo.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;

import com.example.demo.dto.RequestDto;
import com.example.demo.dto.ResponseDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "IChallengeApi", tags = { "Api para consultar el resultado de la trilaterización" })
public interface IChallengeApi {

	@ApiOperation(value = "Consultar el resultado de la trilaterización", 
			response = ResponseDto.class)
	@PostMapping(value = "/top-secret", produces = { "application/json" })
	ResponseEntity<ResponseDto> calcular(@RequestBody @Valid RequestDto request);
	
	@ApiOperation(value = "Método de prueba", 
			response = ResponseDto.class)
	@PostMapping(value = "/test", produces = { "application/json" })
	ResponseEntity<ResponseDto> test();
}
