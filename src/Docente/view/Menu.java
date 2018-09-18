package Docente.view;

import java.sql.SQLException;
import java.util.Scanner;

import Docente.entity.NoExisteDocente;
import Estudiante.entity.NoExisteEstudiante;
import VIEW.InputTypes;

public class Menu {
	private static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("");
			System.out.println("--------- DOCENTE ----------");
			System.out.println("Ingrese una opcion: ");
			System.out.println("---------------------------- ");
			System.out.println("1. Consultar Docentes");
			System.out.println("2. Añadir Docente ");
			System.out.println("3. Eliminar Docente ");
			System.out.println("4. Buscar Docente");
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
	 * @throws ClassNotFoundException *
	 ****************************/

	public static void menú(Scanner scanner, DocentesIO docentesView) {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {

			case 0:
				salir = true;
				break;
			case 1:
				try {
					docentesView.list();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				docentesView.add();
				break;
			case 3:
				docentesView.delete();
				break;
			case 4:
				try {
					try {
						docentesView.buscar_docente();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (NoExisteDocente e) {
					System.out.println();
					System.out.println("¡No existe el docente!");
					System.out.println();
				}
				break;
			}
		}
	}

	/****************************
	 * Encabezado del menú *
	 ****************************/

}
