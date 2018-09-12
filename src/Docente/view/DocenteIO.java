package Docente.view;

import java.util.Date;
import java.util.Scanner;

import Docente.entity.Docente;
import VIEW.InputTypes;

public class DocenteIO {

	public static Docente ingresar(Scanner scanner) {
		int cod_Docente = InputTypes.readInt("Ingrese el código del docente", scanner);

		Date fecha_entrada = InputTypes.leerFecha(scanner, "Ingrese su fecha de entrada porfavor ");
		String nombre = InputTypes.ReadString("Ingrese su nombre completo porfavor: ", scanner);
		Date fecha_nacimiento = InputTypes.leerFecha(scanner, "Ingrese su fecha de nacimiento porfavor ");
		String carrera = InputTypes.ReadString("Ingrese su carrera porfavor: ", scanner);
		int CI = InputTypes.readInt("Ingrese su Cedula de Identidad, porfavor ", scanner);

		return new Docente(cod_Docente, fecha_entrada, nombre, fecha_nacimiento, carrera, CI);

	}
}