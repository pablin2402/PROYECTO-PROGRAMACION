package Estudiante.view;

import java.util.Scanner;

import Estudiante.entity.Estudiante;
import VIEW.InputTypes;

public class EstudianteIO {

	public static Estudiante ingresar(Scanner scanner) {

		int cod_Estudiante = InputTypes.readInt("Ingrese el código del estudiante", scanner);
		int cod_carrera = InputTypes.readInt("Ingrese el código de la carrera: ", scanner);
		String nombre = InputTypes.ReadString("Ingrese su nombre completo porfavor ", scanner);
		String dirección = InputTypes.ReadString("Ingrese su dirección porfavor: ", scanner);
		String correoelectrónico = InputTypes.ReadString("Ingrese su correo electrónico porfavor ", scanner);

		return new Estudiante(cod_Estudiante, cod_carrera, nombre, dirección, correoelectrónico);

	}
}
