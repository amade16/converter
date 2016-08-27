package mz.com.cedsif.converter.models;

import java.util.HashMap;

public class Converter {

	private String valor_desejado;
	private Integer valor_convertido;

	public void setValorDesejado(String valor_desejado) {
		this.valor_desejado = valor_desejado;
	}

	public String getValorDesejado() {
		return this.valor_desejado;
	}

	public void setValorConvertido(int valor_convertido) {
		this.valor_convertido = valor_convertido;
	}

	public int getValorConvertido() {
		return this.valor_convertido;
	}

	public int converterArabicoRomano() {

		validarCaracteresInvalidos(this.valor_desejado);

		validarRepeticao(this.valor_desejado);

		// validarOrdenacao(this.valor_desejado);

		return resultadoConversao(this.valor_desejado);
	}

	private void validarCaracteresInvalidos(String valor_desejado) {

		for (int i = 0; i <= valor_desejado.length() - 1; i++) {
			char caracter_actual = valor_desejado.charAt(i); 
			if (getValidade(caracter_actual)) {
				throw new IllegalArgumentException("Erro! Caracteres inválidos!");
			}
		}
	}
	
	private boolean getValidade(char caracter_actual) {
		return Romano.values().equals(caracter_actual+"");
	}
	
	
	private void validarRepeticao(String valor_desejado) {
		char[] caracteres_no_valor_desejado = valor_desejado.toCharArray();

		for (int i = 0; i < caracteres_no_valor_desejado.length; i++) {
			if (excedeuOcorrencias(caracteres_no_valor_desejado,caracteres_no_valor_desejado[i])) {
				throw new IllegalArgumentException("Erro! Repetições inválidas!");
			}
		}
	}

	private boolean excedeuOcorrencias(char[] valor_desejado_caracteres, char caracter_actual) {
		int contador_ocorrencias = 0;
		int ocorrencia_maxima = getOcorrenciaMaxima(caracter_actual);

		for (int i = 0; i < valor_desejado_caracteres.length; i++) {
			if (valor_desejado_caracteres[i] == caracter_actual) {
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
	
	
	private int resultadoConversao(String valor_desejado) {

		int valor_convertido = 0;
		int tamanho_do_valor_desejado = valor_desejado.length() - 1;

		for (int i = 0; i <= tamanho_do_valor_desejado; i++) {

			char caracter_actual = valor_desejado.charAt(i);

			if (i == valor_desejado.length() - 1) {
				valor_convertido += getArabicoCorrespondente(caracter_actual);
			} else {

				char proximo_caracter = valor_desejado.charAt(i + 1);

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