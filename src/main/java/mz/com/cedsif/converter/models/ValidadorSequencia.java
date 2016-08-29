package mz.com.cedsif.converter.models;

import java.util.ArrayList;

public class ValidadorSequencia implements Validador {

	@Override
	public void valida(String valor_por_converter) {
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

}
