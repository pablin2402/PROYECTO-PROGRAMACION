package Clase.view;

import java.util.Scanner;

import VIEW.InputTypes;

public class ClaseIO {
	public static Clase ingresar(Scanner scanner) {
		int cod_Materia = InputTypes.readInt("Ingrese el c�digo de la materia", scanner);
		int cod_Docente = InputTypes.readInt("Ingrese el c�digo del docente: ", scanner);
		int cod_Estudiante = InputTypes.readInt("Ingrese el nombre del estudiante ", scanner);
		int cod_Aula = InputTypes.readInt("Ingrese el c�digo del aula: ", scanner);
		int cod_Inscripci�n = InputTypes.readInt("Ingrese el c�digo de inscripci�n: ", scanner);

		return new Clase(cod_Materia, cod_Docente, cod_Estudiante, cod_Aula, cod_Inscripci�n);

	}
}
