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
		System.out.println("Insira o telefone do cliente (9 dígitos):");
		String tel = scanner.nextLine();
		Telefone telefone = new Telefone(tel);
		
		// Dados de nascimento
		System.out.println("Insira a data de nascimento do cliente (dd/mm/aaaa):");
		String data = scanner.nextLine();
        
        //Genero
        System.out.println("Insira o gênero do cliente('F'/'M'): ");
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
				return;
			}
		}
	}
	
	//Editar cadastro do cliente
	public void editarClientes() {
		imprimirNomeCliente();
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
			System.out.println("PRODUTOS CONSUMIDOS");
			for(int i = 0; i < 6; ++i) {
				System.out.println("[" + i + "] "+ produtos[i] +" x"+ pessoa.getQtdProdutos(i));
			}
			System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
		}
	}
	
	//Imprimir clientes por gênero
	public void imprimirClientesPorGenero() {
		Collections.sort(pessoas);
		System.out.println("Clientes do gênero feminino:");
		for (Pessoa pessoa : pessoas) {
			if(pessoa.getGenero() == 'F') {
				System.out.println(pessoa.toString());
				System.out.println("PRODUTOS CONSUMIDOS");
				for(int i = 0; i < 6; ++i) {
					System.out.println("[" + i + "] "+ produtos[i] +" x"+ pessoa.getQtdProdutos(i));
				}
				System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
			} 
		}
		
		System.out.println("Clientes do gênero masculino:");
		for (Pessoa pessoa : pessoas) {
			if(pessoa.getGenero() == 'M') {
				System.out.println(pessoa.toString());
				System.out.println("PRODUTOS CONSUMIDOS");
				for(int i = 0; i < 6; ++i) {
					System.out.println("[" + i + "] "+ produtos[i] +" x"+ pessoa.getQtdProdutos(i));
				}
				System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
			} 
		}
	}
	
	//Calcular idade média geral
	public void calcularIdadeMedia() {
		int counter = 0 ;
		int idades = 0;
		for (Pessoa pessoa : pessoas) {
			idades += pessoa.getIdade();
			counter++;
		}
		int media = idades/counter;
		System.out.println("Idade média:" + media);
	}
	
	
	//Cálculo de iade média por gênero
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
		System.out.println("Idade média feminina: " + mediaf);
		System.out.println("Idade média masculina: " + mediam);
	}
	
	
	//Produtos
	public void comprar() {
		int i;
		System.out.println("PRODUTOS: ");
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
				System.out.println("Item adicionado ao histório!");
			}
		}
		System.out.println("Deseja continuar comprando? ('S'/'N')");
		 char op = scanner.nextLine().charAt(0);
		 if(op == 'S') {
			 comprar();
		 }else {
			 System.out.println("Operação finalizada");
		 }
	}
	
	//Determinar produto mais consumido pelo publico
	public void determinarProdConsumido() {
		int[] prod = new int[6];
		int maior = 0;
		int posMaior = 0;
		for (Pessoa p : pessoas) {
			for (int i = 0; i < prod.length; i++) {
				prod[i] += p.getQtdProdutos(i);
			}
		}
		
		for(int i = 0; i < prod.length; ++i) {
			if(prod[i] > maior) {
				maior = prod[i];
				posMaior = i;
			}
		}
		
		System.out.println("Produto/serviço mais consumido:" + this.produtos[posMaior]);
		
	}
	
	//Determinar produto mais consumido por genero
	public void determinarProdConsumidoGenero() {
		int[] prodF = new int[6];
		int[] prodM = new int[6];
		int maiorF = 0;
		int maiorM = 0;
		int posMaiorF = 0;
		int posMaiorM = 0;
		for (Pessoa p : pessoas) {
			for (int i = 0; i < prodM.length; i++) {
				if(p.getGenero() == 'F') {
					prodF[i] += p.getQtdProdutos(i);
				}else {
					prodM[i] += p.getQtdProdutos(i);
				}
			}
		}
		
		for(int i = 1; i < prodF.length; ++i) {
			if(prodF[i] > maiorF) {
				maiorF = prodF[i];
				posMaiorF = i;
			}
				
			if(prodM[i] > maiorM) {
				maiorM = prodM[i];
				posMaiorM = i;
			}
		}
		
		System.out.println("Produto/serviço mais consumido pelo publico feminino:" + this.produtos[posMaiorF]);
		System.out.println("Produto/serviço mais consumido pelo publico masculino:" + this.produtos[posMaiorM]);
	}
	
	public void imprimirRelatorios() {
		calcularIdadeMedia();
		calcularIdadeMediaGenero();
		determinarProdConsumido();
		determinarProdConsumidoGenero();
	}
	
}

