package ventana;

import javax.swing.JFrame;
import javax.swing.JPanel;



import java.awt.Dimension;



import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

import objetos.DatoParaTabla;
import objetos.Mensaje;
import objetos.Persona;

public class Ventana_Mensajes extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	// Modelo de datos propio
	private static MiTableModel datos;
	private static MiTableModel datos2;

	// [02] Renderers para alinear distinto que a la izquierda
	private static DefaultTableCellRenderer rendererDerecha = new DefaultTableCellRenderer();
	private static DefaultTableCellRenderer rendererCentrado = new DefaultTableCellRenderer();
	static {
		rendererDerecha.setHorizontalAlignment(JLabel.RIGHT);
		rendererCentrado.setHorizontalAlignment(JLabel.CENTER);
	}
	// Componentes Nuevo Mensaje
	private static JPanel panelNuevoMensaje;
	private static JLabel lblPara;
	private static JTextField txtPara;
	private static JLabel lblDe;
	private static JTextField txtDe;
	private static JLabel lblAsunto;
	private static JTextField txtAsunto;
	private static JLabel lblMensaje;
	private static JTextArea txtMensaje;
	private static JButton btnEnviar;

	// Componentes Bandeja de Entrada
	private static JPanel panel;
	private static JButton btnBusqueda;
	private static JButton btnPerfil;
	private static JButton btnMensaje;
	private static JButton btnAtras;
	private static JPanel panelBotonera;
	private static JButton btnNuevoMensaje;
	private static JButton btnBandejaDeEntrada;
	private static JButton btnEnviados;
	private static JPanel panelBandejaEntrada;
	private static JButton btnEliminar;
	private static JTable table;
	private static JScrollPane scrollPane;
	private TableModel tableMode;
	private static Ventana_Mensajes tabla;
	private static JFrame frame = new JFrame();

	public Ventana_Mensajes(MiTableModel modelo) {
		super(modelo);
		// Fijar tamaño preferido de la tabla
		setPreferredScrollableViewportSize(new Dimension(491, 252));
		// [02] Asignar renderers de alineación horizontal
		getColumn("Asunto").setCellRenderer(rendererCentrado);
		getColumn("Hora").setCellRenderer(rendererCentrado);
		getColumn("Fecha").setCellRenderer(rendererCentrado);
		// [03] Asignar anchuras iniciales
		getColumn("Asunto").setMinWidth(170);
		getColumn("De").setMinWidth(50);
		getColumn("Tipo").setMinWidth(50);
		getColumn("Hora").setMinWidth(15);
		getColumn("Fecha").setMinWidth(50);
	}

	public void setModel(TableModel t) {
		if (t instanceof MiTableModel)
			super.setModel(t);
		else
			throw new IncompatibleClassChangeError(
					"No se puede asignar cualquier modelo de datos a una MIJTable");
	}

	public MiTableModel getMiTableModel() {
		return (MiTableModel) getModel();
	}

	public static void crearYMostrarGUI() {

		// CODIGO NUEVO MENSAJE

		panelNuevoMensaje = new JPanel();
		panelNuevoMensaje.setBounds(161, 33, 517, 383);
		panelNuevoMensaje.setLayout(null);

		lblPara = new JLabel("Para: ");
		lblPara.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPara.setBounds(28, 36, 31, 14);
		panelNuevoMensaje.add(lblPara);

		txtPara = new JTextField();
		txtPara.setBounds(117, 34, 345, 20);
		panelNuevoMensaje.add(txtPara);
		txtPara.setColumns(10);

		lblDe = new JLabel("De parte de: ");
		lblDe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDe.setBounds(28, 83, 74, 14);
		panelNuevoMensaje.add(lblDe);

		txtDe = new JTextField();
		txtDe.setColumns(10);
		txtDe.setBounds(117, 81, 345, 20);
		panelNuevoMensaje.add(txtDe);

		lblAsunto = new JLabel("Asunto: ");
		lblAsunto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAsunto.setBounds(28, 137, 55, 14);
		panelNuevoMensaje.add(lblAsunto);

		txtAsunto = new JTextField();
		txtAsunto.setColumns(10);
		txtAsunto.setBounds(117, 135, 345, 20);
		panelNuevoMensaje.add(txtAsunto);

		lblMensaje = new JLabel("Mensaje:");
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMensaje.setBounds(28, 174, 55, 14);
		panelNuevoMensaje.add(lblMensaje);

		btnEnviar = new JButton("ENVIAR");
		btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEnviar.setBounds(373, 349, 89, 23);
		panelNuevoMensaje.add(btnEnviar);

		txtMensaje = new JTextArea();
		txtMensaje.setBounds(28, 199, 434, 129);
		txtMensaje.setLineWrap(true);
		txtMensaje.setWrapStyleWord(true);
		txtMensaje.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.GRAY),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		panelNuevoMensaje.add(txtMensaje);

		// CODIGO BADEJA ENTRADA
		// Crear datos de prueba
		datos = new MiTableModel(Mensaje.nombresAtributos,
				Mensaje.atributosEditables);
		datos2 = new MiTableModel(Mensaje.nombresAtributos,
				Mensaje.atributosEditables);
		// TODO insertar de la lista de mensajes
		Persona p = new Persona();
		// TODO cuando este Login
		// for (Mensaje mensaje : Ventana_Login.persona.getBandejaEntrada()){
		for (Mensaje mensaje : p.getBandejaEntrada()) {
			datos.insertar(mensaje);
		}
		for (Mensaje mensaje : p.getEnviados()) {
			datos2.insertar(mensaje);
		}
		// datos.insertar( new Peticion( "Petición", "Piruli",
		// "Clase de hoy", "15:30", "03/12/2015", new Boolean(false) ) );
		// datos.insertar( new Mensaje( "Mensaje", "Juan",
		// "Clase de mañana", "18:00", "01/11/2015", new Boolean(false) ) );
		// datos.insertar( new Peticion( "Petición", "Lola",
		// "Cancelar clase", "11:30", "02/10/2015", new Boolean(false) ) );
		// datos.insertar( new Mensaje( "Mensaje", "Catalina",
		// "Clase de ayer", "20:00", "01/11/2015", new Boolean(false) ) );
		// datos.insertar(new Peticion("Petición", "Periquita",
		// "No quiero dar mas clase", "15:00", "12/12/2012", new
		// Boolean(false)));

		// Crear la tabla y el scrollpane
		// table = new JTable();
		// table.setBounds(491, 252, -486, -211);
		// panelBandejaEntrada.add(table);
		tabla = new Ventana_Mensajes(datos);
		scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(10, 11, 497, 320);

		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(684, 445);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		panelBandejaEntrada = new JPanel();
		panelBandejaEntrada.setBounds(161, 33, 517, 383);
		frame.getContentPane().add(panelBandejaEntrada);
		panelBandejaEntrada.setLayout(null);

		panelBandejaEntrada.add(scrollPane);

		// btnEliminar
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBounds(387, 345, 120, 23);
		btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Eliminar");
				int result = JOptionPane.showConfirmDialog(null,
						"Are you sure you wish to exit application?", null,
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					if (tabla.getSelectedRow() >= 0
							&& tabla.getSelectedRow() < datos.getRowCount()) {
						for (int i = datos.getRowCount() - 1; i >= 0; i--) {
							if ((boolean) datos.getValueAt(i, 5)) {
								// TODO Borrar en el arraylist y en la base de
								// datos
								datos.borrar(i);
							}
						}
						tabla.updateUI();
					} else {
						JOptionPane.showMessageDialog(null,
								"Selecciona una fila antes de borrarla",
								"Error en borrado",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
				if (result == JOptionPane.NO_OPTION) {
					for (int i = datos.getRowCount() - 1; i >= 0; i--) {
						if ((boolean) datos.getValueAt(i, 5)) {
							datos.setValueAt(false, i, 5);
						}
					}
				}
			}
		});
		panelBandejaEntrada.add(btnEliminar);

		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 162, 416);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		btnBusqueda = new JButton("BÚSQUEDA");
		btnBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_Busqueda ventanaBusqueda = new Ventana_Busqueda();
				ventanaBusqueda.setVisible(true);
				frame.setVisible(false);
			}
		});
		
		btnBusqueda.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBusqueda.setBounds(10, 11, 141, 80);
		panel.add(btnBusqueda);
		
		btnPerfil = new JButton("PERFIL");
		btnPerfil.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPerfil.setBounds(10, 113, 141, 86);
		btnPerfil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO Ventana de Enara
				frame.setVisible(false);
			}
		});
		panel.add(btnPerfil);
		
		btnMensaje = new JButton("MENSAJES");
		btnMensaje.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMensaje.setBounds(10, 217, 141, 86);
		btnMensaje.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Ventana_Mensajes.crearYMostrarGUI();
				frame.setVisible(false);
			}
		});
		panel.add(btnMensaje);
		
		btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(Ventana_Mensajes.class 
				.getResource("/imagenes/flecha_atras.gif")));
		btnAtras.setBounds(10, 325, 141, 80);
		btnAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Ventana_Login ventanaLogin = new Ventana_Login();
				ventanaLogin.setVisible(true);
				frame.setVisible(false);
			}
		});
		panel.add(btnAtras);
		
		panelBotonera = new JPanel();
		panelBotonera.setBackground(Color.LIGHT_GRAY);
		panelBotonera.setBounds(161, 0, 517, 33);
		frame.getContentPane().add(panelBotonera);
		panelBotonera.setLayout(null);
		
		panelNuevoMensaje.setVisible(false);
		panelBandejaEntrada.setVisible(true);
		
		btnNuevoMensaje = new JButton("NUEVO MENSAJE");
		btnNuevoMensaje.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNuevoMensaje.setBounds(32, 5, 125, 23);
		btnNuevoMensaje.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelNuevoMensaje.setVisible(true);
				panelBandejaEntrada.setVisible(false);
			}
		});
		panelBotonera.add(btnNuevoMensaje);
		
		btnBandejaDeEntrada = new JButton("BANDEJA DE ENTRADA");
		btnBandejaDeEntrada.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBandejaDeEntrada.setBounds(170, 5, 170, 23);
		btnBandejaDeEntrada.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelNuevoMensaje.setVisible(false);
				panelBandejaEntrada.setVisible(true);
				tabla.setModel(datos);
			}
		});
		panelBotonera.add(btnBandejaDeEntrada);
		frame.getContentPane().add(panelNuevoMensaje);
		
		btnEnviados = new JButton("ENVIADOS");
		btnEnviados.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEnviados.setBounds(352, 5, 120, 23);
		btnEnviados.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelBandejaEntrada.setVisible(true);
				panelNuevoMensaje.setVisible(false);
				tabla.setModel(datos2);
				
				
			}
		});
		panelBotonera.add(btnEnviados);
		
		btnEnviar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if ((txtPara.getText().equals(""))
						|| (txtDe.getText().equals(""))
						|| (txtAsunto.getText().equals(""))
						|| (txtMensaje.getText().equals(""))) {
					JOptionPane.showMessageDialog(frame,
							"Hay un campo incompleto", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(frame,
							"El mensaje ha sido enviado", "ENVIADO",
							JOptionPane.INFORMATION_MESSAGE);
					//TODO Crear la interaccion, guardar en..... , copiar en .....
					frame.getContentPane().remove(panelNuevoMensaje);
					frame.getContentPane().add(panelBandejaEntrada);
					frame.getContentPane().repaint();
				}

			}
		});

        // Muestra la ventana
        
        frame.setVisible(true);
	}
	
	//TODO Hacerlo como el boton eliminar
	
	public static void main(String[] args) {
	       // Mandar trabajo a Swing
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                crearYMostrarGUI();
            }
        });
	}
	
}


