package com.mx.mlibre.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.mlibre.mutants.beans.StatsVerify;
import com.mx.mlibre.mutants.commons.LetterSoup;
import com.mx.mlibre.mutants.commons.OperationUtils;
import com.mx.mlibre.repository.StatsDao;
import com.mx.mlibre.service.MutantsService;

@Service
public class MutantsServiceImpl implements MutantsService{
	
	@Autowired
	private StatsDao statsDao;

	@Override
	public boolean isMutant(String []dnaStr) {
		boolean isMutant = false;
		try {
			//Paso1. Valida object de entrada
			if (isValidArray(dnaStr)) {
				LetterSoup letterSoup = new LetterSoup(dnaStr);
				isMutant = letterSoup.getThereAreMutants();
				this.persistOperation(dnaStr, isMutant);
			} else {
				this.persistOperation(dnaStr, isMutant);
			}
		} catch (Exception e) {
			System.out.println("Error en proceso seleccion de mutantes:" + e.getMessage());
		}
		return isMutant;
	}
	
	public void persistOperation(String[] dna, boolean bndIsMutant) {
		StatsVerify sv = new StatsVerify();
		Integer bndRes = bndIsMutant == true ? 1 : 0;
		sv.setBndResultado(bndRes);
		sv.setCadenaPeticion(dna.toString());
		sv.setFechaCambio(new Date());
		statsDao.save(sv);
	}
	
	private boolean isValidArray(String []dnaStr) throws Exception {
		boolean bndIsOk = true;
		for (String adnCad : dnaStr) {
			boolean isvalidStr = OperationUtils.validStrFormat(adnCad);
			if (!isvalidStr) {
				bndIsOk = false;
				break;
			}
		}
		return bndIsOk;
	}

}
