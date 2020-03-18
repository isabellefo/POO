package br.com.app.fatec;

import java.text.ParseException;

import br.com.modelo.fatec.Agenda;
import br.com.negocio.fatec.AsciiArt;
import br.com.negocio.fatec.Controle;
import br.com.negocio.fatec.Menu;

public class App {
	public static void main(String[] args) throws ParseException{
		AsciiArt.printAsciiArt("Agenda");
		Menu menu = new Menu();
		Agenda agenda = new Agenda();
		int op = 1000;
		while(op != 0) {
			menu.imprimirMenu();
			Controle controle = new Controle();
			op = controle.opcao();
			switch (op) {
			case 1:
				agenda.cadastrarPessoa();
				break;
			case 2:
				agenda.imprimirClientes();
			case 3:
				agenda.editarClientes();
			case 4:
				agenda.excluirCliente();
			case 5:
				agenda.imprimirClientesPorGenero();
			case 6:
				agenda.calcularIdadeMedia();
			case 7:
				agenda.calcularIdadeMediaGenero();
			default:
				menu.imprimirMenu();
			}
		}
		
	}
}