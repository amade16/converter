package mz.com.cedsif.converter.models;

import java.util.HashMap;

public class Converter {

	private String valor_desejado;
	private int valor_convertido;
	private HashMap<Character, Integer> dicionario;

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
		return resultadoDaConversaoArabicoRomano(this.valor_desejado);
	}

	private int resultadoDaConversaoArabicoRomano(String valor_desejado) {
		int valor_convertido=0;
		int i=0;
		for (i=0; i < valor_desejado.length()-1; i++) {
			
			caracteresLegais(valor_desejado.charAt(i),valor_desejado.charAt(i+1));
			
			if (dicionario.get(valor_desejado.charAt(i)) >= dicionario.get(valor_desejado.charAt(i+1))) {
                valor_convertido += dicionario.get(valor_desejado.charAt(i));
            }
			else {
				valor_convertido -= dicionario.get(valor_desejado.charAt(i));
            }      
		}
		
		valor_convertido += dicionario.get(valor_desejado.charAt(i));
		
		return valor_convertido;
	}
	
	private void caracteresLegais (char valor_actual, char proximo_valor) {
		if(dicionario.get(valor_actual)==null || dicionario.get(proximo_valor)==null) {
			throw new IllegalArgumentException("Erro! O valor introduzido não contém correspondentes romanos válidos!");
		}
	}

	private void inicializarDicionario() {
		dicionario = new HashMap<Character, Integer>();
		dicionario.put('I', 1);
		dicionario.put('V', 5);
		dicionario.put('X', 10);
		dicionario.put('L', 50);
		dicionario.put('C', 100);
		dicionario.put('D', 500);
		dicionario.put('M', 1000);
	}

}
