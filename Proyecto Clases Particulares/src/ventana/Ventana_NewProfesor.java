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


public class Ventana_NewProfesor {

	private Persona persona;
	private JFrame frame;
	private JTextField textField;
	private JSlider slider1;
	private JTextPane txtpnG;
	private  boolean estaRelleno ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Persona a = new Persona();
					Ventana_NewProfesor window = new Ventana_NewProfesor(a);
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
		frame.setBounds(100, 100, 683, 464);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false); //you can't see me!
				frame.dispose(); //Destroy the JFrame object
			}
		});
		btnAtras.setBounds(106, 386, 117, 29);
		frame.getContentPane().add(btnAtras);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				estaRelleno = guardar();
				if(estaRelleno==false){
					
					String message="Debe rellenar los campos";
					
					JOptionPane.showMessageDialog(frame, message, "¡Casillas vacías!", JOptionPane.ERROR_MESSAGE);
					
					}
				else{
					int n = 100;
					String textoPob;
					String textoCurriculum;
					//n=(int)slider.getValue(); 
					//esto es lo unico que me casca que no consigo obtner el valor del slider ****************
					//n= slider1.getValue();
					textoPob = textField.getText();
					textoCurriculum = txtpnG.getText();
					Profesor nuevoProfesor = new Profesor(persona, n,textoCurriculum);
					}
			}
		});
		
		btnGuardar.setBounds(397, 386, 117, 29);
		frame.getContentPane().add(btnGuardar);
		
		JSlider slider = new JSlider();
		slider.setMaximum(40);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(5);
		slider.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		slider.setPaintLabels(true);
		slider.setValue(0);
		
		slider.getValue();		//esto es lo unico que me casca que no consigo obtner el valor del slider ****************
		
		slider.setBounds(177, 134, 473, 42);
		frame.getContentPane().add(slider);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(53, 208, 597, 12);
		frame.getContentPane().add(separator);
		
		textField = new JTextField();
		textField.setBounds(177, 59, 333, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.getText();
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(45, 88, 605, 16);
		frame.getContentPane().add(separator_2);
		
		JLabel lblRellenarCamposProfesor = new JLabel("Rellenar campos profesor");
		lblRellenarCamposProfesor.setHorizontalAlignment(SwingConstants.CENTER);
		lblRellenarCamposProfesor.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblRellenarCamposProfesor.setBounds(203, 6, 251, 26);
		frame.getContentPane().add(lblRellenarCamposProfesor);
		
		JLabel lblPoblacin = new JLabel("Población");
		lblPoblacin.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblPoblacin.setBounds(45, 60, 84, 16);
		frame.getContentPane().add(lblPoblacin);
		
		JLabel lblPreciohora = new JLabel("Precio/hora");
		lblPreciohora.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblPreciohora.setBounds(45, 134, 100, 16);
		frame.getContentPane().add(lblPreciohora);
		
		JLabel lblCurriculumVitae = new JLabel("Curriculum vitae");
		lblCurriculumVitae.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblCurriculumVitae.setBounds(45, 242, 142, 20);
		frame.getContentPane().add(lblCurriculumVitae);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(184, 232, 435, 149);
		frame.getContentPane().add(scrollPane);
		
		txtpnG = new JTextPane();
		scrollPane.setViewportView(txtpnG);
	
	}
	public boolean guardar(){
		int n = 100;
		String textoPob;
		String textoCurriculum;
		//n=(int)slider.getValue(); 
		//esto es lo unico que me casca que no consigo obtner el valor del slider ****************
		//n= slider1.getValue();
		textoPob = textField.getText();
		textoCurriculum = txtpnG.getText();
		estaRelleno=true;
		if(n == 0  || textoPob.equals("") || textoCurriculum.equals("")){
			estaRelleno=false;		
			System.out.println(estaRelleno);
		}					
		System.out.println("El slider siempre es 0 no te preocupes");
		System.out.println("Precio/Hora: "+n);

		System.out.println("Población: "+textoPob);
		
		System.out.println("Curriculum: "+textoCurriculum);
		System.out.println(estaRelleno);
		
		return estaRelleno;	   
				  
		}
}