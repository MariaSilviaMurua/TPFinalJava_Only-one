package models;

public class Alumno {
	private int id_alumno;
	private String Nombres;
	
	private String Fecha_De_Nacimiento;
	
	public Alumno(int id_alumno, String Nombres, String Fecha_De_Nacimiento){
		super();
		this.id_alumno = id_alumno;
		this.Nombres = Nombres;
		this.Fecha_De_Nacimiento = Fecha_De_Nacimiento;
		
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

	public String getFecha_De_Nacimiento() {
		return Fecha_De_Nacimiento;
	}

	public void setFecha_De_Nacimiento(String Fecha_De_Nacimiento) {
		this.Fecha_De_Nacimiento = Fecha_De_Nacimiento;
	}

	@Override
	public String toString() {
		return "Alumno [id_alumno=" + id_alumno + ", Nombres=" + Nombres + ", FechaDeNacimiento=" + Fecha_De_Nacimiento + "]";
	}
}
