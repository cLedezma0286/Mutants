package com.mx.mlibre.mutants.controller;



import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mx.mlibre.mutants.beans.DnaTypesDto;
import com.mx.mlibre.mutants.beans.StatsResponse;
import com.mx.mlibre.mutants.beans.StatsVerify;
import com.mx.mlibre.service.MutantsService;
import com.mx.mlibre.service.StatsService;

@RestController
public class MutantsController {
	
	@Autowired
	private MutantsService mutantsService;
	
	@Autowired
	private StatsService statsService;
	
	@PostMapping("/mutant")
	@ResponseBody
	public boolean isMutant(@RequestBody DnaTypesDto dna, HttpServletResponse response) {
		boolean isMutant = false;
		isMutant = mutantsService.isMutant(dna.getDna());
		if (!isMutant) {
			response.setStatus(HttpStatus.FORBIDDEN.value());
		}
		return isMutant;
	}
	
	@PostMapping("/statsByDate")
	public StatsResponse getStatsByDate(){
		return statsService.findStatsByDate(new Date());
	}
	
	@PostMapping("/stats")
	public StatsResponse getStatsVerify(){
		return statsService.findStats();
	}
}
