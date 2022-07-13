package com.mx.mlibre.mutants.commons;

public class LetterSoup {
	private char sopa[][] = null;
	private String[] palabras = {"GGGG","AAAA","CCCC","TTTT"};
	private int[] sitio = new int[]{-1, -1, -1};
	private boolean thereAreMutants= false;
	
	public LetterSoup() {
		super();
	}
	public LetterSoup(String []dnaStr) {
		this.onInitTransform(dnaStr);
		char[][] sopaFinal = this.resolver();
		this.mostrar(sopaFinal);
	}

	public void onInitTransform(String []dnaStr){
		int rowsZize = dnaStr.length;
		this.sopa = new char[rowsZize][6];
		
		for (int i = 0; i < dnaStr.length; i++) {
			char [] singleCharSeq = dnaStr[i].toCharArray();
			for (int j = 0; j < 6 ; j++) {
				this.sopa[i][j] = singleCharSeq[j];
			}
		}
	}
	
	
	public int[] buscar(String palabra) {
	    for (int fila = 0; fila < sopa.length; fila++) {
	        for (int columna = 0; columna < sopa[fila].length; columna++) {

	            // busca derecha
	            if (columna + (palabra.length() - 1) < sopa[fila].length) {
	                boolean encontrada = true;

	                for (int letras = 0; letras < palabra.length(); letras++) {
	                    if (palabra.charAt(letras) != sopa[fila][columna + letras]) {
	                        encontrada = false;
	                        break;
	                    }
	                }
	                if (encontrada) {
	                    sitio[0] = fila;
	                    sitio[1] = columna;
	                    sitio[2] = 2;
	                }
	            }

	            // busca izquierda
	            if (columna - (palabra.length() - 1) >= 0) {
	                boolean encontrada = true;

	                for (int letras = 0; letras < palabra.length(); letras++) {
	                    if (palabra.charAt(letras) != sopa[fila][columna - letras]) {
	                        encontrada = false;
	                        break;
	                    }
	                }
	                if (encontrada) {
	                    sitio[0] = fila;
	                    sitio[1] = columna;
	                    sitio[2] = 6;
	                }
	            }

	            // busca abajo
	            if (fila + (palabra.length() - 1) < sopa.length) {
	                boolean encontrada = true;

	                for (int letras = 0; letras < palabra.length(); letras++) {
	                    if (palabra.charAt(letras) != sopa[fila + letras][columna]) {
	                        encontrada = false;
	                        break;
	                    }
	                }
	                if (encontrada) {
	                    sitio[0] = fila;
	                    sitio[1] = columna;
	                    sitio[2] = 4;
	                }
	            }

	            // busca arriba
	            if (fila - (palabra.length() - 1) >= 0) {
	                boolean encontrada = true;

	                for (int letras = 0; letras < palabra.length(); letras++) {
	                    if (palabra.charAt(letras) != sopa[fila - letras][columna]) {
	                        encontrada = false;
	                        break;
	                    }
	                }
	                if (encontrada) {
	                    sitio[0] = fila;
	                    sitio[1] = columna;
	                    sitio[2] = 0;
	                }
	            }

	            // diagonal arriba derecha
	            if ((fila - (palabra.length() - 1) >= 0) && (columna + (palabra.length() - 1) < sopa[fila].length)) {
	                boolean encontrada = true;

	                for (int letras = 0; letras < palabra.length(); letras++) {
	                    if (palabra.charAt(letras) != sopa[fila - letras][columna + letras]) {
	                        encontrada = false;
	                        break;
	                    }
	                }
	                if (encontrada) {
	                    sitio[0] = fila;
	                    sitio[1] = columna;
	                    sitio[2] = 1;
	                }
	            }
	            //

	            // diagonal arriba izquierda
	            if ((fila - (palabra.length() - 1) >= 0) && (columna - (palabra.length() - 1) >= 0)) {
	                boolean encontrada = true;

	                for (int letras = 0; letras < palabra.length(); letras++) {
	                    if (palabra.charAt(letras) != sopa[fila - letras][columna - letras]) {
	                        encontrada = false;
	                        break;
	                    }
	                }
	                if (encontrada) {
	                    sitio[0] = fila;
	                    sitio[1] = columna;
	                    sitio[2] = 7;
	                }
	            }

	            // diagonal abajo derecha
	            if ((fila + (palabra.length() - 1) < sopa.length) && (columna + (palabra.length() - 1) <= sopa[fila].length)) {
	                boolean encontrada = true;

	                for (int letras = 0; letras < palabra.length(); letras++) {
	                    if (palabra.charAt(letras) != sopa[fila + letras][columna + letras]) {
	                        encontrada = false;
	                        break;
	                    }
	                }
	                if (encontrada) {
	                    sitio[0] = fila;
	                    sitio[1] = columna;
	                    sitio[2] = 3;
	                }
	            }

	            // diagonal abajo izquierda
	            if ((fila + (palabra.length() - 1) < sopa.length) && (columna - (palabra.length() - 1) >= 0)) {
	                boolean encontrada = true;

	                for (int letras = 0; letras < palabra.length(); letras++) {
	                    if (palabra.charAt(letras) != sopa[fila + letras][columna - letras]) {
	                        encontrada = false;
	                        break;
	                    }
	                }
	                if (encontrada) {
	                    sitio[0] = fila;
	                    sitio[1] = columna;
	                    sitio[2] = 5;
	                }
	            }

	        }
	    }

	    return sitio;
	}
	
	
	public char[][] resolver() {
	    char[][] sopablanca = sopa;
	    char[][] sopabuena = new char[sopablanca.length][sopablanca[0].length];
	    boolean[][] valido = new boolean[sopa.length][sopa[0].length];

	    for (int i = 0; i < sopablanca.length; i++) {
	        for (int j = 0; j < sopablanca[i].length; j++) {
	            valido[i][j] = false;
	        }
	    }
	    for (int i = 0; i < palabras.length; i++) {
	        int[] dato = buscar(palabras[i]);
	        int fila = dato[0];
	        int columna = dato[1];
	        int direccion = dato[2];
	        switch (direccion) {
	            case 0:
	                for (int j = 0; j < palabras[i].length(); j++) {
	                    valido[fila][columna] = true;
	                    fila--;
	                }
	                break;
	            case 1:
	                for (int j = 0; j < palabras[i].length(); j++) {
	                    valido[fila][columna] = true;
	                    fila--;
	                    columna++;
	                }
	                break;
	            case 2:
	                for (int j = 0; j < palabras[i].length(); j++) {
	                    valido[fila][columna] = true;
	                    columna++;
	                }
	                break;
	            case 3:
	                for (int j = 0; j < palabras[i].length(); j++) {
	                    valido[fila][columna] = true;
	                    fila++;
	                    columna++;
	                }
	                break;
	            case 4:
	                for (int j = 0; j < palabras[i].length(); j++) {
	                    valido[fila][columna] = true;
	                    fila++;
	                }
	                break;
	            case 5:
	                for (int j = 0; j < palabras[i].length(); j++) {
	                    valido[fila][columna] = true;
	                    columna--;
	                    fila++;
	                }
	                break;
	            case 6:
	                for (int j = 0; j < palabras[i].length(); j++) {
	                    valido[fila][columna] = true;
	                    columna--;
	                }
	                break;
	            case 7:
	                for (int j = 0; j < palabras[i].length(); j++) {
	                    valido[fila][columna] = true;
	                    fila--;
	                    columna--;
	                }
	                break;
	        }
	    }
	    StringBuilder findedWordA = new StringBuilder();
	    StringBuilder findedWordC = new StringBuilder();
	    StringBuilder findedWordG = new StringBuilder();
	    StringBuilder findedWordT = new StringBuilder();
	    for (int i = 0; i < sopablanca.length; i++) {
	        for (int j = 0; j < sopablanca[i].length; j++) {
	            if (valido[i][j] == true) {
	               char charFinded = sopablanca[i][j];
//	               sopabuena[i][j] = sopablanca[i][j];
	               sopabuena[i][j] = charFinded;
	               switch (charFinded) {
					case 'A':
						findedWordA.append(charFinded);
						break;
					case 'C':
						findedWordC.append(charFinded);
						break;
					case 'G':
						findedWordG.append(charFinded);
						break;
					case 'T':
						findedWordT.append(charFinded);
						break;
					default:
						break;
					}
	            } else {
	                sopabuena[i][j] = ' ';
	            }
	        }
	    }
	    
	    if (findedWordA.length() == 4 ||findedWordC.length() == 4 ||
	    	findedWordG.length() == 4 ||findedWordT.length() == 4) {
			this.thereAreMutants = true;
		}
	    return sopabuena;
	}
	
	public void mostrar(char[][] sopa){
	    for (int i = 0 ; i<sopa.length;i++){
	        System.out.print("|");
	        for (int j = 0; j<sopa[0].length;j++){
	            if (j!=sopa[0].length){
	                System.out.print("\t" + sopa[i][j]);
	            }
	        }
	        System.out.println("|");
	    }
	}
	
	public char[][] getMatrizSopaDeLetras() {
		return sopa;
	}
	public void setMatrizSopaDeLetras(char[][] matrizSopaDeLetras) {
		this.sopa = matrizSopaDeLetras;
	}
	public boolean getThereAreMutants() {
		return thereAreMutants;
	}
	public void setThereAreMutants(boolean thereAreMutants) {
		this.thereAreMutants = thereAreMutants;
	}

}
