package VIEW;

import java.util.Scanner;

public class InputTypes {

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
				System.out.println("Debe ingresar un codigo ");
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
				System.out.println("Debe ingresar un codigo ");
				leer.nextLine();
			}

		}
		return valor;

	}

}