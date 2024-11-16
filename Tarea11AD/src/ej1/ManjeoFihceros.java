package ej1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ManjeoFihceros {
	private final File f;
	private final File fJson;
	private FileOutputStream conexionEscribir;
	private ObjectOutputStream escribir;
	private FileInputStream conexionLeer;
	private ObjectInputStream leer;
	private final Gson gson;
	private FileWriter escribirJson;
	private List<Alumno> lista;

	public ManjeoFihceros() {
		f = new File("FihceroBinario.dat");
		fJson = new File("FicheroJson.json");
		this.gson = new GsonBuilder().setPrettyPrinting().setDateFormat("dd-MM-yyyy").create();
	}

	public void escribirEnFicheroBinario(List<Alumno> listaAlumnos) {
		try {
			conexionEscribir = new FileOutputStream(f);
			escribir = new ObjectOutputStream(conexionEscribir);

			for (Alumno alumno : listaAlumnos) {
				escribir.writeObject(alumno);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (escribir != null) {
					escribir.close();
				}
			} catch (Exception e) {
				e.printStackTrace(); // Imprime la traza de la excepción al cerrar
			}
		}

	}

	public void escribirEnFicheroJson(List<Alumno> listaAlumnos) {
		try {
			escribirJson = new FileWriter(fJson);
			gson.toJson(listaAlumnos, escribirJson);
			System.out.println("Archivo JSON guardado exitosamente.");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void leerDeFicheroBinario() {
		try {
			conexionLeer = new FileInputStream(f);
			leer = new ObjectInputStream(conexionLeer);
			while (leer.available() > 0) {
				Alumno a = (Alumno) leer.readObject();
				System.out.println(a.toString());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void leerDeUnFicheroJson() {
		ObjectMapper leer = new ObjectMapper();
		try {
			lista = (leer.readValue(fJson, new TypeReference<List<Alumno>>() {
			}));
			for (Alumno alumno : lista) {
				System.out.println(alumno.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}