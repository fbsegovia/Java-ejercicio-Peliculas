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
	 * M�todo que muestra el men� de inicio del programa,
	 * mostrando las opciones disponibles.
	 * @return Devuelve la opci�n elegida por el ususario.
	 */
	private int mostrarMenu() {
		System.out.println("Seleccione la opci�n que desee realizar");
		System.out.println("1. Dar de alta una pelicula.");
		System.out.println("2. Dar de baja una pelicula.");
		System.out.println("3. Listar las peliculas.");
		System.out.println("4. Salir de la aplicaci�n.");
		Scanner sc = new Scanner(System.in);
		int opcion = sc.nextInt();
		return opcion;
	}
	
	/**
	 * M�todo que crea una pelicula introduciendo:
	 * T�tulo, G�nero y Actores.
	 * @return La pel�cula creada.
	 */
	private Pelicula introducirPelicula() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el t�tulo de la nueva Pelicula");
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
	 * M�todo que a�ade actores a un array de actores para la pelicula.
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
		}while(a�adir(confirmacion));
		return listaActores;
	}
	
	/**
	 * M�todo que evalua si el usuario desea a�adir mas actores.
	 * @param El valor "s" tipo texto.
	 * @return Verdadero o falso, si es falso saldra del bucle.
	 */
	private boolean a�adir(String confirmacion){
		Scanner sc = new Scanner(System.in);
		System.out.println("�Desea a�adir m�s actores? : S/N");
		String confirmacion1 = sc.nextLine();
		if(confirmacion1.equalsIgnoreCase("N")){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * M�todo que elimina una pelicula del Array de peliculas
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
	 * m�todo que muestra el listado de peliculas introducidas en
	 * el programa.
	 * @param El listado de peliculas introducido.
	 */
	private void mostrarListaPeliculas(ArrayList<Pelicula> listaPeliculas) {
		for(Pelicula pelicula : listaPeliculas){
			System.out.println(pelicula);
		}
	}
	
	/**
	 * M�todo que pregunta si desea continuar al usuario.
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
