package Clase.view;

import java.util.Scanner;

import Clase.entity.Clase;
import VIEW.InputTypes;

public class ClaseIO {
	public static Clase ingresar(Scanner scanner) {
		int cod_Materia = InputTypes.readInt("Ingrese el código de la materia", scanner);
		int cod_Docente = InputTypes.readInt("Ingrese el código del docente: ", scanner);
		int cod_Estudiante = InputTypes.readInt("Ingrese el código del estudiante ", scanner);
		int cod_Aula = InputTypes.readInt("Ingrese el código del aula: ", scanner);
		int cod_Inscripción = InputTypes.readInt("Ingrese el código de inscripción: ", scanner);

		return new Clase(cod_Materia, cod_Docente, cod_Estudiante, cod_Aula, cod_Inscripción);

	}
}
