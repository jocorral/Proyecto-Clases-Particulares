package ventana;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana_Asignaturas extends JFrame{
	private JPanel panel_Colegio;
	private JPanel panel_Arriba;
	private JPanel panel_EscuDeIdio;
	private JTextField textField;
	
	
	private JComboBox comboBox_1;
	
	
	public Ventana_Asignaturas() {
		setResizable(false);
		setTitle("Añadir Asignaturas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 417, 430);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana_Asignaturas.class.getResource("/ventana/Logo1.JPG")));
		getContentPane().setLayout(null);
		
		panel_Colegio = new JPanel();
		panel_Colegio.setBounds(0, 72, 411, 329);
		getContentPane().add(panel_Colegio);
		panel_Colegio.setLayout(null);
		
		JLabel label = new JLabel("Asignaturas : ");
		label.setBounds(22, 11, 86, 24);
		panel_Colegio.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(22, 46, 135, 20);
		panel_Colegio.add(textField);
		
		JLabel label_1 = new JLabel("Nivel : ");
		label_1.setBounds(267, 11, 46, 14);
		panel_Colegio.add(label_1);
		
		JRadioButton radioButton = new JRadioButton("Primaria");
		radioButton.setBounds(192, 40, 86, 23);
		panel_Colegio.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("E.S.O.");
		radioButton_1.setBounds(192, 66, 86, 23);
		panel_Colegio.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("Bachillerato");
		radioButton_2.setBounds(192, 92, 86, 23);
		panel_Colegio.add(radioButton_2);
		
		JCheckBox checkBox = new JCheckBox("1\u00BA");
		checkBox.setVisible(false);
		checkBox.setBounds(322, 40, 61, 23);
		panel_Colegio.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("2\u00BA");
		checkBox_1.setVisible(false);
		checkBox_1.setBounds(322, 66, 61, 23);
		panel_Colegio.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("3\u00BA");
		checkBox_2.setVisible(false);
		checkBox_2.setBounds(322, 92, 61, 23);
		panel_Colegio.add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("4\u00BA");
		checkBox_3.setVisible(false);
		checkBox_3.setBounds(322, 118, 61, 23);
		panel_Colegio.add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("5\u00BA");
		checkBox_4.setVisible(false);
		checkBox_4.setBounds(322, 144, 61, 23);
		panel_Colegio.add(checkBox_4);
		
		JCheckBox checkBox_5 = new JCheckBox("6\u00BA");
		checkBox_5.setVisible(false);
		checkBox_5.setBounds(322, 170, 61, 23);
		panel_Colegio.add(checkBox_5);
		
		JLabel label_2 = new JLabel("Idioma : ");
		label_2.setBounds(22, 207, 69, 24);
		panel_Colegio.add(label_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"- Elija idioma -", "Euskera", "Ingl\u00E9s", "Franc\u00E9s", "Alem\u00E1n"}));
		comboBox.setBounds(101, 209, 110, 22);
		panel_Colegio.add(comboBox);
		
		JButton button = new JButton("Añadir otra");
		button.setBounds(262, 237, 121, 23);
		panel_Colegio.add(button);
		
		JButton button_1 = new JButton("Guardar");
		button_1.setBounds(262, 277, 121, 23);
		panel_Colegio.add(button_1);
		
		panel_Arriba = new JPanel();
		panel_Arriba.setBounds(0, 0, 411, 72);
		getContentPane().add(panel_Arriba);
		panel_Arriba.setLayout(null);
		
		comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox_1.getSelectedItem().toString().equals("- Elija Tipo -")){
					
				}else if(comboBox_1.getSelectedItem().toString().equals("Colegio")){
					panel_EscuDeIdio.setVisible(false);
					panel_Colegio.setVisible(true);
				}else{
					panel_Colegio.setVisible(false);
					panel_EscuDeIdio.setVisible(true);
				}
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"- Elija Tipo -", "Colegio", "Escuela de idiomas"}));	
		comboBox_1.setBounds(116, 26, 114, 20);
		panel_Arriba.add(comboBox_1);
		
		JLabel lblTipoAsignatura = new JLabel("Tipo asignatura :  ");
		lblTipoAsignatura.setBounds(10, 26, 96, 20);
		panel_Arriba.add(lblTipoAsignatura);
		
		panel_EscuDeIdio = new JPanel();
		panel_EscuDeIdio.setVisible(false);
		panel_EscuDeIdio.setBounds(0, 72, 411, 329);
		getContentPane().add(panel_EscuDeIdio);
		panel_EscuDeIdio.setLayout(null);
		
		JLabel label_3 = new JLabel("Idioma : ");
		label_3.setBounds(45, 40, 53, 22);
		panel_EscuDeIdio.add(label_3);
		
		JLabel label_4 = new JLabel("Nivel : ");
		label_4.setBounds(45, 115, 53, 22);
		panel_EscuDeIdio.add(label_4);
		
		JCheckBox checkBox_6 = new JCheckBox("A1");
		checkBox_6.setBounds(45, 147, 46, 23);
		panel_EscuDeIdio.add(checkBox_6);
		
		JCheckBox checkBox_7 = new JCheckBox("A2");
		checkBox_7.setBounds(45, 173, 46, 23);
		panel_EscuDeIdio.add(checkBox_7);
		
		JCheckBox checkBox_8 = new JCheckBox("B1");
		checkBox_8.setBounds(123, 147, 46, 23);
		panel_EscuDeIdio.add(checkBox_8);
		
		JCheckBox checkBox_9 = new JCheckBox("B2");
		checkBox_9.setBounds(123, 173, 46, 23);
		panel_EscuDeIdio.add(checkBox_9);
		
		JCheckBox checkBox_10 = new JCheckBox("C1");
		checkBox_10.setBounds(200, 147, 46, 23);
		panel_EscuDeIdio.add(checkBox_10);
		
		JCheckBox checkBox_11 = new JCheckBox("C2");
		checkBox_11.setBounds(200, 173, 46, 23);
		panel_EscuDeIdio.add(checkBox_11);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"- Elija idioma -", "Euskera", "Espa\u00F1ol", "Ingl\u00E9s", "Franc\u00E9s", "Alem\u00E1n", "Italiano", "Chino", "Japon\u00E9s", "Ruso"}));
		comboBox_2.setBounds(45, 73, 138, 22);
		panel_EscuDeIdio.add(comboBox_2);
		
		JButton button_2 = new JButton("A\u00F1adir otra");
		button_2.setBounds(262, 237, 120, 23);
		panel_EscuDeIdio.add(button_2);
		
		JButton button_3 = new JButton("Guardar");
		button_3.setBounds(262, 277, 120, 23);
		panel_EscuDeIdio.add(button_3);
	}
	
	
	public static void main(String[] args) {
		Ventana_Asignaturas a = new Ventana_Asignaturas();
		a.setVisible(true);
	}
}
