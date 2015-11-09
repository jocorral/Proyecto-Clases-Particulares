package objetos;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;

public class Persona {
	final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String telefono; // POSTERIORMENTE CAMBIAR A INT O A LONG
	private String direccion;
	private String ciudad;
	private Date fechaNacimiento;
	private boolean alumnoProfesor; // Alumno = false y Profesor = true
	/**
	 * Método que convierte el String que le pasa por parámetro en Date.
	 * @param fecha Se tratará de un String en el formato "dd/MM/yyyy".
	 * @returnm La fecha en formato Date ("dd/MM/yyyy").
	 */
	public Date conseguirFecha(String fecha){
		Date fechaNcto = new Date(12045628);
		try{
			fechaNcto = (Date) df.parse(fecha);
		}catch(ParseException e){}
		return fechaNcto;
	}
	
	public Persona(){}
	
	public Persona( String dni, String nombre, String apellido1, String apellido2, String telefono,
	String direccion, String ciudad, String fechaNacimiento, boolean alumnoProfesor ){
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.telefono = telefono;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.fechaNacimiento = conseguirFecha(fechaNacimiento);
		this.alumnoProfesor = alumnoProfesor;
	}
}
