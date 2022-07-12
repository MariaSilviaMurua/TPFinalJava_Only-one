package models;

public class Carrera {
	private int id;
	private String Nombre;
	private int AñoDelPlanDeEstudio;
	public Carrera(int id, String Nombre, int AñoDelPlanDeEstudio){
		super();
		this.id = id;
		this.Nombre = Nombre;
		this.AñoDelPlanDeEstudio = AñoDelPlanDeEstudio;
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
	public int getAñoDelPlanDeEstudio() {
		return AñoDelPlanDeEstudio;
	}
	public void setAñoDelPlanDeEstudio(int añoDelPlanDeEstudio) {
		AñoDelPlanDeEstudio = añoDelPlanDeEstudio;
	}
	@Override
	public String toString() {
		return "Carrera [id=" + id + ", Nombre=" + Nombre + ", AñoDelPlanDeEstudio=" + AñoDelPlanDeEstudio + "]";
	}
	
}