package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.demo.dto.PositionDto;
import com.example.demo.dto.RequestDto;
import com.example.demo.dto.ResponseDto;

@Service
public class ChallengeServiceImpl implements IChallengeService {

	@Override
	public ResponseDto calcular(RequestDto request) {
		
		Double radioKenobi = request.getSatellites().stream()
				.filter(sat -> sat.getName().equalsIgnoreCase("kenobi"))
				.findFirst().orElseThrow(NoSuchElementException::new).getDistance();
		
		Double radioSkywalker = request.getSatellites().stream()
				.filter(sat -> sat.getName().equalsIgnoreCase("skywalker"))
				.findFirst().orElseThrow(NoSuchElementException::new).getDistance();
		
		Double radioSato = request.getSatellites().stream()
				.filter(sat -> sat.getName().equalsIgnoreCase("sato"))
				.findFirst().orElseThrow(NoSuchElementException::new).getDistance();
		
		List<Double> xyProbables = this.triangular(radioKenobi, radioSkywalker);
		
		PositionDto pareja1 = new PositionDto(xyProbables.get(0), xyProbables.get(1));
		PositionDto pareja2 = new PositionDto(xyProbables.get(0), xyProbables.get(2));
		
		PositionDto positionResponse = new PositionDto();
		
		Double radioPosible1 = Math.hypot(500 - pareja1.getXPosition(), 
				100 - pareja1.getYPosition());
		
		Double radioPosible2 = Math.hypot(500 - pareja2.getXPosition(), 
				100 - pareja2.getYPosition());
		
		if (Math.abs(radioPosible1 - radioSato) < 1 ) {
			
			positionResponse.setXPosition(pareja1.getXPosition());
			positionResponse.setYPosition(pareja1.getYPosition());
			
		} else if (Math.abs(radioPosible2 - radioSato) < 1 ) {
			
			positionResponse.setXPosition(pareja2.getXPosition());
			positionResponse.setYPosition(pareja2.getYPosition());
			
		} else {
			throw new NoSuchElementException("No son datos coherentes");
		}
		
		ResponseDto response = new ResponseDto();
		response.setPosition(positionResponse);
		response.setMessage("Caso de prueba");

		return response;
	}
	
	public List<Double> triangular(Double radioKenobi, Double radioSkywalker) {
		
		Double l = 608.276;
		Double d1 = radioKenobi;
		Double d2 = radioSkywalker;

		Double x0 = -500 + (Math.pow(d1, 2) - Math.pow(d2, 2) + Math.pow(l, 2)) / (2 * l);

		Double y0Bruto = Math.sqrt(Math.pow(d1, 2) - Math.pow(x0, 2));

		Double opcion1Y0 = -200 + y0Bruto;

		Double opcion2Y0 = -200 + (y0Bruto * -1);

		List<Double> lista = new ArrayList<>();
		lista.add(x0);
		lista.add(opcion1Y0);
		lista.add(opcion2Y0);

		return lista;
	}

}
