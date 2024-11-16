package ej1;

import java.util.Scanner;

public class Menu {
	private CrearAlumno c = new CrearAlumno();
	private ManjeoFihceros m = new ManjeoFihceros();
	private ManejoBaseDeDatos mb = new ManejoBaseDeDatos();
	private final Scanner abielto = new Scanner(System.in);

	public void mostrarMenu() {
		System.out.println("1. Insertar nuevo alumno");
		System.out.println("2. Mostrar alumnos");
		System.out.println("3. Guardar todos los alumnos en fichero");
		System.out.println("4. Leer alumnos de un fichero y guardarlo en la BD");
		System.out.println("5. Modificar nombre alumno");
		System.out.println("6. Eliminar alumno por NIA");
		System.out.println("7. Eliminar alumno por Apellido");
		System.out.println("8. Guardar todos los alumnos en fichero Json");
		System.out.println("9. Leer alumnos del JSON guardarlos en la BD");
	}

	public void elegir(int valor) {
		switch (valor) {
		case 1: {
			c.crear1Alumno();
		}
		case 2:{
			c.leerAlumnos();
		}
		case 3:{
			m.escribirEnFicheroBinario(c.getListaAlumnos());
		}
		case 4:{
			m.leerDeFicheroBinario();
			mb.guardarAlumno(c.getListaAlumnos());
		}
		case 5:{
			System.out.println("Dime el nia por el que quiers cambiar el nombre al alumno");
			mb.modificarNombreAlumno(abielto.nextInt());
		}
		case 6:{
			System.out.println("Dime el nia por el que quiers eliminar al alumno");
			abielto.nextLine();
			mb.eliminarAlumnoPorNia(abielto.nextInt());
		}
		case 7:{
			System.out.println("Dime el apellido por el que quiers eliminar al alumno");
			abielto.nextLine();
			mb.eliminarAlumnoPorApellido(abielto.nextLine());
		}
		case 8:{
			m.escribirEnFicheroJson(c.getListaAlumnos());
		}
		case 9:{
			m.leerDeUnFicheroJson();
			
		}

		}
	}
}
