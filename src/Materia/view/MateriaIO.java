package Materia.view;

import java.util.Scanner;

import Materia.entity.Materia;
import VIEW.InputTypes;

public class MateriaIO {

	public static Materia ingresar(Scanner scanner) {
		int cod_Materia = InputTypes.readInt("Ingrese el c�digo de la materia", scanner);
		String nombre = InputTypes.ReadString("Ingrese el nombre de la materia ", scanner);
		System.out.println("EL FORMATO DE FECHA ES EL SIGUIENTE D�A de MES de A�O");
		String fecha_inicio = InputTypes.ReadString("Ingrese la fecha de inicio porfavor ", scanner);
		String fecha_fin = InputTypes.ReadString("Ingrese su fecha de fin porfavor ", scanner);
		String horarios = InputTypes.ReadString("Ingrese el horario porfavor: ", scanner);
		int creditos = InputTypes.readInt("Ingrese los Cr�ditos porfavor ", scanner);
		int total_a_pagar = InputTypes.readInt("Ingrese la cantidad a pagar, porfavor ", scanner);

		return new Materia(cod_Materia, nombre, fecha_inicio, fecha_fin, horarios, creditos, total_a_pagar);

	}
}
