package ventana;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTable;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLayeredPane;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import objetos.BaseDeDatos;
import objetos.Mensaje;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ventana_PrincipalProf extends JFrame{

	private static final long serialVersionUID = 1L;
	final String [] columnasBandejaEntrada ={"Cod","De","Para","Asunto","Cont","Fecha"} ;
	final String[] columnasTablaClases = {"Hora", "Alumno"};
	private String fechaDeHoy;
	private JButton guardar_JBut;
	private JPanel panelInicio;
	private JPanel panelMensajes;
	private JPanel panel_Botones;
	private JPanel panelPerfil;
	private JPanel panelBandejaEntrada;
	public JLabel lblFotoP;
	private JTextField txt_Telefono;
	private JTextField txt_Ciudad;
	private JTextField txt_Apellido1;
	private JTextField txt_Apellido2;
	private JTextField txt_Nombre;
	private JTextField textField_1;
	private JTextField asunto;
	private JTextField para;
	private JTextPane contenido;
	private JFileChooser fcExaminar;
	private JTable tablaClases;
	private JTextPane txt_Direccion;

	private String[][] dato;
	private JTable tableMensajes;
	private TableModel modeloT;
	private JTextPane Contenido;
	
	public Ventana_PrincipalProf(String userName) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana_NewPersona.class.getResource("/imagenes/Logo1.JPG")));
		setBounds(100, 100, 609, 383);
		setTitle("Principal (Profesor)");

		JSplitPane splitPane = new JSplitPane();
		getContentPane().add(splitPane, BorderLayout.CENTER);

		panel_Botones = new JPanel();
		splitPane.setLeftComponent(panel_Botones);
		panel_Botones.setLayout(new GridLayout(0, 1, 0, 0));

		JButton pefil_JBut = new JButton("Pefil");
		pefil_JBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaDeDatosPerfil();
				txt_Telefono.setEditable(false);
				txt_Apellido1.setEditable(false);
				txt_Apellido2.setEditable(false);
				txt_Ciudad.setEditable(false);
				txt_Nombre.setEditable(false);
				txt_Direccion.setEditable(false);
				textField_1.setEditable(false);
				Ventana_PrincipalProf.this.panelPerfil.setVisible(true);
				Ventana_PrincipalProf.this.panelInicio.setVisible(false);
				Ventana_PrincipalProf.this.panelMensajes.setVisible(false);
				Ventana_PrincipalProf.this.panelBandejaEntrada.setVisible(false);
			}
		});

		JButton inicio_JBut = new JButton("Inicio");
		inicio_JBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_PrincipalProf.this.panelInicio.setVisible(true);
				Ventana_PrincipalProf.this.panelPerfil.setVisible(false);
				Ventana_PrincipalProf.this.panelMensajes.setVisible(false);
				Ventana_PrincipalProf.this.panelBandejaEntrada.setVisible(false);
			}

		});
		panel_Botones.add(inicio_JBut);
		panel_Botones.add(pefil_JBut);

		JButton newMes_JBut = new JButton("Nuevo Mensaje");
		newMes_JBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_PrincipalProf.this.panelMensajes.setVisible(true);
				Ventana_PrincipalProf.this.panelPerfil.setVisible(false);
				Ventana_PrincipalProf.this.panelInicio.setVisible(false);
				Ventana_PrincipalProf.this.panelBandejaEntrada.setVisible(false);
			}
		});
		panel_Botones.add(newMes_JBut);

		JButton bandejaMens_JBut = new JButton("Bandeja de entrada");
		bandejaMens_JBut.addActionListener(new ActionListener() {							
			public void actionPerformed(ActionEvent e) {
//				ArrayList<String> a= new ArrayList<>();	
//				BaseDeDatos.obtenerMensajes();					
//				dato =new String[a.size()/6][6];
//				dato = pasarArrayLAArray(a, 6);				
				modeloT= new DefaultTableModel(dato , columnasTablaClases);							
				Ventana_PrincipalProf.this.panelBandejaEntrada.setVisible(true);
				Ventana_PrincipalProf.this.panelPerfil.setVisible(false);
				Ventana_PrincipalProf.this.panelInicio.setVisible(false);
				Ventana_PrincipalProf.this.panelMensajes.setVisible(false);

				
				
			}
		});

		panel_Botones.add(bandejaMens_JBut);

		JButton nuevaClase_JBut = new JButton("Nueva Clase");
		nuevaClase_JBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_PrincipalProf.this.dispose();
				Ventana_Horarios ventanaHorario = new Ventana_Horarios();	
				ventanaHorario.setSize(525,414);
				ventanaHorario.setLocationRelativeTo(null);
				ventanaHorario.setVisible(true);
			}
		});
		panel_Botones.add(nuevaClase_JBut);

		JButton atras_JBut = new JButton("");	
		atras_JBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_PrincipalProf.this.dispose();
				Ventana_Login a = new Ventana_Login();
				a.setVisible(true);
			}
		});	
		panel_Botones.add(atras_JBut);
		atras_JBut.setIcon(new ImageIcon(Ventana_PrincipalProf.class.getResource("/imagenes/flecha_atras.gif")));

		JLayeredPane layeredPane = new JLayeredPane();
		splitPane.setRightComponent(layeredPane);

		panelMensajes = new JPanel();
		panelMensajes.setVisible(false);
		panelMensajes.setBounds(0, 0, 469, 352);
		layeredPane.add(panelMensajes);
		panelMensajes.setLayout(null);

		JLabel label_1 = new JLabel("De parte de: ");
		label_1.setBounds(39, 30, 85, 16);
		panelMensajes.add(label_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(120, 24, 264, 28);
		panelMensajes.add(textField_1);

		JLabel label_2 = new JLabel("Asunto: ");
		label_2.setBounds(39, 110, 61, 16);
		panelMensajes.add(label_2);

		asunto = new JTextField();
		asunto.setColumns(10);
		asunto.setBounds(120, 104, 264, 28);
		panelMensajes.add(asunto);

		JLabel label_3 = new JLabel("Contenido: ");
		label_3.setBounds(189, 139, 85, 22);
		panelMensajes.add(label_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 172, 418, 105);
		panelMensajes.add(scrollPane);

		contenido = new JTextPane();
		scrollPane.setViewportView(contenido);

		JButton button = new JButton("Enviar");	
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				
				if ((para.getText().equals(""))				
						|| (asunto.getText().equals(""))
						|| (Contenido.getText().equals(""))) {
					JOptionPane.showMessageDialog(Ventana_PrincipalProf.this.panelMensajes,
							"Hay un campo incompleto", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}else {
					String asunto_ = asunto.getText() ;
					String contenido_= Contenido.getText() ;
					String para_= para.getText() ;				
					String CodMensaje=BaseDeDatos.selectUnValor("SELECT * FROM MENSAJE WHERE MAX(COD) ", "COD");					 
					int CodMensaje1=Integer.parseInt(CodMensaje.trim());
					CodMensaje1=CodMensaje1+1;
					String CodMensaje_ = Integer.toString(CodMensaje1);	 
					
					String Tipo=BaseDeDatos.selectUnValor("SELECT * FROM PERSONA WHERE USERNAME = '" + Ventana_Login.getMiUser() + "' AND "
							+ "TIPO_USUARIO = 'ALUMNO'", "TIPO_USUARIO");
					
					if(Tipo.equals("ALUMNO")){
						Tipo="ALUMNO";
						}
					else {
						Tipo="PROFESOR";
						}
					
					String DNIA=BaseDeDatos.selectUnValor("SELECT * FROM PERSONA WHERE USERNAME = '" + para_ + "' AND "
							+ "TIPO_USUARIO = 'ALUMNO'", "DNI");
					String DNIP=BaseDeDatos.selectUnValor("SELECT * FROM PERSONA WHERE USERNAME = '" + Ventana_Login.getMiUser() + "' AND "
							+ "TIPO_USUARIO = 'PROFESOR'", "DNI");

					System.out.println("datos guardados en la BD:"+CodMensaje_ +asunto_+  contenido_+DNIP+  DNIA+  Tipo);
					BaseDeDatos.crearMensaje( CodMensaje_ , asunto_,  contenido_);					
					BaseDeDatos.crearEnvia(CodMensaje_,  DNIP,  DNIA,  Tipo);
					
					JOptionPane.showMessageDialog(Ventana_PrincipalProf.this.panelMensajes,
							"El mensaje ha sido enviado", "ENVIADO",
							JOptionPane.INFORMATION_MESSAGE);
					
					Ventana_PrincipalProf.this.remove(panelMensajes);
					getContentPane().add(panelMensajes);
					Ventana_PrincipalProf.this.repaint();
				}
			
			
			}
		});
		button.setBounds(120, 297, 206, 29);
		panelMensajes.add(button);

		para = new JTextField();
		para.setColumns(10);
		para.setBounds(120, 65, 264, 28);
		panelMensajes.add(para);

		JLabel label = new JLabel("Para: ");
		label.setBounds(39, 71, 40, 16);
		panelMensajes.add(label);

		panelInicio = new JPanel();
		panelInicio.setBounds(0, 0, 469, 352);
		layeredPane.add(panelInicio);
		panelInicio.setLayout(null);

		JLabel lblClasesDelDia = new JLabel("Clases del dia");
		lblClasesDelDia.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblClasesDelDia.setFocusTraversalPolicyProvider(true);
		lblClasesDelDia.setBounds(165, 28, 280, 50);
		panelInicio.add(lblClasesDelDia);

		JButton calendario_JBut = new JButton("Calendario");
		calendario_JBut.setBounds(23, 300, 120, 23);
		calendario_JBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_Calendario calendario = new Ventana_Calendario();
				calendario.setVisible(true);
				calendario.setLocationRelativeTo(null);
			}
		});
		panelInicio.add(calendario_JBut);

		JButton borrar_JBut = new JButton("Borrar");
		borrar_JBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int columna = tablaClases.getSelectedColumn();
				int fila = tablaClases.getSelectedRow();
				Object aBuscar = tablaClases.getValueAt(fila, columna);
				BaseDeDatos.insert("DELETE FROM SESION WHERE H_INI = '" + tablaClases.getValueAt(fila, 0).toString().toUpperCase().substring(0, 3)
						+ "' AND FECHA = '" + fechaDeHoy +
						"' AND USERNAME_P = '" + Ventana_Login.getMiUser().toUpperCase() +"'");
				System.out.println("Sesion borrada");
				tablaClases.setModel(cargarModeloEnTablaClases());
			}
		});
		borrar_JBut.setBounds(318, 300, 120, 23);
		panelInicio.add(borrar_JBut);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 88, 435, 178);
		panelInicio.add(scrollPane_3);
		TableModel modeloTablaClases = cargarModeloEnTablaClases();
		tablaClases = new JTable(modeloTablaClases);
		scrollPane_3.setViewportView(tablaClases);		
		tablaClases.setBackground(Color.WHITE);

		panelPerfil = new JPanel();
		panelPerfil.setVisible(false);
		panelPerfil.setBounds(0, 0, 469, 352);
		layeredPane.add(panelPerfil);
		panelPerfil.setLayout(null);

		lblFotoP = new JLabel("");
		lblFotoP.setIcon(new ImageIcon(Ventana_PrincipalProf.class.getResource("/imagenes/Perfil.png")));
		lblFotoP.setBounds(44, 45, 124, 166);
		panelPerfil.add(lblFotoP);

		JButton editarP_JBut = new JButton("");
		editarP_JBut.setIcon(new ImageIcon(Ventana_PrincipalProf.class.getResource("/imagenes/iconoEditar.png")));
		editarP_JBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int opcion = fcExaminar.showOpenDialog(null);
				if (opcion == 0){
					String path = fcExaminar.getSelectedFile().getAbsolutePath();
					ImageIcon image = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(140, 150, Image.SCALE_DEFAULT));
					lblFotoP.setIcon(image);
				}
			}
		});
		editarP_JBut.setBounds(44, 217, 89, 23);
		panelPerfil.add(editarP_JBut);

		JButton editar_JBut = new JButton("");
		editar_JBut.setIcon(new ImageIcon(Ventana_PrincipalProf.class.getResource("/imagenes/iconoEditar.png")));
		editar_JBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				txt_Telefono.setEditable(true);
				txt_Apellido1.setEditable(true);
				txt_Apellido2.setEditable(true);
				txt_Direccion.setEditable(true);			
				txt_Ciudad.setEditable(true);
				txt_Nombre.setEditable(true);
				guardar_JBut.setEnabled(true);
			}
		});
		editar_JBut.setBounds(239, 286, 89, 23);
		panelPerfil.add(editar_JBut);

		guardar_JBut = new JButton("Guardar");
		guardar_JBut.setEnabled(false);
		guardar_JBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("hihi");
				String 	nombre=txt_Nombre.getText();
				String	apellido_1=txt_Apellido1.getText();
				String	apellido_2=txt_Apellido2.getText();
				String	tlf=txt_Telefono.getText();
				String dir=txt_Direccion.getText();
				String ciudad=txt_Ciudad.getText();
				System.out.println(nombre+  apellido_1+  apellido_2+tlf+  dir+ ciudad);
				BaseDeDatos.editarProfesor(  nombre,  apellido_1,  apellido_2,tlf,  dir,  ciudad);
			}
		});

		guardar_JBut.setBounds(343, 286, 89, 23);
		panelPerfil.add(guardar_JBut);

		JLabel lblTelefono = new JLabel("Tel\u00E9fono: ");
		lblTelefono.setBounds(196, 232, 70, 18);
		panelPerfil.add(lblTelefono);

		txt_Telefono = new JTextField();
		txt_Telefono.setColumns(10);
		txt_Telefono.setBounds(258, 231, 174, 20);
		panelPerfil.add(txt_Telefono);

		txt_Ciudad = new JTextField();
		txt_Ciudad.setColumns(10);
		txt_Ciudad.setBounds(258, 109, 174, 20);
		panelPerfil.add(txt_Ciudad);

		txt_Apellido1 = new JTextField();
		txt_Apellido1.setColumns(10);
		txt_Apellido1.setBounds(258, 70, 86, 20);
		panelPerfil.add(txt_Apellido1);

		JLabel lblApellidos = new JLabel("Apellidos: ");
		lblApellidos.setBounds(196, 71, 70, 18);
		panelPerfil.add(lblApellidos);

		txt_Apellido2 = new JTextField();
		txt_Apellido2.setColumns(10);
		txt_Apellido2.setBounds(346, 70, 86, 20);
		panelPerfil.add(txt_Apellido2);

		txt_Nombre = new JTextField();
		txt_Nombre.setColumns(10);
		txt_Nombre.setBounds(258, 30, 174, 20);
		panelPerfil.add(txt_Nombre);

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(196, 31, 70, 18);
		panelPerfil.add(lblNombre);

		JLabel lblCiudad = new JLabel("Ciudad: ");
		lblCiudad.setBounds(196, 110, 70, 18);
		panelPerfil.add(lblCiudad);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(258, 146, 174, 65);
		panelPerfil.add(scrollPane_2);

		txt_Direccion = new JTextPane();
		scrollPane_2.setViewportView(txt_Direccion);


		JLabel lblDireccion = new JLabel("Direccion: ");
		lblDireccion.setBounds(188, 146, 81, 21);
		panelPerfil.add(lblDireccion);

		panelBandejaEntrada = new JPanel();
		panelBandejaEntrada.setBounds(0, 0, 469, 352);
		layeredPane.add(panelBandejaEntrada);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 88, 435 ,300 );
		panelBandejaEntrada.add(scrollPane_1);
		TableModel modeloTablaMensajes = cargarModeloBandeja();
		
		tableMensajes = new JTable(modeloTablaMensajes);
		scrollPane_1.setViewportView(tableMensajes);
		tableMensajes.setBounds(10, 88, 435, 300);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);

		this.fcExaminar = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imágenes jpg, ico y png", "jpg", "png", "ico");
		this.fcExaminar.setFileFilter(filtro);
	}

	public static String[][] pasarArrayLAArray(ArrayList<String> array, int numCols) {
		String[][] devolver = new String[array.size()/numCols][numCols];
		for(int b = 0; b<(array.size()/numCols); b++){
			for(int x = 0; x<numCols; x++){
				devolver[b][x] = array.get(b*numCols+x);
			}
		}
		return devolver;
	}

	private void cargaDeDatosPerfil() {
		txt_Nombre.setText(BaseDeDatos.selectUnValor("SELECT * FROM PERSONA WHERE USERNAME = '" + Ventana_Login.getMiUser().toUpperCase() + "'", "NOMBRE"));
		txt_Apellido1.setText(BaseDeDatos.selectUnValor("SELECT * FROM PERSONA WHERE USERNAME = '" + Ventana_Login.getMiUser().toUpperCase() + "'", "APELLIDO_1"));
		txt_Apellido2.setText(BaseDeDatos.selectUnValor("SELECT * FROM PERSONA WHERE USERNAME = '" + Ventana_Login.getMiUser().toUpperCase() + "'", "APELLIDO_2"));
		txt_Ciudad.setText(BaseDeDatos.selectUnValor("SELECT * FROM PERSONA WHERE USERNAME = '" + Ventana_Login.getMiUser().toUpperCase() + "'", "CIUDAD"));
		txt_Direccion.setText(BaseDeDatos.selectUnValor("SELECT * FROM PERSONA WHERE USERNAME = '" + Ventana_Login.getMiUser().toUpperCase() + "'", "DIR"));
		txt_Telefono.setText(BaseDeDatos.selectUnValor("SELECT * FROM PERSONA WHERE USERNAME = '" + Ventana_Login.getMiUser().toUpperCase() + "'", "TLF"));
	}

	private TableModel cargarModeloEnTablaClases(){
		//Carga de las horas y los alumnos en la tabla de clases del dia
		//		String hora;
		//		ArrayList<String> horasIniSesion = BaseDeDatos.selectVariosValores("SELECT * FROM SESION WHERE USERNAME_P = '" + Ventana_Login.getMiUser() + "' AND FECHA = '" + fechaDeHoy + "'", "H_INI");
		//		ArrayList<String> horasFinSesion = BaseDeDatos.selectVariosValores("SELECT * FROM SESION WHERE USERNAME_P = '" + Ventana_Login.getMiUser() + "' AND FECHA = '" + fechaDeHoy + "'", "H_FIN");
		//		ArrayList<String> alumnos = BaseDeDatos.selectVariosValores("SELECT * FROM SESION WHERE USERNAME_P = '" + Ventana_Login.getMiUser() + "' AND FECHA = '" + fechaDeHoy + "'", "USERNAME_A");	
		//		for(int i = 0; i<horasIniSesion.size(); i++){
		//			hora = horasIniSesion.get(i).substring(0,1) + ":" + horasIniSesion.get(i).substring(2) + " - " + horasFinSesion.get(i).substring(0,1) + ":" + horasFinSesion.get(i).substring(2);
		//			arrayClases.add(hora);
		//			arrayClases.add(alumnos.get(i));
		//			System.out.println("horas" + hora + "alumno" + alumnos.get(i));
		//		}	
		Calendar fecha = new GregorianCalendar();
		int mesN = fecha.get(Calendar.MONTH) +1;
		String mesS;
		if(mesN<10){
			mesS = "0" + Integer.toString(mesN);
		}else{
			mesS = Integer.toString(mesN);
		}

		int anyo = fecha.get(Calendar.YEAR);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		fechaDeHoy = dia + "-" + mesS + "-" + anyo;
		System.out.println("buscando" + fechaDeHoy);
		ArrayList<String> arrayClases = new ArrayList<String>();
		arrayClases = BaseDeDatos.selectParaDia(Ventana_Login.getMiUser().toUpperCase(), fechaDeHoy);
		String [][] clases = new String[arrayClases.size()/2][2];
		clases = pasarArrayLAArray(arrayClases, 2);
		TableModel modeloTablaClases = new DefaultTableModel(clases, columnasTablaClases);
		return modeloTablaClases;
	}
	public TableModel cargarModeloBandeja() {
		ArrayList<String> a= new ArrayList<>();	
		a = BaseDeDatos.obtenerMensajes();			
		 String [][] dato =new String[a.size()/6][6];
		dato = pasarArrayLAArray(a, 6);		
		 TableModel modelo= new DefaultTableModel(dato , columnasBandejaEntrada);			
		return modelo;
		
	}
}
