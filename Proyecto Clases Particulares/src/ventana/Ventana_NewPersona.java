package ventana;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import objetos.Persona;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Ventana_NewPersona extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField_Nom;
	private JTextField textField_DNI;
	private JTextField textField_Ape1;
	private JTextField textField_Ape2;
	private JTextField textField_Tlf;
	private JTextField textField_Calle;
	private JTextField textField_Num;
	private JTextField textField_Piso;
	private JTextField textField_Ciudad;

	private JComboBox comboDias;
	private JComboBox comboMes;
	private JComboBox comboAnyo;
	private JComboBox comboProf_Alum;

	private JButton cancelar_JButton;
	private JButton guardar_JButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_NewPersona frame = new Ventana_NewPersona();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana_NewPersona() {
		setResizable(false);
		setTitle("Nuevo Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblDni = new JLabel("DNI :");

		JLabel lblNombre = new JLabel("Nombre : ");

		textField_Nom = new JTextField();
		textField_Nom.setColumns(10);

		textField_DNI = new JTextField();
		textField_DNI.setColumns(10);

		JLabel lblApellidos = new JLabel("Apellidos  : ");

		textField_Ape1 = new JTextField();
		textField_Ape1.setColumns(10);

		textField_Ape2 = new JTextField();
		textField_Ape2.setColumns(10);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento : ");

		comboDias = new JComboBox();
		comboDias.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));

		comboMes = new JComboBox();
		comboMes.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));

		comboAnyo = new JComboBox();
		comboAnyo.setModel(new DefaultComboBoxModel(new String[] {"1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009"}));

		JLabel label = new JLabel("/");

		JLabel label_1 = new JLabel("/");

		JLabel lblTelfono = new JLabel("Tel\u00E9fono : ");

		textField_Tlf = new JTextField();
		textField_Tlf.setColumns(10);

		JLabel lblDireccin = new JLabel("Calle : ");

		textField_Calle = new JTextField();
		textField_Calle.setColumns(10);

		JLabel lblN = new JLabel("N\u00BA : ");

		textField_Num = new JTextField();
		textField_Num.setColumns(10);

		JLabel lblPiso = new JLabel("Piso : ");

		textField_Piso = new JTextField();
		textField_Piso.setColumns(10);

		JLabel lblCiudad = new JLabel("Ciudad : ");

		textField_Ciudad = new JTextField();
		textField_Ciudad.setColumns(10);

		JLabel lblTipoDeUsuario = new JLabel("Tipo de usuario : ");

		comboProf_Alum = new JComboBox();
		comboProf_Alum.setModel(new DefaultComboBoxModel(new String[] {"Alumno", "Profesor"}));

		cancelar_JButton = new JButton("Cancelar");
		cancelar_JButton.addActionListener(this);
		guardar_JButton = new JButton("Guardar");
		guardar_JButton.addActionListener(this);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(lblTelfono)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(textField_Tlf, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(lblNombre)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(textField_Nom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																.addGroup(gl_contentPane.createSequentialGroup()
																		.addComponent(lblDni)
																		.addGap(18)
																		.addComponent(textField_DNI, 100, 100, 100)))
																		.addGap(18)
																		.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																				.addGroup(gl_contentPane.createSequentialGroup()
																						.addComponent(lblTipoDeUsuario)
																						.addPreferredGap(ComponentPlacement.UNRELATED)
																						.addComponent(comboProf_Alum, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
																						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																								.addGroup(gl_contentPane.createSequentialGroup()
																										.addComponent(lblApellidos)
																										.addPreferredGap(ComponentPlacement.UNRELATED)
																										.addComponent(textField_Ape1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(ComponentPlacement.UNRELATED)
																										.addComponent(textField_Ape2, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
																										.addGroup(gl_contentPane.createSequentialGroup()
																												.addComponent(lblFechaDeNacimiento)
																												.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
																												.addComponent(comboDias, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																												.addPreferredGap(ComponentPlacement.RELATED)
																												.addComponent(label, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
																												.addPreferredGap(ComponentPlacement.RELATED)
																												.addComponent(comboMes, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
																												.addPreferredGap(ComponentPlacement.RELATED)
																												.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
																												.addPreferredGap(ComponentPlacement.RELATED)
																												.addComponent(comboAnyo, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)))))
																												.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
																														.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
																																.addGroup(gl_contentPane.createSequentialGroup()
																																		.addComponent(cancelar_JButton, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
																																		.addGap(73)
																																		.addComponent(guardar_JButton, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
																																		.addGroup(gl_contentPane.createSequentialGroup()
																																				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																																						.addGroup(gl_contentPane.createSequentialGroup()
																																								.addComponent(lblDireccin)
																																								.addPreferredGap(ComponentPlacement.UNRELATED)
																																								.addComponent(textField_Calle, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
																																								.addPreferredGap(ComponentPlacement.UNRELATED)
																																								.addComponent(lblN)
																																								.addPreferredGap(ComponentPlacement.RELATED))
																																								.addGroup(gl_contentPane.createSequentialGroup()
																																										.addComponent(lblCiudad)
																																										.addPreferredGap(ComponentPlacement.RELATED)
																																										.addComponent(textField_Ciudad, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
																																										.addComponent(textField_Num, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
																																										.addGap(14)
																																										.addComponent(lblPiso)))
																																										.addPreferredGap(ComponentPlacement.RELATED)
																																										.addComponent(textField_Piso, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
																																										.addGap(6)))
																																										.addGap(88))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(33)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombre)
								.addComponent(textField_Nom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblApellidos)
								.addComponent(textField_Ape1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_Ape2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblFechaDeNacimiento)
										.addComponent(comboDias, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label)
										.addComponent(comboMes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_1)
										.addComponent(comboAnyo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDni)
										.addComponent(textField_DNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblTelfono)
												.addComponent(textField_Tlf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblTipoDeUsuario)
												.addComponent(comboProf_Alum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGap(18)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblDireccin)
														.addComponent(textField_Calle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblPiso)
														.addComponent(lblN)
														.addComponent(textField_Num, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textField_Piso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addGap(18)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
																.addComponent(lblCiudad)
																.addComponent(textField_Ciudad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																.addGap(45)
																.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
																		.addComponent(cancelar_JButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
																		.addComponent(guardar_JButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
																		.addContainerGap(45, Short.MAX_VALUE))
				);
		contentPane.setLayout(gl_contentPane);
	}

	public void actionPerformed(ActionEvent arg0) {
		JButton botonPressed = (JButton)arg0.getSource();
		String fecha = "";
		String direccion = "";
		if(botonPressed == cancelar_JButton){
			this.dispose();
		}else if(botonPressed == guardar_JButton){
			
			if(comboProf_Alum.getSelectedItem().toString().equals("Alumno")){				
				// Se comprueba que todas las casillas esten con texto, sino se saca un mensaje de error
				if(textField_Nom.getText().equals("") || textField_DNI.getText().equals("") || textField_Ape1.getText().equals("") || textField_Ape2.getText().equals("") 
						|| textField_Tlf.getText().equals("") || textField_Calle.getText().equals("") || textField_Num.getText().equals("") || textField_Piso.getText().equals("") 
						|| textField_Ciudad.getText().equals("")){

					String message;
					String casilV = "";
					if(textField_Nom.getText().equals(""))
						casilV = casilV + " \n -Nombre";
					if(textField_DNI.getText().equals(""))
						casilV = casilV + " \n -DNI";
					if(textField_Ape1.getText().equals(""))
						casilV = casilV + " \n -Apellido 1";
					if(textField_Ape2.getText().equals(""))
						casilV = casilV + " \n -Apellido 2";
					if(textField_Tlf.getText().equals(""))
						casilV = casilV + " \n -Teléfono";
					if(textField_Calle.getText().equals(""))
						casilV = casilV + " \n -Calle";
					if(textField_Num.getText().equals(""))
						casilV = casilV + " \n -Nº";
					if(textField_Piso.getText().equals(""))
						casilV = casilV + " \n -Piso";
					if(textField_Ciudad.getText().equals(""))
						casilV = casilV + " \n -Ciudad";
					// mensaje de error
					message = ("La(s) casilla(s):" + casilV + "\nEstá(n) vacía(s), por favor rellenela(s).");
					JOptionPane.showMessageDialog(this, message, "¡Casillas vacías!", JOptionPane.ERROR_MESSAGE);
				}else{
					// Hay que Cojer todos los datos y guardarlos como nuevo Alumno
					fecha = comboDias.getSelectedItem().toString() + "/" + comboMes.getSelectedItem().toString() + "/" + comboAnyo.getSelectedItem().toString();
					direccion = textField_Calle.getText() + textField_Num.getText() + textField_Piso.getText();
					Persona nuevoAlumno = new Persona(textField_DNI.getText(), textField_Nom.getText(), textField_Ape1.getText(), textField_Ape2.getText(),
							textField_Tlf.getText(), direccion, textField_Ciudad.getText(), fecha, false );
					/* Cuando se cree 
					 * Ventana_NewAlumno a = new Ventana_NewProfesor(nuevoAlumno);
					 */				
					this.setVisible(false);
					}

			}else if(comboProf_Alum.getSelectedItem().toString().equals("Profesor")){				
				// Se comprueba que todas las casillas esten con texto, sino se saca un mensaje de error
				if(textField_Nom.getText().equals("") || textField_DNI.getText().equals("") || textField_Ape1.getText().equals("") || textField_Ape2.getText().equals("") 
						|| textField_Tlf.getText().equals("") || textField_Calle.getText().equals("") || textField_Num.getText().equals("") || textField_Piso.getText().equals("") 
						|| textField_Ciudad.getText().equals("")){
					String message;
					String casilV = "";
					if(textField_Nom.getText().equals(""))
						casilV = casilV + " \n -Nombre";
					if(textField_DNI.getText().equals(""))
						casilV = casilV + " \n -DNI";
					if(textField_Ape1.getText().equals(""))
						casilV = casilV + " \n -Apellido 1";
					if(textField_Ape2.getText().equals(""))
						casilV = casilV + " \n -Apellido 2";
					if(textField_Tlf.getText().equals(""))
						casilV = casilV + " \n -Teléfono";
					if(textField_Calle.getText().equals(""))
						casilV = casilV + " \n -Calle";
					if(textField_Num.getText().equals(""))
						casilV = casilV + " \n -Nº";
					if(textField_Piso.getText().equals(""))
						casilV = casilV + " \n -Piso";
					if(textField_Ciudad.getText().equals(""))
						casilV = casilV + " \n -Ciudad";
					// mensaje de error
					message = ("La(s) casilla(s):" + casilV + "\nEstá(n) vacía(s), por favor rellenela(s).");
					JOptionPane.showMessageDialog(this, message, "¡Casillas vacías!", JOptionPane.ERROR_MESSAGE);

				}else{
					// Hay que Cojer todos los datos y guardarlos como nuevo Profesor
					Persona nuevoProfesor = new Persona(textField_DNI.getText(), textField_Nom.getText(), textField_Ape1.getText(), textField_Ape2.getText(),
							textField_Tlf.getText(), direccion, textField_Ciudad.getText(), fecha, true );
					Ventana_NewProfesor a = new Ventana_NewProfesor(nuevoProfesor);		
					this.setVisible(false);
				}
			}
		}
	}
}

