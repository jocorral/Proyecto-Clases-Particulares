package objetos;

public class Profesor extends Persona{
	private Persona persona;
	private int precioHora; // Sería interesante que fuera un double.
	private String curriculum;
	private int valoracion;
	
	public Profesor(Persona persona, int precioHora, String curriculum){
		this.persona = persona;
		this.curriculum = curriculum;
		this.precioHora = precioHora;
	}
	
}
