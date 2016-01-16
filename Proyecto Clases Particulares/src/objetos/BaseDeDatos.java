package objetos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import ventana.Ventana_Login;
import ventana.Ventana_NewPersona;

/** Ejemplo de uso de Base de Datos desde Java con JDBC
 * Utilizando sqlite - debe incluirse la librería sqlite-jdbc*.jar
 * @author Andoni Eguíluz Morán
 * Facultad de Ingeniería - Universidad de Deusto
 */
public class BaseDeDatos {

	public static Connection connection;
	public static Statement statement;

	public static void main(String[] args) throws ClassNotFoundException{
		// Carga el sqlite-JDBC driver usando el cargador de clases
		Class.forName("org.sqlite.JDBC");


		try
		{
			// Crear una conexión de BD
			connection = DriverManager.getConnection("jdbc:sqlite:clasesparticulares.db");
			statement = connection.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg

			statement.executeUpdate("drop table if exists person");
			statement.executeUpdate("create table person (id integer, name string)");
			statement.executeUpdate("insert into person values(1, 'leo')");
			statement.executeUpdate("insert into person values(2, 'yui')");
			ResultSet rs = statement.executeQuery("select * from person");
			while(rs.next())
			{
				// Leer el resultset
				System.out.println("name = " + rs.getString("name"));
				System.out.println("id = " + rs.getInt("id"));
			}
		} catch(SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try
			{
				if(connection != null)
					connection.close();
			}
			catch(SQLException e)
			{
				// Cierre de conexión fallido
				System.err.println(e);
			}
		}
	}

	public static void creaConexion(){
		try{
			// Crear una conexión de BD
			connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
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
		final String sentencia = ("INSERT INTO PERSONA VALUES '" + username + "', '" + pass + "', '" + nombre +"', '" + apellido_1 + "',"
				+ "'" + apellido_2 + "', '" + dni + "', '" + f_ncto + "', '" + tlf + "', '" + tipoU + "', '" + dir + "', '" + ciudad + "'");
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

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		hiloDB.start();
	}
	
	public static void crearMensaje(String CodMensaje ,String DNIprofesor, String DNIalumno, boolean esProfe, String asunto, String contenido){	
	Date myDate = new Date();
	String fecha =new SimpleDateFormat("dd/MM/yyyy").format(myDate);	
	final String mensaje = ("INSERT INTO MENSAJE VALUES '" + CodMensaje + "', '" + DNIprofesor + "', '" + DNIalumno +"', '" +
				esProfe + "',"+ "'" + asunto + "', '" + contenido + "'");
				insert(mensaje);		
	}

	/**
	 * Realiza la sentencia insert pasada por parámetro.
	 * @param sentencias sentencia a insertar.
	 */
	public static void insert(String sentencias){ 
		final String sentencia = sentencias;
		Runnable r = new Runnable() {
			@Override
			public void run() {
				try {
					statement.executeUpdate(sentencia);
				} catch (SQLException e) {
					System.out.println( "ERROR EN SENTENCIA SQL: " + sentencia);
					e.printStackTrace();
				}
			}
		};
		(new Thread(r)).start();
	}

	public static void anyadirAlumno(String username, String pass, String nombre, String apellido_1, String apellido_2, String dni, String f_ncto,
			String tlf, String tipoU, String dir, String ciudad) {
		// TODO Auto-generated method stub
		String sentencia = ("INSERT INTO PERSONA VALUES '" + username + "', '" + pass + "', '" + nombre +"', '" + apellido_1 + "',"
				+ "'" + apellido_2 + "', '" + dni + "', '" + f_ncto + "', '" + tlf + "', '" + tipoU + "', '" + dir + "', '" + ciudad + "'");
		insert(sentencia);
	}

	public static void anyadirSesiones(String horaIni, String horaFin, String fecha, String usernameA, String usernameP) {
		// TODO Auto-generated method stub
		String sentencia = ("INSERT INTO SESION VALUES '" + horaIni + "', '" + horaFin + "', '" + fecha + "', '" + usernameA + "', '" + usernameP + "'");
		insert(sentencia);
	}

	public static String getMiUser() {
		// TODO Auto-generated method stub
		return null;
	}


}