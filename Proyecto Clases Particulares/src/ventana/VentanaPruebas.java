package ventana;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;

public class VentanaPruebas extends JFrame{
	private JButton borrar_JBut;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public VentanaPruebas() {
		getContentPane().setLayout(null);
		
		JPanel panelInicio = new JPanel();
		panelInicio.setBounds(493, 0, 469, 352);
		getContentPane().add(panelInicio);
		panelInicio.setLayout(null);
		
		JLabel lblClasesDelDia = new JLabel("Clases del dia");
		lblClasesDelDia.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblClasesDelDia.setFocusTraversalPolicyProvider(true);
		lblClasesDelDia.setBounds(170, 11, 129, 50);
		panelInicio.add(lblClasesDelDia);
		
		JButton calendario_JBut = new JButton("Calendario");
		calendario_JBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_Calendario calendario = new Ventana_Calendario();
				calendario.setVisible(true);
			}
		});
		calendario_JBut.setBounds(30, 283, 89, 23);
		panelInicio.add(calendario_JBut);
		
		borrar_JBut = new JButton("Borrar");
		borrar_JBut.setBounds(356, 283, 89, 23);
		panelInicio.add(borrar_JBut);
		
		JButton anyadeClase_JBut = new JButton("Añadir Clase");
		anyadeClase_JBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		anyadeClase_JBut.setBounds(180, 283, 108, 23);
		panelInicio.add(anyadeClase_JBut);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 358, 490, -357);
		getContentPane().add(layeredPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 469, 352);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Para: ");
		label.setBounds(35, 28, 40, 16);
		panel.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(116, 22, 264, 28);
		panel.add(textField);
		
		JLabel label_1 = new JLabel("De parte de: ");
		label_1.setBounds(35, 68, 85, 16);
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(116, 62, 264, 28);
		panel.add(textField_1);
		
		JLabel label_2 = new JLabel("Asunto: ");
		label_2.setBounds(35, 108, 61, 16);
		panel.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(116, 102, 264, 28);
		panel.add(textField_2);
		
		JLabel label_3 = new JLabel("Contenido: ");
		label_3.setBounds(185, 137, 85, 22);
		panel.add(label_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 170, 418, 105);
		panel.add(scrollPane);
		
		JButton button = new JButton("Enviar");
		button.setBounds(116, 295, 206, 29);
		panel.add(button);
	}
	 public static void main(String[] args) {
		VentanaPruebas a = new VentanaPruebas();
		a.setSize(518, 414);
		a.setVisible(true);
		a.setLocationRelativeTo(null);	
	}
}
