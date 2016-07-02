package tallerweb.sangucheto.controladores;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public ModelAndView agregarIngredienteStock(Model model) {
		
		Ingrediente ingrediente = new Ingrediente();
		model.addAttribute("ingrediente", ingrediente);
				
		return new ModelAndView("agregarIngredienteStock");
		
	}
	
	@RequestMapping(value = "/agregarIngrediente", method = RequestMethod.POST)
	public String agregarIngrediente(@ModelAttribute Ingrediente ingrediente, Model model) {

		model.addAttribute("ingrediente", ingrediente);
		
		Stock stock = Stock.getInstance();
		stock.agregarIngrediente(ingrediente);
		Boolean a = stock.existeIngrediente(ingrediente);
		
		
		return "redirect:index";
		
	}

	@RequestMapping(value = "/eliminarIngrediente", method = RequestMethod.GET)
	public String eliminarIngrediente(@ModelAttribute String nombreIngrediente, Model model) {

		Stock stock = Stock.getInstance();
		Ingrediente ingredienteEliminar = new Ingrediente();
		
		for(Ingrediente item : stock.listarIngredientesDisponibles()){
			String nombre = item.getNombre();
			if(nombre == nombreIngrediente){
				ingredienteEliminar = item;
			}
		}
		
		stock.eliminarIngrediente(ingredienteEliminar);
		
		
		return "redirect:verStock";
		
	}
	
	@RequestMapping(value = "/verStock", method = RequestMethod.GET)
	public ModelAndView verStock() {
		
		Stock stock = Stock.getInstance();
		
		Map<Ingrediente, Integer> stockIngredientes; 
		
		stockIngredientes = stock.obtenerStock();
		ModelMap modelo = new ModelMap();
		modelo.put("stock", stockIngredientes);
		
		return new ModelAndView("stock_disponible",modelo);
	}
}
