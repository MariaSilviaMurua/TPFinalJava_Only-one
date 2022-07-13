package MateriaDaoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import Conexion.Conexion;
import models.Materia;

	public class PruebaControladorMateria {
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
				IMateriaDao materiaServicios = new MateriaDaoImp(stmt);
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
							materiaServicios.mostrar();
							break;
						case 2:
							System.out.print("Ingrese el id abuscar:");
							int id = sc.nextInt();
							Materia m = materiaServicios.findXId(id);
							if(m != null) {
								System.out.println(m.toString());
							}else {
								System.out.println("no se encontro ese id");
							}
							break;
						case 3:
							sc.nextLine();
							System.out.print("ingrese el id: ejemplo 1,2,3,....");
							int id_materia= sc.nextInt();
							Materia mat = materiaServicios.findXId(id_materia);
							if(mat != null) {
								
									System.out.println("elija otro id");
							}else {
								//pedir al usuario1
								sc.nextLine();
								System.out.print("ingrese nombre de la materia:");
								String Nombre_de_la_materia = sc.nextLine();
								System.out.print("ingrese nombre del profesor adjunto:");
								String Profesor_adjunto = sc.nextLine();
								System.out.print("ingrese nombre del Jefe de Trabajos Practicos");
								String Jefe_de_trabajo_practico = sc.nextLine();
								//crear el objeto con los datos
								Materia Mnuevo = new Materia( id_materia, Nombre_de_la_materia, Profesor_adjunto,Jefe_de_trabajo_practico);
								materiaServicios.save(Mnuevo);
							}
							
							break;
						case 4:
							sc.nextLine();
							System.out.print("ingrese el id: ejemplo 1,2,3,....");
							int id_Materia1= sc.nextInt();
							Materia mMateria = materiaServicios.findXId(id_Materia1);
							if(mMateria != null) {
								// pedir lo datos para actualizar
								//EL ID NO SE MODIFICA
								mMateria.setid_materia(id_Materia1);
								sc.nextLine();
								System.out.print("ingrese nombre de la materia:");
								String Nombre_de_la_materia = sc.nextLine();
								mMateria.setNombre_de_la_materia(Nombre_de_la_materia);
								System.out.print("ingrese nombre del profesor adjunto:");
								String Profesor_adjunto = sc.nextLine();
								mMateria.setProfesor_adjunto(Profesor_adjunto);
								System.out.print("ingrese nombre del Jefe de Trabajos Practicos");
								String Jefe_de_trabajo_practico = sc.nextLine();
								mMateria.setJefe_de_trabajo_practico(Jefe_de_trabajo_practico);
								materiaServicios.update(mMateria);
								}else {
									System.out.println("no se encontro ese id de la materia");
								}
							
							break;
						case 5:
							System.out.print("ingrese el id: ejemplo 1,2,3,....");
							int id_Materia2= sc.nextInt();
							Materia mAEliminar = materiaServicios.findXId(id_Materia2);
							if(mAEliminar!= null) {
								materiaServicios.delete(mAEliminar.getid_materia());
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
