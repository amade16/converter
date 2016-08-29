package mz.com.cedsif.converter.models;

import java.util.ArrayList;

public class ValidadorSubtraccoes implements Validador {

	public void valida(String valor_por_converter) {
		ArrayList<String> subtraccoesEncontradas= new ArrayList<String>();
		
		for(int i=0;i<valor_por_converter.length();i++) {
			if(i>0 ) {
				char caracter_actual=valor_por_converter.charAt(i);

			ArrayList <Character> caracteres_permitidos = getCaracteresPermitidos(caracter_actual);
			
			if
			(getArabicoCorrespondente(valor_por_converter.charAt(i-1))<getArabicoCorrespondente(valor_por_converter.charAt(i))
				 &&
				 caracteres_permitidos.contains(valor_por_converter.charAt(i-1))
				 &&
				 subtraccoesEncontradas.contains(valor_por_converter.charAt(i-1)+""+valor_por_converter.charAt(i))
				)
				{	throw new IllegalArgumentException("Erro! Existe subtraccoes repetitivas! A subtraccao: "+valor_por_converter.charAt(i-1)+""+valor_por_converter.charAt(i)+" JÁ EXISTE NO CONJUNTO "+subtraccoesEncontradas);
				}
				else {
					
					if(getArabicoCorrespondente(valor_por_converter.charAt(i-1))<getArabicoCorrespondente(valor_por_converter.charAt(i))
					&&
					caracteres_permitidos.contains(valor_por_converter.charAt(i-1)))
						
					{	subtraccoesEncontradas.add(valor_por_converter.charAt(i-1)+""+valor_por_converter.charAt(i));
					}
				}
				
			}
		}
		
		
	}
	
	private int getArabicoCorrespondente(Character caracter_actual) {
		return Romano.valueOf(caracter_actual+"").getArabicoCorrespondente();
	}
	
	private ArrayList<Character> getCaracteresPermitidos(Character caracter_actual) {
		return Romano.valueOf(caracter_actual+"").getRomanosAntecedentesValidos();
	}
	
}
