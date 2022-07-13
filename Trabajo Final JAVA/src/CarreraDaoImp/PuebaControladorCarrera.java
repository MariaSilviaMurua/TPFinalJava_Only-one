package CarreraDaoImp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import Conexion.Conexion;
import models.Carrera;
public class PuebaControladorCarrera {
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
				ICarreraDao carreraServicios = new CarreraDaoImp(stmt);
				System.out.println("******************************************");
				//repetimos el menu repetidamente
				String respuesta;
				do {
					menuPrincipal();
					switch (opcion) {
					case 1:
						menuCarrera();
						switch (opcion) {
						case 1:
							carreraServicios.mostrar();
							break;
						case 2:
							System.out.print("Ingrese el id abuscar:");
							int id = sc.nextInt();
							Carrera c = carreraServicios.findXId(id);
							if(c != null) {
								System.out.println(c.toString());
							}else {
								System.out.println("no se encontro ese id");
							}
							break;
						case 3:
							sc.nextLine();
							System.out.print("ingrese el id: ejemplo 1,2,3,....");
							int id_carrera= sc.nextInt();
							Carrera car = carreraServicios.findXId(id_carrera);
							if(car != null) {
								
									System.out.println("elija otro id");
							}else {
								//pedir al usuario1
								sc.nextLine();
								System.out.print("ingrese nombre de la carrera:");
								String Nombre = sc.nextLine();
								System.out.print("ingrese el año del plan de estudio");
								int Año_del_plan_de_estudio = sc.nextInt();
								//crear el objeto con los datos
								Carrera Cnuevo = new Carrera( id_carrera, Nombre, Año_del_plan_de_estudio);
								carreraServicios.save(Cnuevo);
							}
							
							break;
						case 4:
							sc.nextLine();
							System.out.print("ingrese el id: ejemplo 1,2,3,....");
							int id_carrera1= sc.nextInt();
							Carrera cCarrera = carreraServicios.findXId(id_carrera1);
							if(cCarrera != null) {
								// pedir lo datos para actualizar
								//EL ID NO SE MODIFICA
								cCarrera.setid_carrera(id_carrera1);
								sc.nextLine();
								System.out.print("ingrese nombre de la carrera:");
								String Nombre= sc.nextLine();
								cCarrera.setNombre(Nombre);
								System.out.print("ingrese año del plan de estudio:");
								int Año_del_plan_de_estudio = sc.nextInt();
								cCarrera.setAño_del_plan_de_estudio(Año_del_plan_de_estudio);
								carreraServicios.update(cCarrera);
								}else {
									System.out.println("no se encontro ese id de la carrera");
								}
							
							break;
						case 5:
							System.out.print("ingrese el id: ejemplo 1,2,3,....");
							int id_carrera2= sc.nextInt();
							Carrera cAEliminar = carreraServicios.findXId(id_carrera2);
							if(cAEliminar!= null) {
								carreraServicios.delete(cAEliminar.getid_carrera());
							}else {
								System.out.println("no se encontro ese id");
							}
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
			System.out.println("***** 1- materia ");
			System.out.print("***** Ingrese una opcion del menu principal:");
			opcion = sc.nextInt();
		}
		public static void menuCarrera() {
			System.out.println("************ alumnos**********");
			System.out.println("***** 1- mostrar todos ");
			System.out.println("***** 2- obtener x id ");
			System.out.println("***** 3- alta ");
			System.out.println("***** 4- modificar ");
			System.out.println("***** 5- eliminar ");
			System.out.print("***** Ingrese una opcion:");
			opcion = sc.nextInt();
			
			
		}

	



}