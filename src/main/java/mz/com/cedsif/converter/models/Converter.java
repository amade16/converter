package mz.com.cedsif.converter.models;

import java.util.HashMap;

public class Converter {

	private String valor_desejado;
	private int valor_convertido;

	private static HashMap<Character, Integer> caracteres_validos;

	public Converter() {
		inicializarDicionario();
	}

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

		return resultadoConversao(this.valor_desejado);
	}

	private int resultadoConversao(String valor_desejado) {

		int valor_convertido = 0;

		for (int i = 0; i <= valor_desejado.length() - 1; i++) {
			
			Character caracter_actual = valor_desejado.charAt(i);
			
			
			if(i==valor_desejado.length() - 1) {
				valor_convertido += mapearRomanoNumerico(caracter_actual);
			}
			else {Character proximo_caracter = valor_desejado.charAt(i + 1);
				if (mapearRomanoNumerico(caracter_actual) >= mapearRomanoNumerico(proximo_caracter)) {
					valor_convertido += mapearRomanoNumerico(caracter_actual);
				} else {
					valor_convertido -= mapearRomanoNumerico(caracter_actual);
				}
			}
			
		}
		
		return valor_convertido;
	}

	private int mapearRomanoNumerico(Character valor_a_mapear) {
		return caracteres_validos.get(valor_a_mapear);
	}

	private void validarCaracteresInvalidos(String valor_desejado) {
		
		for (int i = 0; i < valor_desejado.length() - 1; i++) {
			
			if (caracteres_validos.get(valor_desejado.charAt(i)) == null) {
				throw new IllegalArgumentException("Erro! Caracteres inválidos!");
			}
		}
	}

	private void validarRepeticao(String valor_desejado) {
		char[] caracteres_no_valor_desejado = valor_desejado.toCharArray();

		for (int i = 0; i < caracteres_no_valor_desejado.length; i++) {
			if (contarOcorrencias(caracteres_no_valor_desejado,caracteres_no_valor_desejado[i])) {
				throw new IllegalArgumentException("Erro! Repetições inválidas!");
			}
		}
	}

	public boolean contarOcorrencias(char[] valor_desejado_caracteres, char caracter_actual) {
		String caracteres_que_podem_ocorrer_3_vez = "IXCM";

		String caracteres_que_podem_ocorrer_1_vez = "VLD";

		int contador_ocorrencias = 0;

		// se existir possso em seguida contar a ocorrencia
		if (caracteres_que_podem_ocorrer_3_vez.indexOf(caracter_actual) > -1) {
			for (int i = 0; i < valor_desejado_caracteres.length; i++) {
				if (valor_desejado_caracteres[i] == caracter_actual) {
					contador_ocorrencias++;
				}

				if (contador_ocorrencias > 3) {
					return true;
				}
			}
		} else {
			if (caracteres_que_podem_ocorrer_1_vez.indexOf(caracter_actual) > -1) {
				for (int i = 0; i < valor_desejado_caracteres.length; i++) {
					if (valor_desejado_caracteres[i] == caracter_actual) {
						contador_ocorrencias++;
					}

					if (contador_ocorrencias > 1) {
						return true;
					}
				}
			}
		}

		return false;
	}

	private static void inicializarDicionario() {
		caracteres_validos = new HashMap<Character, Integer>();
		caracteres_validos.put('I', 1);
		caracteres_validos.put('V', 5);
		caracteres_validos.put('X', 10);
		caracteres_validos.put('L', 50);
		caracteres_validos.put('C', 100);
		caracteres_validos.put('D', 500);
		caracteres_validos.put('M', 1000);
	}
}