package mz.com.cedsif.converter.models;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.*;

public class ConverterTest {

	private Converter converter;
	
	@Before
	public void setUp() {
		converter= new Converter();
	}
	
	@Test
	public void deveConverterNumerosMaioresQue1() {
		converter.setValorDesejado(2);
		
		assertThat(converter.converter_arabico_romano(), equalTo("I"));
	}
}