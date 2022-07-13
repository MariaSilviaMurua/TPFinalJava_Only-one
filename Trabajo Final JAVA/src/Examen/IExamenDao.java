package Examen;

import java.util.List;

import models.Examen;
public interface IExamenDao {
//estan declarado pero no implementados
	public List<Examen> findAll();
	public Examen findXId(int id);
	public void mostrar();
	public void save(Examen examen);
	public void update(Examen examen);
	public void delete(int id);
}
