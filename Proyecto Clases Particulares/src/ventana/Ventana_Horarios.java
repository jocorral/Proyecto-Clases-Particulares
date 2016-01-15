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

import javax.swing.JTextField;

import objetos.BaseDeDatos;

import java.awt.Dimension;


public class Ventana_Horarios extends JFrame{
	private JButton btnGuardar;
	private JButton btnAadirMsClases;
	private JButton btnAtras;
	private  int hora_inicial;
	private int hora_final;
	private boolean hora_correcta;
	private JComboBox comboMes;
	private JComboBox comboAnyo;
	private JComboBox comboDia;
	private JComboBox horasInicio_1;
	private JComboBox minutosInicio_1;
	private JComboBox horasFin_1;
	private JComboBox minutosFin_1;
	private JComboBox horasInicio_2;
	private JComboBox minutosInicio_2;
	private JComboBox horasFin_2;
	private JComboBox minutosFin_2;
	private JComboBox horasInicio_4;
	private JComboBox minutosInicio_4;
	private JComboBox horasFin_4;
	private JComboBox minutosFin_4;
	private JComboBox horasInicio_5;
	private JComboBox minutosInicio_5;
	private JComboBox horasFin_5;
	private JComboBox minutosFin_5;
	private JComboBox horasInicio_3;
	private JComboBox minutosInicio_3;
	private JComboBox horasFin_3;
	private JComboBox minutosFin_3;
	private JTextField txtAlumno1;
	private JTextField txtAlumno2;
	private JTextField txtAlumno3;
	private JTextField txtAlumno4;
	private JTextField txtAlumno5;

