package VIEW;

import java.sql.SQLException;
import java.util.Scanner;

import Aula.entity.NoExisteAula;
import Clase.entity.NoExisteClase;
import Estudiante.entity.NoExisteEstudiante;
import Materia.entity.NoExisteMateria;

public class Pantalla {

	public static void main(String[] args)
			throws NoExisteEstudiante, NoExisteAula, ClassNotFoundException, NoExisteMateria, NoExisteClase {
		Scanner scanner = new Scanner(System.in);

		try {
			VIEW.Menuconsola.men�(scanner);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		scanner.close();
	}
}