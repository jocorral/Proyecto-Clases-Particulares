package ventana;

import javax.swing.JFrame;
import com.toedter.calendar.JCalendar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Ventana_Calendario extends JFrame{
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
		
		JCalendar calendar = new JCalendar();
		calendar.getYearChooser().getSpinner().setBounds(256, 0, 98, 20);
		calendar.setBounds(0, 0, 463, 255);
		getContentPane().add(calendar);
		calendar.getYearChooser().setLayout(null);

	}
	public static void main(String[] args) {
		Ventana_Calendario a = new Ventana_Calendario();
		a.setVisible(true);
		a.setLocationRelativeTo(null);
	}
}
