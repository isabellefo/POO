package br.com.negocio.fatec;

public class Menu {
	public void imprimirMenu() {
		System.out.println("|~~~~ MENU ~~~~|");
		System.out.println("[1] - Cadastrar usuário");
		System.out.println("[2] - Cadastrar entrada");
		System.out.println("[3] - Cadastrar saída");
		System.out.println("[4] - Imprimir relatório mensal");
		System.out.println("[5] - Imprimir relatório semanal");
		//System.out.println("[6] - Imprimir relatórios");
		System.out.println("[0] - Sair");
	}
	
	public void imprimirMenuIniciar() {
		System.out.println("|~~~~ MENU INICIAR~~~~|");
		System.out.println("[1] - Realizar login");
		System.out.println("[2] - Criar conta");
	}

}
