package com.mx.mlibre.mutants.beans;

import java.util.Arrays;

public class DnaTypesDto {
	private String[] dna;

	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}

	@Override
	public String toString() {
		return "DnaTypesDto [dna=" + Arrays.toString(dna) + "]";
	}
}
