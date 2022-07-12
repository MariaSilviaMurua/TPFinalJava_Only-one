/* TODO COMENTADO
package InscripcionExamen;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

import AlumnoDaoImp.Categoria;
import models.Alumno;
import models.InscripcionExamen; 
public class InscripcionExamenDaoImp implements IInscripcionExamenDao{
		private Statement stmt;
		private String sql;

		public InscripcionExamenDaoImp(Statement stmt) {
			this.stmt = stmt;
		}

		@Override
		public List<InscripcionExamen> findAll() {
			List<InscripcionExamen> lista = new ArrayList<InscripcionExamen>();
			sql = "SELECT alumno.*, categorias.id_cate as idcategoria, categorias.nombre as nombrecategoria\r\n"
					+ "FROM productos\r\n" + "INNER JOIN categorias ON \r\n" + "productos.c_categoria=categorias.id_cate";
			try {
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Alumno a = new Alumno();
					a.setId(rs.getInt("id_prod"));
					p.setNombre(rs.getString("nombre"));
					p.setPrecio(rs.getDouble("precio"));
					// crear una categoria
					Categoria c = new Categoria();
					c.setId(rs.getInt("idcategoria"));
					c.setNombre(rs.getString("nombrecategoria"));
					// guardo la categoria en producto
					p.setCategoria(c);
					lista.add(p);

				}
				rs.close();
			} catch (SQLException e) {
				System.out.println("no se pudo realizar consulta");
			}
			return lista;
		}

		@Override
		public Alumno findXId(int id_inscripcionexamen) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void mostrar() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void save() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void update(Alumno alumno) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(int id) {
			// TODO Auto-generated method stub
			
		}
}

*/