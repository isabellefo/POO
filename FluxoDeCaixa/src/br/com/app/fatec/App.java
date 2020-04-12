package br.com.app.fatec;

import java.text.ParseException;

import br.com.modelo.fatec.Caixa;
import br.com.modelo.fatec.Login;
import br.com.negocio.fatec.Controle;
import br.com.negocio.fatec.Menu;

public class App {
	public static void main(String[] args) throws ParseException{

		Menu menu = new Menu();
		Login login = new Login();
		Caixa caixa = new Caixa();
		Controle controle = new Controle();
		int op = 1000;
		int alt = 0;
		boolean autenticado = false;
		
		while(alt != -1) {
			menu.imprimirMenuIniciar();
			alt = controle.opcao();
			switch(alt) {
			case 1:
				autenticado = login.autenticar();
				break;
			case 2:
				login.cadastrarUsuario();
				System.out.println("-----ENTRAR NO SISTEMA-----");
				autenticado = login.autenticar();
				if(autenticado == true) {
					alt = -1;
				}
				break;
			default:
				menu.imprimirMenuIniciar();
			}
		}
		
		if(autenticado) {
			while(op != 0) {
				menu.imprimirMenu();
				
				op = controle.opcao();
				switch (op) {
				case 1:
					login.cadastrarUsuario();
					break;
				case 2:
					caixa.cadastrarEntrada();
					//caixa.imprimirEntrada();
					break;
				case 3:
					caixa.cadastrarSaida();
					break;
				case 4:
					caixa.relatorioMensal();
					break;
				case 5:
					caixa.relatorioSemanal();
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
