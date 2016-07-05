package tallerweb.sangucheto.modelo;

import java.util.LinkedList;
import java.util.List;

public class Sanguchetto {

	private static Sanguchetto instance = new Sanguchetto();
	private List<Ingrediente> ingredientes = new LinkedList<Ingrediente>();
	
	private Sanguchetto(){}
	
	public static Sanguchetto getInstance(){
		return instance;
	}
	
	/**
	 * Elimina todos los ingredientes del sanguchetto.<br>
	 */
	public void vaciar(){
		this.ingredientes.clear();
	}
	
	/**
	 * Agrega un ingrediente al carrito.<br>
	 * @param ingrediente
	 */
	public void agregarIngrediente(Ingrediente ingrediente){
		this.ingredientes.add(ingrediente);
	}
	
	/**
	 * Elimina un ingrediente del carrito.<br>
	 * @param ingrediente
	 */
	public void quitarIngrediente(Ingrediente ingrediente){
		
		for (Ingrediente item :this.ingredientes) {
			 
				if (item.equals(ingrediente)) {
				 
					ingredientes.remove(ingrediente);
				}
			 
			}

	}
	
	/**
	 * Lista todos los ingredientes que forman parte del sanguchetto.<br>
	 * @return
	 */
	public List<Ingrediente> verIngredientes(){
		List<Ingrediente> ingredientesSanguche = new LinkedList<Ingrediente>();
		for(Ingrediente a : this.ingredientes){
			if(a.getTipo().equals(TipoIngrediente.INGREDIENTE)){
				ingredientesSanguche.add(a);
			}
		}
		return ingredientesSanguche;
	}
	
	/**
     * Lista todos los condimentos que forman parte del sanguchetto.<br>
     * @return
     */
    public List<Ingrediente> verCondimentos(){
    	List<Ingrediente> condimentosSanguche = new LinkedList<Ingrediente>();
		for(Ingrediente a : this.ingredientes){
			if(a.getTipo().equals(TipoIngrediente.CONDIMENTO)){
				condimentosSanguche.add(a);
			}
		}
		return condimentosSanguche;
    }
	
	/**
	 * Devuelve el precio total del sanguchetto.<br>
	 * @return
	 */
	public Double getPrecio(){
		Double total = 0.00;
		for(Ingrediente a : this.ingredientes){
			total += a.getPrecio(); 
		}
		return total;
	}
}
