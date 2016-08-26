package mz.com.cedsif.converter.models;

public class Converter {

	private int valor_desejado;
	private String valor_convertido;

	public void setValorDesejado(int valor_desejado) {
		this.valor_desejado = valor_desejado;
	}

	public int getValorDesejado() {
		return this.valor_desejado;
	}

	public void setValorConvertido(String valor_convertido) {
		this.valor_convertido = valor_convertido;
	}

	public String getValorConvertido() {
		return this.valor_convertido;
	}

	public String converter_arabico_romano() {
		return "II";
	}

}
