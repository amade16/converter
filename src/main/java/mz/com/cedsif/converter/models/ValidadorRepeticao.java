package mz.com.cedsif.converter.models;

import java.util.ArrayList;

public class ValidadorRepeticao implements Validador{
	
	@Override
	public void valida(String valor_por_converter) {
		for (int i = 0; i < valor_por_converter.length(); i++) {
			char caracter_actual = valor_por_converter.charAt(i);
			if(validarNumeroMaximoDeOcorrencias(caracter_actual)) {
				if (excedeuOcorrencias(valor_por_converter,caracter_actual)) {
					throw new IllegalArgumentException("Erro! Repetições inválidas! "+valor_por_converter.charAt(i));
				}
			}
		}
	}

	private boolean excedeuOcorrencias(String valor_por_converter, char caracter_actual) {
		int contador_ocorrencias = 0;
		int ocorrencia_maxima = getNumeroMaximoDeOcorrencias(caracter_actual);

		for (int i = 0; i < valor_por_converter.length(); i++) {
			if (valor_por_converter.charAt(i) == caracter_actual) {
				contador_ocorrencias++;
			}
			if (contador_ocorrencias > ocorrencia_maxima) {
				return true;
			}
		}
		return false;
	}
	
	private int getNumeroMaximoDeOcorrencias(Character caracter_actual) {
		return Romano.valueOf(caracter_actual+"").getNumeroMaximoDeOcorrencias();
	}
	
	private boolean validarNumeroMaximoDeOcorrencias(Character caracter_actual) {
		return Romano.valueOf(caracter_actual+"").validarNumeroMaximoDeOcorrencias();
	}

}
