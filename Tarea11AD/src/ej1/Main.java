package ej1;

import java.util.Scanner;

public class Main {
	private static boolean handler = true;
	private static Menu m = new Menu();
	private static final Scanner abielto = new Scanner(System.in);

	public static void main(String[] args) {
		while (handler) {
			m.mostrarMenu();
			int valor = abielto.nextInt();
			m.elegir(valor);
			if (valor == 10) {
				handler = false;
			} else {
				handler = true;
			}

		}

	}

}
