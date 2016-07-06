package tallerweb.sangucheto.controladores;

import java.util.ArrayList;
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
import tallerweb.sangucheto.modelo.TipoIngrediente;


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
		
		
		for(Ingrediente item : stock.listarIngredientesDisponibles()) {
		    if(stock.obtenerStockDisponible(item) > 0){
		    	modelo.put("stock", stockIngredientes);
		    }
		}
		
		
		Sanguchetto sanguche = Sanguchetto.getInstance();
		
		 Double precio =sanguche.getPrecio();
		 
		 model.addAttribute("precio",precio);
		
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
	
	@RequestMapping(value = "/quitarIngredienteSanguche", method = RequestMethod.GET)
	public String quitarIngrediente(@RequestParam String ingredientes) {
		
		Stock stock = Stock.getInstance();
		Sanguchetto sanguche = Sanguchetto.getInstance();
		Ingrediente ingredienteSeleccionado = null;
		
		for(Ingrediente item : stock.listarIngredientesDisponibles()){
			if(item.getNombre().equals(ingredientes)){
				ingredienteSeleccionado = item;
				break;
			}
		}
		
		sanguche.quitarIngrediente(ingredienteSeleccionado);
		
		
		return "redirect:armarSanguche";
	}
	

	@RequestMapping(value = "/limpiarSanguche", method = RequestMethod.GET)
	public String limpiarSanguche() {
		
		Sanguchetto sanguche = Sanguchetto.getInstance();
		
		
		sanguche.vaciar();

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
		Boolean exist =false;
		
		
		for(Ingrediente item : stock.listarIngredientesDisponibles()){
			if(item.getNombre().equals(ingrediente.getNombre())){
				exist=true;
			
			}
		}
		if(exist==false){
			stock.agregarIngrediente(ingrediente);
			Boolean a = stock.existeIngrediente(ingrediente);
		}
			
		
		
		return "redirect:index";
		
	}
	


	@RequestMapping(value = "/eliminarStock", method = RequestMethod.GET)
	public String eliminarIngrediente(@RequestParam String condimento, Model model) {
		
		Stock stock = Stock.getInstance();
		
		for(Ingrediente item : stock.listarIngredientesDisponibles()){
			if(item.getNombre().equals(condimento)){
				stock.eliminarIngrediente(item);
				break;
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
	
	@RequestMapping(value = "/comprarSanguche", method = RequestMethod.GET)
	public String comprar() {
		
		Stock stock = Stock.getInstance();
		Sanguchetto sanguche =Sanguchetto.getInstance();
		
		
		
		 for ( Ingrediente ingredientes : sanguche.verIngredientes() ) {
               
			 stock.comprarIngrediente(ingredientes,1);
		 };
		 
		 for ( Ingrediente condimentos: sanguche.verCondimentos() ) {
             
			 stock.comprarIngrediente(condimentos,1);
		 };
		
		sanguche.vaciar();
		
		return "redirect:index";
	}
	
	

	@RequestMapping(value = "/autoCompletar", method = RequestMethod.GET)
	public String autoCompletar() {
		
		
		Stock stock = Stock.getInstance();
		
		
		ArrayList<String> nombre= new ArrayList<String>();
		nombre.add(0,"Lechuga");
		nombre.add(1,"Tomate");
		nombre.add(2,"Jamon");
		nombre.add(3,"Queso");
		nombre.add(4,"Mayonesa");
		nombre.add(5,"Ketchup");
		
		ArrayList<Double> precio= new ArrayList<Double>();
		precio.add(0,10.50);
		precio.add(1,10.00);
		precio.add(2,15.30);
		precio.add(3,8.00);
		precio.add(4,1.00);
		precio.add(5,1.00);
		
		ArrayList<TipoIngrediente> tipo= new ArrayList<TipoIngrediente>();
		tipo.add(0,TipoIngrediente.INGREDIENTE);
		tipo.add(1,TipoIngrediente.INGREDIENTE);
		tipo.add(2,TipoIngrediente.INGREDIENTE);
		tipo.add(3,TipoIngrediente.INGREDIENTE);
		tipo.add(4,TipoIngrediente.CONDIMENTO);
		tipo.add(5,TipoIngrediente.CONDIMENTO);
	
		for (int i = 0; i < nombre.size(); i++) {
			
			Ingrediente ingrediente = new Ingrediente();
			
			ingrediente.setNombre(nombre.get(i));
			ingrediente.setPrecio(precio.get(i));
			ingrediente.setTipo(tipo.get(i));
			
			stock.agregarIngrediente(ingrediente);
			stock.agregarStock(ingrediente, 15);
			
		}
		
		
		
		
		return "redirect:index";
	}
	
	

}
