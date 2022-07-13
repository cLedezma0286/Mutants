package com.mx.mlibre.service;

import java.util.Date;
import java.util.List;

import com.mx.mlibre.mutants.beans.StatsResponse;
import com.mx.mlibre.mutants.beans.StatsVerify;

public interface StatsService {
	List<StatsVerify> findAll();
	StatsResponse findStatsByDate(Date date);
	StatsResponse findStats();
}
