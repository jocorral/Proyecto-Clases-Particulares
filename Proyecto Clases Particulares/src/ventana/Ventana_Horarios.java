package ventana;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Label;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;


public class Ventana_Horarios extends JFrame{
	private  int hora_inicial;
	private int hora_final;
	private boolean hora_correcta;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JComboBox comboBox_4;
	private JComboBox comboBox_5;
	private JComboBox comboBox_27;
	private JComboBox comboBox_6;
	private JComboBox comboBox_20;
	private JComboBox comboBox_13;
	private JComboBox comboBox_28;
	private JComboBox comboBox_8;
	private JComboBox comboBox_22;
	private JComboBox comboBox_15;
	private JComboBox comboBox_30;
	private JComboBox comboBox_9;
	private JComboBox comboBox_23;
	private JComboBox comboBox_16;
	private JComboBox comboBox_31;
	private JComboBox comboBox_7;
	private JComboBox comboBox_21;
	private JComboBox comboBox_14;
	private JComboBox comboBox_29;

	/**
	 * Create the application.
	 */
	public Ventana_Horarios() {
		initialize();
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		this.setResizable(false);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana_NewPersona.class.getResource("/imagenes/Logo1.JPG")));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);

		JLabel lblHorarios = new JLabel("Horarios");
		lblHorarios.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblHorarios.setBounds(241, 16, 87, 22);
		this.getContentPane().add(lblHorarios);

		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(30, 65, 31, 16);
		this.getContentPane().add(lblDia);

		JLabel lblMes = new JLabel("Mes");
		lblMes.setBounds(164, 65, 31, 16);
		this.getContentPane().add(lblMes);

		JLabel lblAo = new JLabel("Año");
		lblAo.setBounds(352, 65, 61, 16);
		this.getContentPane().add(lblAo);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Enero\t\t", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre ", "Noviembre", "Diciembre"}));
		comboBox.setMaximumRowCount(12);
		comboBox.setBounds(197, 61, 117, 27);
		this.getContentPane().add(comboBox);

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"}));
		comboBox_1.setBounds(397, 61, 98, 27);
		this.getContentPane().add(comboBox_1);

		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_2.setMaximumRowCount(31);
		comboBox_2.setBounds(86, 61, 74, 27);
		this.getContentPane().add(comboBox_2);

		JLabel lblHorario = new JLabel("Horario:");
		lblHorario.setBounds(30, 129, 61, 16);
		this.getContentPane().add(lblHorario);

		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4 ", "5 ", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_3.setBounds(107, 153, 74, 27);
		this.getContentPane().add(comboBox_3);

		JLabel lblClase = new JLabel("Clase 2");
		lblClase.setBounds(30, 188, 61, 16);
		this.getContentPane().add(lblClase);

		JLabel lblClase_1 = new JLabel("Clase 1");
		lblClase_1.setBounds(30, 157, 61, 16);
		this.getContentPane().add(lblClase_1);

		JLabel lblClase_2 = new JLabel("Clase 3");
		lblClase_2.setBounds(30, 216, 61, 16);
		this.getContentPane().add(lblClase_2);

		JLabel lblClase_3 = new JLabel("Clase 4");
		lblClase_3.setBounds(30, 244, 61, 16);
		this.getContentPane().add(lblClase_3);

		JLabel lblClase_4 = new JLabel("Clase 5");
		lblClase_4.setBounds(30, 272, 61, 16);
		this.getContentPane().add(lblClase_4);

		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setBounds(322, 129, 61, 16);
		this.getContentPane().add(lblHasta);

		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setBounds(154, 129, 61, 16);
		this.getContentPane().add(lblDesde);

		comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		comboBox_4.setBounds(181, 153, 74, 27);
		this.getContentPane().add(comboBox_4);

		comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4 ", "5 ", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_5.setBounds(275, 153, 74, 27);
		this.getContentPane().add(comboBox_5);

		comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4 ", "5 ", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_6.setBounds(107, 184, 74, 27);
		this.getContentPane().add(comboBox_6);

		comboBox_7 = new JComboBox();
		comboBox_7.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4 ", "5 ", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_7.setBounds(107, 212, 74, 27);

		this.getContentPane().add(comboBox_7);

		comboBox_8 = new JComboBox();
		comboBox_8.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4 ", "5 ", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_8.setBounds(107, 240, 74, 27);
		this.getContentPane().add(comboBox_8);

		comboBox_9 = new JComboBox();
		comboBox_9.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4 ", "5 ", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_9.setBounds(107, 268, 74, 27);
		this.getContentPane().add(comboBox_9);

		comboBox_13 = new JComboBox();
		comboBox_13.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4 ", "5 ", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_13.setBounds(275, 184, 74, 27);
		this.getContentPane().add(comboBox_13);

		comboBox_14 = new JComboBox();
		comboBox_14.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4 ", "5 ", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_14.setBounds(275, 212, 74, 27);
		this.getContentPane().add(comboBox_14);

		comboBox_15 = new JComboBox();
		comboBox_15.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4 ", "5 ", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_15.setBounds(275, 240, 74, 27);
		this.getContentPane().add(comboBox_15);

		comboBox_16 = new JComboBox();
		comboBox_16.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4 ", "5 ", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_16.setBounds(275, 268, 74, 27);
		this.getContentPane().add(comboBox_16);

		comboBox_20 = new JComboBox();
		comboBox_20.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		comboBox_20.setBounds(181, 184, 74, 27);
		this.getContentPane().add(comboBox_20);

		comboBox_21 = new JComboBox();
		comboBox_21.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		comboBox_21.setBounds(181, 212, 74, 27);
		this.getContentPane().add(comboBox_21);

		comboBox_22 = new JComboBox();
		comboBox_22.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		comboBox_22.setBounds(181, 240, 74, 27);
		this.getContentPane().add(comboBox_22);

		comboBox_23 = new JComboBox();
		comboBox_23.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		comboBox_23.setBounds(181, 268, 74, 27);
		this.getContentPane().add(comboBox_23);

		comboBox_27 = new JComboBox();
		comboBox_27.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		comboBox_27.setBounds(352, 153, 74, 27);
		this.getContentPane().add(comboBox_27);

		comboBox_28 = new JComboBox();
		comboBox_28.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		comboBox_28.setBounds(352, 184, 74, 27);

		this.getContentPane().add(comboBox_28);

		comboBox_29 = new JComboBox();
		comboBox_29.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		comboBox_29.setBounds(352, 212, 74, 27);
		this.getContentPane().add(comboBox_29);

		comboBox_30 = new JComboBox();
		comboBox_30.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		comboBox_30.setBounds(352, 240, 74, 27);
		this.getContentPane().add(comboBox_30);

		comboBox_31 = new JComboBox();
		comboBox_31.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		comboBox_31.setBounds(352, 268, 74, 27);
		this.getContentPane().add(comboBox_31);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_Horarios.this.setVisible(false);
				Ventana_Horarios.this.dispose();
				Ventana_PrincipalProf vPrincipal = new Ventana_PrincipalProf("");
				vPrincipal.setVisible(true);
			}
		});
		btnAtras.setBounds(58, 331, 117, 29);
		this.getContentPane().add(btnAtras);

		JButton btnAadirMsClases = new JButton("Añadir más clases");
		btnAadirMsClases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Ventana_Horarios.this.setVisible(false);
				Ventana_Horarios.this.dispose();
				Ventana_Horarios vHorarios = new Ventana_Horarios();
				vHorarios.setVisible(true);
				
			}
		});
		btnAadirMsClases.setBounds(197, 331, 143, 29);
		this.getContentPane().add(btnAadirMsClases);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				horaValida();
				if(horaValida()==false||horaValida1()==false||horaValida2()==false||horaValida3()==false||horaValida4()==false||horaValida()==false){
					String message="la hora final acaba antes de la hora inicial";
					System.out.println(message);
					JOptionPane.showMessageDialog(Ventana_Horarios.this, message,"¡Casillas vacías!", JOptionPane.ERROR_MESSAGE);
				}
				else{

				}
			}
		});
		btnGuardar.setBounds(352, 331, 117, 29);
		this.getContentPane().add(btnGuardar);
	}
	public boolean horaValida(){

		hora_inicial= (comboBox_3.getSelectedIndex()*60)+comboBox_4.getSelectedIndex() ;
		hora_final=(comboBox_5.getSelectedIndex()*60)+comboBox_27.getSelectedIndex();	
		System.out.println(hora_inicial);	
		System.out.println(hora_final);

		if (hora_inicial>hora_final){
			hora_correcta=false;
			System.out.println(hora_correcta);
			return hora_correcta;

		}
		else{
			hora_correcta=true;
			return hora_correcta;
		}		
	}
	
	public boolean horaValida1(){
		hora_inicial= (comboBox_6.getSelectedIndex()*60)+comboBox_20.getSelectedIndex() ;
		hora_final=(comboBox_13.getSelectedIndex()*60)+comboBox_28.getSelectedIndex();	
		System.out.println(hora_inicial);	
		System.out.println(hora_final);
		if (hora_inicial>hora_final){
			hora_correcta=false;
			return hora_correcta;
		}
		else{
			hora_correcta=true;
			return hora_correcta;
		}
	}
	
	public boolean horaValida2(){
		hora_inicial= (comboBox_8.getSelectedIndex()*60)+comboBox_22.getSelectedIndex() ;
		hora_final=(comboBox_15.getSelectedIndex()*60)+comboBox_30.getSelectedIndex();	
		System.out.println(hora_inicial);	
		System.out.println(hora_final);
		if (hora_inicial>hora_final){
			hora_correcta=false;
			return hora_correcta;
		}
		else{
			hora_correcta=true;
			return hora_correcta;
		}

	}
	
	public boolean horaValida3(){
		hora_inicial= (comboBox_9.getSelectedIndex()*60)+comboBox_23.getSelectedIndex() ;
		hora_final=(comboBox_16.getSelectedIndex()*60)+comboBox_31.getSelectedIndex();	
		System.out.println(hora_inicial);	
		System.out.println(hora_final);
		if (hora_inicial>hora_final){
			hora_correcta=false;
			return hora_correcta;
		}
		else{
			hora_correcta=true;
			return hora_correcta;
		}

	}
	
	public boolean horaValida4(){
		hora_inicial= (comboBox_7.getSelectedIndex()*60)+comboBox_21.getSelectedIndex() ;
		hora_final=(comboBox_14.getSelectedIndex()*60)+comboBox_29.getSelectedIndex();	
		System.out.println(hora_inicial);	
		System.out.println(hora_final);
		if (hora_inicial>hora_final){
			hora_correcta=false;
			return hora_correcta;
		}
		else{
			hora_correcta=true;
			return hora_correcta;
		}
	}
	
}
