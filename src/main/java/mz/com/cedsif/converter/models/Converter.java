package mz.com.cedsif.converter.models;

import java.util.HashMap;

public class Converter {

	private String valor_por_converter;
	private Integer valor_convertido;

	public void setValorDesejado(String valor_por_converter) {
		this.valor_por_converter = valor_por_converter;
	}

	public String getValorDesejado() {
		return this.valor_por_converter;
	}

	public void setValorConvertido(int valor_convertido) {
		this.valor_convertido = valor_convertido;
	}

	public int getValorConvertido() {
		return this.valor_convertido;
	}

	public int converterArabicoRomano() {

		validarCaracteresInvalidos(this.valor_por_converter);

		validarRepeticao(this.valor_por_converter);

		validarAntecedentes(this.valor_por_converter);

		return resultadoConversao(this.valor_por_converter);
	}

	private void validarCaracteresInvalidos(String valor_por_converter) {

		for (int i = 0; i <= valor_por_converter.length() - 1; i++) {
			char caracter_actual = valor_por_converter.charAt(i); 
			if (getValidade(caracter_actual)) {
				throw new IllegalArgumentException("Erro! Caracteres inválidos!");
			}
		}
	}
	
	private boolean getValidade(char caracter_actual) {
		return Romano.values().equals(caracter_actual+"");
	}
	
	
	private void validarRepeticao(String valor_por_converter) {
		char[] caracteres_no_valor_por_converter = valor_por_converter.toCharArray();

		for (int i = 0; i < caracteres_no_valor_por_converter.length; i++) {
			if (excedeuOcorrencias(caracteres_no_valor_por_converter,caracteres_no_valor_por_converter[i])) {
				throw new IllegalArgumentException("Erro! Repetições inválidas!");
			}
		}
	}

	private boolean excedeuOcorrencias(char[] valor_por_converter_caracteres, char caracter_actual) {
		int contador_ocorrencias = 0;
		int ocorrencia_maxima = getOcorrenciaMaxima(caracter_actual);

		for (int i = 0; i < valor_por_converter_caracteres.length; i++) {
			if (valor_por_converter_caracteres[i] == caracter_actual) {
				contador_ocorrencias++;
			}
			if (contador_ocorrencias > ocorrencia_maxima) {
				return true;
			}
		}
		return false;
	}
	
	private int getOcorrenciaMaxima(Character caracter_actual) {
		return Romano.valueOf(caracter_actual+"").getOcorrenciaMaxima();
	}
	
	private void validarAntecedentes(String valor_por_converter) {
		
	}
	
	private int resultadoConversao(String valor_por_converter) {

		int valor_convertido = 0;
		int tamanho_do_valor_por_converter = valor_por_converter.length() - 1;

		for (int i = 0; i <= tamanho_do_valor_por_converter; i++) {

			char caracter_actual = valor_por_converter.charAt(i);

			if (i == valor_por_converter.length() - 1) {
				valor_convertido += getArabicoCorrespondente(caracter_actual);
			} else {

				char proximo_caracter = valor_por_converter.charAt(i + 1);

				if (getArabicoCorrespondente(caracter_actual) >= getArabicoCorrespondente(proximo_caracter)) {
					valor_convertido += getArabicoCorrespondente(caracter_actual);
				} else {
					valor_convertido -= getArabicoCorrespondente(caracter_actual);
				}
			}

		}

		return valor_convertido;
	}

	private int getArabicoCorrespondente(Character caracter_actual) {
		return Romano.valueOf(caracter_actual+"").getArabicoCorrespondente();
	}
}