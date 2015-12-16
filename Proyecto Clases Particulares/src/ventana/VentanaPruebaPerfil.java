package ventana;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class VentanaPruebaPerfil extends JFrame{
private JTextField txt_Ciudad;
private JTextField txt_Telefono;
private JTextField txt_Num;
private JTextField txt_Piso;
private JTextField txt_Calle;
private JTextField txt_Apellido1;
private JTextField txt_Nombre;
private JTextField txt_Apellido2;
private JTextField txt_Para;
private JTextField txt_DParteD;
private JTextField txt_Asunto;

private JPanel panel_Botones;
private JPanel panelMensaje;
private JPanel panelPerfil;

	public VentanaPruebaPerfil() {
		panelPerfil = new JPanel();
		panelPerfil.setVisible(false);
		panelPerfil.setBounds(0, 0, 469, 352);
		this.getContentPane().add(panelPerfil);
		panelPerfil.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(39, 44, 70, 18);
		panelPerfil.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos: ");
		lblApellidos.setBounds(39, 84, 70, 18);
		panelPerfil.add(lblApellidos);
		
		JLabel lblCalle = new JLabel("Calle: ");
		lblCalle.setBounds(39, 124, 70, 18);
		panelPerfil.add(lblCalle);
		
		JButton editar_JBut = new JButton("Editar");
		editar_JBut.setBounds(316, 299, 89, 23);
		panelPerfil.add(editar_JBut);
		
		JLabel lblPiso = new JLabel("Piso: ");
		lblPiso.setBounds(161, 165, 47, 18);
		panelPerfil.add(lblPiso);
		
		JLabel lblNum = new JLabel("Nº: ");
		lblNum.setBounds(39, 165, 47, 18);
		panelPerfil.add(lblNum);
		
		JLabel lblTelefono = new JLabel("Teléfono: ");
		lblTelefono.setBounds(39, 206, 70, 18);
		panelPerfil.add(lblTelefono);
		
		JLabel lblCiudad = new JLabel("Ciudad: ");
		lblCiudad.setBounds(39, 246, 70, 18);
		panelPerfil.add(lblCiudad);
		
		txt_Ciudad = new JTextField();
		txt_Ciudad.setColumns(10);
		txt_Ciudad.setBounds(101, 245, 174, 20);
		panelPerfil.add(txt_Ciudad);
		
		txt_Telefono = new JTextField();
		txt_Telefono.setColumns(10);
		txt_Telefono.setBounds(101, 205, 174, 20);
		panelPerfil.add(txt_Telefono);
		
		txt_Num = new JTextField();
		txt_Num.setColumns(10);
		txt_Num.setBounds(101, 164, 50, 20);
		panelPerfil.add(txt_Num);
		
		txt_Piso = new JTextField();
		txt_Piso.setColumns(10);
		txt_Piso.setBounds(228, 164, 47, 20);
		panelPerfil.add(txt_Piso);
		
		txt_Calle = new JTextField();
		txt_Calle.setColumns(10);
		txt_Calle.setBounds(101, 123, 174, 20);
		panelPerfil.add(txt_Calle);
		
		txt_Apellido1 = new JTextField();
		txt_Apellido1.setColumns(10);
		txt_Apellido1.setBounds(101, 83, 86, 20);
		panelPerfil.add(txt_Apellido1);
		
		txt_Nombre = new JTextField();
		txt_Nombre.setColumns(10);
		txt_Nombre.setBounds(101, 43, 174, 20);
		panelPerfil.add(txt_Nombre);
		
		JButton guardar_JBut = new JButton("Guardar");
		guardar_JBut.setEnabled(false);
		guardar_JBut.setBounds(186, 299, 89, 23);
		panelPerfil.add(guardar_JBut);
		
		txt_Apellido2 = new JTextField();
		txt_Apellido2.setColumns(10);
		txt_Apellido2.setBounds(189, 83, 86, 20);
		panelPerfil.add(txt_Apellido2);
		
		JLabel lblFoto = new JLabel(new ImageIcon(Ventana_PrincipalProf.class.getResource("/imagenes/Perfil.png")));
		panelPerfil.add(lblFoto);
		
		JButton cambiarFoto_JBut = new JButton(new ImageIcon(Ventana_PrincipalProf.class.getResource("/imagenes/iconoEditar.png")));
		panelPerfil.add(cambiarFoto_JBut);
		
	}

}
