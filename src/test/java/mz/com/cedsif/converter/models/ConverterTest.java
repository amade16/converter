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
	public void deveConverterParaNumericoQualquerRomanoValidoEntre1A3999() {
		converter.setValorDesejado("XXXVII");
		assertThat(converter.converterArabicoRomano(), equalTo(37));
		
		converter.setValorDesejado("XIX");
		assertThat(converter.converterArabicoRomano(), equalTo(19));
		
		
		converter.setValorDesejado("XXXIX");
		assertThat(converter.converterArabicoRomano(), equalTo(39));
		
		converter.setValorDesejado("LIV");
		assertThat(converter.converterArabicoRomano(), equalTo(54));
		
		
		converter.setValorDesejado("CXXIX");
		assertThat(converter.converterArabicoRomano(), equalTo(129));
		
		converter.setValorDesejado("MM");
		assertThat(converter.converterArabicoRomano(), equalTo(2000));
	}
	
	@Test
	public void deveConverterParaNumericoQualquerRomanoValidoEntre1A3999IndependenteDoFormato() {
		converter.setValorDesejado("D");		
		assertThat(converter.converterArabicoRomano(), equalTo(500));		
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
		
		converter.setValorDesejado("LL");		
		converter.converterArabicoRomano();
		
		converter.setValorDesejado("DD");		
		converter.converterArabicoRomano();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoDeveConterIXCMMaisQue3VezesSequencialmente() {
		converter.setValorDesejado("iiii");		
		converter.converterArabicoRomano();
		
		converter.setValorDesejado("xxxx");		
		converter.converterArabicoRomano();
		
		converter.setValorDesejado("cccc");		
		converter.converterArabicoRomano();
		
		converter.setValorDesejado("mmmm");		
		converter.converterArabicoRomano();			
	}
	
	
	//TESTAR VALORES ANTECEDENTES

	//VALIDAR 1
	@Test
	public void todosOsValoresAntecedentesAo1DevemSerIgualOuSuperiorAo1() {
		converter.setValorDesejado("II");		
		converter.converterArabicoRomano();
		
		converter.setValorDesejado("VI");		
		converter.converterArabicoRomano();
		
		converter.setValorDesejado("XI");		
		converter.converterArabicoRomano();
		
		converter.setValorDesejado("LI");		
		converter.converterArabicoRomano();
		
		converter.setValorDesejado("CI");		
		converter.converterArabicoRomano();
		
		converter.setValorDesejado("DI");		
		converter.converterArabicoRomano();
		
		converter.setValorDesejado("MI");		
		converter.converterArabicoRomano();
	}
	//VALIDAR 1
	
	//VALIDAR 5
	@Test(expected=IllegalArgumentException.class)
	public void naoDeveAceitarValorAntecedenteAo5QueSejaIgualAo5() {
		converter.setValorDesejado("VV");		
		converter.converterArabicoRomano();
	}
		
	@Test
	public void unicoValorInferiorAntecedenteAo5DeveSer1() {
		converter.setValorDesejado("IV");		
		converter.converterArabicoRomano();
	}
	
	@Test
	public void aceitarQualquerValorAntecedenteQueSejaSuperiorAo5() {
		converter.setValorDesejado("IV");		
		converter.converterArabicoRomano();
		
		converter.setValorDesejado("XV");		
		converter.converterArabicoRomano();
		
		converter.setValorDesejado("LV");		
		converter.converterArabicoRomano();
		
		converter.setValorDesejado("CV");		
		converter.converterArabicoRomano();
		
		converter.setValorDesejado("DV");		
		converter.converterArabicoRomano();
		
		converter.setValorDesejado("MV");		
		converter.converterArabicoRomano();
	}
	//VALIDAR 5
	
	
	//VALIDAR 50
	@Test(expected=IllegalArgumentException.class)
	public void naoDeveAceitarValorAntecedenteAo50QueSejaIgualAo50() {
		converter.setValorDesejado("LL");		
		converter.converterArabicoRomano();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoDeveAceitarValoresAntecedentesAo50QueInclua1Ou5() {
		converter.setValorDesejado("IL");		
		converter.converterArabicoRomano();
		
		converter.setValorDesejado("VL");		
		converter.converterArabicoRomano();
	}
	
	@Test
	public void todosOsValoresAntecedentesAo50DevemSerSuperioresAo50Excepto10() {
		converter.setValorDesejado("XL");
		converter.converterArabicoRomano();
		
		converter.setValorDesejado("CL");		
		converter.converterArabicoRomano();
		
		converter.setValorDesejado("DL");		
		converter.converterArabicoRomano();
		
		converter.setValorDesejado("ML");		
		converter.converterArabicoRomano();
	}
	//VALIDAR 50
	//END TESTAR VALORES ANTECEDENTES
	
	//START SUBTRACCOES SEQUENCIAS
	@Test(expected=IllegalArgumentException.class)
	public void naoDeveAceitarSubtraccoesSequenciasUmaAposOutra() {
		converter.setValorDesejado("IXIX");		
		converter.converterArabicoRomano();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoDeveAceitarMesmoTipoDeSubtraccaoNumUnicoNumero() {
		converter.setValorDesejado("CMIXCM");		
		converter.converterArabicoRomano();
		
		converter.setValorDesejado("XLIIICMXL");		
		converter.converterArabicoRomano();
	}
	//END SUBTRACOES SEQUENCIAS
}