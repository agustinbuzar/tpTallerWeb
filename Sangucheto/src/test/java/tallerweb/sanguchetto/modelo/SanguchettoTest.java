package tallerweb.sanguchetto.modelo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import tallerweb.sangucheto.modelo.Ingrediente;
import tallerweb.sangucheto.modelo.Sanguchetto;
import tallerweb.sangucheto.modelo.TipoIngrediente;

public class SanguchettoTest {
	
	
    @Test
    public void testVaciar() {
    	Ingrediente lechuga = new Ingrediente();
    	lechuga.setNombre("lechuga");
    	lechuga.setPrecio(25.50);
    	lechuga.setTipo(TipoIngrediente.INGREDIENTE);
    	
    	Sanguchetto sanguchito = Sanguchetto.getInstance();
        
        sanguchito.agregarIngrediente(lechuga);
        sanguchito.agregarIngrediente(lechuga);
        sanguchito.vaciar();

        Assert.assertTrue(sanguchito.verIngredientes().size() == 0);
        Assert.assertTrue(sanguchito.verIngredientes().isEmpty());
    }

    @Test
    public void testAgregarIngrediente() {
    	Ingrediente lechuga = new Ingrediente();
    	lechuga.setNombre("lechuga");
    	lechuga.setPrecio(25.50);
    	lechuga.setTipo(TipoIngrediente.INGREDIENTE);
    	
    	Sanguchetto sanguchito = Sanguchetto.getInstance();
        sanguchito.vaciar();
        sanguchito.agregarIngrediente(lechuga);
        
        Assert.assertTrue(sanguchito.verIngredientes().size() == 1);
        sanguchito.agregarIngrediente(lechuga);
        Assert.assertTrue(sanguchito.verIngredientes().size() == 2);
    }

    @Test
    public void testVerIngredientes() {
    	Ingrediente lechuga = new Ingrediente();
    	List<Ingrediente> listaIngredientes = new LinkedList<Ingrediente>();
    	
    	lechuga.setNombre("lechuga");
    	lechuga.setPrecio(25.50);
    	lechuga.setTipo(TipoIngrediente.INGREDIENTE);
    	
    	Sanguchetto sanguchito = Sanguchetto.getInstance();
        sanguchito.vaciar();
        sanguchito.agregarIngrediente(lechuga);
        
        listaIngredientes = sanguchito.verIngredientes();
        Assert.assertTrue(listaIngredientes.contains(lechuga));
        
    }

    @Test
    public void testVerCondimentos() {
    	Ingrediente mostaza = new Ingrediente();
    	List<Ingrediente> listaCondimentos = new LinkedList<Ingrediente>();
    	
    	mostaza.setNombre("Mostaza");
    	mostaza.setPrecio(25.50);
    	mostaza.setTipo(TipoIngrediente.CONDIMENTO);
    	
    	Sanguchetto sanguchito = Sanguchetto.getInstance();
        sanguchito.vaciar();
        sanguchito.agregarIngrediente(mostaza);
        
        listaCondimentos = sanguchito.verCondimentos();
        Assert.assertTrue(listaCondimentos.contains(mostaza));

    }

    @Test
    public void testGetPrecio() {
    	Ingrediente mostaza = new Ingrediente();
    	
    	mostaza.setNombre("Mostaza");
    	mostaza.setPrecio(25.50);
    	mostaza.setTipo(TipoIngrediente.CONDIMENTO);
    	
    	Sanguchetto sanguchito = Sanguchetto.getInstance();
        sanguchito.vaciar();
        sanguchito.agregarIngrediente(mostaza);
        sanguchito.agregarIngrediente(mostaza);
        
        Assert.assertTrue(sanguchito.getPrecio() == 51.00);
    }
}
