package models;

public class Carrera {
	private int id_carrera;
	private String Nombre;
	private int Año_del_plan_de_estudio;
	public Carrera(int id_carrera, String nombre, int año_del_plan_de_estudio) {
		super();
		this.id_carrera = id_carrera;
		Nombre = nombre;
		Año_del_plan_de_estudio = año_del_plan_de_estudio;
	}
	
	public Carrera() {
		super();
	}

	public int getid_carrera() {
		return id_carrera;
	}
	public void setid_carrera(int id_carrera) {
		this.id_carrera = id_carrera;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getAño_del_plan_de_estudio() {
		return Año_del_plan_de_estudio;
	}
	public void setAño_del_plan_de_estudio(int Año_del_plan_de_estudio) {
		this.Año_del_plan_de_estudio = Año_del_plan_de_estudio;
	}

	@Override
	public String toString() {
		return "Carrera [id_carrera=" + id_carrera + ", Nombre=" + Nombre + ", Año_del_plan_de_estudio="
				+ Año_del_plan_de_estudio + "]";
	}
	
}