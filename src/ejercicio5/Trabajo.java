package ejercicio5;

import java.util.ArrayList;
import java.util.LinkedList;

public class Trabajo {

	// Propiedades
	
	private final String titulo;
	private final LinkedList<String> autores;
	private final ArrayList<String> revisores;
	
	// Getters
	
	public String getTitulo() {
		return titulo;
	}
	public LinkedList<String> getAutores() {
		return new LinkedList<String>(autores);
	}
	public ArrayList<String> getRevisores() {
		return new ArrayList<String>(revisores);
	}
	
	// Constructores
	
	public Trabajo(String titulo, LinkedList<String> autores, ArrayList<String> revisores) {
		this.titulo=titulo;
		this.autores=autores;
		this.revisores=revisores;
	}
	
	// Método toString
	
	@Override
	public String toString() {
		return titulo + "\nautores=" + autores + "\nrevisores=" + revisores;
	}
	
}
