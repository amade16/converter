package mz.com.cedsif.converter.models;

public class Converter {

	private String valor_desejado;
	private int valor_convertido;

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

	public int converter_arabico_romano() {
		return 10;
	}
	

}
