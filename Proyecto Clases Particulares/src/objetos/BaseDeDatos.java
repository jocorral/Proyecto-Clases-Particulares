package objetos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
			connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
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

	public static void crearTablas(){
		Thread hiloDB = new Thread( new Runnable() {
			public void run(){
				try {
					// Crea la tabla si no existe
					statement.executeUpdate( "CREATE TABLE IF NOT EXISTS COMPONENTES ( NOMBRE TEXT, TIPO TEXT, LISTAPUNTOS TEXT )" );
					// Recorre los componentes y los guarda en BD
					for(Componente c: marcasAverias.getComponentes()) {
						// Existe el componente en la BD?
						ResultSet rs = statement.executeQuery( "SELECT * FROM COMPONENTES WHERE NOMBRE='" + c.getNombre() + "'" );
						if (rs.next()) {  // El componente ya existe: UPDATE
							statement.executeUpdate( "UPDATE COMPONENTES SET TIPO='" + c.getTipo() + 
								"',LISTAPUNTOS='" + c.getAL().toString() + "' WHERE NOMBRE='" + c.getNombre() + "'" );
						} else {  // El componente no existe: INSERT
							statement.executeUpdate( "INSERT INTO COMPONENTES VALUES( '"
								+ c.getNombre() + "','" + c.getTipo() + "','" + c.getAL().toString() + "')" );
						}
						rs.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		hiloDB.start();
	}
	
	
	public static void insertInt() {
		final String sent = "insert into NOMBRETABLA values("  + /*tiempo*/ "" + ")";
		Runnable r = new Runnable() {
			@Override
			public void run() {
				try {
					statement.executeUpdate(sent);
				} catch (SQLException e) {
					System.out.println( "ERROR EN SENTENCIA SQL: " + sent);
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
		
	}

	public static void anyadirSesiones(String horaIni, String horaFin, String fecha, String username) {
		// TODO Auto-generated method stub
		String sentencia = ("INSERT INTO SESION VALUES '" + horaIni + "', '" + horaFin + "', '" + fecha + "', '" + username + "'");
	}

}