// [01] Clase que implementa un modelo de datos para usar en JTables
class MiTableModel extends AbstractTableModel {
    // Lista principal de datos del modelo:
    private ArrayList<DatoParaTabla> datos = new ArrayList<DatoParaTabla>();
    private String[] nombresColumnas;  // Nombres de columnas
    private boolean[] columnasEditables;  // Columnas editables o no
	private static final long serialVersionUID = 7026825539532562011L;
	private boolean DEBUG = true;

    /** Constructor de modelo de tabla
     * @param nombresColumnas	Nombres de las columnas
     * @param colsEditables	Array de valores lógicos si las columnas son editables (true) o no (false)
     */
    public MiTableModel( String[] nombresColumnas, boolean[] colsEditables ) {
    	this.nombresColumnas = nombresColumnas;
    	this.columnasEditables = colsEditables;
    }

    /** Añade un dato al final del modelo
     * @param dato	Dato a añadir
     */
    public void insertar( DatoParaTabla dato ) {
    	datos.add( dato );
    }

    /** Elimina un dato del modelo
     * @param dato	Dato a borrar
     */
    public void borrar( DatoParaTabla dato ) {
    	datos.remove( dato );
    }

    /** Elimina un dato del modelo, indicado por su posición
     * @param ind	Posición del dato a borrar
     */
    public void borrar( int ind ) {
    	datos.remove( ind );
    }
    
