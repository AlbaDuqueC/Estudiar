package examenTema3;

import java.util.Random;
import java.util.Scanner;

public class ExamenTema3 {

	public static void main(String[] args) {
		/* HUNDIR LA FLOTA */

		/* VARIABLES DEL MAIN */

		char[][] tablero;
		char[][] tableroJ;
		char[][] tableroJ1;
		char[][] tableroJ2;
		int fila;
		int columna;
		int barcos;
		int barcosHundidosJ1;
		int barcoshundidosJ2;
		boolean acertar = false;

		Scanner sc = new Scanner(System.in);

		/* PREGUNTA LAS DIMENSIONES DEL TABLERO */

		System.out.println("¿De cuanto quieres que sea las dimensiones del tablero?");
		System.out.print("Filas: ");
		fila = sc.nextInt();
		System.out.println("Columnas: ");
		columna = sc.nextInt();

		/* CALCULA EL NUMERO DE BARCOS */

		barcos = (int) Math.sqrt(fila * columna);

		/* DAMOS VALOR AL TABLERO CON LA SOLUCION */

		tablero = creaTablero(fila, columna);
		generaBarquitos (tablero, barcos);

		/* COMPROBACIONES */
		
		

	}

	static char[][] inicializaTablero(int fila, int columna) {
		char[][] tablero = new char[fila][columna];

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = '-';
			}
		}

		return tablero;

	}

	static char[][] creaTablero(int fila, int columna) {

		char[][] tablero = new char[fila][columna];

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = 'A';
			}
		}

		return tablero;

	}

	static void generaBarquitos(char[][] tablero, int barcos) {

		Random rand = new Random();

		int fila;
		int columna;
		int cont;

		for (int i = 0; i < barcos; i++) {

			fila = rand.nextInt(0, tablero.length);
			columna = rand.nextInt(0, tablero[fila].length);
			
			tablero[fila][columna]='B';

		}

	}

}
