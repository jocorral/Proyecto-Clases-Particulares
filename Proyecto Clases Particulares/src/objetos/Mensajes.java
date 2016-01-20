package objetos;


import java.io.ObjectInputStream.GetField;

public class Mensajes implements DatoParaTabla{
	private String codigo;
	private String para;
	private String de;
	private String asunto;
	private String contenido;
	private String fecha;
	
	
	public static String[] nombresAtributos = new String[] {
		"Codigo", "De","Para", "Asunto", "Contenido", "Fecha" };

	
	public Mensajes(String codigo, String de, String para, String asunto, String contenido, String fecha) {
		super();
		this.codigo =codigo;
		this.para = para;
		this.de = de;
		this.asunto = asunto;
		this.contenido = contenido;
		this.fecha = fecha;
	}


	public Mensajes(){}
	
	

	
	
	
	//Metodos de la interfaz
	
	public String getCodigo() {
		return codigo;
	}


	public String getPara() {
		return para;
	}


	public String getDe() {
		return de;
	}


	public String getAsunto() {
		return asunto;
	}


	public String getContenido() {
		return contenido;
	}


	public String getFecha() {
		return fecha;
	}




	public static String[] getNombresAtributos() {
		return nombresAtributos;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public void setPara(String para) {
		this.para = para;
	}


	public void setDe(String de) {
		this.de = de;
	}


	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}


	public void setContenido(String contenido) {
		this.contenido = contenido;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}




	public static void setNombresAtributos(String[] nombresAtributos) {
		Mensajes.nombresAtributos = nombresAtributos;
	}


	@Override
	public String toString() {
		return "Mensajes [codigo=" + codigo + ", para=" + para + ", de=" + de
				+ ", asunto=" + asunto + ", contenido=" + contenido
				+ ", fecha=" + fecha +  "]";
	}


	@Override
	public int getNumColumnas() {
		return 6;
	}

	@Override
	public Object getValor(int col) {
		switch (col) {
    	case 0: { return codigo; }
    	case 1: { return de; }
    	case 2: { return para; }
    	case 3: { return asunto; }
    	case 4: { return contenido; }
    	case 5: { return fecha; }
    	
	}
	return null;
	}

	@Override
	public void setValor(Object value, int col) {
		try {
	    	switch (col) {
		    	case 0: { codigo = (String) value; break; }
		    	case 1: { de = (String) value; break; }
		    	case 2:	{ para= (String) value; break;                             }
		    	case 3: { asunto = (String) value; break; }
		    	case 4: { contenido = (String) value; break; }
		    	case 5: { fecha = (String) value; break; }
		    	
	    	}
    	} catch (Exception e) {
    		// Error en conversi�n. Intentando asignar un tipo incorrecto
    		e.printStackTrace();
    	}
	}
}
