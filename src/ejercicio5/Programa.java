package ejercicio5;

public class Programa {

	public static void main(String[] args) {
		
		Congreso congreso = new Congreso("JENUI 2022", 3, "Antonio", "Alicia", "Alejandro", "Almudena");
		congreso.enviarTrabajo("trabajo1", "Claudia", "José Luis");	
		congreso.enviarTrabajo("trabajo2", "Pedro", "Antonio", "Jorge");
		congreso.enviarTrabajo("trabajo3", "Pedro", "Teresa");
		congreso.cerrar();
		congreso.enviarTrabajo("trabajo4", "Andrés", "Amparo");
		
		for (Trabajo trab : congreso.getAceptados()) {
			System.out.println(trab.toString());
		}
	}

}
