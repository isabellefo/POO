package br.com.modelo.fatec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;

public class Agenda {
	public List<Pessoa> pessoas = new ArrayList<Pessoa>();
	public Scanner scanner = new Scanner(System.in);
	private String[] produtos = {"Corte de cabelo","Pintura de cabelo","Manicure","Pedicure","Corte de barba","Shampoo Antiqueda"};
	
	
	public void cadastrarPessoa() throws ParseException{
		
		//Nome
		System.out.println("Insira o nome do cliente:");
		String nome = scanner.nextLine();
		
		// Dados de contato
		System.out.println("Insira o telefone do cliente:");
		String tel = scanner.nextLine();
		Telefone telefone = new Telefone(tel);
		
		// Dados de nascimento
		System.out.println("Insira a data de nascimento do cliente (dd/mm/aaaa):");
		String data = scanner.nextLine();
        
        //Genero
        System.out.println("Insira o g�nero do cliente('F'/'M'): ");
        char genero = scanner.next().charAt(0);
        scanner.nextLine();
		
		Pessoa c  = new Pessoa(nome, telefone, genero, data);
		pessoas.add(c);
		System.out.println("Novo contato adicionado!");
	}
	
	//Imprimir lista de nomes dos clientes
	public void imprimirNomeCliente() {
		for (Pessoa pessoa : pessoas) {
			System.out.println("NOME:" + pessoa.getNome());
		}
	}
	
	//Exlcuir cliente
	public void excluirCliente() {
		String nome;
		imprimirNomeCliente();
		System.out.println("Digite o nome do cliente que deseja excluir: ");
		nome = scanner.nextLine();
		for (Pessoa pe : pessoas) {
			if (pe.getNome().equals(nome)) {
				pessoas.remove(pe);
				System.out.println(pe.getNome() + " excluido com sucesso.\n");
			}
		}
	}
	
	//Editar cadastro do cliente
	public void editarClientes() {
		System.out.println("Digite o nome do cliente que deseja alterar: ");
		String nome = scanner.nextLine();
		for (Pessoa pessoa : pessoas) {
			if(pessoa.getNome().equals(nome))
				pessoa.editaCliente();
		}
	}

	//Imprimir os clientes
	public void imprimirClientes() {
		Collections.sort(pessoas);
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa.toString());
		}
	}
	
	//Imprimir clientes por g�nero
	public void imprimirClientesPorGenero() {
		Collections.sort(pessoas);
		System.out.println("Clientes do g�nero feminino:");
		for (Pessoa pessoa : pessoas) {
			if(pessoa.getGenero() == 'F') {
				System.out.println(pessoa.toString());
			} 
		}
		
		System.out.println("Clientes do g�nero masculino:");
		for (Pessoa pessoa : pessoas) {
			if(pessoa.getGenero() == 'M') {
				System.out.println(pessoa.toString());
			} 
		}
	}
	
	//Calcular idade m�dia geral
	public void calcularIdadeMedia() {
		int counter = 0 ;
		int idades = 0;
		for (Pessoa pessoa : pessoas) {
			idades += pessoa.getIdade();
			counter++;
		}
		int media = idades/counter;
		System.out.println("Idade m�dia:" + media);
	}
	
	
	//C�lculo de iade m�dia por g�nero
	public void calcularIdadeMediaGenero() {
		int counterf = 0;
		int idadesf = 0;
		int counterm = 0;
		int idadesm = 0;
		for (Pessoa pessoa : pessoas) {
			if(pessoa.getGenero() == 'F') {
				idadesf += pessoa.getIdade();
				counterf++;
			}
			
			if(pessoa.getGenero() == 'M') {
				idadesm += pessoa.getIdade();
				counterm++;
			}
		}
		int mediaf;
		int mediam;		
		
		if(counterf == 0) {
			mediaf = 0;
		}else {
			mediaf = idadesf/counterf;
		}
		
		if(counterm == 0) {
			mediam = 0;
		}else {
			mediam = idadesm/counterm;
		}
		System.out.println("Idade m�dia feminina:\n" + mediaf);
		System.out.println("Idade m�dia masculina:\n" + mediam);
	}
	
	
	//Produtos
	public void comprar() {
		int i;
		System.out.println("\n PRODUTOS: ");
		for(i = 0; i < this.produtos.length; ++i) {
			System.out.println("[" + i + "]" + produtos[i]);
		}
		
		System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~+");
		System.out.println("Selecione o produto que deseja comprar (pelo id):");
		int prod = Integer.parseInt(scanner.nextLine());
		System.out.println("Insira a quantidade:");
		int qtd = Integer.parseInt(scanner.nextLine());
		
		imprimirNomeCliente();
		System.out.println("Selecione o cliente que deseja adicionar o item na lista:");
		String pe = scanner.nextLine();
		
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getNome().equals(pe)) {
				pessoa.setQtdProdutos(prod, qtd);
				System.out.println("Item adicionado ao hist�rio!\n");
			}
		}
		System.out.println("Deseja continuar comprando? ('S'/'N')");
		 char op = scanner.nextLine().charAt(0);
		 if(op == 'S') {
			 comprar();
		 }else {
			 System.out.println("Opera��o finalizada");
		 }
	}
	
	
}

