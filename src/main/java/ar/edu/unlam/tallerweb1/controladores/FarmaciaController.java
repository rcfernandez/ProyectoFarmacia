package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Farmacia;

@Controller
public class FarmaciaController {
	
	@RequestMapping(path = "/verFarmacia", method = RequestMethod.GET)
	public ModelAndView mostrarFarmacia() {
		
		Farmacia miFarmacia = new Farmacia();
		miFarmacia.setNombre("DR AHORRO");
		miFarmacia.setTelefono("011-4338-5800");
		miFarmacia.setDiaDeTurno("Viernes");
		
		ModelMap modelo = new ModelMap();
		modelo.put("clave", miFarmacia);
		
		return new ModelAndView("Farmacia",modelo);
	}

}
