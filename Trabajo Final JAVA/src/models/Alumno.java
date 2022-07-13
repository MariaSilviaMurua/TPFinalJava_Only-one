package models;

public class Alumno {
	private int id_alumno;
	private String Nombres;
	
	private String Fecha_de_nacimiento;
	
	public Alumno(int id_alumno, String Nombres, String Fecha_De_Nacimiento){
		super();
		this.id_alumno = id_alumno;
		this.Nombres = Nombres;
		this.Fecha_de_nacimiento = Fecha_De_Nacimiento;
		
	}

	public Alumno() {
		super();
	}

	public int getid_alumno() {
		return id_alumno;
	}

	public void setid_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}

	public String getNombres() {
		return Nombres;
	}

	public void setNombres(String nombres) {
		Nombres = nombres;
	}

	public String getFecha_de_nacimiento() {
		return Fecha_de_nacimiento;
	}

	public void setFecha_de_nacimiento(String Fecha_de_nacimiento) {
		this.Fecha_de_nacimiento = Fecha_de_nacimiento;
	}

	@Override
	public String toString() {
		return "Alumno [id_alumno=" + id_alumno + ", Nombres=" + Nombres + ", FechaDeNacimiento=" + Fecha_de_nacimiento + "]";
	}
}
