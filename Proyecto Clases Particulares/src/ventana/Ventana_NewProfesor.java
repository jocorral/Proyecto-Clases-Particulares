package ventana;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.BoxLayout;

import java.awt.GridLayout;

import javax.swing.JSplitPane;

import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.Box;
import javax.swing.JTextArea;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLayeredPane;

import objetos.BaseDeDatos;
import objetos.Persona;
import objetos.Profesor;

import java.awt.Label;
import java.awt.Button;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;

import java.awt.Color;
import java.beans.Statement;
import java.sql.SQLException;


public class Ventana_NewProfesor{

	private Persona persona;
	private JFrame frame;
	private boolean estaRelleno ;
	private JSlider slider;
	private JTextField txtAsig;
	private JComboBox<String> comboBox_tipo; 
	private JTextPane textPane;
	private JPanel panel_escueladeidiomas;
	private JPanel panel_colegio;
	private JComboBox<String> eligeIdiomaCombo;
	private JComboBox<String> eligeIdiomaEscCombo;
	private JRadioButton rButPrimaria;
	private JRadioButton rButESO;
	private JRadioButton rButBachi;
	private JCheckBox checkBox;
	private JCheckBox checkBox_1;
	private JCheckBox checkBox_2;
	private JCheckBox checkBox_3;
	private JCheckBox checkBox_4;
	private JCheckBox checkBox_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Persona a = new Persona();
					Ventana_NewProfesor window = new Ventana_NewProfesor(a);
					window.frame.setLocationRelativeTo(null);
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana_NewProfesor(Persona nuevaPersona) {
		this.persona = nuevaPersona;
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana_NewPersona.class.getResource("/imagenes/Logo1.JPG")));
		frame.setBounds(100, 100, 698, 526);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false); //you can't see me!
				frame.dispose(); //Destroy the JFrame object
			}
		});
		btnAtras.setBounds(107, 447, 117, 29);
		frame.getContentPane().add(btnAtras);
		JButton siguiente_JButton = new JButton("Guardar");
		siguiente_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				estaRelleno = guardar();
				if(estaRelleno==false){			
					String message="Debe rellenar los campos";					
					JOptionPane.showMessageDialog(frame, message, "¡Casillas vacías!", JOptionPane.ERROR_MESSAGE);
				}
				else{
					int n = 0;
					String textoCurriculum;
						n=(int)slider.getValue();				
					textoCurriculum = textPane.getText();
					BaseDeDatos.insert("INSERT INTO PROFESOR VALUES('" + Ventana_NewPersona.getDni() + "', '"
							+ n + "', '" + textoCurriculum.toUpperCase() + "')");
					System.out.println("Profesor creado");
					frame.dispose();
					Ventana_Login login = new Ventana_Login();
					login.setVisible(true);
				}
			}
		});

		siguiente_JButton.setBounds(398, 447, 117, 29);
		frame.getContentPane().add(siguiente_JButton);

		slider = new JSlider();
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMinimum(10);
		slider.setMaximum(30);
		slider.setMajorTickSpacing(1);
		slider.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		slider.setValue(0);

		slider.setBounds(155, 89, 494, 42);
		frame.getContentPane().add(slider);
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(44, 62, 605, 16);
		frame.getContentPane().add(separator_2);

		JLabel lblRellenarCamposProfesor = new JLabel("Rellenar campos profesor");
		lblRellenarCamposProfesor.setHorizontalAlignment(SwingConstants.CENTER);
		lblRellenarCamposProfesor.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblRellenarCamposProfesor.setBounds(208, 25, 251, 26);
		frame.getContentPane().add(lblRellenarCamposProfesor);

		JLabel lblPreciohora = new JLabel("Precio/hora");
		lblPreciohora.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblPreciohora.setBounds(44, 89, 100, 16);
		frame.getContentPane().add(lblPreciohora);

		JLabel lblCurriculumVitae = new JLabel("Curriculum vitae");
		lblCurriculumVitae.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblCurriculumVitae.setBounds(45, 204, 142, 20);
		frame.getContentPane().add(lblCurriculumVitae);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(173, 204, 452, 88);
		frame.getContentPane().add(scrollPane);

		textPane = new JTextPane();
		scrollPane.setViewportView(textPane);

		JSeparator separator = new JSeparator();
		separator.setBounds(44, 177, 605, 16);
		frame.getContentPane().add(separator);

		JLabel lblTipoAsig = new JLabel("Tipo de asignatura que oferto:");
		lblTipoAsig.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipoAsig.setBounds(44, 313, 212, 14);
		frame.getContentPane().add(lblTipoAsig);

		comboBox_tipo = new JComboBox<String>();
		comboBox_tipo.setModel(new DefaultComboBoxModel(new String[] {"-  Elija tipo  -", "Colegio", "Escuela de idiomas"}));
		comboBox_tipo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox_tipo.setBounds(266, 311, 123, 20);
		frame.getContentPane().add(comboBox_tipo);

		panel_colegio = new JPanel();
		panel_colegio.setVisible(false);
		panel_colegio.setBounds(44, 338, 605, 98);
		frame.getContentPane().add(panel_colegio);
		panel_colegio.setLayout(null);

		JLabel label = new JLabel("Asignatura:");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(77, 13, 71, 15);
		panel_colegio.add(label);

		txtAsig = new JTextField();
		txtAsig.setColumns(10);
		txtAsig.setBounds(158, 11, 167, 20);
		panel_colegio.add(txtAsig);

		JLabel label_1 = new JLabel("Nivel:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(77, 45, 46, 14);
		panel_colegio.add(label_1);

		rButPrimaria = new JRadioButton("Primaria");
		rButPrimaria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rButPrimaria.setBackground(Color.LIGHT_GRAY);
		rButPrimaria.setBounds(138, 41, 71, 23);
		panel_colegio.add(rButPrimaria);

		rButESO = new JRadioButton("ESO");
		rButESO.setBackground(Color.LIGHT_GRAY);
		rButESO.setBounds(248, 42, 52, 23);
		panel_colegio.add(rButESO);

		rButBachi = new JRadioButton("Bachillerato");
		rButBachi.setBackground(Color.LIGHT_GRAY);
		rButBachi.setBounds(333, 42, 97, 23);
		panel_colegio.add(rButBachi);

		JLabel label_2 = new JLabel("Idioma:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(345, 13, 46, 14);
		panel_colegio.add(label_2);

		eligeIdiomaCombo = new JComboBox<String>();
		eligeIdiomaCombo.setModel(new DefaultComboBoxModel(new String[] {"- Elija idioma -", "Euskera", "Ingl\u00E9s", "Espa\u00F1ol", "Franc\u00E9s", "Alem\u00E1n"}));
		eligeIdiomaCombo.setBounds(401, 11, 146, 20);
		panel_colegio.add(eligeIdiomaCombo);

		panel_escueladeidiomas = new JPanel();
		panel_escueladeidiomas.setVisible(false);
		panel_escueladeidiomas.setBounds(32, 338, 626, 98);
		frame.getContentPane().add(panel_escueladeidiomas);
		panel_escueladeidiomas.setLayout(null);

		JLabel label_3 = new JLabel("Idioma:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(87, 10, 46, 15);
		panel_escueladeidiomas.add(label_3);

		eligeIdiomaEscCombo = new JComboBox<String>();
		eligeIdiomaEscCombo.setModel(new DefaultComboBoxModel(new String[] {"- Elija idioma -", "Euskera", "Ingl\u00E9s", "Espa\u00F1ol", "Franc\u00E9s", "Alem\u00E1n", "Italiano", "Chino", "Japon\u00E9s", "Ruso"}));
		eligeIdiomaEscCombo.setBounds(143, 8, 108, 20);
		panel_escueladeidiomas.add(eligeIdiomaEscCombo);

		JLabel label_4 = new JLabel("Nivel:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(283, 10, 46, 14);
		panel_escueladeidiomas.add(label_4);

		checkBox = new JCheckBox("A1");
		checkBox.setBackground(Color.LIGHT_GRAY);
		checkBox.setBounds(335, 7, 47, 23);
		panel_escueladeidiomas.add(checkBox);

		checkBox_1 = new JCheckBox("A2");
		checkBox_1.setBackground(Color.LIGHT_GRAY);
		checkBox_1.setBounds(335, 33, 47, 23);
		panel_escueladeidiomas.add(checkBox_1);

		checkBox_2 = new JCheckBox("B1");
		checkBox_2.setBackground(Color.LIGHT_GRAY);
		checkBox_2.setBounds(408, 7, 46, 23);
		panel_escueladeidiomas.add(checkBox_2);

		checkBox_3 = new JCheckBox("B2");
		checkBox_3.setBackground(Color.LIGHT_GRAY);
		checkBox_3.setBounds(408, 33, 46, 23);
		panel_escueladeidiomas.add(checkBox_3);

		checkBox_4 = new JCheckBox("C1");
		checkBox_4.setBackground(Color.LIGHT_GRAY);
		checkBox_4.setBounds(481, 8, 46, 20);
		panel_escueladeidiomas.add(checkBox_4);

		checkBox_5 = new JCheckBox("C2");
		checkBox_5.setBackground(Color.LIGHT_GRAY);
		checkBox_5.setBounds(481, 37, 46, 19);
		panel_escueladeidiomas.add(checkBox_5);

		JButton ofrezcoMasJBut = new JButton("Ofrezco m\u00E1s");
		ofrezcoMasJBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String codigoAsig = BaseDeDatos.selectUnValor("SELECT * FROM ASIG WHERE NOMBRE = '" + txtAsig.getText().toUpperCase() +"'", "COD");
				if(codigoAsig.equals(null)){
					int codigo = Integer.parseInt(BaseDeDatos.selectUnValor("SELECT * FROM ASIG WHERE MAX(COD)", "COD"))+1;
					codigoAsig = codigo + "";
					BaseDeDatos.insert("INSERT INTO ASIGNATURA VALUES ('" + txtAsig.getText().toUpperCase() + "', '" + codigoAsig + "')");
				}
				String idioma = eligeIdiomaCombo.getSelectedItem().toString();
				if(idioma.equals("- Elija idioma -")){
					JOptionPane.showMessageDialog(frame, "Falta por indicar el idioma de la asignatura.", "Fallo en el idioma", JOptionPane.ERROR_MESSAGE);
				}else{
					String codIdioma = BaseDeDatos.selectUnValor("SELECT * FROM IDIOMA WHERE NOMBRE = '" + idioma.toUpperCase() + "'", "COD");
					if(rButPrimaria.isSelected()){
						BaseDeDatos.insert("INSERT INTO OFRECE VALUES ('" + Ventana_Login.getMiDNI() + "', '" + codigoAsig + "', '100', '" + codIdioma + "')");
					}
					if(rButESO.isSelected()){
						BaseDeDatos.insert("INSERT INTO OFRECE VALUES ('" + Ventana_Login.getMiDNI() + "', '" + codigoAsig + "', '101', '" + codIdioma + "')");
					}
					if(rButBachi.isSelected()){
						BaseDeDatos.insert("INSERT INTO OFRECE VALUES ('" + Ventana_Login.getMiDNI() + "', '" + codigoAsig + "', '102', '" + codIdioma + "')");
					}else if(!rButPrimaria.isSelected() && !rButESO.isSelected()){
						JOptionPane.showMessageDialog(frame, "Falta por indicar el nivel de la asignatura.", "Fallo en el nivel", JOptionPane.ERROR_MESSAGE);
					}
				}

				txtAsig.setText("");
				eligeIdiomaCombo.setSelectedIndex(0);
				rButPrimaria.setSelected(false);
				rButESO.setSelected(false);
				rButBachi.setSelected(false);
			}
		});
		ofrezcoMasJBut.setBounds(468, 64, 127, 23);
		panel_colegio.add(ofrezcoMasJBut);

		JButton ofrezcoMasJBut2 = new JButton("Ofrezco m\u00E1s");
		ofrezcoMasJBut2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String asignatura = eligeIdiomaEscCombo.getSelectedItem().toString();
				if(asignatura.equals("- Elija idioma -")){
					JOptionPane.showMessageDialog(frame, "Falta por indicar el idioma de la asignatura.", "Fallo en el idioma", JOptionPane.ERROR_MESSAGE);	
				}else{
					String codigoAsig = BaseDeDatos.selectUnValor("SELECT * FROM ASIGNATURA WHERE NOMBRE = '" + asignatura.toUpperCase() + "'", "COD");
					String idioma = eligeIdiomaCombo.getSelectedItem().toString();
					if(idioma.equals("- Elija idioma -")){
						JOptionPane.showMessageDialog(frame, "Falta por indicar el idioma de la asignatura.", "Fallo en el idioma", JOptionPane.ERROR_MESSAGE);
					}else{
						String codIdioma = BaseDeDatos.selectUnValor("SELECT * FROM IDIOMA WHERE NOMBRE = '" + idioma.toUpperCase() + "'", "COD");
						if(checkBox.isSelected()){
							BaseDeDatos.insert("INSERT INTO OFRECE VALUES ('" + Ventana_Login.getMiDNI() + "', '" + codigoAsig + "', '103', '" + codIdioma + "')");
						}
						if(checkBox_1.isSelected()){
							BaseDeDatos.insert("INSERT INTO OFRECE VALUES ('" + Ventana_Login.getMiDNI() + "', '" + codigoAsig + "', '104', '" + codIdioma + "')");
						}
						if(checkBox_2.isSelected()){
							BaseDeDatos.insert("INSERT INTO OFRECE VALUES ('" + Ventana_Login.getMiDNI() + "', '" + codigoAsig + "', '105', '" + codIdioma + "')");
						}
						if(checkBox_3.isSelected()){
							BaseDeDatos.insert("INSERT INTO OFRECE VALUES ('" + Ventana_Login.getMiDNI() + "', '" + codigoAsig + "', '106', '" + codIdioma + "')");
						}
						if(checkBox_4.isSelected()){
							BaseDeDatos.insert("INSERT INTO OFRECE VALUES ('" + Ventana_Login.getMiDNI() + "', '" + codigoAsig + "', '107', '" + codIdioma + "')");
						}
						if(checkBox_5.isSelected()){
							BaseDeDatos.insert("INSERT INTO OFRECE VALUES ('" + Ventana_Login.getMiDNI() + "', '" + codigoAsig + "', '108', '" + codIdioma + "')");
						}else if(!checkBox.isSelected() && !checkBox_1.isSelected() && !checkBox_2.isSelected() && !checkBox_3.isSelected() &&
								!checkBox_4.isSelected() && !checkBox_5.isSelected()){
							JOptionPane.showMessageDialog(frame, "Falta por indicar el nivel de la asignatura.", "Fallo en el nivel", JOptionPane.ERROR_MESSAGE);
						}
						System.out.println("El profesor ahora ofrece las asignaturas indicadas");
					}
				}
				txtAsig.setText("");
				eligeIdiomaEscCombo.setSelectedIndex(0);
				checkBox.setSelected(false);
				checkBox_1.setSelected(false);
				checkBox_2.setSelected(false);
				checkBox_3.setSelected(false);
				checkBox_4.setSelected(false);
				checkBox_5.setSelected(false);
			}
		});
		ofrezcoMasJBut2.setBounds(481, 64, 124, 23);
		panel_escueladeidiomas.add(ofrezcoMasJBut2);

		comboBox_tipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox_tipo.getSelectedItem().toString().equals("    -  Elija tipo  -")){
					panel_escueladeidiomas.setVisible(false);
					panel_colegio.setVisible(false);
				}else if (comboBox_tipo.getSelectedItem().toString().equals("Colegio")){
					panel_escueladeidiomas.setVisible(false);
					panel_colegio.setVisible(true);
				} else{
					panel_colegio.setVisible(false);
					panel_escueladeidiomas.setVisible(true);
				}
			}
		});
	}

	public boolean guardar(){
		int n = 100;
		String textoCurriculum;
		n=(int)slider.getValue(); 
		textoCurriculum = textPane.getText();
		if((eligeIdiomaCombo.getSelectedItem().equals("- Elija idioma -") && eligeIdiomaEscCombo.getSelectedItem().equals("- Elija idioma -")) || (!eligeIdiomaCombo.getSelectedItem().equals("- Elija idioma -") && txtAsig.getText().equals("")) ||
				((!rButPrimaria.isSelected() && !rButESO.isSelected() && !rButBachi.isSelected()) && (!checkBox.isSelected() && !checkBox_1.isSelected() && !checkBox_2.isSelected() &&
						!checkBox_3.isSelected() && !checkBox_4.isSelected() && !checkBox_5.isSelected())) ||textoCurriculum.equals("")){	
			return false;
		}
		System.out.println("Precio/Hora: "+n);
		System.out.println("Curriculum: " + textoCurriculum);
		System.out.println(estaRelleno);

		return true;
	}
}