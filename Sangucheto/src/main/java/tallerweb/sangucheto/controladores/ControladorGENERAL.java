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

import tallerweb.sangucheto.modelo.Administrador;
import tallerweb.sangucheto.modelo.Ingrediente;
import tallerweb.sangucheto.modelo.Login;
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
	
	@RequestMapping(value = "/indexAdmin", method = RequestMethod.GET)
	public ModelAndView indexAdmin() {
				
		ModelAndView a = new ModelAndView("indexAdmin");
		
		return a;
		
	}
	
	@RequestMapping(value = "/armarSanguche", method = RequestMethod.GET)
	public ModelAndView armarSanguche(Model model) {
		
		List<Ingrediente> ingredientesAgregados;
		List<Ingrediente> condimentosAgregados;
		Map<Ingrediente, Integer> stockIngredientes; 
		
		Stock stock = Stock.getInstance();
		
		ModelMap modelo = new ModelMap();
		
		stockIngredientes = stock.obtenerStock();

		modelo.put("stock", stockIngredientes);

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
		stock.comprarIngrediente(ingredienteSeleccionado, 1);
		
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
				sanguche.quitarIngrediente(ingredienteSeleccionado);
				break;
			}
		}
		
		stock.agregarStock(ingredienteSeleccionado, 1);
		
		return "redirect:armarSanguche";
	}
	

	@RequestMapping(value = "/limpiarSanguche", method = RequestMethod.GET)
	public String limpiarSanguche() {
		
		Sanguchetto sanguche = Sanguchetto.getInstance();
		Stock stock = Stock.getInstance();
		
		List<Ingrediente> listaCondimentos = sanguche.verCondimentos();
		for(Ingrediente item : listaCondimentos){
			stock.agregarStock(item, 1);
		}
		
		List<Ingrediente> listaIngredientes = sanguche.verIngredientes();
		for(Ingrediente item : listaIngredientes){
			stock.agregarStock(item, 1);
		}
		
		sanguche.vaciar(); 

		return "redirect:armarSanguche";
	}
	
	@RequestMapping(value = "/loginAdmin", method = RequestMethod.GET)
	public ModelAndView loginAdmin(Model model) {
		
		Administrador admin = new Administrador();
		

		model.addAttribute("admin", admin);

				
		return new ModelAndView("loginAdmin");
		
	}
	
	@RequestMapping(value = "/validaAdmin", method = RequestMethod.POST)
	public String agregarIngrediente(@ModelAttribute Administrador admin, Model model) {

		model.addAttribute("admin", admin);
		
		Login login = new Login();
		
		login.setPass("1234");
		login.setUser("admin");
		
		
		if(login.validarAdmin(admin) ){
			
			return "redirect:indexAdmin";
		}else
			return "redirect:loginAdmin";
		
		
		
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
			
		
		
		return "redirect:indexAdmin";
		
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
		
		//Stock stock = Stock.getInstance();
		Sanguchetto sanguche =Sanguchetto.getInstance();
		
		
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
		
		ArrayList<String> imagen= new ArrayList<String>();
		imagen.add(0,"http://ejerciciosencasa.es/wp-content/uploads/2013/12/24566-high-definition-picture-lettuce.jpg");
		imagen.add(1,"data:image/jpeg;base64,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");
		imagen.add(2,"http://www.periodicoabc.mx/sites/default/files/jamon_0.jpg");
		imagen.add(3,"http://thumbs.dreamstime.com/x/yellow-cheese-holes-13872108.jpg");
		imagen.add(4,"http://casaraspu.es/wp-content/uploads/2014/05/salsa-base-mayonesa.jpg");
		imagen.add(5,"http://gastronomia.laverdad.es/img/almirez/trucos/trucos_264162725.jpg");
		
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
			ingrediente.setImagen(imagen.get(i));
			
			stock.agregarIngrediente(ingrediente);
			stock.agregarStock(ingrediente, 15);
			
		}
		
		
		
		
		
		
		return "redirect:indexAdmin";
	}
	
	

}
