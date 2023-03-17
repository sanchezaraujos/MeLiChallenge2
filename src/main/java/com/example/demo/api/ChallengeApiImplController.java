package com.example.demo.api;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.dto.RequestDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.service.IChallengeService;

@RestController
@RequestMapping("/challenge")
public class ChallengeApiImplController implements IChallengeApi{

	@Autowired
	IChallengeService service;

	@Override
	public ResponseEntity<ResponseDto> calcular(@Valid RequestDto request) {

		try {
			ResponseDto response = service.calcular(request);
			return ResponseEntity.ok(response);
			
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "parámetros incoherentes");
		}
	}

	@Override
	public ResponseEntity<ResponseDto> test() {

		try {
			ResponseDto response = service.calcular(new RequestDto());
			return ResponseEntity.ok(response);
			
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "parámetros incoherentes");
		}

	}


}
