import static org.junit.Assert.*;

import java.util.ArrayList;

import objetos.BaseDeDatos;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ventana.Ventana_PrincipalProf;


public class TestVentana_PrinccipalProf {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("400-500");
		a.add("AMERICA5555");
		a.add("600-700");
		a.add("AMERICA5555");
		String[][] b = new String[2][2];
		b[0][0] = ("400-500");
		b[0][1] = ("AMERICA5555");
		b[1][0] = ("600-700");
		b[1][1] = ("AMERICA5555");
		String[][] c = new String[a.size()/2][2];
		c = Ventana_PrincipalProf.pasarArrayLAArray(a, 2);
		for(String[] x : c){
			System.out.println(x[0]);
			System.out.println(x[1]);
		}
	}
	

}
