package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion_BD {
	
	public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	// org.postgresql.Driver
	public static final String DB_URL = "jdbc:mysql://localhost:3306/only_one";
	// jdbc:postgresql://192.168.0.26:5432/customerdb
	public static String USER = "root";
	public static String PASS = "";
	
	

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;	
		
		try {
			// 2 registrar el diver
			Class.forName(JDBC_DRIVER);

			// 3 abrir conexion
			System.out.println("conectando");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// 4 ejecutar consulta sql
			System.out.println("***creando statement...*****");
			stmt = conn.createStatement();
			String sql;
			// 5 probar las consultas
			sql = findAll();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("ID");
				String nombre = rs.getString("nombre");
				int carrera = rs.getInt("ID_carrera");
				System.out.print("id:" + id);
				System.out.print(", nombre:" + nombre);
				System.out.println(" , id carrera:" + carrera);
				System.out.println();
			}
			
			
			
			rs.close();
			
			sql = "INSERT INTO `materia`(`ID`, `Nombre`, `ID_Carrera`) VALUES (null,'Literatura Clasica II','3')";
			stmt.executeUpdate(sql);
			
			
			
			sql = "delete from materia where ID= " + 2;
			stmt.executeUpdate(sql);
		
			
			sql = update(3,"filosofia ii");
			stmt.executeUpdate(sql);
			
			
			
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("algun error al conectar");
		}
		System.out.println("****termino****");

	}


	
	
	
	private static String insert(int i, String string, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String findAll() {
		/*
		sql = findAll();
		ResultSet rs = stmt.executeQuery(sql);
		// 5 extraer datos
		while (rs.next()) {
			int id = rs.getInt("id_prod");
			String nombre = rs.getString("nombre");
			double precio = rs.getDouble("precio");
			int cate = rs.getInt("c_categoria");
			System.out.print("id:" + id);
			System.out.print(", nombre:" + nombre);
			System.out.print(", precio:" + precio);
			System.out.println(" , id cate:" + cate);
			System.out.println();
		}

		rs.close();
		*/
		return "SELECT * from materia";
	}
	
	

	public static String insert1(int ID, String nombre, int ID_carrera) {
		// sql = insert(50,"Literatura Clasica",3);//insertar
		// stmt.executeUpdate(sql);
		return "INSERT INTO materia (ID, nombre, ID_carrera) VALUES (" + ID + ",'" + nombre + "'," + "," + ID_carrera + ");";
	}
	

	public static String get(int id) {
		/*
		sql = get(1);
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			int id = rs.getInt("id_prod");
			String nombre = rs.getString("nombre");
			double precio = rs.getDouble("precio");
			int cate = rs.getInt("c_categoria");
			System.out.print("id:"+id);
			System.out.print(", nombre:"+nombre);
			System.out.print(", precio:"+precio);
			System.out.println(" , id cate:"+cate);
			System.out.println();
		}
		rs.close();
		*/
		
		return "SELECT * from productos where id_prod= " + id;
	}

	public static String update(int id, String nombre) {
		/*
		sql = update(4,"nombre materia",);
		stmt.executeUpdate(sql);
		*/
		return "UPDATE `materia` SET `Nombre`='"+nombre+"' WHERE id = "+id+";";
	}
	
	
	public static String delete(int id) {
		/*
		sql = delete(101);
		stmt.executeUpdate(sql);
		*/
		return "delete from materias where ID= " + id;
	}
	
	
	
	
}
