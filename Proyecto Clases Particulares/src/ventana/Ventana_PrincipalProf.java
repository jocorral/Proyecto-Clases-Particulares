package ventana;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
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

public class Ventana_PrincipalProf extends JFrame{
	private JTextField txt_Ciudad;
	private JTextField txt_Telefono;
	private JTextField txt_Num;
	private JTextField txt_Piso;
	private JTextField txt_Calle;
	private JTextField txt_Apellido1;
	private JTextField txt_Nombre;
	private JTextField txt_Apellido2;
	private JTextField txt_Para;
	private JTextField txt_DParteD;
	private JTextField txt_Asunto;
	
	private JPanel panel_Botones;
	private JPanel panelMensaje;
	private JPanel panelPerfil;
	
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
				Ventana_PrincipalProf.this.panelMensaje.setVisible(false);
			}
		});
		
		JButton inicio_JBut = new JButton("Inicio");
		panel_Botones.add(inicio_JBut);
		panel_Botones.add(pefil_JBut);
		
		JButton newMes_JBut = new JButton("Nuevo Mensaje");
		newMes_JBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_PrincipalProf.this.panelMensaje.setVisible(true);
				Ventana_PrincipalProf.this.panelPerfil.setVisible(false);
			}
		});
		panel_Botones.add(newMes_JBut);
		
		JButton bandejaMens_JBut = new JButton("Bandeja de entrada");
		bandejaMens_JBut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
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
		
		panelMensaje = new JPanel();
		panelMensaje.setVisible(false);
		panelMensaje.setBounds(0, 0, 469, 352);
		layeredPane.add(panelMensaje);
		panelMensaje.setLayout(null);
		
		JLabel lblPara = new JLabel("Para: ");
		lblPara.setBounds(38, 17, 40, 16);
		panelMensaje.add(lblPara);
		
		txt_Para = new JTextField();
		txt_Para.setBounds(119, 11, 264, 28);
		txt_Para.setColumns(10);
		panelMensaje.add(txt_Para);
		
		JLabel lblDParteD = new JLabel("De parte de: ");
		lblDParteD.setBounds(38, 57, 85, 16);
		panelMensaje.add(lblDParteD);
		
		txt_DParteD = new JTextField();
		txt_DParteD.setBounds(119, 51, 264, 28);
		txt_DParteD.setColumns(10);
		panelMensaje.add(txt_DParteD);
		
		JLabel lblAsunto = new JLabel("Asunto: ");
		lblAsunto.setBounds(38, 97, 61, 16);
		panelMensaje.add(lblAsunto);
		
		txt_Asunto = new JTextField();
		txt_Asunto.setBounds(119, 91, 264, 28);
		txt_Asunto.setColumns(10);
		panelMensaje.add(txt_Asunto);
		
		JLabel lblContenido = new JLabel("Contenido: ");
		lblContenido.setBounds(188, 126, 85, 22);
		panelMensaje.add(lblContenido);
		
		JScrollPane scrollPane_Contenido = new JScrollPane();
		scrollPane_Contenido.setBounds(24, 159, 418, 105);
		panelMensaje.add(scrollPane_Contenido);
		
		JTextPane txt_Contenido = new JTextPane();
		scrollPane_Contenido.setViewportView(txt_Contenido);
		
		JButton enviar_JBut = new JButton("Enviar");
		enviar_JBut.setBounds(119, 284, 206, 29);
		panelMensaje.add(enviar_JBut);
		
		panelPerfil = new JPanel();
		panelPerfil.setVisible(false);
		panelPerfil.setBounds(0, 0, 469, 352);
		layeredPane.add(panelPerfil);
		panelPerfil.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(39, 44, 70, 18);
		panelPerfil.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos: ");
		lblApellidos.setBounds(39, 84, 70, 18);
		panelPerfil.add(lblApellidos);
		
		JLabel lblCalle = new JLabel("Calle: ");
		lblCalle.setBounds(39, 124, 70, 18);
		panelPerfil.add(lblCalle);
		
		JButton editar_JBut = new JButton("Editar");
		editar_JBut.setBounds(316, 299, 89, 23);
		panelPerfil.add(editar_JBut);
		
		JLabel lblPiso = new JLabel("Piso: ");
		lblPiso.setBounds(161, 165, 47, 18);
		panelPerfil.add(lblPiso);
		
		JLabel lblNum = new JLabel("Nº: ");
		lblNum.setBounds(39, 165, 47, 18);
		panelPerfil.add(lblNum);
		
		JLabel lblTelefono = new JLabel("Teléfono: ");
		lblTelefono.setBounds(39, 206, 70, 18);
		panelPerfil.add(lblTelefono);
		
		JLabel lblCiudad = new JLabel("Ciudad: ");
		lblCiudad.setBounds(39, 246, 70, 18);
		panelPerfil.add(lblCiudad);
		
		txt_Ciudad = new JTextField();
		txt_Ciudad.setColumns(10);
		txt_Ciudad.setBounds(101, 245, 174, 20);
		panelPerfil.add(txt_Ciudad);
		
		txt_Telefono = new JTextField();
		txt_Telefono.setColumns(10);
		txt_Telefono.setBounds(101, 205, 174, 20);
		panelPerfil.add(txt_Telefono);
		
		txt_Num = new JTextField();
		txt_Num.setColumns(10);
		txt_Num.setBounds(101, 164, 50, 20);
		panelPerfil.add(txt_Num);
		
		txt_Piso = new JTextField();
		txt_Piso.setColumns(10);
		txt_Piso.setBounds(228, 164, 47, 20);
		panelPerfil.add(txt_Piso);
		
		txt_Calle = new JTextField();
		txt_Calle.setColumns(10);
		txt_Calle.setBounds(101, 123, 174, 20);
		panelPerfil.add(txt_Calle);
		
		txt_Apellido1 = new JTextField();
		txt_Apellido1.setColumns(10);
		txt_Apellido1.setBounds(101, 83, 86, 20);
		panelPerfil.add(txt_Apellido1);
		
		txt_Nombre = new JTextField();
		txt_Nombre.setColumns(10);
		txt_Nombre.setBounds(101, 43, 174, 20);
		panelPerfil.add(txt_Nombre);
		
		JButton guardar_JBut = new JButton("Guardar");
		guardar_JBut.setEnabled(false);
		guardar_JBut.setBounds(186, 299, 89, 23);
		panelPerfil.add(guardar_JBut);
		
		txt_Apellido2 = new JTextField();
		txt_Apellido2.setColumns(10);
		txt_Apellido2.setBounds(189, 83, 86, 20);
		panelPerfil.add(txt_Apellido2);
		
		JLabel lblFoto = new JLabel("foto");
		lblFoto.setBounds(316, 75, 109, 132);
		panelPerfil.add(lblFoto);
		
		JButton cambiarFoto_JBut = new JButton("Cambiar foto");
		cambiarFoto_JBut.setBounds(316, 218, 109, 23);
		panelPerfil.add(cambiarFoto_JBut);
		
		JPanel panelInicio = new JPanel();
		panelInicio.setBounds(0, 0, 469, 352);
		layeredPane.add(panelInicio);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		}

	public static void main(String[] args) {
		Ventana_PrincipalProf frame = new Ventana_PrincipalProf("");
	}
}
