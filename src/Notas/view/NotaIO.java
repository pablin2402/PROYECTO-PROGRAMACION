package Notas.view;

import java.util.Scanner;

import Notas.entity.Nota;
import VIEW.InputTypes;

public class NotaIO {

	public static Nota ingresar(Scanner scanner) {
		int cod_Nota = InputTypes.readInt("Ingrese el código de registo de Notas", scanner);
		int cod_Docente = InputTypes.readInt("Ingrese el código del docente: ", scanner);
		int cod_Estudiante = InputTypes.readInt("Ingrese el código del estudiante ", scanner);
		int cod_Materia = InputTypes.readInt("Ingrese el código de la materia: ", scanner);
		int nota = InputTypes.readInt("Ingrese la nota final: ", scanner);

		return new Nota(cod_Nota, cod_Docente, cod_Estudiante, cod_Materia, nota);

	}
}
