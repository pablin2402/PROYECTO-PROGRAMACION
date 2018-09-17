package VIEW;

import java.sql.SQLException;
import java.util.Scanner;

public class Pantalla {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			VIEW.Menuconsola.menú(scanner);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		scanner.close();
	}
}