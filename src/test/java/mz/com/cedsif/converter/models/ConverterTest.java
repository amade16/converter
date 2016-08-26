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
		converter.setValorDesejado("XXXVII");
		assertThat(converter.converterArabicoRomano(), equalTo(37));
		
		converter.setValorDesejado("XIX");
		assertThat(converter.converterArabicoRomano(), equalTo(19));
		
		
		converter.setValorDesejado("LIV");
		assertThat(converter.converterArabicoRomano(), equalTo(54));
		
		
		converter.setValorDesejado("CXXIX");
		assertThat(converter.converterArabicoRomano(), equalTo(129));
		
		converter.setValorDesejado("M");
		assertThat(converter.converterArabicoRomano(), equalTo(1000));		
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void naoDeveAceitarQualquerTipoDeEntrada() {
		converter.setValorDesejado("cedsif matrix caelum amade hélio nelúcia silvano 2016");		
		converter.converterArabicoRomano();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoDeveConterVLDMaisQue1Vez() {
		converter.setValorDesejado("VV");		
		converter.converterArabicoRomano();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoDeveConterIXCMMaisQue3Vezes() {
		converter.setValorDesejado("MCMLXXXIVX");		
		converter.converterArabicoRomano();
	}
}