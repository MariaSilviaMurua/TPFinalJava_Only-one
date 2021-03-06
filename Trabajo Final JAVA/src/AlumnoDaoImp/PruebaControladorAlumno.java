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
						sc.nextLine();
						System.out.print("ingrese el id: ejemplo 1,2,3,....");
						int id_alumno= sc.nextInt();
						Alumno alu = alumnoServicios.findXId(id_alumno);
						if(alu != null) {
							
								System.out.println("elija otro id");
						}else {
							//pedir al usuario1
						
							sc.nextLine();
							System.out.print("ingrese nombre:");
							String Nombres = sc.nextLine();
							System.out.print("ingrese fecha de nacimiento:");
							String Fecha_de_nacimineto = sc.nextLine();
							//crear el objeto con los datos
							Alumno Anuevo = new Alumno( id_alumno, Nombres, Fecha_de_nacimineto);
							alumnoServicios.save(Anuevo);
						}
						
						break;
					case 4:
						sc.nextLine();
						System.out.print("ingrese el id: ejemplo 1,2,3,....");
						int id_alumno1= sc.nextInt();
						Alumno aAlumno = alumnoServicios.findXId(id_alumno1);
						if(aAlumno != null) {
							// pedir lo datos para actualizar
							//EL ID NO SE MODIFICA
							aAlumno.setid_alumno(id_alumno1);
							sc.nextLine();
							System.out.print("ingrese nombre:");
							String Nombres = sc.nextLine();
							aAlumno.setNombres(Nombres);
							System.out.print("ingrese fecha de nacimiento:");
							String Fecha_de_nacimineto = sc.nextLine();
							aAlumno.setFecha_de_nacimiento(Fecha_de_nacimineto);
							alumnoServicios.update(aAlumno);
							}else {
								System.out.println("no se encontro ese id del alumno");
							}
						
						break;
					case 5:
						System.out.print("ingrese el id: ejemplo 1,2,3,....");
						int id_alumno2= sc.nextInt();
						Alumno aAEliminar = alumnoServicios.findXId(id_alumno2);
						if(aAEliminar != null) {
							alumnoServicios.delete(aAEliminar.getid_alumno());
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
		System.out.println("***** 1- alumno ");
		System.out.print("***** Ingrese una opcion del menu principal:");
		opcion = sc.nextInt();
	}
	
	
	public static void menuAlumno() {
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


