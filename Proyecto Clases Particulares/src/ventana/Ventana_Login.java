package ventana;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class Ventana_Login extends JFrame{

	
	
	
	
	public Ventana_Login(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana_NewPersona.class.getResource("/ventana/Logo1.JPG")));
		setBounds(100, 100, 550, 346);
	}
}
