package models;

public class Examen {
	private int id_examen;
	private Carrera id_carrera1;
	private Materia id_materia1;
	private String Fecha;
	private String Hora;
	public Examen(int id_examen, Carrera id_carrera1, Materia id_materia1, String fecha, String hora) {
		super();
		this.id_examen = id_examen;
		this.id_carrera1 = id_carrera1;
		this.id_materia1 = id_materia1;
		Fecha = fecha;
		Hora = hora;
	}
	public int getId_examen() {
		return id_examen;
	}
	public void setid_examen(int id_examen) {
		this.id_examen = id_examen;
	}
	public Carrera getid_carrera1() {
		return id_carrera1;
	}
	public void setid_carrera1(Carrera id_carrera1) {
		this.id_carrera1 = id_carrera1;
	}
	public Materia getid_materia1() {
		return id_materia1;
	}
	public void setid_materia1(Materia id_materia1) {
		this.id_materia1 = id_materia1;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	public String getHora() {
		return Hora;
	}
	public void setHora(String hora) {
		Hora = hora;
	}
	@Override
	public String toString() {
		return "Examen [id_examen=" + id_examen + ", id_carrera1=" + id_carrera1 + ", id_materia1=" + id_materia1
				+ ", Fecha=" + Fecha + ", Hora=" + Hora + "]";
	}
	

}

