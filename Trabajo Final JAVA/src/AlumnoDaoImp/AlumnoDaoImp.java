package AlumnoDaoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Alumno;

public class AlumnoDaoImp implements IAlumnoDao {
	private Statement stmt;
	private String sql;

	public AlumnoDaoImp(Statement stmt) {
		this.stmt = stmt;
	}

	@Override
	public List<Alumno> findAll() {
		List<Alumno> lista = new ArrayList<Alumno>();
		sql="SELECT id_alumno,Nombres,Fecha_de_nacimiento FROM alumno";
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Alumno a = new Alumno();
				a.setid_alumno(rs.getInt("id_alumno"));
				a.setNombres(rs.getString("Nombres"));
				a.setFecha_de_nacimiento(rs.getString("Fecha_de_nacimiento"));
				lista.add(a);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("no se pudo realizar consulta");
		}
		return lista;
	}

	@Override
	public Alumno findXId(int id) {
		// TODO Auto-generated method stub
	Alumno a=null;
	sql = "SELECT id_alumno,Nombres,Fecha_de_nacimiento FROM alumno where id_alumno="+id;
	try {
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			 a = new Alumno ();
			//instancio el alumno
			a.setid_alumno((rs.getInt("id_alumno")));;
			a.setNombres(rs.getString("Nombres"));
			a.setFecha_de_nacimiento(rs.getString("Fecha_de_nacimiento"));
			//System.out.println(a.toString());
		}
		rs.close();
	} catch (SQLException e) {
		System.out.println("no se pudo realizar consulta");
	}
	return a;
		}
	
	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		sql="SELECT id_alumno,Nombres,Fecha_de_nacimiento FROM alumno";
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Alumno a = new Alumno();
				a.setid_alumno(rs.getInt("id_alumno"));
				a.setNombres(rs.getString("Nombres"));
				a.setFecha_de_nacimiento(rs.getString("Fecha_de_nacimiento"));
				System.out.println(a.toString());
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("no se pudo realizar consulta");
		}	
	}

	@Override
	public void save(Alumno alumno) {
					sql = "INSERT INTO alumno (id_alumno,Nombres,Fecha_de_nacimiento) VALUES" + "(null,'" +alumno.getNombres()+"',"+"'"+alumno.getFecha_de_nacimiento()+"')";
					                                                                              
		try {
			stmt.executeUpdate(sql);
			System.out.println("alta exitosa");
		} catch (SQLException e) {
			System.out.println("error al guardar el producto");
		}
	}

	@Override
	public void update(Alumno alumno) {
		sql= "UPDATE alumno SET Nombres='"+alumno.getNombres()+"',Fecha_de_nacimiento = '"+ alumno.getFecha_de_nacimiento()+"' WHERE alumno.id_alumno ="+alumno.getid_alumno();
		try {
			stmt.executeUpdate(sql);
			System.out.println("modificacion exitosa");
		} catch (SQLException e) {
			System.out.println("error al actualizar el producto");
		}
	}

	@Override
	public void delete(int id_alumno) {
		sql = "delete from alumno where id_alumno= " + id_alumno;
		try {
			stmt.executeUpdate(sql);
			System.out.println("eliminado exitosamente");
		} catch (SQLException e) {
			System.out.println("error al eliminar el producto");
		}
	}

}