package ventana;

import javax.swing.JFrame;
import javax.swing.JPanel;


import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JLabel;


import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class Ventana_Busqueda extends JFrame implements ActionListener {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	private JButton btnBusqueda;
	private JButton btnPerfil;
	private JButton btnMensaje;
	private JButton btnAtras;
	private JPanel panelBotonera;
	private JLabel lblTipoDeAsignatura;
	private JComboBox<String> comboBox_tipo;
	private JPanel panel_colegio;
	private JTextField textField;
	private JRadioButton rdbtnEso;
	private JRadioButton rdbtnBachillerato;
	private JLabel lblIdioma;
	private JComboBox<String> comboBox_1;
	private JPanel panel_escuelaDeIdiomas;
	private JLabel lblIdioma_1;
	private JComboBox<String> comboBox_2;
	private JLabel lblNivel_1;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxA;
	private JCheckBox chckbxB;
	private JCheckBox chckbxB_1;
	private JCheckBox chckbxC;
	private JCheckBox chckbxC_1;
	private JLabel lblAsignatura;
	private JLabel lblNivel;
	private JRadioButton rdbtnNewRadioButton;
	
	public Ventana_Busqueda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(684, 445);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 162, 416);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		btnBusqueda = new JButton("BÚSQUEDA");
		btnBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBusqueda.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBusqueda.setBounds(10, 11, 141, 80);
		panel.add(btnBusqueda);
		
		btnPerfil = new JButton("PERFIL");
		btnPerfil.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPerfil.setBounds(10, 113, 141, 86);
		panel.add(btnPerfil);
		
		btnMensaje = new JButton("MENSAJES");
		btnMensaje.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMensaje.setBounds(10, 217, 141, 86);
		panel.add(btnMensaje);
		
		btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(Ventana_Busqueda.class 
				.getResource("/imagenes/Flecha_atras.gif")));
		btnAtras.setBounds(10, 325, 141, 80);
		panel.add(btnAtras);
		
		panelBotonera = new JPanel();
		panelBotonera.setBackground(Color.LIGHT_GRAY);
		panelBotonera.setBounds(161, 0, 517, 111);
		getContentPane().add(panelBotonera);
		panelBotonera.setLayout(null);
		
		lblTipoDeAsignatura = new JLabel("Tipo de asignatura:");
		lblTipoDeAsignatura.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipoDeAsignatura.setBounds(10, 11, 123, 14);
		panelBotonera.add(lblTipoDeAsignatura);
		
		comboBox_tipo = new JComboBox<String>();
		comboBox_tipo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox_tipo.setModel(new DefaultComboBoxModel<String>(new String[] {"    -  Elija tipo  -", "Colegio", "Escuela de idiomas"}));
		comboBox_tipo.setBounds(134, 9, 123, 20);
		panelBotonera.add(comboBox_tipo);
		
		panel_colegio = new JPanel();
		panel_colegio.setBackground(Color.LIGHT_GRAY);
		panel_colegio.setBounds(10, 36, 497, 70);
		panelBotonera.add(panel_colegio);
		panel_colegio.setLayout(null);
		
		lblAsignatura = new JLabel("Asignatura:");
		lblAsignatura.setBounds(10, 11, 71, 15);
		panel_colegio.add(lblAsignatura);
		lblAsignatura.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField = new JTextField();
		textField.setBounds(91, 9, 167, 20);
		panel_colegio.add(textField);
		textField.setColumns(10);
		
		lblNivel = new JLabel("Nivel:");
		lblNivel.setBounds(10, 43, 46, 14);
		panel_colegio.add(lblNivel);
		lblNivel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		rdbtnNewRadioButton = new JRadioButton("Primaria");
		rdbtnNewRadioButton.setBounds(71, 39, 71, 23);
		panel_colegio.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNewRadioButton.setBackground(Color.LIGHT_GRAY);
		
		rdbtnEso = new JRadioButton("ESO");
		rdbtnEso.setBounds(181, 40, 52, 23);
		panel_colegio.add(rdbtnEso);
		rdbtnEso.setBackground(Color.LIGHT_GRAY);
		
		rdbtnBachillerato = new JRadioButton("Bachillerato");
		rdbtnBachillerato.setBounds(266, 40, 97, 23);
		panel_colegio.add(rdbtnBachillerato);
		rdbtnBachillerato.setBackground(Color.LIGHT_GRAY);
		
		lblIdioma = new JLabel("Idioma:");
		lblIdioma.setBounds(278, 11, 46, 14);
		panel_colegio.add(lblIdioma);
		lblIdioma.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(334, 9, 146, 20);
		panel_colegio.add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"- Elija idioma -", "Euskera", "Ingl\u00E9s", "Franc\u00E9s", "Alem\u00E1n"}));
		
		panel_escuelaDeIdiomas = new JPanel();
		panel_escuelaDeIdiomas.setBounds(10, 36, 497, 70);
		panelBotonera.add(panel_escuelaDeIdiomas);
		panel_escuelaDeIdiomas.setBackground(Color.LIGHT_GRAY);
		panel_escuelaDeIdiomas.setLayout(null);
		
		lblIdioma_1 = new JLabel("Idioma:");
		lblIdioma_1.setBounds(10, 11, 46, 15);
		panel_escuelaDeIdiomas.add(lblIdioma_1);
		lblIdioma_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		comboBox_2 = new JComboBox<String>();
		comboBox_2.setModel(new DefaultComboBoxModel<String>(new String[] {"- Elija idioma -", "Euskera", "Espa\u00F1ol", "Ingl\u00E9s", "Franc\u00E9s", "Alem\u00E1n", "Italiano", "Chino", "Japon\u00E9s", "Ruso"}));
		comboBox_2.setBounds(66, 9, 108, 20);
		panel_escuelaDeIdiomas.add(comboBox_2);
		
		lblNivel_1 = new JLabel("Nivel:");
		lblNivel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNivel_1.setBounds(206, 11, 46, 14);
		panel_escuelaDeIdiomas.add(lblNivel_1);
		
		chckbxNewCheckBox = new JCheckBox("A1");
		chckbxNewCheckBox.setBackground(Color.LIGHT_GRAY);
		chckbxNewCheckBox.setBounds(258, 8, 47, 23);
		panel_escuelaDeIdiomas.add(chckbxNewCheckBox);
		
		chckbxA = new JCheckBox("A2");
		chckbxA.setBackground(Color.LIGHT_GRAY);
		chckbxA.setBounds(258, 34, 47, 23);
		panel_escuelaDeIdiomas.add(chckbxA);
		
		chckbxB = new JCheckBox("B1");
		chckbxB.setBackground(Color.LIGHT_GRAY);
		chckbxB.setBounds(331, 8, 46, 23);
		panel_escuelaDeIdiomas.add(chckbxB);
		
		chckbxB_1 = new JCheckBox("B2");
		chckbxB_1.setBackground(Color.LIGHT_GRAY);
		chckbxB_1.setBounds(331, 34, 46, 23);
		panel_escuelaDeIdiomas.add(chckbxB_1);
		
		chckbxC = new JCheckBox("C1");
		chckbxC.setBackground(Color.LIGHT_GRAY);
		chckbxC.setBounds(404, 9, 46, 20);
		panel_escuelaDeIdiomas.add(chckbxC);
		
		chckbxC_1 = new JCheckBox("C2");
		chckbxC_1.setBackground(Color.LIGHT_GRAY);
		chckbxC_1.setBounds(404, 38, 46, 19);
		panel_escuelaDeIdiomas.add(chckbxC_1);
		
		panel_escuelaDeIdiomas.setVisible(false);
		panel_colegio.setVisible(false);
		
		comboBox_tipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox_tipo.getSelectedItem().toString().equals("    -  Elija tipo  -")){
					panel_escuelaDeIdiomas.setVisible(false);
					panel_colegio.setVisible(false);
				}else if (comboBox_tipo.getSelectedItem().toString().equals("Colegio")){
					panel_escuelaDeIdiomas.setVisible(false);
					panel_colegio.setVisible(true);
				} else{
					panel_colegio.setVisible(false);
					panel_escuelaDeIdiomas.setVisible(true);
				}
			}
		});
		btnBusqueda.addActionListener(this);
		btnPerfil.addActionListener(this);
		btnMensaje.addActionListener(this);
		btnAtras.addActionListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o = arg0.getSource();
		if (o == btnBusqueda) {
			Ventana_Busqueda ventanaBusqueda = new Ventana_Busqueda();
			ventanaBusqueda.setVisible(true);
			this.setVisible(false);
		} else if (o == btnPerfil) {
			//TODO Ventana de Enara
			this.dispose();
			//this.setVisible(false);
		} else if (o == btnMensaje) {
			System.out.println("Mensajes");
			Ventana_Mensajes.crearYMostrarGUI();
			this.setVisible(false);
		} else if (o == btnAtras) {
			Ventana_Login ventanaLogin = new Ventana_Login();
			ventanaLogin.setVisible(true);
			this.setVisible(false);
		}

	}

	public static void main(String[] args) {
		Ventana_Busqueda ventanaBusqueda = new Ventana_Busqueda();
	}
}
