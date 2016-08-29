package mz.com.cedsif.converter.models;

public class ValidadorEntrada implements Validador {

	public void valida(String valor_por_converter) {

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
	
}
