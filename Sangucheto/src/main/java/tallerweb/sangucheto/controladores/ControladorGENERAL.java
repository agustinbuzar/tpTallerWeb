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
import tallerweb.sangucheto.modelo.Sanguchetto;
import tallerweb.sangucheto.modelo.Stock;


@Controller
public class ControladorGENERAL {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
				
		ModelAndView a = new ModelAndView("index");
		
		return a;
		
	}
	
	@RequestMapping(value = "/armarSanguche", method = RequestMethod.GET)
	public ModelAndView armarSanguche(Model model) {
		
		List<Ingrediente> ingredientesAgregados;
		List<Ingrediente> condimentosAgregados;
		Map<Ingrediente, Integer> stockIngredientes; 
		
		Stock stock = Stock.getInstance();
		
		stockIngredientes = stock.obtenerStock();
		ModelMap modelo = new ModelMap();
		modelo.put("stock", stockIngredientes);
		
		Sanguchetto sanguche = Sanguchetto.getInstance();
		
		condimentosAgregados = sanguche.verCondimentos();
		ingredientesAgregados = sanguche.verIngredientes();
		
		modelo.put("condimentosAgregados", condimentosAgregados);
		modelo.put("ingredientesAgregados", ingredientesAgregados);
		
		
		return new ModelAndView("armarSanguche",modelo);
	}
	
	
	@RequestMapping(value = "/agregarIngredienteSanguche", method = RequestMethod.GET)
	public String agregarIngredienteSanguche(@RequestParam String ingredientes) {
		
		Stock stock = Stock.getInstance();
		Sanguchetto sanguche = Sanguchetto.getInstance();
		Ingrediente ingredienteSeleccionado = null;
		
		for(Ingrediente item : stock.listarIngredientesDisponibles()){
			if(item.getNombre().equals(ingredientes)){
				ingredienteSeleccionado = item;
			}
		}
		
		sanguche.agregarIngrediente(ingredienteSeleccionado);
		
		//Integer a = sanguche.verCondimentos().size();
		//Integer b = sanguche.verIngredientes().size();
		
		return "redirect:armarSanguche";
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

	@RequestMapping(value = "/eliminarStock", method = RequestMethod.GET)
	public String eliminarIngrediente(@RequestParam String condimento, Model model) {
		
		Stock stock = Stock.getInstance();
		
		for(Ingrediente item : stock.listarIngredientesDisponibles()){
			if(item.getNombre().equals(condimento)){
				stock.eliminarIngrediente(item);
			}
		}
		
		return "redirect:verStock";
	}
	
	@RequestMapping(value = "/agregarStock", method = RequestMethod.GET)
	public String agregarStock(@RequestParam String ingrediente, @RequestParam Integer cantidad) {
		
		Set<Ingrediente> listaIngredientes;
		Ingrediente ingredienteSeleccionado = null;
		
		Stock stock = Stock.getInstance();
		
		listaIngredientes = stock.listarIngredientesDisponibles();
		
		for(Ingrediente item : listaIngredientes){
			if(item.getNombre().equals(ingrediente)){
				ingredienteSeleccionado = item;
			}
		}
		
		stock.agregarStock(ingredienteSeleccionado, cantidad);
		
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
