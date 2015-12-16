package objetos;

public class Peticion extends Mensaje{

	
	
	public Peticion(String tipo, String de, String asunto, String hora,
			String fecha, Boolean eliminar) {
		super(tipo, de, asunto, hora, fecha, eliminar);
	}

	public Peticion(String tipo, String para, String de, String asunto,
			String contenido, String hora, String fecha) {
		super(tipo, para, de, asunto, contenido, hora, fecha);
	}

	public Peticion(){}



}
