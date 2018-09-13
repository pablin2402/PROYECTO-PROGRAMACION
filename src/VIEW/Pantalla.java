package VIEW;

import java.sql.SQLException;
import java.util.Scanner;

import Aula.entity.NoExisteAula;
import Estudiante.entity.NoExisteEstudiante;

public class Pantalla {

	public static void main(String[] args) throws NoExisteEstudiante, NoExisteAula {
		Scanner scanner = new Scanner(System.in);

		try {
			VIEW.Menuconsola.menú(scanner);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		scanner.close();
	}
}