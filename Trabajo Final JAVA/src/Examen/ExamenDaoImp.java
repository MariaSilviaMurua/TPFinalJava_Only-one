package Examen;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Examen;
public class ExamenDaoImp implements IExamenDao{

		private Statement stmt;
		private String sql;

		public ExamenDaoImp(Statement stmt) {
			this.stmt = stmt;
		}

		@Override
		public List<Examen> findAll() {
			List<Examen> lista = new ArrayList<Examen>();
			sql="SELECT Examen.*, categorias.id_cate as idcategoria, categorias.nombre as nombrecategoria\r\n" + 
					"FROM productos\r\n" + 
					"INNER JOIN categorias ON \r\n" + 
					"productos.c_categoria=categorias.id_cate";
			try {
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Carrera c = new Carrera();
					c.setid_carrera(rs.getInt("id_carrera"));
					c.setNombre(rs.getString("Nombre"));
					c.setAño_del_plan_de_estudio(rs.getInt("Año_del_plan_de_estudio"));;
					lista.add(c);
				}
				rs.close();
			} catch (SQLException e) {
				System.out.println("no se pudo realizar consulta");
			}
			return lista;
		}

		@Override
		public Carrera findXId(int id) {
			// TODO Auto-generated method stub
		Carrera c=null;
		sql = "SELECT id_carrera,Nombre,Año_del_plan_de_estudio FROM carrera where id_carrera="+id;
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				 c = new Carrera ();
				//instancio la materia
					c.setid_carrera(rs.getInt("id_carrera"));;
					c.setNombre(rs.getString("Nombre"));
					c.setAño_del_plan_de_estudio(rs.getInt("Año_del_plan_de_estudio"));
				//System.out.println(a.toString());
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("no se pudo realizar consulta");
		}
		return c;
			}
		
		@Override
		public void mostrar() {
			// TODO Auto-generated method stub
			sql="SELECT id_carrera,Nombre,Año_del_plan_de_estudio FROM carrera";
			try {
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Carrera c = new Carrera();
					c.setid_carrera(rs.getInt("id_carrera"));;
					c.setNombre(rs.getString("Nombre"));
					c.setAño_del_plan_de_estudio(rs.getInt("Año_del_plan_de_estudio"));
					System.out.println(c.toString());
				}
				rs.close();
			} catch (SQLException e) {
				System.out.println("no se pudo realizar consulta");
			}	
		}

		@Override
		public void save(Carrera carrera) {
						sql = "INSERT INTO carrera (id_carrera,Nombre,Año_del_plan_de_estudio) VALUES" + "("+carrera.getid_carrera()+",'"+ carrera.getNombre() + "'," + "'" + carrera.getAño_del_plan_de_estudio()+ "')";

			try {
				stmt.executeUpdate(sql);
				System.out.println("alta exitosa");
			} catch (SQLException e) {
				System.out.println("error al guardar el producto");
			}
		}

		@Override
		public void update(Carrera carrera) {
			sql= "UPDATE carrera SET Nombre='"+carrera.getNombre()+"',Año_del_plan_de_estudio= '"+ carrera.getAño_del_plan_de_estudio()+"' WHERE carrera.id_carrera ="+carrera.getid_carrera();
			try {
				stmt.executeUpdate(sql);
				System.out.println("modificacion exitosa");
			} catch (SQLException e) {
				System.out.println("error al actualizar el producto");
			}
		}

		@Override
		public void delete(int id_carrera) {
			sql = "delete from carrera where id_carrera= " + id_carrera;
			try {
				stmt.executeUpdate(sql);
				System.out.println("eliminado exitosamente");
			} catch (SQLException e) {
				System.out.println("error al eliminar el producto");
			}
		}

	
}