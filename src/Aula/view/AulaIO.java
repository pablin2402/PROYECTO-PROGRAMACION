package Aula.view;

import java.util.Scanner;

import Aula.entity.Aula;
import VIEW.InputTypes;

public class AulaIO {

	public static Aula ingresar(Scanner scanner) {

		int cod_Aula = InputTypes.readInt("Ingrese el código del aula: ", scanner);
		int cod_Edificio = InputTypes.readInt("Ingrese el código del edificio: ", scanner);
		String Nombre = InputTypes.ReadString("Ingrese el nombre del aula porfavor: ", scanner);
		int Piso = InputTypes.readInt("Ingrese el piso donde se encuentra el aula:", scanner);
		return new Aula(cod_Aula, cod_Edificio, Nombre, Piso);
	}
}
