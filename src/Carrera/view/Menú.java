package Carrera.view;

import java.sql.SQLException;
import java.util.Scanner;

import Carrera.entity.NoExisteCarrera;
import Estudiante.entity.NoExisteEstudiante;
import VIEW.InputTypes;

public class Menú {

	private static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar nueva carrera");
			System.out.println("2. Consultar carreras ");
			System.out.println("3. Buscar carrera");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 3) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del menú
	 * 
	 * @throws SQLException
	 * @throws NoExisteEstudiante
	 * @throws ClassNotFoundException *
	 ****************************/

	public static void menú(Scanner scanner, CarrerasIO carrerasView) {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {

			case 0:
				salir = true;
				break;
			case 1:
				carrerasView.add();
				break;
			case 2:
				try {
					carrerasView.list();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					carrerasView.buscar_carrera();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoExisteCarrera e) {
					System.out.println();
					System.out.println("No existe la Carrera");
					System.out.println();

				}
			}
		}
	}

	/****************************
	 * Encabezado del menú *
	 ****************************/

}
