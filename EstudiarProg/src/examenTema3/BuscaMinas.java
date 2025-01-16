package examenTema3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BuscaMinas {

	public static void main(String[] args) {
		/* BUSCA MINAS */

		/* VARIABLES */

		char[][] tableroBase;
		char[][] tableroJugador;
		int linea;
		int columna;
		int bombas;
		int casillas;
		boolean ganar = false;

		Scanner sc = new Scanner(System.in);

		/* PREGUNTAR AL USUARIO LAS DIMENSIONES DEL TABLERO DE JUEGO */

		System.out.println("BUSCA MINAS");

		System.out.println();

		System.out.println("Introduzca las dimensiones del tablero:");

		System.out.println();

		System.out.print("Lineas: ");
		linea = sc.nextInt();
		System.out.println();

		System.out.print("Columnas: ");
		columna = sc.nextInt();
		System.out.println();

		/* CALCULAMOS EL NUMERO DE BOMBAS Y EL NUMERO DE CASILLAS */

		bombas = (int) Math.sqrt(linea * columna);

		casillas = linea * columna - bombas;

		/* AGREGAMOS LAS FUNCIONES */

		tableroBase = crearTablero(linea, columna);
		tableroJugador = crearTablero(linea, columna);

		PonerBomba(tableroBase, bombas);
		IntroducirNumeros(tableroBase);

		/* COMPROBACIONES */

		for (int i = 0; i < tableroBase.length; i++) {
			for (int j = 0; j < tableroBase[i].length; j++) {
				System.out.print("\t" + tableroBase[i][j]);
			}
			System.out.println();
		}
		System.out.println();

		/* FUNCIONAMIENTO DEL JUEGO */

		do {

			ganar = Preguntar(tableroBase, tableroJugador, columna);

			if (ganar == true) {
				casillas--;
			}

		} while (casillas != 0 && ganar == true);

		if (ganar == true) {
			System.out.println("No vea lo bueno que ere a ehto");
		} else {
			System.out.println("Menudo ñordo");
		}

	}

	/* CREAMOS LA BASE DEL TABLERO INICIAL */

	static char[][] crearTablero(int linea, int columna) {

		char[][] tablero = new char[linea][columna];

		for (int i = 0; i < tablero.length; i++) {

			for (int j = 0; j < tablero[i].length; j++) {

				tablero[i][j] = '-';

			}
		}

		return tablero;

	}

	/* AGREGAMOS LAS MINAS AL TABLERO */

	static void PonerBomba(char[][] tableroBase, int bombas) {

		int lin;

		int col;

		Random rand = new Random();

		for (int i = 0; i < bombas; i++) {

			do {

				col = rand.nextInt(0, tableroBase[0].length);
				lin = rand.nextInt(0, tableroBase.length);

			} while (tableroBase[lin][col] == '*');

			tableroBase[lin][col] = '*';
		}

	}

	/* INTRODUCIOMOS EL NUMERO DE MINAS QUE HAY ALREDEDOR DE CADA POSICIÓN */

	static void IntroducirNumeros(char[][] tableroBase) {

		int cont = 0;

		for (int i = 0; i < tableroBase.length; i++) {

			for (int j = 0; j < tableroBase[i].length; j++) {

				cont = 0;

				if (tableroBase[i][j] != '*') {

					/* ESQUINAS */
					/* arriba izquierda */
					if (i - 1 >= 0 && j - 1 >= 0 && tableroBase[i - 1][j - 1] == '*') {
						cont++;
					}
					/* arriba derecha */
					if (i - 1 >= 0 && j + 1 < tableroBase[i].length && tableroBase[i - 1][j + 1] == '*') {
						cont++;
					}
					/* abajo izquierda */
					if (i + 1 < tableroBase.length && j - 1 >= 0 && tableroBase[i + 1][j - 1] == '*') {
						cont++;
					}
					/* abajo derecha */
					if (i + 1 < tableroBase.length && j + 1 < tableroBase[i].length
							&& tableroBase[i + 1][j + 1] == '*') {
						cont++;
					}

					/* LATERALES */
					/* arriba */
					if (i - 1 >= 0 && tableroBase[i - 1][j] == '*') {
						cont++;
					}
					/* abajo */
					if (i + 1 < tableroBase.length && tableroBase[i + 1][j] == '*') {
						cont++;
					}
					/* izquierda */
					if (j - 1 >= 0 && tableroBase[i][j - 1] == '*') {
						cont++;
					}
					/* derecha */
					if (j + 1 < tableroBase[i].length && tableroBase[i][j + 1] == '*') {
						cont++;
					}

					tableroBase[i][j] = (char) (cont + '0');

				}

			}

		}

	}

	/*
	 * PREGUNTA EN QUE POSICION QUIERES PINCHAR, DEPENDIENDO LO QUE HAYA SEGUIRAS
	 * JUGANDO O PERDERAS
	 */

	static boolean Preguntar(char[][] tableroBase, char[][] tableroJugador, int columna) {

		int lin;
		int col;
		boolean ganar = false;

		Scanner sc = new Scanner(System.in);

		ImprimirTablero(tableroJugador, columna);

		System.out.println("En que posicion quieres pinchar?");
		System.out.print("linea: ");
		lin = sc.nextInt();
		System.out.print("columna: ");
		col = sc.nextInt();

		if (tableroBase[lin][col] != '*') {
			ganar = true;
			tableroJugador[lin][col] = tableroBase[lin][col];
		}

		return ganar;

	}

	/* IMPRIME EL TABLERO DEL JUGADOR */

	static void ImprimirTablero(char[][] tableroJugador, int columna) {

		for (int i = 0; i < columna; i++) {

			System.out.print(" \t" + i);
		}
		System.out.println();

		for (int i = 0; i < tableroJugador.length; i++) {

			System.out.println(i);

			for (int j = 0; j < tableroJugador[i].length; j++) {

				System.out.print("\t" + tableroJugador[i][j]);

			}
			System.out.println();

		}

	}

}
