package MateriaDaoImp;

import java.util.List;

import models.Materia;

public interface IMateriaDao {
	public List<Materia> findAll();
	public Materia findXId(int id);
	public void mostrar();
	public void save(Materia materia);
	public void update(Materia materia);
	public void delete(int id);
}

