package br.com.app.fatec;

import java.text.ParseException;

import br.com.modelo.fatec.Caixa;
import br.com.modelo.fatec.Login;
import br.com.negocio.fatec.Controle;
import br.com.negocio.fatec.Menu;

public class App {
	public static void main(String[] args) throws ParseException{
		//AsciiArt.printAsciiArt("Agenda");
		Menu menu = new Menu();
		Login login = new Login();
		Caixa caixa = new Caixa();
		int op = 1000;
		boolean autenticado = login.autenticar();
		while(autenticado) {
			while(op != 0) {
				menu.imprimirMenu();
				Controle controle = new Controle();
				op = controle.opcao();
				switch (op) {
				case 1:
					login.cadastrarUsuario();
					break;
				case 2:
					caixa.cadastrarEntrada();
					break;
				case 3:
					//agenda.editarClientes();
					break;
				case 4:
					//agenda.excluirCliente();
					break;
				case 5:
					//agenda.comprar();;
					break;
				case 6:
					//agenda.imprimirRelatorios();
					break;
				default:
					menu.imprimirMenu();
				}
			}
		}
	}

}
