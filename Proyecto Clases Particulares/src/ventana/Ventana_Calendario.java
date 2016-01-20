package ventana;

import javax.swing.JFrame;
import javax.swing.JTable;

import com.toedter.calendar.JCalendar;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import objetos.BaseDeDatos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Calendar;

public class Ventana_Calendario extends JFrame{
	final static String[] columnasTablaClases = {"Hora", "Alumno"};
	private JCalendar calendar;
	public Ventana_Calendario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana_Calendario.class.getResource("/imagenes/Logo1.JPG")));
		setBounds(new Rectangle(0, 0, 469, 352));
		setSize(469, 352);
		setResizable(false);
		getContentPane().setLayout(null);

		JButton atras_JBut = new JButton("Atrás");
		atras_JBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ventana_Calendario.this.dispose();
			}
		});
		atras_JBut.setBounds(65, 277, 89, 23);
		getContentPane().add(atras_JBut);

		JButton verDia_JBut = new JButton("Ver día");
		verDia_JBut.setBounds(298, 277, 89, 23);

		getContentPane().add(verDia_JBut);

		calendar = new JCalendar();
		calendar.getYearChooser().getSpinner().setBounds(256, 0, 98, 20);
		calendar.setBounds(0, 0, 463, 255);
		getContentPane().add(calendar);
		calendar.getYearChooser().setLayout(null);

		verDia_JBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int mesN = calendar.getCalendar().get(java.util.Calendar.MONTH) +1;
				String mesS;
				if(mesN<10){
					mesS = "0" + Integer.toString(mesN);
				}else{
					mesS = Integer.toString(mesN);
				}			
				String fecha =  Integer.toString(calendar.getCalendar().get(java.util.Calendar.DATE)) + "-" +
						mesS + "-" + 
								Integer.toString(calendar.getCalendar().get(java.util.Calendar.YEAR));
				System.out.println("buscando" + fecha);
				verDia(fecha);

			}
		});
	}

	public static void verDia(String fecha){
//		String hora;
//		ArrayList<String> horasIniSesion = BaseDeDatos.selectVariosValores("SELECT * FROM SESION WHERE USERNAME_P = '" + Ventana_Login.getMiUser() + "' AND FECHA = '" + fecha + "';", "H_INI");
//		ArrayList<String> horasFinSesion = BaseDeDatos.selectVariosValores("SELECT * FROM SESION WHERE USERNAME_P = '" + Ventana_Login.getMiUser() + "' AND FECHA = '" + fecha + "';", "H_FIN");
//		ArrayList<String> alumnos = BaseDeDatos.selectVariosValores("SELECT * FROM SESION WHERE USERNAME_P = '" + Ventana_Login.getMiUser() + "' AND FECHA = '" + fecha + "';", "USERNAME_A");
		ArrayList<String> arrayClases = new ArrayList<String>();
//		for(int i = 0; i<horasIniSesion.size(); i++){
//			hora = horasIniSesion.get(i).substring(0,1) + ":" + horasIniSesion.get(i).substring(2) + " - " + horasFinSesion.get(i).substring(0,1) + ":" + horasFinSesion.get(i).substring(2);
//			arrayClases.add(hora);
//			arrayClases.add(alumnos.get(i));
//		}
		arrayClases = BaseDeDatos.selectParaDia(Ventana_Login.getMiUser().toUpperCase(), fecha);
		String[][] clases = Ventana_PrincipalProf.pasarArrayLAArray(arrayClases, 2);
		TableModel modeloTablaClases = new DefaultTableModel(clases, columnasTablaClases);
		//Crea el dia en un pop up
		Ventana_Dia dia = new Ventana_Dia(modeloTablaClases, fecha);
	}

	public static void main(String[] args) {
		Ventana_Calendario a = new Ventana_Calendario();
		a.setVisible(true);
		a.setLocationRelativeTo(null);
	}
}
