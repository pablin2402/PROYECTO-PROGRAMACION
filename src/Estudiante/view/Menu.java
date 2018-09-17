package Estudiante.view;

import java.sql.SQLException;
import java.util.Scanner;

import Carrera.entity.NoExisteCarrera;
import Estudiante.entity.Estudiante;
import Estudiante.entity.NoExisteEstudiante;
import Notas.entity.NoExisteNota;
import VIEW.InputTypes;

public class Menu {
	private static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Consultar Alumno");
			System.out.println("2. A�adir Alumno nuevo ");
			System.out.println("3. Eliminar Alumno ");
			System.out.println("4. Modificar datos del Alumno ");
			System.out.println("5. Buscar alumno");
			System.out.println("6. Consultar Nota");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 6) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del men�
	 * 
	 * @throws SQLException
	 * @throws NoExisteEstudiante
	 * @throws ClassNotFoundException
	 * @throws                        *
	 ****************************/

	public static void men�(Scanner scanner, EstudiantesIO estudiantesView) {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {

			case 0:
				salir = true;
				break;
			case 1:
				try {
					estudiantesView.list();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				break;
			case 2:
				estudiantesView.add();
				break;
			case 3:
				break;
			case 4:
				try {
					try {
						estudiantesView.upload();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (NoExisteEstudiante e) {
					System.out.println();
					System.out.println("�No existe el estudiante!");
					System.out.println();
				}
				break;
			case 5:
				try {
					estudiantesView.listaalumnosporcarrera();
				} catch (NoExisteEstudiante e) {
					System.out.println("�No existe el estudiante!");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoExisteCarrera e) {
					System.out.println("No existe la carrera");
				}
			case 6:
				try {
					estudiantesView.consultarnotas();
				} catch (NoExisteNota e) {
					System.out.println();
					System.out.println(
							"�El estudiante no est� inscrito en ninguna materia y por lo tanto no existe registro de notas!");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoExisteEstudiante e) {
					System.out.println();
					System.out.println("�No existe el estudiante!");
					System.out.println();
				}
			}
		}
	}

	private static int encabezadoModificar(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("--------------------");
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Modificar C�digo de carrera");
			System.out.println("2. Modificar direcci�n");
			System.out.println("3. Modificar el correo electr�nico");
			System.out.println("4. Ingrese el c�digo del estudiante al que modificar� sus datos");
			System.out.println("0. Salir");
			System.out.println("");

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}

	public static void men�Modificar(Scanner scanner, Estudiante estudiante) {

		boolean salir = false;
		/****
		 * NOTA: FALT A EXCEPCION PARA CODIGO DE CARRERA
		 * 
		 */
		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:

				estudiante.setCod_Carrera(InputTypes.readInt("Ingrese el nuevo c�digo de carrera: ", scanner));
				break;
			case 2:
				estudiante.setDirecci�n(InputTypes.ReadString("Ingrese la nueva direcci�n del estudiante", scanner));
				break;
			case 3:
				estudiante.setCorreoelectr�nico(InputTypes.ReadString("Ingrese el correo electr�nico", scanner));
				break;
			case 4:
				estudiante.setCod_Estudiante(InputTypes.readInt("Ingrese su c�digo de estudiante", scanner));
			}
		}
	}
}
