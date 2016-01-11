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

import objetos.Persona;
import objetos.Profesor;

import java.awt.Label;
import java.awt.Button;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.Color;


public class Ventana_NewProfesor{

	private Persona persona;
	private JFrame frame;
	private  boolean estaRelleno ;
	private JTextField textField;
	private JSlider slider;
	private JTextField textField_1;
	private JComboBox<String> comboBox_tipo; 
	private JTextPane textPane;
	private JPanel panel_escueladeidiomas;
	private JPanel panel_colegio;
	
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
					Profesor nuevoProfesor = new Profesor(persona, n, textoCurriculum);
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

		textField = new JTextField();
		textField.setBounds(485, 146, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JCheckBox chckbxOtro = new JCheckBox("Otro:");
		chckbxOtro.setBounds(414, 142, 65, 23);
		frame.getContentPane().add(chckbxOtro);

		JSeparator separator = new JSeparator();
		separator.setBounds(44, 177, 605, 16);
		frame.getContentPane().add(separator);

		JLabel lblTipoAsig = new JLabel("Tipo de asignatura que oferto:");
		lblTipoAsig.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipoAsig.setBounds(44, 313, 212, 14);
		frame.getContentPane().add(lblTipoAsig);

		comboBox_tipo = new JComboBox<String>();
		comboBox_tipo.setModel(new DefaultComboBoxModel(new String[] {"    -  Elija tipo  -", "Colegio", "Escuela de idiomas"}));
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

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(158, 11, 167, 20);
		panel_colegio.add(textField_1);

		JLabel label_1 = new JLabel("Nivel:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(77, 45, 46, 14);
		panel_colegio.add(label_1);

		JRadioButton radioButton = new JRadioButton("Primaria");
		radioButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		radioButton.setBackground(Color.LIGHT_GRAY);
		radioButton.setBounds(138, 41, 71, 23);
		panel_colegio.add(radioButton);

		JRadioButton radioButton_1 = new JRadioButton("ESO");
		radioButton_1.setBackground(Color.LIGHT_GRAY);
		radioButton_1.setBounds(248, 42, 52, 23);
		panel_colegio.add(radioButton_1);

		JRadioButton radioButton_2 = new JRadioButton("Bachillerato");
		radioButton_2.setBackground(Color.LIGHT_GRAY);
		radioButton_2.setBounds(333, 42, 97, 23);
		panel_colegio.add(radioButton_2);

		JLabel label_2 = new JLabel("Idioma:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(345, 13, 46, 14);
		panel_colegio.add(label_2);

		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"- Elija idioma -", "Euskera", "Ingl\u00E9s", "Franc\u00E9s", "Alem\u00E1n"}));
		comboBox_1.setBounds(401, 11, 146, 20);
		panel_colegio.add(comboBox_1);
		
		JButton button = new JButton("Ofrezco m\u00E1s");
		button.setBounds(468, 64, 127, 23);
		panel_colegio.add(button);

		panel_escueladeidiomas = new JPanel();
		panel_escueladeidiomas.setVisible(false);
		panel_escueladeidiomas.setBounds(32, 338, 626, 98);
		frame.getContentPane().add(panel_escueladeidiomas);
		panel_escueladeidiomas.setLayout(null);

		JLabel label_3 = new JLabel("Idioma:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(87, 10, 46, 15);
		panel_escueladeidiomas.add(label_3);

		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"- Elija idioma -", "Euskera", "Espa\u00F1ol", "Ingl\u00E9s", "Franc\u00E9s", "Alem\u00E1n", "Italiano", "Chino", "Japon\u00E9s", "Ruso"}));
		comboBox_2.setBounds(143, 8, 108, 20);
		panel_escueladeidiomas.add(comboBox_2);

		JLabel label_4 = new JLabel("Nivel:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(283, 10, 46, 14);
		panel_escueladeidiomas.add(label_4);

		JCheckBox checkBox = new JCheckBox("A1");
		checkBox.setBackground(Color.LIGHT_GRAY);
		checkBox.setBounds(335, 7, 47, 23);
		panel_escueladeidiomas.add(checkBox);

		JCheckBox checkBox_1 = new JCheckBox("A2");
		checkBox_1.setBackground(Color.LIGHT_GRAY);
		checkBox_1.setBounds(335, 33, 47, 23);
		panel_escueladeidiomas.add(checkBox_1);

		JCheckBox checkBox_2 = new JCheckBox("B1");
		checkBox_2.setBackground(Color.LIGHT_GRAY);
		checkBox_2.setBounds(408, 7, 46, 23);
		panel_escueladeidiomas.add(checkBox_2);

		JCheckBox checkBox_3 = new JCheckBox("B2");
		checkBox_3.setBackground(Color.LIGHT_GRAY);
		checkBox_3.setBounds(408, 33, 46, 23);
		panel_escueladeidiomas.add(checkBox_3);

		JCheckBox checkBox_4 = new JCheckBox("C1");
		checkBox_4.setBackground(Color.LIGHT_GRAY);
		checkBox_4.setBounds(481, 8, 46, 20);
		panel_escueladeidiomas.add(checkBox_4);

		JCheckBox checkBox_5 = new JCheckBox("C2");
		checkBox_5.setBackground(Color.LIGHT_GRAY);
		checkBox_5.setBounds(481, 37, 46, 19);
		panel_escueladeidiomas.add(checkBox_5);
		
		JButton button_1 = new JButton("Ofrezco m\u00E1s");
		button_1.setBounds(481, 64, 124, 23);
		panel_escueladeidiomas.add(button_1);

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
		//esto es lo unico que me casca que no consigo obtner el valor del slider ****************
		//n= slider1.getValue();
		textoCurriculum = textPane.getText();
		estaRelleno=true;
		if(n == 0  || textoCurriculum.equals("")){
			estaRelleno=false;
		}
		System.out.println("Precio/Hora: "+n);
		System.out.println("Curriculum: " + textoCurriculum);
		System.out.println(estaRelleno);
		
		return estaRelleno;
	}
}