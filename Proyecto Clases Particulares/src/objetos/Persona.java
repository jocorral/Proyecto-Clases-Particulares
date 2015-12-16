package objetos;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Persona {
	private String userName;
	private String password;
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int telefono; // POSTERIORMENTE CAMBIAR A INT O A LONG
	private String direccion;
	private String ciudad;
	private Date fechaNacimiento;
	private ArrayList<Mensaje> bandejaEntrada = new ArrayList<Mensaje>();
	private ArrayList<Mensaje> enviados = new ArrayList<Mensaje>();
	private boolean alumnoProfesor; // Alumno = false y Profesor = true

	public Persona(){
		bandejaEntrada.add( new Peticion( "Petición", "Piruli",
   	         "Clase de hoy", "15:30", "03/12/2015", new Boolean(false) ) );
		bandejaEntrada.add( new Mensaje( "Mensaje", "Juan",
  	         "Clase de mañana", "18:00", "01/11/2015", new Boolean(false) ) );
		bandejaEntrada.add( new Peticion( "Petición", "Lola",
  	         "Cancelar clase", "11:30", "02/10/2015", new Boolean(false) ) );
		bandejaEntrada.add( new Mensaje( "Mensaje", "Catalina",
     	         "Clase de ayer", "20:00", "01/11/2015", new Boolean(false) ) );
		bandejaEntrada.add(new Peticion("Petición", "Periquita", "No quiero dar mas clase", "15:00", "12/12/2012", new Boolean(false)));
		
		enviados.add( new Mensaje( "Mensaje", "Catalina",
    	         "Clase de ayer", "20:00", "01/11/2015", new Boolean(false) ) );
		enviados.add(new Peticion("Petición", "Periquita", "No quiero dar mas clase", "15:00", "12/12/2012", new Boolean(false)));
	}
	

	public Persona( String userName, String password, String dni, String nombre, String apellido1, String apellido2, int telefono,
			String direccion, String ciudad, String fechaNacimiento, boolean alumnoProfesor ){
		this.userName = userName;
		this.password = password;
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
	/**
	 * Método que convierte el String que le pasa por parámetro en Date.
	 * @param fecha Se tratará de un String en el formato "dd/MM/yyyy".
	 * @returnm La fecha en formato Date ("dd/MM/yyyy").
	 */
	public Date conseguirFecha(String fecha){
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaNcto = null;
		try{
			if(fechaNcto instanceof Date){
				fechaNcto = (Date) df.parse(fecha);
			}
		}catch(ParseException e){}
		return fechaNcto;
	}
	
	public int getEdad(){
		Calendar fechaNacimientoDiaMesAnyo = Calendar.getInstance();
		fechaNacimientoDiaMesAnyo.setTime(this.fechaNacimiento);
		Calendar fechaNacimiento = new GregorianCalendar(fechaNacimientoDiaMesAnyo.get(Calendar.YEAR), fechaNacimientoDiaMesAnyo.get(Calendar.MONTH), fechaNacimientoDiaMesAnyo.get(Calendar.DAY_OF_MONTH) );
		Calendar fechaActual = Calendar.getInstance();  
		int edad = fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);  
		if (fechaActual.get(Calendar.MONTH) < fechaNacimiento.get(Calendar.MONTH)) {
			edad--;  
		} else if (fechaActual.get(Calendar.MONTH) == fechaNacimiento.get(Calendar.MONTH)
				&& fechaActual.get(Calendar.DAY_OF_MONTH) < fechaNacimiento.get(Calendar.DAY_OF_MONTH)) {
			edad--;  
		}
		return edad;
	}
	public ArrayList<Mensaje> getBandejaEntrada() {
		return bandejaEntrada;
	}
	

	public ArrayList<Mensaje> getEnviados() {
		return enviados;
	}
}