	/**
	 * Create the application.
	 */
	public Ventana_Horarios() {
		setMinimumSize(new Dimension(570, 415));
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
		lblMes.setBounds(196, 65, 31, 16);
		this.getContentPane().add(lblMes);

		JLabel lblAo = new JLabel("Año");
		lblAo.setBounds(388, 65, 61, 16);
		this.getContentPane().add(lblAo);

		comboMes = new JComboBox();
		comboMes.setModel(new DefaultComboBoxModel(new String[] {"Enero\t\t", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre ", "Noviembre", "Diciembre"}));
		comboMes.setMaximumRowCount(12);
		comboMes.setBounds(237, 60, 117, 27);
		this.getContentPane().add(comboMes);

		comboAnyo = new JComboBox();
		comboAnyo.setModel(new DefaultComboBoxModel(new String[] {"2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"}));
		comboAnyo.setBounds(425, 60, 98, 27);
		this.getContentPane().add(comboAnyo);

		comboDia = new JComboBox();
		comboDia.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboDia.setMaximumRowCount(31);
		comboDia.setBounds(86, 61, 74, 27);
		this.getContentPane().add(comboDia);

		JLabel lblHorario = new JLabel("Horario:");
		lblHorario.setBounds(30, 129, 61, 16);
		this.getContentPane().add(lblHorario);

		horasInicio_1 = new JComboBox();
		horasInicio_1.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4 ", "5 ", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		horasInicio_1.setBounds(101, 153, 74, 27);
		this.getContentPane().add(horasInicio_1);

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
		lblHasta.setBounds(316, 129, 61, 16);
		this.getContentPane().add(lblHasta);

		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setBounds(148, 129, 61, 16);
		this.getContentPane().add(lblDesde);

		minutosInicio_1 = new JComboBox();
		minutosInicio_1.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		minutosInicio_1.setBounds(175, 153, 74, 27);
		this.getContentPane().add(minutosInicio_1);

		horasFin_1 = new JComboBox();
		horasFin_1.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4 ", "5 ", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		horasFin_1.setBounds(269, 153, 74, 27);
		this.getContentPane().add(horasFin_1);

		horasInicio_2 = new JComboBox();
		horasInicio_2.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4 ", "5 ", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		horasInicio_2.setBounds(101, 184, 74, 27);
		this.getContentPane().add(horasInicio_2);

		horasInicio_3 = new JComboBox();
		horasInicio_3.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4 ", "5 ", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		horasInicio_3.setBounds(101, 212, 74, 27);

		this.getContentPane().add(horasInicio_3);

		horasInicio_4 = new JComboBox();
		horasInicio_4.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4 ", "5 ", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		horasInicio_4.setBounds(101, 240, 74, 27);
		this.getContentPane().add(horasInicio_4);

		horasInicio_5 = new JComboBox();
		horasInicio_5.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4 ", "5 ", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		horasInicio_5.setBounds(101, 268, 74, 27);
		this.getContentPane().add(horasInicio_5);

		horasFin_2 = new JComboBox();
		horasFin_2.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4 ", "5 ", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		horasFin_2.setBounds(269, 184, 74, 27);
		this.getContentPane().add(horasFin_2);

		horasFin_3 = new JComboBox();
		horasFin_3.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4 ", "5 ", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		horasFin_3.setBounds(269, 212, 74, 27);
		this.getContentPane().add(horasFin_3);

		horasFin_4 = new JComboBox();
		horasFin_4.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4 ", "5 ", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		horasFin_4.setBounds(269, 240, 74, 27);
		this.getContentPane().add(horasFin_4);

		horasFin_5 = new JComboBox();
		horasFin_5.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4 ", "5 ", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		horasFin_5.setBounds(269, 268, 74, 27);
		this.getContentPane().add(horasFin_5);

		minutosInicio_2 = new JComboBox();
		minutosInicio_2.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		minutosInicio_2.setBounds(175, 184, 74, 27);
		this.getContentPane().add(minutosInicio_2);

		minutosInicio_3 = new JComboBox();
		minutosInicio_3.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		minutosInicio_3.setBounds(175, 212, 74, 27);
		this.getContentPane().add(minutosInicio_3);

		minutosInicio_4 = new JComboBox();
		minutosInicio_4.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		minutosInicio_4.setBounds(175, 240, 74, 27);
		this.getContentPane().add(minutosInicio_4);

		minutosInicio_5 = new JComboBox();
		minutosInicio_5.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		minutosInicio_5.setBounds(175, 268, 74, 27);
		this.getContentPane().add(minutosInicio_5);

		minutosFin_1 = new JComboBox();
		minutosFin_1.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		minutosFin_1.setBounds(346, 153, 74, 27);
		this.getContentPane().add(minutosFin_1);

		minutosFin_2 = new JComboBox();
		minutosFin_2.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		minutosFin_2.setBounds(346, 184, 74, 27);

		this.getContentPane().add(minutosFin_2);

		minutosFin_3 = new JComboBox();
		minutosFin_3.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		minutosFin_3.setBounds(346, 212, 74, 27);
		this.getContentPane().add(minutosFin_3);

		minutosFin_4 = new JComboBox();
		minutosFin_4.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		minutosFin_4.setBounds(346, 240, 74, 27);
		this.getContentPane().add(minutosFin_4);

		minutosFin_5 = new JComboBox();
		minutosFin_5.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		minutosFin_5.setBounds(346, 268, 74, 27);
		this.getContentPane().add(minutosFin_5);

		btnAtras = new JButton("Atras");
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

		btnAadirMsClases = new JButton("Añadir más clases");
		btnAadirMsClases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Añadir las clases a la BD
				if(txtAlumno1.getText().equals(null) ||txtAlumno2.getText().equals(null) || txtAlumno3.getText().equals(null) ||
						txtAlumno4.getText().equals(null) ||txtAlumno5.getText().equals(null) ||
						!horaValida(horasInicio_1, minutosInicio_1, horasFin_1, minutosFin_1)==false||!horaValida(horasInicio_2, minutosInicio_2, horasFin_2, minutosFin_2)==false||
						!horaValida(horasInicio_3, minutosInicio_3, horasFin_3, minutosFin_3)==false||!horaValida(horasInicio_4, minutosInicio_4, horasFin_4, minutosFin_4)==false||
						!horaValida(horasInicio_5, minutosInicio_5, horasFin_5, minutosFin_5)==false){
					JOptionPane.showMessageDialog(Ventana_Horarios.this, "Aún se pueden añadir más clases en esta ventana o ha dejado alguna casilla de alumno vacía.", "Operación innecesaria", JOptionPane.ERROR_MESSAGE);
				}else{
					String horaInicio1 = horasInicio_1.getSelectedItem().toString() + minutosInicio_1.getSelectedItem().toString();
					String horaFin1 = horasFin_1.getSelectedItem().toString() + minutosFin_1.getSelectedItem().toString();
					String alumno_UN1 = txtAlumno1.getText();
					String horaInicio2 = horasInicio_2.getSelectedItem().toString() + minutosInicio_2.getSelectedItem().toString();
					String horaFin2 = horasFin_2.getSelectedItem().toString() + minutosFin_2.getSelectedItem().toString();
					String alumno_UN2 = txtAlumno2.getText();
					String horaInicio3 = horasInicio_3.getSelectedItem().toString() + minutosInicio_3.getSelectedItem().toString();
					String horaFin3 = horasFin_3.getSelectedItem().toString() + minutosFin_3.getSelectedItem().toString();
					String alumno_UN3 = txtAlumno3.getText();
					String horaInicio4 = horasInicio_4.getSelectedItem().toString() + minutosInicio_4.getSelectedItem().toString();
					String horaFin4 = horasFin_4.getSelectedItem().toString() + minutosFin_4.getSelectedItem().toString();
					String alumno_UN4 = txtAlumno4.getText();
					String horaInicio5 = horasInicio_5.getSelectedItem().toString() + minutosInicio_5.getSelectedItem().toString();
					String horaFin5 = horasFin_5.getSelectedItem().toString() + minutosFin_5.getSelectedItem().toString();
					String alumno_UN5 = txtAlumno5.getText();
					String fecha = comboDia.getSelectedItem().toString() + "" + comboMes.getSelectedItem().toString() + "" + comboAnyo.getSelectedItem().toString();
					String profe_UN = BaseDeDatos.getMiUser();
					BaseDeDatos.anyadirSesiones(horaInicio1, horaFin1, fecha, alumno_UN1, profe_UN);	
					BaseDeDatos.anyadirSesiones(horaInicio2, horaFin2, fecha, alumno_UN2, profe_UN);
					BaseDeDatos.anyadirSesiones(horaInicio3, horaFin3, fecha, alumno_UN3, profe_UN);
					BaseDeDatos.anyadirSesiones(horaInicio4, horaFin4, fecha, alumno_UN4, profe_UN);
					BaseDeDatos.anyadirSesiones(horaInicio5, horaFin5, fecha, alumno_UN5, profe_UN);
					Ventana_Horarios.this.setVisible(false);
					Ventana_Horarios.this.dispose();
					Ventana_Horarios vHorarios = new Ventana_Horarios();
					vHorarios.setLocationRelativeTo(null);
					vHorarios.setVisible(true);
				}
			}
		});
		btnAadirMsClases.setBounds(197, 331, 143, 29);
		this.getContentPane().add(btnAadirMsClases);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(horaValida(horasInicio_1, minutosInicio_1, horasFin_1, minutosFin_1)==false||horaValida(horasInicio_2, minutosInicio_2, horasFin_2, minutosFin_2)==false||
						horaValida(horasInicio_3, minutosInicio_3, horasFin_3, minutosFin_3)==false||horaValida(horasInicio_4, minutosInicio_4, horasFin_4, minutosFin_4)==false||
						horaValida(horasInicio_5, minutosInicio_5, horasFin_5, minutosFin_5)==false){
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

		txtAlumno1 = new JTextField();
		txtAlumno1.setBounds(437, 153, 86, 27);
		getContentPane().add(txtAlumno1);
		txtAlumno1.setColumns(10);

		txtAlumno2 = new JTextField();
		txtAlumno2.setColumns(10);
		txtAlumno2.setBounds(437, 184, 86, 27);
		getContentPane().add(txtAlumno2);

		txtAlumno3 = new JTextField();
		txtAlumno3.setColumns(10);
		txtAlumno3.setBounds(437, 212, 86, 27);
		getContentPane().add(txtAlumno3);

		txtAlumno4 = new JTextField();
		txtAlumno4.setColumns(10);
		txtAlumno4.setBounds(437, 240, 86, 27);
		getContentPane().add(txtAlumno4);

		txtAlumno5 = new JTextField();
		txtAlumno5.setColumns(10);
		txtAlumno5.setBounds(437, 268, 86, 27);
		getContentPane().add(txtAlumno5);
	}
	public boolean horaValida(JComboBox horaIni, JComboBox minutosIni, JComboBox horaFin, JComboBox minutosFin ){

		hora_inicial= (horaIni.getSelectedIndex()*60)+minutosIni.getSelectedIndex() ;
		hora_final=(horaFin.getSelectedIndex()*60)+minutosFin.getSelectedIndex();	
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

}
