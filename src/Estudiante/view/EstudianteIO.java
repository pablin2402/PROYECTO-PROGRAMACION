package Estudiante.view;

import java.util.Scanner;

import Estudiante.entity.Estudiante;
import VIEW.InputTypes;

public class EstudianteIO {
	/***************
	 * Ingresar nuevo estudiante
	 * 
	 * @param scanner
	 * @return
	 */
	public static Estudiante ingresar(Scanner scanner) {
		System.out.println("NOTA:");
		System.out.println("En caso de que se repita el c�digo del estudiante, el sistema no ingresar� ning�n alumno");
		System.out.println("");
		int cod_Estudiante = InputTypes.readInt("Ingrese el c�digo del estudiante: ", scanner);
		int cod_carrera = InputTypes.readInt("Ingrese el c�digo de la carrera: ", scanner);
		String nombre = InputTypes.ReadString("Ingrese su nombre completo porfavor ", scanner);
		String direcci�n = InputTypes.ReadString("Ingrese su direcci�n porfavor: ", scanner);
		String correoelectr�nico = InputTypes.ReadString("Ingrese su correo electr�nico porfavor ", scanner);

		return new Estudiante(cod_Estudiante, cod_carrera, nombre, direcci�n, correoelectr�nico);

	}
}
