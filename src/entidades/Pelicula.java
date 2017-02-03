package entidades;

import java.util.ArrayList;

public class Pelicula {
	String titulo;
	String genero;
	protected ArrayList<Actor> actores;
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public ArrayList<Actor> getActores() {
		return actores;
	}
	public void setActores(ArrayList<Actor> actores) {
		this.actores = actores;
	}
	
	
	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", genero=" + genero + ", actores=" + actores + "]";
	}
	
	
}
