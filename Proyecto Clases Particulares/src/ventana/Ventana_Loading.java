package ventana;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.JPanel;
import java.awt.Toolkit;

public class Ventana_Loading extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblLogo;
	private JPanel panelBarra;
	private JProgressBar current;
	private JTextArea out;
	private JButton find;
	private Thread runner;
	private int num = 0;
	//private Progress progress;

	public Ventana_Loading() {
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana_Loading.class.getResource("/imagenes/Logo1.JPG")));
		setResizable(false);
		setSize(522, 445);
		setLocationRelativeTo(null);
		setTitle("MyTeach");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		getContentPane().setForeground(Color.BLACK);
		setResizable(false);
		getContentPane().setLayout(null);

		lblLogo = new JLabel("");
		lblLogo.setBounds(99, 26, 291, 314);
		lblLogo.setIcon(new ImageIcon(Ventana_Loading.class
				.getResource("/imagenes/Logo1.JPG")));
		getContentPane().add(lblLogo);

		panelBarra = new JPanel();
		panelBarra.setBounds(10, 345, 497, 60);
		panelBarra.setBackground(Color.WHITE);
		panelBarra.setForeground(Color.WHITE);
		
		panelBarra.setLayout(new FlowLayout());
		//progress = new Progress();
		current = new JProgressBar(0, 2000);
		current.setValue(500);
		current.setStringPainted(true);
		panelBarra.add(current);
		
		getContentPane().add(panelBarra);
		//iterate();
	}
	
	/** Método para que la JProgressBar avance en x tiempo
	 * 
	 */
	public void iterate() {
		while (num < 2000) {
			current.setValue(num);
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
			}
			num += 95;
		}
	}

	public static void main(String[] args) {
		
		
	}

}