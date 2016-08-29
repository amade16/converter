package mz.com.cedsif.converter.models;

import java.util.ArrayList;

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

		validarSequencia(this.valor_por_converter);
		
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
	
	
	private void validarSequencia(String valor_por_converter) {
		ArrayList<Character> controlador_de_sequencia= new ArrayList<Character>();

		for (int i = 0; i < valor_por_converter.length(); i++) {
			char caracter_actual = valor_por_converter.charAt(i);
	
			controlador_de_sequencia = actualizarControladorSequencia(controlador_de_sequencia,caracter_actual);
			
			if (controlador_de_sequencia.size()>getLimiteDeCaracteresEmSequencia(caracter_actual)) {
					throw new IllegalArgumentException("Erro! Sequência inválida!");
			}
		}
	}

	private ArrayList<Character> actualizarControladorSequencia (ArrayList<Character> controlador_de_sequencia,char caracter_actual) {
		if (controlador_de_sequencia.contains(caracter_actual) || validarLimiteDeCaracteresEmSequencia(caracter_actual) && controlador_de_sequencia.isEmpty()) {
			controlador_de_sequencia.add(caracter_actual);
		}
		else {
			controlador_de_sequencia.clear();
		}
		
		return controlador_de_sequencia;
	}
	
	private int getLimiteDeCaracteresEmSequencia(Character caracter_actual) {
		return Romano.valueOf(caracter_actual+"").getLimiteDeCaracteresEmSequencia();
	}
	
	
	private boolean validarLimiteDeCaracteresEmSequencia(Character caracter_actual) {
		return Romano.valueOf(caracter_actual+"").validarLimiteCaracteresEmSequencia();
	}
	
	private void validarRepeticao(String valor_por_converter) {
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
	
	private void validarAntecedentes(String valor_por_converter) {

		for(int i=0;i<valor_por_converter.length();i++) {
			char caracter_actual=valor_por_converter.charAt(i);
			ArrayList <Character> caracteres_permitidos = getCaracteresPermitidos(caracter_actual);
			
			if(
			i-1>=0 
			&& 
			getArabicoCorrespondente(valor_por_converter.charAt(i-1))<getArabicoCorrespondente(valor_por_converter.charAt(i))
			&& 
			!caracteres_permitidos.contains(valor_por_converter.charAt(i-1))) {
				throw new IllegalArgumentException("Erro! Antecedentes Ilegais!");
			}
		}
	}
	
	private ArrayList<Character> getCaracteresPermitidos(Character caracter_actual) {
		return Romano.valueOf(caracter_actual+"").getRomanosAntecedentesValidos();
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