    /* [01] MODELO: Devuelve el número de columnas
     */
	@Override
	public int getColumnCount() {
		 return nombresColumnas.length;
	}
	
	 /* [01] MODELO: Devuelve el número de filas
     */
	@Override
	public int getRowCount() {
		return datos.size();
	}
	
	 /* [01] MODELO: Devuelve el nombre de la columna
     */
	@Override
    public String getColumnName(int col) {
        return nombresColumnas[col];
    }
	
    /* [01] MODELO: Devuelve el valor de la celda indicada
     */
	@Override
	public Object getValueAt(int row, int column) {
		return datos.get(row).getValor(column);
	}
	
	//EDITAR
	
	 /* [01] MODELO: Este método devuelve el renderer/editor por defecto
     * para cada celda, identificado por la columna. Si no cambiáramos
     * este método la última columna se vería como un String en lugar
     * de un checkbox (renderer/editor por defecto para Boolean)
     */
    public Class<?> getColumnClass(int c) {
    	if (datos.size()==0) return String.class;  // por defecto String
        return datos.get(0).getValor(c).getClass();  // Si hay datos, la clase correspondiente
    }

    /* [01] MODELO: Si la tabla es editable, este método identifica
     * qué celdas pueden editarse
     */
    public boolean isCellEditable(int row, int col) {
    	if (col >= 0 && col < columnasEditables.length)
    		return columnasEditables[col];
    	else return false;
    }

    /* [01] MODELO: Método que sólo hay que implementar si la tabla
     * puede cambiar (editar) valores de sus celdas
     */
    public void setValueAt(Object value, int row, int col) {
        if (DEBUG) {
            System.out.println("Poniendo valor en (" + row + "," + col
                               + ") = " + value + " (instancia de "
                               + value.getClass() + ")");
        }
        datos.get(row).setValor( value, col );
        fireTableCellUpdated(row, col);  // Notifica a escuchadores de cambio de celda
    }
}