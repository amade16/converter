package mz.com.cedsif.converter.models;

import java.util.ArrayList;

public class ValidadorAntecedente implements Validador {

	@Override
	public void valida(String valor_por_converter) {

		
		
		for(int i=0;i<valor_por_converter.length();i++) {
			char caracter_actual=valor_por_converter.charAt(i);
			int arabico_correspondente_actual=Romano.valueOf(caracter_actual+"").getArabicoCorrespondente();
			//PENSAR EM MUDAR A BUSCA DE ARABICOS!
			ArrayList <Character> caracteres_permitidos = getCaracteresPermitidos(caracter_actual);
			
			if(i-1>=0) {
				int arabico_correspondente_anterior=Romano.valueOf(valor_por_converter.charAt(i-1)+"").getArabicoCorrespondente();
			
				if(arabico_correspondente_anterior<arabico_correspondente_actual
				   && 
				   !caracteres_permitidos.contains(valor_por_converter.charAt(i-1))) {
					throw new IllegalArgumentException("Erro! Antecedentes Ilegais!");
				}
			}
		}
	}
	
	private ArrayList<Character> getCaracteresPermitidos(Character caracter_actual) {
		return Romano.valueOf(caracter_actual+"").getRomanosAntecedentesValidos();
	}
	
	
}
