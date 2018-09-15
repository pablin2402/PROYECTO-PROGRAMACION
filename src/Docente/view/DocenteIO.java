package Docente.view;

import java.util.Scanner;

import Docente.entity.Docente;
import VIEW.InputTypes;

public class DocenteIO {

	public static Docente ingresar(Scanner scanner) {
		int cod_Docente = InputTypes.readInt("Ingrese el código del docente", scanner);
		System.out.println("");
		System.out.println("EL FORMATO DE FECHA ES dia-mes-año");
		System.out.println("");
		String fecha_entrada = InputTypes.ReadString("Ingrese su fecha de entrada porfavor ", scanner);
		String nombre = InputTypes.ReadString("Ingrese su nombre completo porfavor: ", scanner);
		System.out.println("");
		System.out.println("EL FORMATO DE FECHA ES dia-mes-año");
		System.out.println("");
		String fecha_nacimiento = InputTypes.ReadString("Ingrese su fecha de nacimiento porfavor ", scanner);
		String carrera = InputTypes.ReadString("Ingrese su carrera porfavor: ", scanner);
		int CI = InputTypes.readInt("Ingrese su Cedula de Identidad, porfavor ", scanner);

		return new Docente(cod_Docente, fecha_entrada, nombre, fecha_nacimiento, carrera, CI);

	}
}