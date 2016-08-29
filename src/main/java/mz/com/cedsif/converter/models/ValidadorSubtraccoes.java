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
		
		for (int j=0;j<subtraccoesEncontradas.size();j++) {
			String subtraccao_actual=subtraccoesEncontradas.get(j);
			char primeiro_valor_da_subtracao=subtraccao_actual.charAt(0);
			int indice_inicial_da_subtraccao=valor_por_converter.indexOf(subtraccao_actual);
			if(indice_inicial_da_subtraccao>0) {
				char valor_antes_da_subtraccao=valor_por_converter.charAt(indice_inicial_da_subtraccao-1);
			
				if(valor_antes_da_subtraccao==primeiro_valor_da_subtracao) {
					throw new IllegalArgumentException("Erro! Existe subtraccoes com sequencias antecedentes!");
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
