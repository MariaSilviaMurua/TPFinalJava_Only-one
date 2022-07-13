package MateriaDaoImp;
import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;
	
import models.Materia;
public class MateriaDaoImp implements IMateriaDao{
	
		private Statement stmt;
		private String sql;

		public MateriaDaoImp(Statement stmt) {
			this.stmt = stmt;
		}

		@Override
		public List<Materia> findAll() {
			List<Materia> lista = new ArrayList<Materia>();
			sql="SELECT id_materia,Nombre_de_la_materia,Profesor_adjunto,Jefe_de_trabajo_practico FROM materia";
			try {
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Materia m = new Materia();
					m.setid_materia(rs.getInt("id_materia"));;
					m.setNombre_de_la_materia(rs.getString("Nombre_de_la_materia"));
					m.setProfesor_adjunto(rs.getString("Profesor_adjunto"));
					m.setJefe_de_trabajo_practico(rs.getString("Jefe_de_trabajo_practico"));
					lista.add(m);
				}
				rs.close();
			} catch (SQLException e) {
				System.out.println("no se pudo realizar consulta");
			}
			return lista;
		}

		@Override
		public Materia findXId(int id) {
			// TODO Auto-generated method stub
		Materia m=null;
		sql = "SELECT id_Materia,Nombre_de_la_materia,Profesor_adjunto,Jefe_de_trabajo_practico FROM materia where id_Materia="+id;
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				 m = new Materia ();
				//instancio la materia
					m.setid_materia(rs.getInt("id_materia"));;
					m.setNombre_de_la_materia(rs.getString("Nombre_de_la_materia"));
					m.setProfesor_adjunto(rs.getString("Profesor_adjunto"));
					m.setJefe_de_trabajo_practico(rs.getString("Jefe_de_trabajo_practico"));
				//System.out.println(a.toString());
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("no se pudo realizar consulta");
		}
		return m;
			}
		
		@Override
		public void mostrar() {
			// TODO Auto-generated method stub
			sql="SELECT id_Materia,Nombre_de_la_materia,Profesor_adjunto,Jefe_de_trabajo_practico FROM materia";
			try {
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Materia m = new Materia();
					m.setid_materia(rs.getInt("id_materia"));;
					m.setNombre_de_la_materia(rs.getString("Nombre_de_la_materia"));
					m.setProfesor_adjunto(rs.getString("Profesor_adjunto"));
					m.setJefe_de_trabajo_practico(rs.getString("Jefe_de_trabajo_practico"));
					System.out.println(m.toString());
				}
				rs.close();
			} catch (SQLException e) {
				System.out.println("no se pudo realizar consulta");
			}	
		}

		@Override
		public void save(Materia materia) {
						sql = "INSERT INTO materia (id_materia,Nombre_de_la_materia,Profesor_adjunto,Jefe_de_trabajo_practico) VALUES" + "("+materia.getid_materia()+",'"+ materia.getNombre_de_la_materia() + "'," + "'" + materia.getProfesor_adjunto() + "'" + ",'" + materia.getJefe_de_trabajo_practico() + "')";

			try {
				stmt.executeUpdate(sql);
				System.out.println("alta exitosa");
			} catch (SQLException e) {
				System.out.println("error al guardar el producto");
			}
		}

		@Override
		public void update(Materia materia) {
			sql= "UPDATE materia SET Nombre_de_la_materia='"+materia.getNombre_de_la_materia()+"',Profesor_adjunto= '"+ materia.getProfesor_adjunto()+"',Jefe_de_trabajo_practico= '"+ materia.getJefe_de_trabajo_practico()+"' WHERE materia.id_materia ="+materia.getid_materia();
			try {
				stmt.executeUpdate(sql);
				System.out.println("modificacion exitosa");
			} catch (SQLException e) {
				System.out.println("error al actualizar el producto");
			}
		}

		@Override
		public void delete(int id_materia) {
			sql = "delete from materia where id_materia= " + id_materia;
			try {
				stmt.executeUpdate(sql);
				System.out.println("eliminado exitosamente");
			} catch (SQLException e) {
				System.out.println("error al eliminar el producto");
			}
		}

	
}
