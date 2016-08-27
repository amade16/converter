package mz.com.cedsif.converter.models;

import java.util.ArrayList;

public enum Romano {
	
	I (1,3,criar_lista_de_caracteres_validos("VXLCDM")), 
	V (5,1,criar_lista_de_caracteres_validos("I")), 
	X (10,3,criar_lista_de_caracteres_validos("I")), 
	L (50,1,criar_lista_de_caracteres_validos("X")), 
	C (100,3,criar_lista_de_caracteres_validos("X")), 
	D (500,1,criar_lista_de_caracteres_validos("C")), 
	M (1000,3,criar_lista_de_caracteres_validos("C"));

	private int arabico_correspondente;
	private int ocorrencia_maxima;
	private ArrayList <Character> romanos_antecedentes_validos;
	
	private Romano(int arabico_correspondente, int ocorrencia_maxima, ArrayList <Character> romanos_antecedentes_validos) {
		this.arabico_correspondente=arabico_correspondente;
		this.ocorrencia_maxima=ocorrencia_maxima;	
		this.romanos_antecedentes_validos=romanos_antecedentes_validos;
	}
	
	private static ArrayList<Character> criar_lista_de_caracteres_validos(String caracteres_validos) {
		ArrayList <Character> lista_de_caracteres_validos=new ArrayList<Character>();
		for(int i=0;i<caracteres_validos.length();i++) {
			lista_de_caracteres_validos.add(caracteres_validos.charAt(i));
		}
		return lista_de_caracteres_validos;
	}

	public int getArabicoCorrespondente() {
		return arabico_correspondente;
	}

	public int getOcorrenciaMaxima() {
		return ocorrencia_maxima;
	}

	public ArrayList<Character> getRomanosAntecedentesValidos() {
		return romanos_antecedentes_validos;
	}
	
	
}