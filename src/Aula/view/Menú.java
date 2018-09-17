package Aula.view;

import java.sql.SQLException;
import java.util.Scanner;

import Aula.entity.Aula;
import Aula.entity.NoExisteAula;
import Estudiante.entity.NoExisteEstudiante;
import VIEW.InputTypes;

public class Menú {

	private static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("****************AULA***************");
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Consultar aula");
			System.out.println("2. Ingresar aula ");
			System.out.println("3. Eliminar aula ");
			System.out.println("4. Modificar aula ");
			System.out.println("5. Buscar Aula");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 5) {
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

	public static void menú(Scanner scanner, AulasIO aulasView) {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {

			case 0:
				salir = true;
				break;
			case 1:
				try {
					aulasView.list();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 2:
				aulasView.add();
				break;
			case 3:
				break;
			case 4:
				try {
					aulasView.upload();
				} catch (NoExisteAula e) {
					System.out.println();
					System.out.println("!No existe el aula!");
					System.out.println();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5:
				try {
					aulasView.buscar_aula();
				} catch (NoExisteAula e) {
					System.out.println();
					System.out.println("¡No existe el aula!");
					System.out.println();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/****************************
	 * Encabezado del menú *
	 ****************************/

	private static int encabezadoModificar(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("--------------------------------------");
			System.out.println("MODIFICAR AULA");
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Modificar código del edificio");
			System.out.println("2. Modificar nombre del aula ");
			System.out.println("3. Modificar el nuevo piso");
			System.out.println("4. Ingrese el código del aula");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del modificar *
	 ****************************/

	public static void menúModificar(Scanner scanner, Aula aula) {

		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				aula.setCod_edificio(InputTypes.readInt("Ingrese el código del nuevo edificio: ", scanner));

				break;
			case 2:
				aula.setNombre(InputTypes.ReadString("Ingrese el nuevo nombre: ", scanner));

				break;
			case 3:
				aula.setPiso(InputTypes.readInt("Ingrese el nuevo piso: ", scanner));
				break;
			case 4:
				aula.setCod_Aula(InputTypes.readInt("Ingrese el código del aula: ", scanner));

			}
		}
	}
}
