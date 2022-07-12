package models;

public class Carrera {
	private int id;
	private String Nombre;
	private int A�oDelPlanDeEstudio;
	public Carrera(int id, String Nombre, int A�oDelPlanDeEstudio){
		super();
		this.id = id;
		this.Nombre = Nombre;
		this.A�oDelPlanDeEstudio = A�oDelPlanDeEstudio;
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
	public int getA�oDelPlanDeEstudio() {
		return A�oDelPlanDeEstudio;
	}
	public void setA�oDelPlanDeEstudio(int a�oDelPlanDeEstudio) {
		A�oDelPlanDeEstudio = a�oDelPlanDeEstudio;
	}
	@Override
	public String toString() {
		return "Carrera [id=" + id + ", Nombre=" + Nombre + ", A�oDelPlanDeEstudio=" + A�oDelPlanDeEstudio + "]";
	}
	
}