package br.com.negocio.fatec;

public class Menu {
	public void imprimirMenu() {
		System.out.println("|~~~~ MENU ~~~~|");
		System.out.println("[1] - Cadastrar usu�rio");
		System.out.println("[2] - Cadastrar entrada");
		System.out.println("[3] - Cadastrar sa�da");
		System.out.println("[4] - Imprimir relat�rio mensal");
		System.out.println("[5] - Imprimir relat�rio semanal");
		//System.out.println("[6] - Imprimir relat�rios");
		System.out.println("[0] - Sair");
	}
	
	public void imprimirMenuIniciar() {
		System.out.println("|~~~~ MENU INICIAR~~~~|");
		System.out.println("[1] - Realizar login");
		System.out.println("[2] - Criar conta");
	}

}
