package examenesTema2;

import java.util.Scanner;

public class Ej1 {

	public static void main(String[] args) {

		int lado;

		Scanner sc = new Scanner(System.in);

		System.out.println("¿De cuanto quiere que sea el lado?");

		lado = sc.nextInt();

		/* CUADRADO */

		for (int i = 0; i < lado; i++) {

			for (int j = 0; j < lado; j++) {

				if (i == 0 || i == lado - 1) {

					System.out.print("*");

				} else if (j == 0 || j == lado - 1) {

					System.out.print("*");

				} else {

					System.out.print(" ");

				}

			}
			System.out.println();

		}
		System.out.println();
		System.out.println();

		/* TRIANGULO */

		int medio = (int) lado / 2;
		int izq = medio - 1;
		int der = medio;

		for (int i = 0; i < lado - 1; i++) {

			System.out.println();

			for (int j = 0; j < lado; j++) {

				if (j == medio && i == 0) {

					System.out.print("*");

				} else if (i == lado - 2) {

					System.out.print("*");

				} else if (i != 0 && i != lado - 1 && j == izq) {

					System.out.print("*");
					izq--;

				} else if (i != 0 && i != lado - 1 && j == der) {

					System.out.print("*");

				} else {
					System.out.print(" ");
				}

			}
			der++;

		}

		/* TRIANGULO INVERTIDO */

		medio = (int) lado / 2;
		izq = -1;
		der = lado - 1;

		for (int i = 0; i < lado - 1; i++) {

			System.out.println();

			for (int j = 0; j < lado; j++) {

				if (j == medio && i == lado - 2) {

					System.out.print("*");

				} else if (i == 0) {

					System.out.print("*");

				} else if (i != 0 && i != lado - 2 && j == izq) {

					System.out.print("*");

				} else if (i != 0 && i != lado - 2 && j == der) {

					System.out.print("*");
					der--;

				} else {
					System.out.print(" ");
				}

			}

			izq++;
		}

	}

}
