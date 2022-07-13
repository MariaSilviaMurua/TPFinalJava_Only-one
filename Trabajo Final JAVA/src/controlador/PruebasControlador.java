package controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import AlumnoDaoImp.AlumnoDaoImp;
import AlumnoDaoImp.IAlumnoDao;
import CarreraDaoImp.ICarreraDao;
import CarreraDaoImp.CarreraDaoImp;
import Conexion.Conexion;
import MateriaDaoImp.IMateriaDao;
import MateriaDaoImp.MateriaDaoImp;
import models.Alumno;
import models.Materia;
import models.Carrera;
public class PruebasControlador {
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
				ICarreraDao carreraServicios= new CarreraDaoImp(stmt);
				IMateriaDao materiaServicios= new MateriaDaoImp(stmt);
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
			System.out.println("***** 1- Alumnos ");
			System.out.println("***** 2- Administracion ");
			System.out.print("***** Ingrese una opcion del menu principal:");
			opcion = sc.nextInt();
		}
		
		public static void menuAdministración() {
			
			System.out.println("************ Administración**********");
			System.out.println("***** 1- Alumnos ");
			System.out.println("***** 2- Carreras ");
			System.out.println("***** 3- Materias ");
			System.out.print("***** Ingrese una opcion:");
			opcion = sc.nextInt();

		}
		public static void menuAlumno() {
			System.out.println("************ alumno**********");
			System.out.println("***** 1- inscribir carrera ");
			System.out.println("***** 2- inscribir materia ");
			System.out.println("***** 3- dar de baja carrera ");
			System.out.print("***** Ingrese una opcion:");
			opcion = sc.nextInt();
			
			
		}

}
