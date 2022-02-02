package ejercicio5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Congreso {

	// Propiedades
	
	private String nombre;
	private LinkedList<Trabajo> aceptados;
	private ArrayList<String> revisores;
	private int nRevisores;
	private boolean abierto;
	
	// Getters
	
	public String getNombre() {
		return nombre;
	}
	public LinkedList<Trabajo> getAceptados() {
		return new LinkedList<Trabajo>(aceptados);
	}
	public int getNRevisores() {
		return nRevisores;
	}
	public LinkedList<String> getRevisores() {
		return new LinkedList<String>(revisores);
	}
	public boolean isAbierto() {
		return abierto;
	}
	
	// Constructores
	
	public Congreso(String nombre, int nRevisores, String... revisores) {
		this.nombre=nombre;
		this.nRevisores=nRevisores;
		this.revisores = new ArrayList<String>();
		for (String rev : revisores) {
			this.revisores.add(rev);
		}
		this.aceptados= new LinkedList<Trabajo>();
		this.abierto=true;
		
	}
	
	public Congreso(String nombre, String... revisores) {
		this(nombre, 2, revisores);
	}
	
	// Funcionalidad
	
	public LinkedList<Trabajo> getTrabajos(String revisor) {
		LinkedList<Trabajo> trabajos = new LinkedList<Trabajo>();
		for (Trabajo trab : aceptados) {
			if (trab.getAutores().contains(revisor)) trabajos.add(trab);
		}
		return trabajos;
	}
	
	public int getNTrabajos(String revisor) {
		return getTrabajos(revisor).size();
	}
	
	public Trabajo enviarTrabajo(String titulo, String... autores) {
		if (isAbierto()) {
			boolean control = true;
			for (String aut : autores) {
				if (revisores.contains(aut)) control=false;
			}
			if (control) {
				int posrevisor = (getAceptados().size()*getNRevisores())%getRevisores().size();
				
				ArrayList<String> a = new ArrayList<String>();
				for (int i=0;i<getNRevisores();i++) {
					a.add(revisores.get(posrevisor));
					posrevisor++;
					if (posrevisor>=revisores.size()) posrevisor=0;
				}
				LinkedList<String> b = new LinkedList<String>();
				Collections.addAll(b, autores);
				Trabajo trab = new Trabajo(titulo, b, a);
				aceptados.add(trab);
				return trab;
			}
		}
		return null;
	}
	
	public void cerrar() {
		abierto=false;
	}
	
}
