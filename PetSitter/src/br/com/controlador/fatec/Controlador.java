package br.com.controlador.fatec;

import java.util.Scanner;

public class Controlador {
	public Scanner scanner;
	public Controlador() {
		scanner = new Scanner(System.in);
	}

	public int opcao() {
		int op = scanner.nextInt();
		return op;
	}
}
