package objetos;

import java.util.Date;

public class Mensaje {

	private Date hora_env;
	private String mensaje;
	private String departe;
	private String para;
	private String asunto;

	public Mensaje( Date hora_env, String mensaje, 
			String departe, String para, String asunto) {
		super();
		this.hora_env = hora_env;
		this.mensaje = mensaje;
		this.asunto= asunto;
		this.departe = departe;
		this.para = para;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public Date getHora_env() {
		return hora_env;
	}



	public String getMensaje() {
		return mensaje;
	}

	public String getDeparte() {
		return departe;
	}

	public String getPara() {
		return para;
	}

	public void setHora_env(Date hora_env) {
		this.hora_env = hora_env;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public void setDeparte(String departe) {
		this.departe = departe;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
