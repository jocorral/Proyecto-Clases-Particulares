package objetos;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import ventana.Ventana_Login;
import ventana.Ventana_NewPersona;

public class BaseDeDatos{

	public static Connection connection;
	public static Statement statement;

	public static void creaConexion(){
		try{
			// Crear una conexión de BD
			connection = DriverManager.getConnection("jdbc:sqlite:clasesparticulares.db");
			statement = connection.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
		}catch(SQLException e){
			// Cierre de conexión fallido
			System.err.println(e);
		}
	}

	public static void finConexion() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void crearPersona(String username, String pass, String nombre, String apellido_1, String apellido_2, String dni, String f_ncto,
			String tlf, String tipoU, String dir, String ciudad){	
		final String sentencia = ("INSERT INTO PERSONA VALUES ('" + username.toUpperCase() + "', '" + pass + "', '" + nombre.toUpperCase() +"', '" + apellido_1.toUpperCase() + "',"
				+ "'" + apellido_2.toUpperCase() + "', '" + dni.toUpperCase() + "', '" + f_ncto + "', '" + tlf + "', '" + tipoU + "', '" + dir.toUpperCase() + "', '" + ciudad.toUpperCase() + "')");
		final String nombreU = username;

		Thread hiloDB = new Thread( new Runnable() {
			public void run(){
				try {
					ResultSet rs = statement.executeQuery( "SELECT * FROM PERSONA WHERE NOMBRE='" + nombreU + "'" );
					if (rs.next()) { //La persona existe ya en la BD
						Ventana_Login a = new Ventana_Login();
						a.setLocationRelativeTo(null);
						a.setVisible(true);
					} else {  // El componente no existe: INSERT	
						insert(sentencia);
					}
					rs.close();
					System.out.println("Persona creada");

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		hiloDB.start();
	}

	public static void crearMensaje(String CodMensaje ,String DNIprofesor, String DNIalumno, boolean esProfe, String asunto, String contenido){	
		Date myDate = new Date();
		String fecha =new SimpleDateFormat("dd-MM-yyyy").format(myDate);	
		final String mensaje = ("INSERT INTO MENSAJE VALUES ('" + CodMensaje + "', '" + DNIprofesor + "', '" + DNIalumno +"', '" +
				esProfe + "',"+ "'" + asunto + "', '" + contenido + "')");
		insert(mensaje);		
	}

	/**
	 * Realiza la sentencia insert pasada por parámetro.
	 * @param sentencias sentencia a insertar.
	 */
	public static void insert(String sentencias){ 
		final String sentencia = sentencias;

		try {
			statement.executeUpdate(sentencia);
			System.out.println("Sentencia creada");
		} catch (SQLException e) {
			System.out.println( "ERROR EN SENTENCIA SQL: " + sentencia);
			e.printStackTrace();
		}
	}

	public static String selectUnValor(String sentenciaSelect, String columna){
		String devolver = "";
		try{
			ResultSet rs = statement.executeQuery(sentenciaSelect);
			devolver = rs.getString(columna);
		}catch(SQLException e){
			System.out.println("No existe un valor para esa seleccion");
		}finally{
			return devolver;
		}
	}

	public static ArrayList<String> selectVariosValores(String sentenciaSelect, String columna){
		ArrayList<String> devolver = new ArrayList<>();
		try{
			ResultSet rs = statement.executeQuery(sentenciaSelect);
			while(rs.next()){
				devolver.add(rs.getString(columna));
			}
			return devolver;
		}catch(SQLException e){
			System.out.println("No existe un valor para esa seleccion");
			return devolver;
		}
	}

	public static ArrayList<String> selectParaDia(String usuario, String fecha){
		ArrayList<String> devolver = new ArrayList<>();
		try{
			String hora_ini;
			String hora_fin;
			String horas;
			String alumno;
			ResultSet rs = statement.executeQuery("SELECT * FROM SESION WHERE USERNAME_P = '" + usuario + "' AND FECHA = '" + fecha + "'");
			while(rs.next()){
				hora_ini = rs.getString("H_INI");
				hora_fin = rs.getString("H_FIN");
				alumno = rs.getString("USERNAME_A");
				horas = hora_ini + " - " + hora_fin;
				devolver.add(horas);
				devolver.add(alumno);
			}
			return devolver;
		}catch(SQLException e){
			devolver.add("No existen clases para este dia.");
			return devolver;
		}
	}

	public static void anyadirAlumno(String username, String pass, String nombre, String apellido_1, String apellido_2, String dni, String f_ncto,
			String tlf, String tipoU, String dir, String ciudad) {
		String sentencia = ("INSERT INTO PERSONA VALUES ('" + username + "', '" + pass + "', '" + nombre +"', '" + apellido_1 + "',"
				+ "'" + apellido_2 + "', '" + dni + "', '" + f_ncto + "', '" + tlf + "', '" + tipoU + "', '" + dir + "', '" + ciudad + "')");
		insert(sentencia);
	}

	public static void anyadirSesiones(String horaIni, String horaFin, String fecha, String usernameA, String usernameP) {
		String sentencia = ("INSERT INTO SESION VALUES ('" + horaIni + "', '" + horaFin + "', '" + fecha + "', '" + usernameA + "', '" + usernameP + "')");
		insert(sentencia);
	}

	public static void editarProfesor( String nombre, String apellido_1, String apellido_2, String tlf, String dir, String ciudad) {
		if(!nombre.equals("")){
			String sentencia = "UPDATE PERSONA SET NOMBRE='"+ nombre + "'" +"WHERE USERNAME='"+Ventana_Login.getMiUser().toUpperCase() +"'";
			insert(sentencia);
		}
		if(!apellido_1.equals("")){
			String sentencia = "UPDATE PERSONA SET APELLIDO_1 ='"+ apellido_1 + "'" +"WHERE USERNAME='"+Ventana_Login.getMiUser().toUpperCase() +"'";
			insert(sentencia);
		}
		if(!apellido_2.equals("")){
			String sentencia = "UPDATE PERSONA SET APELLIDO_2 ='"+ apellido_2 + "'" +"WHERE USERNAME='"+Ventana_Login.getMiUser().toUpperCase() +"'";
			insert(sentencia);
		}
		if(!tlf.equals("")){
			String sentencia = "UPDATE PERSONA SET TLF= '"+ tlf + "'" +"WHERE USERNAME='"+Ventana_Login.getMiUser().toUpperCase() +"'";
			insert(sentencia);
		}
		if(!dir.equals("")){
			String sentencia = "UPDATE PERSONA SET DIR ='"+ dir + "'" +"WHERE USERNAME='"+Ventana_Login.getMiUser().toUpperCase() +"'";
			insert(sentencia);
		}
		if(!ciudad.equals("")){
			String sentencia = "UPDATE PERSONA SET CIUDAD = '"+ ciudad + "'" +"WHERE USERNAME='"+Ventana_Login.getMiUser().toUpperCase() +"'";
			insert(sentencia);
		}else if (dir.equals("") && tlf.equals("") && apellido_2.equals("") && apellido_2.equals("") && nombre.equals("")){
			System.out.println("Campos vacios");
		}
	}

	
	public static void crearMensaje (String CodMensaje , String asunto, String contenido){	
		Date myDate = new Date();		
		String fecha =new SimpleDateFormat("dd-MM-yyyy").format(myDate);	
		final String mensaje = ("INSERT INTO MENSAJE VALUES( '" +
		CodMensaje + "', '" + asunto + "', '" + contenido + "', '"+fecha+"')");				
			insert(mensaje);				
		}
		
		public static void crearEnvia (String CodMensaje, String DNIP, String DNIA, String esProfe ){	

		final String envia = ("INSERT INTO ENVIA VALUES ('" +
		CodMensaje  + "', '" +DNIA  + "', '" +  DNIP+ "','" +esProfe + "')");
			
			insert(envia);
			
		}
		//Anyadido nuevo
		public static ArrayList<String> obtenerMensajes(){
				String c=Ventana_Login.getMiDNI().toUpperCase();
				ArrayList<String> arrayMensajes = new ArrayList<>();
				String SelectMensaje = "SELECT COD,ASUNTO,CONTENIDO,FECHA "
						+ "FROM MENSAJE,ENVIA "
						+ "WHERE "
									+ "	MENSAJE.COD=ENVIA.COD_MENSAJE "
									+ " AND ENVIA.DNI_P= '"+ c +"'";
			try {
				ResultSet mensaje = statement.executeQuery(SelectMensaje);		
		         	while(mensaje.next()) {   
		           
		        	String codigo=   mensaje.getString("COD");         
		            String asunto= 	 mensaje.getString("ASUNTO");
					String contenido=  mensaje.getString("CONTENIDO");
					String fecha=  mensaje.getString("FECHA");
					
					String exe="SELECT * "
							+ "FROM ENVIA,PERSONA "
							+ "WHERE " + "	ENVIA.COD_MENSAJE= ' "+ codigo
							+ " ' AND ENVIA.DNI_A = PERSONA.DNI "   ;		
					String para=Ventana_Login.getMiUser();				
					System.out.println(codigo);
				     System.out.println(para);
				     System.out.println(asunto);
				     System.out.println(contenido);
				     System.out.println(fecha);
					
				     arrayMensajes.add(codigo);
					ResultSet de=statement.executeQuery(exe);
					while(de.next()) { 				
						String DeQuien=   mensaje.getString("USERNAME");
						arrayMensajes.add(DeQuien);
						System.out.println("Username"+DeQuien);
					}					
					arrayMensajes.add(para);
					arrayMensajes.add(asunto);
					arrayMensajes.add(contenido);
					arrayMensajes.add(fecha);				
		         	}	
		      } catch(SQLException ex) {
		         ex.printStackTrace();
		      }
			return arrayMensajes;	
		}

		
}