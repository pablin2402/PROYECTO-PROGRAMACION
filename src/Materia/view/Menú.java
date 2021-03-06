package Materia.view;

import java.sql.SQLException;
import java.util.Scanner;

import Estudiante.entity.NoExisteEstudiante;
import Materia.entity.Materia;
import Materia.entity.NoExisteMateria;
import VIEW.InputTypes;

public class Men� {

	private static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("");
			System.out.println("---------- MATERIA ----------");
			System.out.println("Ingrese una opcion: ");
			System.out.println("----------------------------- ");
			System.out.println("1. Consultar Materia");
			System.out.println("2. Modificar Materia ");
			System.out.println("3. Eliminar Materia ");
			System.out.println("4. A�adir Materia ");
			System.out.println("5. Buscar Materia");

			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 5) {
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
	 * @throws NoExisteMateria *
	 ****************************/

	public static void men�(Scanner scanner, MateriasIO materiasView) {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {

			case 0:
				salir = true;
				break;
			case 1:
				try {
					materiasView.list();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 2:
				try {
					try {
						materiasView.upload();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (NoExisteMateria e) {
					System.out.println();
					System.out.println("No existe la materia");
					System.out.println();
				}
				break;
			case 3:
				materiasView.delete();
				break;
			case 4:
				materiasView.add();
				break;
			case 5:
				try {
					materiasView.buscar_materia();
				} catch (NoExisteMateria e) {
					System.out.println();
					System.out.println("�No existe la materia!");
					System.out.println();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/****************************
	 * Encabezado del men� *
	 ****************************/

	private static int encabezadoModificar(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("");
			System.out.println("---------- MODIFICAR DATOS DE UNA MATERIA ----------");
			System.out.println("----------------------------------------------------");
			System.out.println("Ingrese una opcion: ");
			System.out.println("---------------------------------------------------- ");
			System.out.println("1. Modificar nombre");
			System.out.println("2. Modificar horario");
			System.out.println("3. Modificar la cantidad de cr�ditos");
			System.out.println("4. Ingresa el c�digo de la materia a modificar");
			System.out.println("0. Salir");
			System.out.println("");

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del modificar *
	 ****************************/

	public static void men�Modificar(Scanner scanner, Materia materia) {

		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				materia.setNombre(InputTypes.ReadString("Ingrese el nuevo nombre: ", scanner));
				break;
			case 2:
				materia.setHorarios(InputTypes.ReadString("Ingrese el nuevo horario", scanner));
				break;
			case 3:
				materia.setCreditos(InputTypes.readInt("Ingrese la nueva cantidad de cr�ditos", scanner));
				break;
			case 4:
				materia.setCod_Materia(InputTypes.readInt("Ingrese el c�digo de la materia", scanner));
				break;
			}
		}
	}
}
