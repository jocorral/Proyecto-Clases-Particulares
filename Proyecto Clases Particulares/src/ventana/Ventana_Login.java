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
import java.util.ArrayList;

import javax.swing.ImageIcon;

import objetos.BaseDeDatos;

public class Ventana_Login extends JFrame{
	
	private static ArrayList<String> insertsYTablas;
	private static String usuarioConectado;
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
		String correcto = BaseDeDatos.selectUnValor("SELECT * FROM PERSONA WHERE USERNAME = '" + usuario.toUpperCase() + "'", "PASS");
		if(correcto.equals(contrasenya)){
			log = 1;
		}else if(usuario.equals("admin") && contrasenya.equals("admin")){
			cargaInicialTablas();
			cargaInicialDeDatos();
		}
		return log;
	}

	public void iniciarSesion(){
		usuarioConectado = txtUsuario.getText();
		String contrasenya = Ventana_Login.this.txtContrasea.getText();
		int log = compruebaContrasenya(usuarioConectado, contrasenya);
		if(log == 1){
			Ventana_PrincipalProf ventanaPrincipal = new Ventana_PrincipalProf(usuarioConectado);
			Ventana_Login.this.dispose();
		}else{
			JOptionPane.showMessageDialog(Ventana_Login.this, "El usuario introducido o la contraseña son erroneos, por favor reviselos.", "Usuario o contraseña erroneo", JOptionPane.ERROR_MESSAGE);
			Ventana_Login.this.txtContrasea.setText(null);
		}
	}

	public static String getMiUser() {	
		return usuarioConectado;
	}
	public static String getMiDNI(){
		return BaseDeDatos.selectUnValor("SELECT * FROM PERSONA WHERE USERNAME = '" + usuarioConectado + "'", "DNI");
	}

	private static void cargaInicialTablas(){
		insertsYTablas = new ArrayList<>();
		insertsYTablas.add("CREATE TABLE PERSONA (USERNAME VARCHAR(20), PASS VARCHAR(30), NOMBRE VARCHAR(10), "
				+ "APELLIDO_1 VARCHAR(20), APELLIDO_2 VARCHAR(20), DNI VARCHAR(9), FECHA_NCTO VARCHAR(9), TLF NUMBER(9), "
				+ "TIPO_USUARIO VARCHAR(8), DIR VARCHAR(40), CIUDAD VARCHAR(20))");
		insertsYTablas.add("CREATE TABLE PROFESOR (DNI VARCHAR(9) REFERENCES PERSONA(DNI), PRECIO_H NUMBER(2),"
				+ " CURRICULUM VARCHAR(1000))");
		insertsYTablas.add("CREATE TABLE ASIGNATURA (NOMBRE VARCHAR(20), COD NUMBER(3))");
		insertsYTablas.add("CREATE TABLE MENSAJE (COD NUMBER(5), ASUNTO VARCHAR(50), CONTENIDO VARCHAR(1000), FECHA VARCHAR(9))");
		insertsYTablas.add("CREATE TABLE NIVEL (NOMBRE VARCHAR(15), COD NUMBER(3))");
		insertsYTablas.add("CREATE TABLE IDIOMA (NOMBRE VARCHAR(15), COD NUMBER(3))");
		insertsYTablas.add("CREATE TABLE SESION (H_INI CHAR(4), H_FIN CHAR(4), FECHA VARCHAR(9), USERNAME_A REFERENCES PERSONA(USERNAME), USERNAME_P REFERENCES PERSONA(USERNAME))");
		insertsYTablas.add("CREATE TABLE ENVIA (COD_MENSAJE NUMBER(5) REFERENCES MENSAJE(COD), DNI_A NUMBER(8) REFERENCES PERSONA(DNI), DNI_P NUMBER(8) REFERENCES PERSONA(DNI), QUIEN_E VARCHAR(8))");
		insertsYTablas.add("CREATE TABLE OFRECE (DNI VARCHAR(9) REFERENCES PERSONA(DNI), COD_ASIG NUMBER(3) REFERENCES ASIGNATURA(COD),"
				+ " COD_NIVEL NUMBER(3) REFERENCES NIVEL(COD), COD_IDIOMA NUMBER(3) REFERENCES IDIOMA(COD))");

		for(String s: insertsYTablas){
			BaseDeDatos.insert(s);
		}
	}

	private static void cargaInicialDeDatos() {
		insertsYTablas = new ArrayList<String>();
		insertsYTablas.add("INSERT INTO PERSONA VALUES ('FRANCIS123', '123', 'FRANCISCA', 'FERNANDEZ',"
				+ "'GONZALEZ', 77777770, '20-03-1960', 900000001, 'PROFESOR', 'GRAN VIA 15 4', 'BILBAO')");
		insertsYTablas.add("INSERT INTO PERSONA VALUES ('MIKELTXU07', '07', 'MIKEL', 'GARCIA',"
				+ "'OLIVAN', 77777771, '15-12-1957', 900000002, 'PROFESOR', 'ARABA 3 2', 'BARAKALDO')");
		insertsYTablas.add("INSERT INTO PERSONA VALUES ('ALAN2564', '2564','ALAN', 'JIMENEZ',"
				+ "'RICK', 77777772, '31-01-1974', 900000003, 'PROFESOR', 'BALEJO 11 3', 'BARAKALDO')");
		insertsYTablas.add("INSERT INTO PERSONA VALUES ('AMERICA5555', '5555','AMERICA', 'PEREZ',"
				+ "'DE LA ROSA', 88888880, '31-05-1993', 900000004, 'ALUMNO', 'MARIA ZAMBRANO 138 BAJO', 'MIRANDA')");
		insertsYTablas.add("INSERT INTO PERSONA VALUES ('MANU742', '742','MANUELA', 'LOPEZ',"
				+ "'CARAZO', 88888881, '21-02-1990', 900000005, 'ALUMNO', 'PADRE CLARET 13 17', 'LOGROÑO')");
		insertsYTablas.add("INSERT INTO PROFESOR VALUES ('77777770', 13, 'MAS DE 20 AÑOS COMO PROFESORA DANDO CLASE A GENTE DE TODAS LAS EDADES. CONTROL SOBRE EUSKERA E INGLES"
				+ " EN NIVEL B2.')");
		insertsYTablas.add("INSERT INTO PROFESOR VALUES ('77777771', 12, 'ANTIGUO ALUMNO DEL COLEGIO JESUITAS DE BILBAO Y PROFESOR EN EL MISMO DURANTE CERCA DE 10 AÑOS. AYUDA COMPLEMENTARIA EN CUALQUIER"
				+ "CURSO DE PRIMARIA Y ESO. CLASES DE PREPARACION DEL FCE Y PRACTICAS CON EXAMENES OFICIALES.')");
		insertsYTablas.add("INSERT INTO PROFESOR VALUES ('77777772', 15, 'PROFESOR DURANTE TRES AÑOS EN EL INSTITUTO LA SALLE, ACTUALMENTE PROFESOR FREELANCE PARA DAR CLASES ENTRE"
				+ " LOS CURSOS DE ESO Y BACHILLERATO. TITULO DEL EGA, FCE Y NOCIONES EN CHINO')");
		insertsYTablas.add("INSERT INTO ASIGNATURA VALUES ('MATEMATICAS', '000')");
		insertsYTablas.add("INSERT INTO ASIGNATURA VALUES ('GIZARTE', '001')");
		insertsYTablas.add("INSERT INTO ASIGNATURA VALUES ('BIOLOGIA', '002')");
		insertsYTablas.add("INSERT INTO ASIGNATURA VALUES ('FISICA', '003')");
		insertsYTablas.add("INSERT INTO ASIGNATURA VALUES ('GEOGRAFIA', '004')");
		insertsYTablas.add("INSERT INTO ASIGNATURA VALUES ('HISTORIA', '005')");
		insertsYTablas.add("INSERT INTO ASIGNATURA VALUES ('FILOSOFIA', '006')");
		insertsYTablas.add("INSERT INTO ASIGNATURA VALUES ('EUSKERA', '007')");
		insertsYTablas.add("INSERT INTO ASIGNATURA VALUES ('INGLES', '008')");
		insertsYTablas.add("INSERT INTO ASIGNATURA VALUES ('ESPANYOL', '009')");
		insertsYTablas.add("INSERT INTO ASIGNATURA VALUES ('FRANCES', '010')");
		insertsYTablas.add("INSERT INTO ASIGNATURA VALUES ('ALEMAN', '011')");
		insertsYTablas.add("INSERT INTO ASIGNATURA VALUES ('ITALIANO', '012')");
		insertsYTablas.add("INSERT INTO ASIGNATURA VALUES ('CHINO', '013')");
		insertsYTablas.add("INSERT INTO ASIGNATURA VALUES ('JAPONES', '014')");
		insertsYTablas.add("INSERT INTO NIVEL VALUES ('PRIMARIA', '100')");
		insertsYTablas.add("INSERT INTO NIVEL VALUES ('ESO', '101')");
		insertsYTablas.add("INSERT INTO NIVEL VALUES ('BACHILLERATO', '102')");
		insertsYTablas.add("INSERT INTO NIVEL VALUES ('A1', '103')");
		insertsYTablas.add("INSERT INTO NIVEL VALUES ('A2', '104')");
		insertsYTablas.add("INSERT INTO NIVEL VALUES ('B1', '105')");
		insertsYTablas.add("INSERT INTO NIVEL VALUES ('B2', '106')");
		insertsYTablas.add("INSERT INTO NIVEL VALUES ('C1', '107')");
		insertsYTablas.add("INSERT INTO NIVEL VALUES ('C2', '108')");
		insertsYTablas.add("INSERT INTO IDIOMA VALUES ('EUSKERA', '200')");
		insertsYTablas.add("INSERT INTO IDIOMA VALUES ('INGLES', '201')");
		insertsYTablas.add("INSERT INTO IDIOMA VALUES ('ESPANYOL', '202')");
		insertsYTablas.add("INSERT INTO IDIOMA VALUES ('FRANCES', '203')");
		insertsYTablas.add("INSERT INTO IDIOMA VALUES ('ALEMAN', '204')");
		insertsYTablas.add("INSERT INTO IDIOMA VALUES ('ITALIANO', '205')");
		insertsYTablas.add("INSERT INTO IDIOMA VALUES ('CHINO', '206')");
		insertsYTablas.add("INSERT INTO IDIOMA VALUES ('JAPONES', '207')");
		insertsYTablas.add("INSERT INTO IDIOMA VALUES ('RUSO', '208')");
		insertsYTablas.add("INSERT INTO OFRECE VALUES ('77777770','002', '200', '102')");
		insertsYTablas.add("INSERT INTO OFRECE VALUES ('77777770','000', '202', '101')");
		insertsYTablas.add("INSERT INTO OFRECE VALUES ('77777770','000', '202', '102')");
		insertsYTablas.add("INSERT INTO OFRECE VALUES ('77777770','005', '200', '102')");
		insertsYTablas.add("INSERT INTO OFRECE VALUES ('77777771','001', '200', '101')");
		insertsYTablas.add("INSERT INTO OFRECE VALUES ('77777771','005', '201', '102')");
		insertsYTablas.add("INSERT INTO OFRECE VALUES ('77777771','007', '200', '104')");
		insertsYTablas.add("INSERT INTO OFRECE VALUES ('77777771','008', '201', '106')");
		insertsYTablas.add("INSERT INTO OFRECE VALUES ('77777772','006', '207', '102')");
		insertsYTablas.add("INSERT INTO OFRECE VALUES ('77777772','004', '200', '101')");
		insertsYTablas.add("INSERT INTO OFRECE VALUES ('77777772','004', '200', '102')");
		insertsYTablas.add("INSERT INTO OFRECE VALUES ('77777772','002', '203', '102')");
		insertsYTablas.add("INSERT INTO SESION VALUES ('1730', '1900', '20-01-2016', '88888880', '77777772')");
		insertsYTablas.add("INSERT INTO SESION VALUES ('1000', '1500', '20-01-2016', '88888881', '77777772')");
		insertsYTablas.add("INSERT INTO SESION VALUES ('2000', '2100', '17-01-2016', '88888881', '77777772')");
		insertsYTablas.add("INSERT INTO SESION VALUES ('1800', '2000', '27-01-2016', '88888880', '77777770')");
		insertsYTablas.add("INSERT INTO SESION VALUES ('0930', '1100', '25-01-2016', '88888881', '77777770')");
		insertsYTablas.add("INSERT INTO SESION VALUES ('1300', '1545', '30-01-2016', '88888881', '77777771')");
		insertsYTablas.add("INSERT INTO MENSAJE VALUES ('00000', 'CLASE DE MAÑANA', 'AL FINAL NO PODRE ACUDIR A LA CLASE QUE TENIAMOS ORGANIZADA MAÑANA, LO SIENTO', '19-01-2016')");
		insertsYTablas.add("INSERT INTO MENSAJE VALUES ('00001', 'PRACTICAS DE REPASO', 'NO ESTOY SEGURA DE COMO SE HACEN LAS INTEGRALES, ¿PODRIA PASARME MAS EJERCICIOS PARA PRACTICAR, POR FAVOR?', '17-01-2016')");
		insertsYTablas.add("INSERT INTO MENSAJE VALUES ('00002', 'TUTORIA DE MATE', '¿PODEMOS HACER UNA CLASE INTENSIVA DE INTEGRALES PARA ASEGURARME DE QUE LAS CONTROLO ANTES DEL PARCIAL?', '18-01-2016')");
		insertsYTablas.add("INSERT INTO MENSAJE VALUES ('00003', 'SUSPENSO Y SUBIR NOTA EN EL DESPACHO', '¿MAÑANA PODRIAMOS HACER LA CLASE EN TU DESPACHO? ES QUE EN MI CASA NO SE VA A PODER HACER', '15-01-2016')");
		insertsYTablas.add("INSERT INTO ENVIA VALUES ('00000', '88888880', '77777770', 'ALUMNO')");
		insertsYTablas.add("INSERT INTO ENVIA VALUES ('00001', '88888881', '77777770', 'ALUMNO')");
		insertsYTablas.add("INSERT INTO ENVIA VALUES ('00002', '88888881', '77777770', 'ALUMNO')");
		insertsYTablas.add("INSERT INTO ENVIA VALUES ('00003', '88888880', '77777770', 'ALUMNO')");
		
		Runnable r = new Runnable() {
			@Override
			public void run() {
				for(String s: insertsYTablas){
					BaseDeDatos.insert(s);
				}
			}

		};
		(new Thread(r)).start();

	}
}
