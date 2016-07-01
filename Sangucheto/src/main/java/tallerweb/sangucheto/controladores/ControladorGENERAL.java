package tallerweb.sangucheto.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.sangucheto.modelo.Ingrediente;
import tallerweb.sangucheto.modelo.Stock;


@Controller
public class ControladorGENERAL {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
				
		ModelAndView a = new ModelAndView("index");
		
		return a;
		
	}
	
	@RequestMapping(value = "/armarSanguche", method = RequestMethod.GET)
	public Model armarSanguche(Model model) {
		
			
		return model;
		
	}
	
	@RequestMapping(value = "/agregarIngredienteStock", method = RequestMethod.GET)
	public Model agregarIngredienteStock(Model model) {
		
		Ingrediente ingrediente = new Ingrediente();
		model.addAttribute("ingrediente", ingrediente);
		
		Stock stock = Stock.getInstance();
		
		return model;
		
	}
	@RequestMapping(value = "/agregarIngrediente", method = RequestMethod.GET)
	public Model agregarIngrediente(Model model) {
		
		
		
		return model;
		
	}
}
