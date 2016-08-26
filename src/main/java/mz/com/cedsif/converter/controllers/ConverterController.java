package mz.com.cedsif.converter.controllers;

import mz.com.cedsif.converter.models.Converter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConverterController {

	@RequestMapping("converterForm")
	public String converterForm() {
		return "redirect:converter.jsp";
	}
	
	@RequestMapping("processarConversao")
	public String processarConversao(String valor_desejado, Model model) {
		Converter converter= new Converter();
		converter.setValorDesejado(valor_desejado);
	
		model.addAttribute("valor_convertido",converter.converterArabicoRomano());

		return "converter";
	}
	
	
	
}
