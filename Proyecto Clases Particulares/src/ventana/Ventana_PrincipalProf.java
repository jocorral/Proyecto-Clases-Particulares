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
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	private JPanel panel_Botones;
	private JPanel panelMensaje;
	private JPanel panelPerfil;
	
	public Ventana_PrincipalProf() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana_NewPersona.class.getResource("/ventana/Logo1.JPG")));
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
		panel_Botones.add(bandejaMens_JBut);
		
		JButton nuevaClase_JBut = new JButton("Nueva Clase");
		nuevaClase_JBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_PrincipalProf.this.dispose();
				Ventana_Horarios.main(null);
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
		atras_JBut.setIcon(new ImageIcon(Ventana_PrincipalProf.class.getResource("/ventana/flecha_atras.gif")));
		
		JLayeredPane layeredPane = new JLayeredPane();
		splitPane.setRightComponent(layeredPane);
		
		panelMensaje = new JPanel();
		panelMensaje.setVisible(false);
		panelMensaje.setLayout(null);
		panelMensaje.setBounds(0, 0, 469, 352);
		layeredPane.add(panelMensaje);
		
		JLabel label = new JLabel("Para: ");
		label.setBounds(38, 17, 40, 16);
		panelMensaje.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(119, 11, 264, 28);
		panelMensaje.add(textField);
		
		JLabel label_1 = new JLabel("De parte de: ");
		label_1.setBounds(38, 57, 85, 16);
		panelMensaje.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(119, 51, 264, 28);
		panelMensaje.add(textField_1);
		
		JLabel label_2 = new JLabel("Asunto: ");
		label_2.setBounds(38, 97, 61, 16);
		panelMensaje.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(119, 91, 264, 28);
		panelMensaje.add(textField_2);
		
		JLabel label_3 = new JLabel("Contenido: ");
		label_3.setBounds(188, 126, 85, 22);
		panelMensaje.add(label_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 159, 418, 105);
		panelMensaje.add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		JButton button = new JButton("Enviar");
		button.setBounds(119, 284, 206, 29);
		panelMensaje.add(button);
		
		panelPerfil = new JPanel();
		panelPerfil.setBounds(0, 0, 469, 352);
		layeredPane.add(panelPerfil);
		panelPerfil.setLayout(null);
		
		JLabel label_8 = new JLabel("Nombre: ");
		label_8.setBounds(39, 44, 70, 18);
		panelPerfil.add(label_8);
		
		JLabel label_9 = new JLabel("Apellidos: ");
		label_9.setBounds(39, 84, 70, 18);
		panelPerfil.add(label_9);
		
		JLabel label_10 = new JLabel("Calle: ");
		label_10.setBounds(39, 124, 70, 18);
		panelPerfil.add(label_10);
		
		JButton button_3 = new JButton("Editar");
		button_3.setBounds(316, 299, 89, 23);
		panelPerfil.add(button_3);
		
		JLabel label_11 = new JLabel("Piso: ");
		label_11.setBounds(161, 165, 47, 18);
		panelPerfil.add(label_11);
		
		JLabel label_12 = new JLabel("N\u00BA: ");
		label_12.setBounds(39, 165, 47, 18);
		panelPerfil.add(label_12);
		
		JLabel label_13 = new JLabel("Tel\u00E9fono: ");
		label_13.setBounds(39, 206, 70, 18);
		panelPerfil.add(label_13);
		
		JLabel label_14 = new JLabel("Ciudad: ");
		label_14.setBounds(39, 246, 70, 18);
		panelPerfil.add(label_14);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(101, 245, 174, 20);
		panelPerfil.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(101, 205, 174, 20);
		panelPerfil.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(101, 164, 50, 20);
		panelPerfil.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(228, 164, 47, 20);
		panelPerfil.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(101, 123, 174, 20);
		panelPerfil.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(101, 83, 86, 20);
		panelPerfil.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(101, 43, 174, 20);
		panelPerfil.add(textField_14);
		
		JButton button_4 = new JButton("Guardar");
		button_4.setEnabled(false);
		button_4.setBounds(186, 299, 89, 23);
		panelPerfil.add(button_4);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(189, 83, 86, 20);
		panelPerfil.add(textField_15);
		
		JLabel lblFoto = new JLabel("foto");
		lblFoto.setBounds(316, 75, 109, 132);
		panelPerfil.add(lblFoto);
		
		JButton button_5 = new JButton("Cambiar foto");
		button_5.setBounds(316, 218, 109, 23);
		panelPerfil.add(button_5);
	}

	public static void main(String[] args) {
		Ventana_PrincipalProf frame = new Ventana_PrincipalProf();
		frame.setVisible(true);
	}
}
