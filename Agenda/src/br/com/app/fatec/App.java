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
				break;
			case 3:
				agenda.editarClientes();
				break;
			case 4:
				agenda.excluirCliente();
				break;
			case 5:
				agenda.imprimirClientesPorGenero();
				break;
			case 6:
				agenda.comprar();
				//agenda.calcularIdadeMedia();
				break;
			case 7:
				agenda.imprimirRelatorios();
				/*agenda.calcularIdadeMediaGenero();
				break;*/
			default:
				menu.imprimirMenu();
			}
		}
		
	}
}