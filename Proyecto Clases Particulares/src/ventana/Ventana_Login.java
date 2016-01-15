package ventana;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.SpringLayout;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import objetos.BaseDeDatos;

public class Ventana_Login extends JFrame{

	/**
	 * 
	 */
	private static Thread cargaBD;
	private static Connection connection;
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JLabel lblContrasea;
	private JPasswordField txtContrasea;
	private JButton button;
	private JButton button_1;
	private JLabel label;

	public Ventana_Login() {
		setResizable(false);
		setSize(550,445);
		setTitle("INICIAR SESIÓN");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana_NewPersona.class.getResource("/imagenes/Logo1.JPG")));
		setBounds(100, 100, 550, 346);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setBounds(76, 96, 54, 17);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblUsuario);

		lblContrasea = new JLabel("Contraseña: ");
		lblContrasea.setBounds(76, 155, 79, 17);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblContrasea);

		txtUsuario = new JTextField();
		txtUsuario.setBackground(Color.LIGHT_GRAY);
		txtUsuario.setBounds(177, 96, 224, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtContrasea = new JPasswordField();
		txtContrasea.setBackground(Color.LIGHT_GRAY);
		txtContrasea.setBounds(177, 155, 224, 20);
		panel.add(txtContrasea);
		txtContrasea.setColumns(10);

		button = new JButton("CREAR NUEVO USUARIO");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_NewPersona.main(null);
				Ventana_Login.this.dispose();
			}
		});
		button.setBounds(40, 222, 186, 23);
		panel.add(button);

		button_1 = new JButton("INICIAR SESIÓN");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarSesion();
			}	
		});
		button_1.setBounds(315, 222, 130, 23);
		panel.add(button_1);

		label = new JLabel("");
		label.setIcon(new ImageIcon(Ventana_Login.class.getResource("/imagenes/Logo1.JPG")));
		label.setBounds(110, 11, 315, 305);
		panel.add(label);

		KeyListener enter = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER){
					iniciarSesion();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		};
		txtContrasea.addKeyListener(enter);
		txtUsuario.addKeyListener(enter);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		cargaBD = new Thread (new Runnable() {
			public void run(){
				BaseDeDatos.creaConexion();
				System.out.println("conexion creada");
			}	
		});
		Thread load = new Thread(new Runnable() {
			public void run() {
				Ventana_Loading ventanaLoading = new Ventana_Loading();
				ventanaLoading.setVisible(true);
				cargaBD.run();	
				ventanaLoading.iterate();
				//Despues de x tiempo, para que consiga rellenarse la Progress barra
				Ventana_Login ventanaLogin = new Ventana_Login();
				ventanaLoading.setVisible(false);
				ventanaLogin.setVisible(true);
			}
		});
		load.run();
	}

	public int compruebaContrasenya(String usuario, String contrasenya){
		int log = 0;
		if(usuario.equals("bd2a") && contrasenya.equals("bd2a")){
			log = 1;
		}else if(usuario.equals("bd2b") && contrasenya.equals("bd2b")){
			log = 2;
		}else if(usuario.equals("admin") && contrasenya.equals("admin")){
			cargaInicialDeDatos();
		}
		return log;
	}
	public void iniciarSesion(){
		String usuario = Ventana_Login.this.txtUsuario.getText();
		String contrasenya = Ventana_Login.this.txtContrasea.getText();
		int log = compruebaContrasenya(usuario, contrasenya);
		if(log == 1){
			Ventana_PrincipalProf ventanaPrincipal = new Ventana_PrincipalProf(usuario);
			Ventana_Login.this.dispose();
		}else if(log == 2){
			Ventana_Busqueda ventanaPrincipal = new Ventana_Busqueda();
			Ventana_Login.this.dispose();
		}else{
			JOptionPane.showMessageDialog(Ventana_Login.this, "El usuario introducido o la contraseña son erroneos, por favor reviselos.", "Usuario o contraseña erroneo", JOptionPane.ERROR_MESSAGE);
			Ventana_Login.this.txtContrasea.setText(null);
		}
	}
	
	private static void cargaInicialDeDatos(){
		//TODO Meter valores en las tablas de sesion, nivel, asignatura, idioma y algunas personas que sean alumnos
		ArrayList<String> insertsYTablas = new ArrayList<>();
		insertsYTablas.add("CREATE TABLE PERSONA (USERNAME NOT NULL VARCHAR(20), PASS NOT NULL VARCHAR(30), NOMBRE VARCHAR(10), "
				+ "APELLIDO_1 VARCHAR(20), APELLIDO_2 VARCHAR(20), DNI NOT NULL VARCHAR(9), FECHA_NCTO DATE, TLF NUMBER(9), "
				+ "TIPO_USUARIO VARCHAR(8), DIR VARCHAR(40), CIUDAD VARCHAR(20)");
		insertsYTablas.add("CREATE TABLE PROFESOR (DNI NOT NULL VARCHAR(9) REFERENCES PERSONA(DNI), PRECIO_H NUMBER(2),"
				+ " CURRICULUM VARCHAR(300), LISTAASIG VARCHAR(300)");
		insertsYTablas.add("CREATE TABLE ASIGNATURA (NOMBRE VARCHAR(20), COD NUMBER(3)");
		insertsYTablas.add("CREATE TABLE NIVEL (NOMBRE VARCHAR(15), COD NUMBER(2)");
		insertsYTablas.add("CREATE TABLE IDIOMA (NOMBRE VARCHAR(15), COD NUMBER(1)");
		insertsYTablas.add("CREATE TABLE SESION (H_INI NOT NULL CHAR(4), H_FIN NOT NULL CHAR(4), FECHA DATE, USERNAME_A REFERENCES PERSONA(USERNAME), USERNAME_P REFERENCES PERSONA(USERNAME))");
		insertsYTablas.add("CREATE TABLE OFRECE (DNI VARCHAR(9) REFERENCES PERSONA(DNI), COD_ASIG NUMBER(3) REFERENCES ASIGNATURA(COD),"
				+ " COD_NIVEL NUMBER(2) REFERENCES NIVEL(COD), COD_IDIOMA NUMBER(1) REFERENCES IDIOMA(COD)");
		insertsYTablas.add("INSERT INTO PERSONA VALUES 'FRANCIS123', '123', 'FRANCISCA', 'FERNANDEZ',"
				+ "'GONZALEZ', 77777770, '20/03/1960', 900000001, 'PROFESOR', 'GRAN VIA 15 4', 'BILBAO'");
		insertsYTablas.add("INSERT INTO PERSONA VALUES 'MIKELTXU07', '07', 'MIKEL', 'GARCIA',"
				+ "'OLIVAN', 77777771, '15/12/1957', 900000002, 'PROFESOR', 'ARABA 3 2', 'BARAKALDO'");
		insertsYTablas.add("INSERT INTO PERSONA VALUES 'ALAN2564', '2564','ALAN', 'JIMENEZ',"
				+ "'RICK', 77777772, '31/01/1974', 900000003, 'PROFESOR', 'BALEJO 11 3', 'BARAKALDO'");
		insertsYTablas.add("INSERT INTO PROFESOR VALUES 77777770, 13, 'MAS DE 20 AÑOS COMO PROFESORA DANDO CLASE A GENTE DE TODAS LAS EDADES. CONTROL SOBRE EUSKERA E INGLES"
				+ " EN NIVEL B2.', ''");
		insertsYTablas.add("INSERT INTO PROFESOR VALUES 77777771, 12, 'ANTIGUO ALUMNO DEL COLEGIO JESUITAS DE BILBAO Y PROFESOR EN EL MISMO DURANTE CERCA DE 10 AÑOS. AYUDA COMPLEMENTARIA EN CUALQUIER"
				+ "CURSO DE PRIMARIA Y ESO. CLASES DE PREPARACION DEL FCE Y PRACTICAS CON EXAMENES OFICIALES.', ''");
		insertsYTablas.add("INSERT INTO PROFESOR VALUES 77777772, 15, 'PROFESOR DURANTE TRES AÑOS EN EL INSTITUTO LA SALLE, ACTUALMENTE PROFESOR FREELANCE PARA DAR CLASES ENTRE"
				+ " LOS CURSOS DE ESO Y BACHILLERATO. TITULO DEL EGA, FCE Y NOCIONES EN CHINO', '' ");
	}
	
}
