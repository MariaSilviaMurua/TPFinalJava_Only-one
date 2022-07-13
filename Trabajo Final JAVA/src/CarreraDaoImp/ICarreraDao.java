package CarreraDaoImp;

import java.util.List;

import models.Carrera;

public interface ICarreraDao {
	//estan declarado pero no implementados
		public List<Carrera> findAll();
		public Carrera findXId(int id);
		public void mostrar();
		public void save(Carrera carrera);
		public void update(Carrera carrera);
		public void delete(int id);
}
