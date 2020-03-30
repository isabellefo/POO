package br.com.modelo.fatec;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {
	
	public Scanner scanner = new Scanner(System.in);
	public static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	public void cadastrarUsuario() {
		//User
		System.out.println("Digite o nome de usu�rio:");
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
		
		//Endere�o
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
		
		//Tipo de usu�rio
		System.out.println("Digite o tipo de usu�rio");
		int t = Integer.parseInt(scanner.nextLine());
		while(t!=1 && t!=2) {
			System.out.println("Selecione uma op��o v�lida!");
			t = Integer.parseInt(scanner.nextLine());
		}
		Usuario usuario = new Usuario(u, s, n, tel, endereco, email,t);
		
		usuarios.add(usuario);
	}
	
	public boolean autenticar() {
		
		//User
		System.out.println("Digite o nome de usu�rio:");
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
		System.out.println("Usu�rio ou senha inv�lidos");
		return false;
	}
	
	public Usuario userLogado() {
		for (Usuario usuario : usuarios) {
			if (usuario.getLodago() == true){
				return usuario;
			}
		}
		return null;
	}
	
	

}