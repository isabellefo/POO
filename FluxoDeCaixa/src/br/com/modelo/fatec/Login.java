package br.com.modelo.fatec;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.negocio.fatec.Menu;

public class Login {
	
	public Scanner scanner = new Scanner(System.in);
	public Menu menu = new Menu();
	public static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	public void cadastrarUsuario() {
		//User
		System.out.println("Digite o nome de usuário:");
		String u = scanner.nextLine();
		
		//Senha
		System.out.println("Digite a senha:");
		String s = scanner.nextLine();
		
		//Nome
		System.out.println("Digite seu nome:");
		String n = scanner.nextLine();
		//Telefone
		System.out.println("Digite seu telefone:");
		String num = scanner.nextLine();
		Telefone tel = new Telefone(num);
		
		//Endereço
		System.out.printf("Insira a cidade: ");
		String cidade = scanner.nextLine();
		System.out.printf("Insira a rua: ");
		String rua = scanner.nextLine();
		System.out.printf("Insira o bairro: ");
		String bairro = scanner.nextLine();
		System.out.printf("Insira o estado: ");
		String estado = scanner.nextLine();
		System.out.printf("Insira o CEP: ");
		String cep = scanner.nextLine();
		Endereco endereco = new Endereco(cidade, rua, bairro, estado, cep);
		
		//Email
		System.out.println("Digite seu email:");
		String email = scanner.nextLine();
		
		//Tipo de usuário
		System.out.println("Selecione o tipo de usuário");
		System.out.println("[1] - Pessoa Física");
		System.out.println("[2] - Pessoa Juridica");
		int t = Integer.parseInt(scanner.nextLine());
		while(t!=1 && t!=2) {
			System.out.println("Selecione uma opção válida!");
			t = Integer.parseInt(scanner.nextLine());
		}
		Usuario usuario = new Usuario(u, s, n, tel, endereco, email,t);
		
		usuarios.add(usuario);
	}
	
	public boolean autenticar() {
		
		//User
		System.out.println("Digite o nome de usuário:");
		String u = scanner.nextLine();
				
		//Senha
		System.out.println("Digite a senha:");
		String s = scanner.nextLine();
		
		for (Usuario usuario : usuarios) {
			if((usuario.getUser() == u) && (usuario.getSenha() == s)) {
				usuario.setLogado(true);
				return true;
			}
		}
		System.out.println("Usuário ou senha inválidos");
		return false;
	}
	
	public Usuario userLogado() {
		for (Usuario usuario : usuarios) {
			if (usuario.getLogado() == true){
				return usuario;
			}
		}
		return null;
	}
	
	//Incompleta
	/*public void trocarDeUsuario() {
		Usuario u;
		u = userLogado();
		u.setLogado(false);
		
	}*/
	
	/*public void loginInicial() {
		menu.imprimirMenuIniciar();
		int op = Integer.parseInt(scanner.nextLine());
		while(op!=1 && op!=2) {
			System.out.println("Selecione uma opção válida!");
			op = Integer.parseInt(scanner.nextLine());
		}
		if(op==1) {
			autenticar();
		}else {
			cadastrarUsuario();
		}
	}*/
	
	
	

}
