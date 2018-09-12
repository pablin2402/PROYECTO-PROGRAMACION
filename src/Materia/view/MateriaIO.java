package Materia.view;

import java.util.Date;
import java.util.Scanner;

import Materia.entity.Materia;
import VIEW.InputTypes;

public class MateriaIO {

	public static Materia ingresar(Scanner scanner) {
		int cod_Materia = InputTypes.readInt("Ingrese el código de la materia", scanner);
		String nombre = InputTypes.ReadString("Ingrese el nombre de la materia ", scanner);
		Date fecha_inicio = InputTypes.leerFecha(scanner, "Ingrese la fecha de inicio porfavor ");
		Date fecha_fin = InputTypes.leerFecha(scanner, "Ingrese su fecha de fin porfavor ");
		String horarios = InputTypes.ReadString("Ingrese el horario porfavor: ", scanner);
		int creditos = InputTypes.readInt("Ingrese los Créditos porfavor ", scanner);
		int total_a_pagar = InputTypes.readInt("Ingrese la cantidad a pagar, porfavor ", scanner);

		return new Materia(cod_Materia, nombre, fecha_inicio, fecha_fin, horarios, creditos, total_a_pagar);

	}
}
