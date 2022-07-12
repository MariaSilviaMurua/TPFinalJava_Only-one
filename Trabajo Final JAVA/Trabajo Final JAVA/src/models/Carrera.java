package models;

public class Carrera {
	private int id;
	private String Nombre;
	private int AņoDelPlanDeEstudio;
	public Carrera(int id, String Nombre, int AņoDelPlanDeEstudio){
		super();
		this.id = id;
		this.Nombre = Nombre;
		this.AņoDelPlanDeEstudio = AņoDelPlanDeEstudio;
	}
	public Carrera() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getAņoDelPlanDeEstudio() {
		return AņoDelPlanDeEstudio;
	}
	public void setAņoDelPlanDeEstudio(int aņoDelPlanDeEstudio) {
		AņoDelPlanDeEstudio = aņoDelPlanDeEstudio;
	}
	@Override
	public String toString() {
		return "Carrera [id=" + id + ", Nombre=" + Nombre + ", AņoDelPlanDeEstudio=" + AņoDelPlanDeEstudio + "]";
	}
	
}