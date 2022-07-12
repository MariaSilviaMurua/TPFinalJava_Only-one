package AlumnoDaoImp;
import java.util.List;

import models.Alumno;
public interface IAlumnoDao {
//estan declarado pero no implementados
	public List<Alumno> findAll();
	public Alumno findXId(int id);
	public void mostrar();
	public void save(Alumno alumno);
	public void update(Alumno alumno);
	public void delete(int id);
}
