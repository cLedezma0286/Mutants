package com.mx.mlibre.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.mlibre.mutants.beans.StatsResponse;
import com.mx.mlibre.mutants.beans.StatsVerify;
import com.mx.mlibre.repository.StatsDao;
import com.mx.mlibre.service.StatsService;

@Service
public class StatsServiceImpl implements StatsService{
	
	private final Integer TYPE_HUMAN = 0;
	private final Integer TYPE_MUTANT = 1;

	@Autowired
	private StatsDao statsDao;
	
	@Override
	public List<StatsVerify> findAll() {
		return (List<StatsVerify>) statsDao.findAll();
	}

	@Override
	public StatsResponse findStatsByDate(Date date) {
		StatsResponse sResponse = new StatsResponse();
		Long numHum = statsDao.getHumansNumberD(date);
		Long numMut = statsDao.getMutantsNumberD(date);
		sResponse.setCountHumanDna(numHum);
		sResponse.setCountMutantDna(numMut);
		sResponse.setRatio(this.getRatio(numHum, numMut));
		return sResponse;
	}

	@Override
	public StatsResponse findStats() {
		StatsResponse sResponse = new StatsResponse();
		Long numHum = statsDao.getResNumber(TYPE_HUMAN);
		Long numMut = statsDao.getResNumber(TYPE_MUTANT);
		sResponse.setCountHumanDna(numHum);
		sResponse.setCountMutantDna(numMut);
		sResponse.setRatio(this.getRatio(numHum, numMut));
		return sResponse;
	}
	
	public float getRatio(Long numHuman, Long numMutant) {
		float percent = 0.0f;
		if (numHuman > numMutant) {
			percent = (float)(numMutant.floatValue()/numHuman.floatValue());
			System.out.println("Ratio: " + percent);
		}
		return percent;
	}
}
