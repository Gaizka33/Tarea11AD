package ej1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.sql.Date;

public class ManejoBaseDeDatos {
	private final String url = "jdbc:mysql://localhost:3306/alumnos";
	private final String usuario = "root";
	private final String contra = "";
	private final Scanner abielto = new Scanner(System.in);

	public Connection establecerConexion() {
		try {
			return DriverManager.getConnection(url, usuario, contra);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public void guardarAlumno(List<Alumno> listaAlumnos) {
		for (Alumno alumno : listaAlumnos) {

			String query = "INSERT INTO alumno(NIA, NOMBRE, APELLIDOS, GENERO, FEHCADENACIMIENTO, CICLO, CURSO, GRUPO)"
					+ "VALUES(?,?,?,?,?,?,?,?)";

			try (PreparedStatement parteDeLaQuery = establecerConexion().prepareStatement(query)) {
				parteDeLaQuery.setInt(1, alumno.getNia());
				parteDeLaQuery.setString(2, alumno.getNombre());
				parteDeLaQuery.setString(3, alumno.getApellidos());
				parteDeLaQuery.setString(4, String.valueOf(alumno.getGenero()));
				parteDeLaQuery.setDate(5, Date.valueOf(alumno.getFechadenacimiento()));
				parteDeLaQuery.setString(6, alumno.getCiclo());
				parteDeLaQuery.setString(7, alumno.getCurso());
				parteDeLaQuery.setString(8, alumno.getGrupo());
				parteDeLaQuery.executeUpdate();

				System.out.println("Alumno lo maximo de guardado");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void modificarNombreAlumno(int niaAlumno) {
		String query = "UPDATE alumno SET NOMBRE = ? WHERE NIA = ? ";

		try (PreparedStatement parteDeLaQuery = establecerConexion().prepareStatement(query)) {
			parteDeLaQuery.setString(1, abielto.nextLine());
			System.out.println("que nombre quieres ponerle?");
			parteDeLaQuery.setInt(2, niaAlumno);
			int filasActualizadas = parteDeLaQuery.executeUpdate();

			if (filasActualizadas > 0) {
				System.out.println("El nombre del alumno con NIA " + niaAlumno + " fue actualizado correctamente.");
			} else {
				System.out.println("No se encontró un alumno con NIA " + niaAlumno + ".");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void eliminarAlumnoPorNia(int niaAulmno) {
		String query = "DELETE FROM alumno WHERE NIA = ?";

		try (PreparedStatement parteDeLaQuery = establecerConexion().prepareStatement(query)) {
			parteDeLaQuery.setInt(1, niaAulmno);

			int resultado = parteDeLaQuery.executeUpdate();

			if (resultado > 0) {
				System.out.println("Alumno con nia: " + niaAulmno + " con exito");
			} else {
				System.out.println("no se pudo encontrar al alumno con nia: " + niaAulmno);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void eliminarAlumnoPorApellido(String apellidoAlumno) {
		String query = "DELETE FROM alumno WHERE APELLIDOS = ?";

		try (PreparedStatement parteDeLaqQuery = establecerConexion().prepareStatement(query)) {
			parteDeLaqQuery.setString(1, apellidoAlumno);

			int resultado = parteDeLaqQuery.executeUpdate();

			if (resultado > 0) {
				System.out.println("Alumno con apellidos: " + apellidoAlumno + " con exito");
			} else {
				System.out.println("no se pudo encontrar al alumno con apellidos: " + apellidoAlumno);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
