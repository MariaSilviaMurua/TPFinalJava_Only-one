package AlumnoDaoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import Conexion.Conexion;
import models.Alumno;

public class PruebaControladorAlumno {
	public static int opcion;
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// 2 registrar el diver
			Class.forName(Conexion.JDBC_DRIVER);
			
			// 3 abrir conexion
			System.out.println("conecando");
			conn = DriverManager.getConnection(Conexion.DB_URL, Conexion.USER, Conexion.PASS);

			// 4 ejecutar consulta sql
			System.out.println("***creando statement...*****");
			stmt = conn.createStatement();
			
			// 5 probar las consultas
			System.out.println("********definimos nuestros servicios****");
			IAlumnoDao alumnoServicios = new AlumnoDaoImp(stmt);
			System.out.println("******************************************");
			//repetimos el menu repetidamente
			String respuesta;
			do {
				menuPrincipal();
				switch (opcion) {
				case 1:
					menuAlumno();
					switch (opcion) {
					case 1:
						alumnoServicios.mostrar();
						break;
					case 2:
						System.out.print("Ingrese el id abuscar:");
						int id = sc.nextInt();
						Alumno a = alumnoServicios.findXId(id);
						if(a != null) {
							System.out.println(a.toString());
						}else {
							System.out.println("no se encontro ese id");
						}
						break;
					case 3:
						//datos de aluimno
						System.out.println("ingrese nombres");
						sc.nextLine();
						String nombre_al = sc.nextLine();
						System.out.println("fecha nacimiento: EJ: 1998-10-10");
						String fecha_al = sc.nextLine();
						//crear un alumno
						//insertamos
						Alumno alu = new Alumno(4,nombre_al,fecha_al);
						alumnoServicios.save(alu);
						break;
					case 4:
						
						
						break;
					case 5:
						
						break;

					default:
						break;
					}
					break;

				default:
					break;
				}
				
				
				sc.nextLine();
				System.out.println("Desea continuar si o no:");
				respuesta = sc.nextLine();
			} while (respuesta.toUpperCase().equals("SI"));
			
			
			
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("algun error al conectar");
		}
		System.out.println("****termino****");

	}
	
	public static void menuPrincipal() {
		System.out.println("*****menu principal *********** ");
		System.out.println("***** 1- alumno ");
		System.out.println("***** 2- administracion ");
		System.out.print("***** Ingrese una opcion del menu principal:");
		opcion = sc.nextInt();
	}
	
	public static void menuCategorias() {
		
		System.out.println("************ categorias**********");
		System.out.println("***** 1- mostrar todos ");
		System.out.println("***** 2- obtener x id ");
		System.out.println("***** 3- alta ");
		System.out.println("***** 4- modificar ");
		System.out.println("***** 5- eliminar ");
		System.out.print("***** Ingrese una opcion:");
		opcion = sc.nextInt();

	}
	public static void menuAlumno() {
		System.out.println("************ productos**********");
		System.out.println("***** 1- mostrar todos ");
		System.out.println("***** 2- obtener x id ");
		System.out.println("***** 3- alta ");
		System.out.println("***** 4- modificar ");
		System.out.println("***** 5- eliminar ");
		System.out.print("***** Ingrese una opcion:");
		opcion = sc.nextInt();
		
		
	}

}


