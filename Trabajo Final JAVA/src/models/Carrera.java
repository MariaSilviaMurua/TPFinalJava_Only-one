package models;

public class Carrera {
	private int id_carrera;
	private String Nombre;
	private int A�o_del_plan_de_estudio;
	public Carrera(int id_carrera, String nombre, int a�o_del_plan_de_estudio) {
		super();
		this.id_carrera = id_carrera;
		Nombre = nombre;
		A�o_del_plan_de_estudio = a�o_del_plan_de_estudio;
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
	public int getA�o_del_plan_de_estudio() {
		return A�o_del_plan_de_estudio;
	}
	public void setA�o_del_plan_de_estudio(int A�o_del_plan_de_estudio) {
		this.A�o_del_plan_de_estudio = A�o_del_plan_de_estudio;
	}

	@Override
	public String toString() {
		return "Carrera [id_carrera=" + id_carrera + ", Nombre=" + Nombre + ", A�o_del_plan_de_estudio="
				+ A�o_del_plan_de_estudio + "]";
	}
	
}