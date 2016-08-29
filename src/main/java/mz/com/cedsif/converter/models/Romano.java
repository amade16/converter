package mz.com.cedsif.converter.models;

import java.util.ArrayList;

public enum Romano {
	
	I (1,3,true,Integer.MAX_VALUE,false,criar_lista_de_caracteres_validos("IVXLCDM")),  //TODOS ESTES PODEM ESTAR ATRÁS DO I
	
	V (5,Integer.MAX_VALUE,false,1,true,criar_lista_de_caracteres_validos("I")), //ATRÁS DO V SÓ PODE TER I
	
	X (10,3,true,Integer.MAX_VALUE,false,criar_lista_de_caracteres_validos("IX")), //ATRÁS DO X SÓ PODE TER O I
	
	L (50,Integer.MAX_VALUE,false,1,true,criar_lista_de_caracteres_validos("XL")), //ATRÁS DO L SÓ PODE TER O X
	
	C (100,3,true,Integer.MAX_VALUE,false,criar_lista_de_caracteres_validos("XC")), //ATRÁS DO C SÓ PODE TER X
	
	D (500,Integer.MAX_VALUE,false,1,true,criar_lista_de_caracteres_validos("CD")), //ATRÁS DO D SÓ PODE TER C
	
	M (1000,3,true,Integer.MAX_VALUE,false,criar_lista_de_caracteres_validos("CM")); //ATRÁS DO M SÓ PODE TER C

	private int arabico_correspondente;
	
	private int limite_de_caracteres_em_sequencia;
	private boolean validar_limite_caracteres_em_sequencia;

	private int numero_maximo_de_ocorrencias;
	private boolean validar_numero_maximo_de_ocorrencias;
	
	private ArrayList <Character> romanos_antecedentes_validos;
	
	private Romano(int arabico_correspondente, int limite_de_caracteres_em_sequencia, boolean validar_limite_caracteres_em_sequencia,
			int numero_maximo_de_ocorrencias, boolean validar_numero_maximo_de_ocorrencias, ArrayList <Character> romanos_antecedentes_validos) {
		this.arabico_correspondente=arabico_correspondente;
		
		this.limite_de_caracteres_em_sequencia=limite_de_caracteres_em_sequencia;	
		this.validar_limite_caracteres_em_sequencia=validar_limite_caracteres_em_sequencia;
		
		this.numero_maximo_de_ocorrencias=numero_maximo_de_ocorrencias;
		
		this.validar_numero_maximo_de_ocorrencias=validar_numero_maximo_de_ocorrencias;
		
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

	public int getLimiteDeCaracteresEmSequencia() {
		return limite_de_caracteres_em_sequencia;
	}

	public boolean validarLimiteCaracteresEmSequencia() {
		return validar_limite_caracteres_em_sequencia;
	}

	public int getNumeroMaximoDeOcorrencias() {
		return numero_maximo_de_ocorrencias;
	}

	public boolean validarNumeroMaximoDeOcorrencias() {
		return validar_numero_maximo_de_ocorrencias;
	}

	public ArrayList<Character> getRomanosAntecedentesValidos() {
		return romanos_antecedentes_validos;
	}		
}