package Docente.view;

import java.util.Date;
import java.util.Scanner;

import VIEW.InputTypes;

public class DocenteIO {
	public static Docente ingresar(Scanner scanner) {
		int cod_Docente = InputTypes.readInt("Ingrese el código de la categoría", scanner);
		int cod_Empleado = InputTypes.readInt("Ingrese el nombre de la carrera: ", scanner);
		Date fecha_entrada = InputTypes.leerFecha(scanner, "Ingrese su fecha de entrada porfavor ");
		String nombre = InputTypes.ReadString("Ingrese su dirección porfavor: ", scanner);
		Date fecha_nacimiento = InputTypes.leerFecha(scanner, "Ingrese su fecha de nacimiento porfavor ");
		String carrera = InputTypes.ReadString("Ingrese su carrera porfavor: ", scanner);
		int CI = InputTypes.readInt("Ingrese CI ", scanner);

		return new Docente(cod_Docente, cod_Empleado, fecha_entrada, nombre, fecha_nacimiento, carrera, CI);

	}
}