package Carrera.view;

import java.util.Scanner;

import Carrera.entity.Carrera;
import VIEW.InputTypes;

public class CarreraIO {

	public static Carrera ingresar(Scanner scanner) {
		int cod_Materia = InputTypes.readInt("Ingrese el código de la carrera", scanner);
		String nombre = InputTypes.ReadString("Ingrese el nombre de la carrera ", scanner);

		return new Carrera(cod_Materia, nombre);

	}
}