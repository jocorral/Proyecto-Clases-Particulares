import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import objetos.BaseDeDatos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ventana.Ventana_Login;
import ventana.Ventana_PrincipalProf;


public class PruebasProyecto {



	
	String username;
	String usernameBD;
	
	
	String devolver = "";
	

	@Before
	public void setUp() throws Exception {
		
		 username = "FRANCIS123";			
		 BaseDeDatos.	creaConexion();
		 usernameBD	=BaseDeDatos.probarBD(username);
		 BaseDeDatos.finConexion();	
	}

	
	@Test
	public void test() {	
		assertTrue( username.equals(usernameBD));			
	}

	

}
