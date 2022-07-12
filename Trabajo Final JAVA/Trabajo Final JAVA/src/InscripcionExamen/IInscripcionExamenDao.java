package InscripcionExamen;
import java.util.List;
import models.Alumno;
public interface IInscripcionExamenDao {
//estan declarado pero no implementados
	public List<Alumno> findAll();
	public Alumno findXId(int id_inscripcionexamen);
	public void mostrar();
	public void save(Alumno alumno);//mod
	public void update(Alumno alumno);
	public void delete(int id);
}





