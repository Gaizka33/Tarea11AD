package ej1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrearAlumno {
	private String nombre, apellidos, ciclo, curso, grupo;
	private int nia;
	private char genero;
	private LocalDate fechadenacimiento;
	private final Scanner abielto = new Scanner(System.in);
	private final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private List<Alumno> listaAlumnos = new ArrayList<Alumno>();

	public void crear1Alumno() {
		System.out.println("Dame la fecha de nacimiento del alumno (dd-MM-yyyy): ");
		String fechaNacimientoString = abielto.next();
		LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoString, formato);

		abielto.nextLine();

		System.out.println("Dame los datos del alumno (Nombre, Apellidos, Ciclo, Curso, Grupo, NIA y Genero): ");
		String nombre = abielto.nextLine();
		String apellidos = abielto.nextLine();
		String ciclo = abielto.nextLine();
		String curso = abielto.nextLine();
		String grupo = abielto.nextLine();
		int nia = abielto.nextInt();
		char genero = abielto.next().charAt(0);

		Alumno alumno = new Alumno(nombre, apellidos, ciclo, curso, grupo, nia, genero, fechaNacimiento);
		listaAlumnos.add(alumno);
	}

	public void crearVariosAlumnos(int numeroDeAlumnos) {
		for (int i = 0; i < numeroDeAlumnos; i++) {
			crear1Alumno();
		}

	}
	
	public void leerAlumnos() {
		for (Alumno alumno : listaAlumnos) {
			System.out.println(alumno.toString());
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public int getNia() {
		return nia;
	}

	public void setNia(int nia) {
		this.nia = nia;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public LocalDate getFechadenacimiento() {
		return fechadenacimiento;
	}

	public void setFechadenacimiento(LocalDate fechadenacimiento) {
		this.fechadenacimiento = fechadenacimiento;
	}

	public List<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}

	public void setListaAlumnos(List<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}

	public Scanner getAbielto() {
		return abielto;
	}

	public DateTimeFormatter getFormato() {
		return formato;
	}

	
}
