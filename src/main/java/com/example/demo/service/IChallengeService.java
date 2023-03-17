package com.example.demo.service;

import com.example.demo.dto.RequestDto;
import com.example.demo.dto.ResponseDto;

public interface IChallengeService {
	
	public ResponseDto calcular(RequestDto request);
}
