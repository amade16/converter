package mz.com.cedsif.converter.models;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ConverterTest {

	private Converter converter;

	@Before
	public void setUp() {
		converter = new Converter();
	}

	@Test
	public void deveConverterParaNumericoQualquerRomanoEntre1A3999() {
		converter.setValorDesejado("MMM");

		assertThat(converter.converterArabicoRomano(), equalTo(3000));
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void naoDeveAceitarQualquerTipoDeEntrada() {
		converter.setValorDesejado("cedsif matrix caelum amade hélio nelúcia 2016");
		
		converter.converterArabicoRomano();
	}
}