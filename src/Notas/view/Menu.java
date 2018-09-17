package Notas.view;

import java.sql.SQLException;
import java.util.Scanner;

import Estudiante.entity.NoExisteEstudiante;
import Materia.entity.NoExisteMateria;
import Notas.entity.NoExisteNota;
import Notas.entity.Nota;
import VIEW.InputTypes;

public class Menu {

	private static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Consultar Notas");
			System.out.println("2. Añadir Nota ");
			System.out.println("3. Modificar Nota ");
			System.out.println("4. Eliminar Nota ");

			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del menú
	 * 
	 * @throws SQLException
	 * @throws NoExisteEstudiante
	 * @throws ClassNotFoundException
	 * @throws NoExisteNota
	 * @throws NoExisteMateria *
	 ****************************/

	public static void menú(Scanner scanner, NotasIO notas) {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {

			case 0:
				salir = true;
				break;
			case 1:
				try {
					notas.list();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				notas.add();
				break;
			case 3:
				try {
					notas.upload();
				} catch (NoExisteNota e) {
					System.out.println();
					System.out.println("No existe el código único de nota");
					System.out.println();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				break;

			}
		}
	}

	/****************************
	 * Encabezado del menú *
	 ****************************/

	private static int encabezadoModificar(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("--------------------");
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Modificar Nota");
			System.out.println("2. Ingresa el código de la nota a modificar");
			System.out.println("0. Salir");
			System.out.println("");

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 2) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del modificar *
	 ****************************/

	public static void menúModificar(Scanner scanner, Nota materia) {

		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				materia.setNota(InputTypes.readInt("Ingrese la nueva nota: ", scanner));
				break;
			case 2:
				materia.setCod_Nota(InputTypes.readInt("Ingrese el código de la nota a modificar", scanner));
				break;

			}
		}
	}
}
