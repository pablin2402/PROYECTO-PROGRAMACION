package Materia.view;

import java.util.Date;
import java.util.Scanner;

import Materia.entity.Materia;
import VIEW.InputTypes;

public class MateriaIO {

	public static Materia ingresar(Scanner scanner) {
		int cod_Materia = InputTypes.readInt("Ingrese el código del docente", scanner);
		String nombre = InputTypes.ReadString("Ingrese su fecha de entrada porfavor ", scanner);
		Date fecha_inicio = InputTypes.leerFecha(scanner, "Ingrese su nombre completo porfavor: ");
		Date fecha_fin = InputTypes.leerFecha(scanner, "Ingrese su fecha de nacimiento porfavor ");
		String horarios = InputTypes.ReadString("Ingrese su carrera porfavor: ", scanner);
		int creditos = InputTypes.readInt("Ingrese su Cedula de Identidad, porfavor ", scanner);
		int total_a_pagar = InputTypes.readInt("Ingrese su Cedula de Identidad, porfavor ", scanner);

		return new Materia(cod_Materia, nombre, fecha_inicio, fecha_fin, horarios, creditos, total_a_pagar);

	}
}
