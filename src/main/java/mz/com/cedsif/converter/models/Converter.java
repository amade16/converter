package mz.com.cedsif.converter.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		List<Validador> validadores = new ArrayList<Validador>();
		validadores.add(new ValidadorEntrada());
		validadores.add(new ValidadorSequencia());
		validadores.add(new ValidadorRepeticao());
		validadores.add(new ValidadorAntecedente());
		validadores.add(new ValidadorSubtraccoes());
		
		for (Validador validador : validadores) {
			validador.valida(this.valor_por_converter);
		}
		
		return resultadoConversao(this.valor_por_converter);
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