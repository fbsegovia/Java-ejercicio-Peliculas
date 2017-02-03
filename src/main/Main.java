package main;

import java.util.ArrayList;
import java.util.Scanner;
import entidades.*;
import negocio.GestorPeliculas;

public class Main {
	static GestorPeliculas ge = new GestorPeliculas();
	public static void main(String[] args) {
		
			Main main = new Main();
			int opcion = 0;
			
			do{
				opcion = main.mostrarMenu(); 
				switch (opcion) {
				case 1://Dar de Alta
					Pelicula pelicula = main.introducirPelicula();
					ge.alta(pelicula);
					break;
				case 2://Dar de Baja
					String titulo = main.pedirNombre();
					ge.baja(titulo);
					break;
				case 3://Listar empleados
					main.mostrarListaPeliculas(ge.getListaPeliculas());
					break;
				case 4://Salir
					System.out.println("Fin del programa");
					break;
				}
			}while(main.continuar(opcion));

	}

	/**
	 * Método que muestra el menú de inicio del programa,
	 * mostrando las opciones disponibles.
	 * @return Devuelve la opción elegida por el ususario.
	 */
	private int mostrarMenu() {
		System.out.println("Seleccione la opción que desee realizar");
		System.out.println("1. Dar de alta una pelicula.");
		System.out.println("2. Dar de baja una pelicula.");
		System.out.println("3. Listar las peliculas.");
		System.out.println("4. Salir de la aplicación.");
		Scanner sc = new Scanner(System.in);
		int opcion = sc.nextInt();
		return opcion;
	}
	
	/**
	 * Método que crea una pelicula introduciendo:
	 * Título, Género y Actores.
	 * @return La película creada.
	 */
	private Pelicula introducirPelicula() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el título de la nueva Pelicula");
		String titulo = sc.next();
		System.out.println("Introduzca el genero de la nueva Pelicula");
		String genero = sc.next();
		ArrayList<Actor> listaActores = introducirActores();
		Pelicula pelicula = new Pelicula();
		pelicula.setTitulo(titulo);
		pelicula.setGenero(genero);
		pelicula.setActores(listaActores);
		return pelicula;
	}
	
	/**
	 * Método que añade actores a un array de actores para la pelicula.
	 * @return El listado de actores de la pelicula.
	 */
	private ArrayList<Actor> introducirActores() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Actor> listaActores = new ArrayList<>();
		String confirmacion = "N";
		do{
			Actor actor = new Actor();
			System.out.println("Introduzca el Nombre del actor o actriz");
			String nombre = sc.next();
			System.out.println("Introduzca la Edad del actor o actriz");
			int edad = sc.nextInt();
			actor.setNombre(nombre);
			actor.setEdad(edad);
			listaActores.add(actor);
		}while(añadir(confirmacion));
		return listaActores;
	}
	
	/**
	 * Método que evalua si el usuario desea añadir mas actores.
	 * @param El valor "s" tipo texto.
	 * @return Verdadero o falso, si es falso saldra del bucle.
	 */
	private boolean añadir(String confirmacion){
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Desea añadir más actores? : S/N");
		String confirmacion1 = sc.nextLine();
		if(confirmacion1.equalsIgnoreCase("N")){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * Método que elimina una pelicula del Array de peliculas
	 * introduciendo el nombre de la pelicula a borra.
	 * @return El nombre de la pelicula.
	 */
	private String pedirNombre() {
		System.out.println("Introduzca el titulo de la pelicula a borrar");
		Scanner sc = new Scanner(System.in);
		String titulo = sc.next();
		return titulo;
	}
	
	/**
	 * método que muestra el listado de peliculas introducidas en
	 * el programa.
	 * @param El listado de peliculas introducido.
	 */
	private void mostrarListaPeliculas(ArrayList<Pelicula> listaPeliculas) {
		for(Pelicula pelicula : listaPeliculas){
			System.out.println(pelicula);
		}
	}
	
	/**
	 * Método que pregunta si desea continuar al usuario.
	 * @param Condicion que la opcion numero 5 sea verdadera.
	 * @return Verdader la opcion 5 para salir del bucle.
	 */
	private boolean continuar(int opcion) {
		if(opcion==5){
			return false;
		}else{
			return true;
		}
	}
	
	
}
