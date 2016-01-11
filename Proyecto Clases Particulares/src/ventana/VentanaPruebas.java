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
	private JTable table;
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(429, 88, -396, 205);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBounds(33, 88, 396, 205);
		panel.add(table);
		
		JLabel label = new JLabel("Bandeja de Entrada");
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label.setBounds(147, 35, 157, 25);
		panel.add(label);
	}
	 public static void main(String[] args) {
		VentanaPruebas a = new VentanaPruebas();
		a.setSize(518, 414);
		a.setVisible(true);
		a.setLocationRelativeTo(null);	
	}
}
