package models;

public class Materia {
	private int id;
	private String nombre;
	private String profesorAdjunto;
	private String jefeDeTrabajosPracticos;
	private Carrera carrera;

	public Materia(int id, String nombre, String profesorAdjunto, String jefeDeTrabajosPracticos, Carrera carrera){
		super();
		this.id = id;
		this.nombre = nombre;
		this.profesorAdjunto = profesorAdjunto;
		this.jefeDeTrabajosPracticos = jefeDeTrabajosPracticos;
		this.carrera = carrera;
	}
	public Materia() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getProfesorAdjunto() {
		return profesorAdjunto;
	}
	public void setProfesorAdjunto(String profesorAdjunto) {
		this.profesorAdjunto = profesorAdjunto;
	}
	public String getJefeDeTrabajosPracticos() {
		return jefeDeTrabajosPracticos;
	}
	public void setJefeDeTrabajosPracticos(String jefeDeTrabajosPracticos) {
		this.jefeDeTrabajosPracticos = jefeDeTrabajosPracticos;
	}
	public Carrera getCarrera() {
		return carrera;
	}
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	@Override
	public String toString() {
		return "Materia [id=" + id + ", nombre=" + nombre + ", profesorAdjunto=" + profesorAdjunto
				+ ", jefeDeTrabajosPracticos=" + jefeDeTrabajosPracticos + ", carrera=" + carrera + "]";
	}
	
}