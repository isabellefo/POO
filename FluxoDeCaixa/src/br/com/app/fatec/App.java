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
		int alt = -1;
		boolean autenticado = false;
		
		
		while(alt != 0) {
			menu.imprimirMenuIniciar();
			alt = controle.opcao();
			switch(alt) {
			case 1:
				autenticado = login.autenticar();
				if(autenticado == true) {
					caixa.menuPrincipal();
				}
				break;
			case 2:
				login.cadastrarUsuario();
				System.out.println("-----ENTRAR NO SISTEMA-----");
				autenticado = login.autenticar();
				if(autenticado == true) {
					caixa.menuPrincipal();
				}
				break;
			case 0:
				System.out.println("Programa finalizado!");
				break;
			default:
				menu.imprimirMenuIniciar();
			}
		}
		
	}

}
