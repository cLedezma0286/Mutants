package com.mx.mlibre.mutants.beans;

import java.io.Serializable;

import javax.persistence.Transient;

public class StatsResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Transient
	private Long countMutantDna;
	@Transient
	private Long countHumanDna;
	@Transient
	private Float ratio;
	
	public Long getCountMutantDna() {
		return countMutantDna;
	}
	public void setCountMutantDna(Long countMutantDna) {
		this.countMutantDna = countMutantDna;
	}
	public Long getCountHumanDna() {
		return countHumanDna;
	}
	public void setCountHumanDna(Long countHumanDna) {
		this.countHumanDna = countHumanDna;
	}
	public Float getRatio() {
		return ratio;
	}
	public void setRatio(Float ratio) {
		this.ratio = ratio;
	}
	
	
}
