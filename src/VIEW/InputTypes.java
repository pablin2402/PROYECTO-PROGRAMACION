package VIEW;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InputTypes {
	/*****
	 * Date mysql
	 * 
	 * @param uDate
	 * @return
	 */
	public static java.sql.Date cASqlDate(java.util.Date uDate) {
		return new java.sql.Date(uDate.getTime());

	}

	public static int readInt(String msg, Scanner leer) {

		int valor;
		while (true) {
			try {
				System.out.print(msg);
				System.out.print(" ");
				valor = leer.nextInt();
				leer.nextLine();
				break;
			} catch (java.util.InputMismatchException e) {
				System.out.println("Debe ingresar un valor de tipo entero ");
				leer.nextLine();
			}

		}
		return valor;
	}

	public static String ReadString(String msg, Scanner leer) {
		String valor;
		System.out.print(msg);
		System.out.print(" ");
		valor = leer.nextLine();

		return valor;
	}

	public static double ReadDouble(String msg, Scanner leer) {
		double valor;
		while (true) {
			try {
				System.out.print(msg);
				System.out.print(" ");
				valor = leer.nextDouble();
				leer.nextLine();
				break;
			} catch (java.util.InputMismatchException e) {
				System.out.println("Debe ingresar un valor de tipo double ");
				leer.nextLine();
			}

		}
		return valor;

	}

	public static Date leerFecha(Scanner leer, String msg) {
		Date fecha;
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		while (true) {
			System.out.print(msg);
			try {
				fecha = formato.parse(leer.nextLine());
				return fecha;
			} catch (ParseException e) {
				System.out.println("Error en el formato de fecha");
			}
		}
	}
}
