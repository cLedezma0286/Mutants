package com.mx.mlibre.mutants.commons;

import java.util.regex.Pattern;

public class OperationUtils {
	public static boolean validStrFormat(String wordToVal) throws Exception {
		boolean bndIsValid = false;
		if (wordToVal == null || wordToVal.length() != 6) {
			throw new Exception("El tamaño de la cadena es direfente de 6 o es nulo.");
		}
		bndIsValid = Pattern.compile("^[(A)(T)(C)(G)]*").matcher(wordToVal).matches();
		return bndIsValid;
	}
}
