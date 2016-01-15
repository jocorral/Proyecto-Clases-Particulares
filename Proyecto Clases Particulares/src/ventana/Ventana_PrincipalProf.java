package ventana;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import java.awt.GridLayout;

import javax.swing.SpringLayout;

import java.awt.GridBagLayout;

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

import objetos.Mensaje;

import java.awt.Font;
import java.util.ArrayList;

public class Ventana_PrincipalProf extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel panelInicio;
	private JPanel panelMensajes;
	private JPanel panel_Botones;
	private JPanel panelPerfil;
	private JPanel panelBandejaEntrada;
	public JLabel lblFotoP;
	private JTextField txt_Telefono;
	private JTextField txt_Piso;
	private JTextField txt_Num;
	private JTextField txt_Calle;
	private JTextField txt_Ciudad;
	private JTextField txt_Apellido1;
	private JTextField txt_Apellido2;
	private JTextField txt_Nombre;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField;
	private JTable tablaBandejaEntrada;
	Mensaje a1 = new Mensaje("Normal", "Usuario 3", "Usuario 1", "Clases Matematicas", "Hola, que tal? \n Me gustaria decidir la hora de mañana", "18:54", "20-12-2015");
	Mensaje a2 = new Mensaje("Normal", "Usuario 1", "Usuario 4", "Clases Fisica", "Hola, que tal? \n Me gustaria decidir la hora del viernes", "15:12", "12-12-2015");
	Mensaje a3 = new Mensaje("Normal", "Usuario 5", "Usuario 2", "Clases Sociales", "Hola, que tal? \n Me gustaria decidir la hora de la semana que viene", "16:30", "05-12-2015");
	Mensaje a4 = new Mensaje("Normal", "Usuario 4", "Usuario 3", "Clases Euskera", "Hola, que tal? \n Me gustaria decidir la hora de hoy", "06:07", "21-12-2015");
	private ArrayList<Mensaje> a = new ArrayList<Mensaje>();
	private TableModel modeloT;
	private JFileChooser fcExaminar;
	
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
			@Override
			public void actionPerformed(ActionEvent e) {
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

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(120, 104, 264, 28);
		panelMensajes.add(textField_2);

		JLabel label_3 = new JLabel("Contenido: ");
		label_3.setBounds(189, 139, 85, 22);
		panelMensajes.add(label_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 172, 418, 105);
		panelMensajes.add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);

		JButton button = new JButton("Enviar");
		button.setBounds(120, 297, 206, 29);
		panelMensajes.add(button);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(120, 65, 264, 28);
		panelMensajes.add(textField);

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
		lblClasesDelDia.setBounds(163, 28, 129, 50);
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
		borrar_JBut.setBounds(318, 300, 120, 23);
		panelInicio.add(borrar_JBut);

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
		editar_JBut.setBounds(239, 286, 89, 23);
		panelPerfil.add(editar_JBut);

		JButton guardar_JBut = new JButton("Guardar");
		guardar_JBut.setEnabled(false);
		guardar_JBut.setBounds(343, 286, 89, 23);
		panelPerfil.add(guardar_JBut);

		JLabel lblTelefono = new JLabel("Tel\u00E9fono: ");
		lblTelefono.setBounds(196, 232, 70, 18);
		panelPerfil.add(lblTelefono);

		txt_Telefono = new JTextField();
		txt_Telefono.setColumns(10);
		txt_Telefono.setBounds(258, 231, 174, 20);
		panelPerfil.add(txt_Telefono);

		txt_Piso = new JTextField();
		txt_Piso.setColumns(10);
		txt_Piso.setBounds(385, 190, 47, 20);
		panelPerfil.add(txt_Piso);

		JLabel lblPiso = new JLabel("Piso: ");
		lblPiso.setBounds(328, 191, 47, 18);
		panelPerfil.add(lblPiso);

		JLabel lblNum = new JLabel("Nº: ");
		lblNum.setBounds(196, 191, 47, 18);
		panelPerfil.add(lblNum);

		txt_Num = new JTextField();
		txt_Num.setColumns(10);
		txt_Num.setBounds(258, 190, 50, 20);
		panelPerfil.add(txt_Num);

		txt_Calle = new JTextField();
		txt_Calle.setColumns(10);
		txt_Calle.setBounds(258, 149, 174, 20);
		panelPerfil.add(txt_Calle);

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

		JLabel lblCalle = new JLabel("Calle: ");
		lblCalle.setBounds(196, 150, 70, 18);
		panelPerfil.add(lblCalle);

		JLabel lblCiudad = new JLabel("Ciudad: ");
		lblCiudad.setBounds(196, 110, 70, 18);
		panelPerfil.add(lblCiudad);

		//TODO Cambiar a BD 
		a.add(a1);
		a.add(a2);
		a.add(a3);
		a.add(a4);	
		String[][] dato = new String[a.size()][7];

		for(int i = 0; i<a.size(); i++){
			dato[i][0] = a.get(i).getTipo();			
			dato[i][1] = a.get(i).getPara();			
			dato[i][2] = a.get(i).getDe();
			dato[i][3] = a.get(i).getAsunto();			
			dato[i][4] = a.get(i).getContenido();		
			dato[i][5] = a.get(i).getHora();	
			dato[i][6] = a.get(i).getFecha();
		}
		modeloT = new DefaultTableModel( dato, new String[]{"Tipo Mensaje", "Para", "De", "Asunto", "Mensaje", "Hora", "Fecha"});
		tablaBandejaEntrada = new JTable(modeloT);

		panelBandejaEntrada = new JPanel();
		panelBandejaEntrada.setBounds(0, 0, 469, 352);
		layeredPane.add(panelBandejaEntrada);
		// tablaBandejaEntrada.setBounds(x, y, width, height);
		panelBandejaEntrada.add(tablaBandejaEntrada);

		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		this.fcExaminar = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imágenes jpg, ico y png", "jpg", "png", "ico");
		this.fcExaminar.setFileFilter(filtro);
	}

	public static void main(String[] args) {
		Ventana_PrincipalProf frame = new Ventana_PrincipalProf("");
	}
}
