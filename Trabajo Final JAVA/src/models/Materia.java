package models;

public class Materia {
	private int id_materia;
	private String Nombre_de_la_materia;
	private String Profesor_adjunto;
	private String Jefe_de_trabajo_practico;
	public Materia(int id_materia, String nombre_de_la_materia, String Profesor_adjunto,
			String Jefe_de_trabajo_practico) {
		super();
		this.id_materia = id_materia;
		Nombre_de_la_materia = nombre_de_la_materia;
		this.Profesor_adjunto = Profesor_adjunto;
		this.Jefe_de_trabajo_practico = Jefe_de_trabajo_practico;
	}
	
	public Materia() {
		super();
	}

	public int getid_materia() {
		return id_materia;
	}
	public void setid_materia(int id_materia) {
		this.id_materia = id_materia;
	}
	public String getNombre_de_la_materia() {
		return Nombre_de_la_materia;
	}
	public void setNombre_de_la_materia(String Nombre_de_la_materia) {
		this.Nombre_de_la_materia = Nombre_de_la_materia;
	}
	public String getProfesor_adjunto() {
		return Profesor_adjunto;
	}
	public void setProfesor_adjunto(String Profesor_adjunto) {
		this.Profesor_adjunto = Profesor_adjunto;
	}
	public String getJefe_de_trabajo_practico() {
		return Jefe_de_trabajo_practico;
	}
	public void setJefe_de_trabajo_practico(String Jefe_de_trabajo_practico) {
		this.Jefe_de_trabajo_practico = Jefe_de_trabajo_practico;
	}

	@Override
	public String toString() {
		return "Materia [id_materia=" + id_materia + ", Nombre_de_la_materia=" + Nombre_de_la_materia
				+ ", Profesor_adjunto=" + Profesor_adjunto + ", Jefe_de_trabajo_practico=" + Jefe_de_trabajo_practico + "]";
	}
	
}