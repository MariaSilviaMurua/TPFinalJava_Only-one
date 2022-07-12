package models;

public class InscripcionExamen {
	private int id_examen;
	private Materia materia;
	private Carrera carrera;
	public InscripcionExamen(int id_examen, Materia materia, Carrera carrera){
		super();
		this.id_examen = id_examen;
		this.materia = materia;
		this.carrera = carrera;
	}
	public int getId_examen() {
		return id_examen;
	}
	public void setId_examen(int id_examen) {
		this.id_examen = id_examen;
	}
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	public Carrera getCarrera() {
		return carrera;
	}
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	public InscripcionExamen() {
		super();
	}
	@Override
	public String toString() {
		return "InscripcionExamen [id_examen=" + id_examen + ", materia=" + materia + ", carrera=" + carrera + "]";
	}

}

