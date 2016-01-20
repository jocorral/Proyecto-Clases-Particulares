package ventana;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import java.awt.Color;

import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import objetos.BaseDeDatos;

public class Ventana_Dia extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTable diaIndicado;
	private String fechaEnCuestion;
	public Ventana_Dia(TableModel modeloTabla, String fecha){
		fechaEnCuestion = fecha;
		setTitle(fecha);
		setSize(new Dimension(437, 240));
		setResizable(false);
		setMinimumSize(new Dimension(150, 150));
		getContentPane().setBackground(Color.GRAY);
		getContentPane().setLayout(null);	
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 431, 165);
		getContentPane().add(scrollPane_1);
		diaIndicado = new JTable(modeloTabla);
		scrollPane_1.setViewportView(diaIndicado);
		diaIndicado.setBackground(Color.WHITE);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
				int columna = diaIndicado.getSelectedColumn();
				int fila = diaIndicado.getSelectedRow();
				Object aBuscar = diaIndicado.getValueAt(fila, columna);
				BaseDeDatos.insert("DELETE FROM SESION WHERE H_INI LIKE ('" + diaIndicado.getValueAt(fila, 0).toString().toUpperCase().substring(0, 3)
						+ "%') AND FECHA = '" + fechaEnCuestion +
						"' AND USERNAME_P = '" + Ventana_Login.getMiUser().toUpperCase() +"'");
				System.out.println("Sesion borrada");
				Ventana_Dia.this.dispose();
				Ventana_Calendario.verDia(fechaEnCuestion);
				}catch(ArrayIndexOutOfBoundsException x){
					
				}
			}
		});
		btnBorrar.setBounds(306, 176, 89, 23);
		getContentPane().add(btnBorrar);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
