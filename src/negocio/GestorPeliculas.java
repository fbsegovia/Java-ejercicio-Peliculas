package negocio;

import java.util.ArrayList;
import entidades.*;

public class GestorPeliculas {

	private ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
	
	public void alta(Pelicula e){
		listaPeliculas.add(e);
	}
	
	public void baja(String nombre){
		Pelicula peliculaEncontrada = null;
		for(Pelicula pelicula : listaPeliculas){
			if(pelicula.getTitulo().equalsIgnoreCase(nombre)){
				peliculaEncontrada = pelicula;
			}
		}
		if(peliculaEncontrada !=null){
			listaPeliculas.remove(peliculaEncontrada);
		}
	}
	
	public ArrayList<Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}
	
}
