package br.com.modelo.fatec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;

public class Agenda {
	public List<Pessoa> pessoas = new ArrayList<Pessoa>();
	public Scanner scanner = new Scanner(System.in);
	
	
	public void cadastrarPessoa() throws ParseException{
		
		//Nome
		System.out.println("Insira o nome do cliente:");
		String nome = scanner.nextLine();
		
		// Dados de contato
		System.out.println("Insira o telefone do cliente:");
		String tel = scanner.nextLine();
		Telefone telefone = new Telefone(tel);
		
		// Dados de nascimento
		System.out.println("Insira a data de nascimento do cliente:");
		String data = scanner.nextLine();
        
        //Genero
        System.out.println("Insira o gênero do cliente('F' para Feminino e 'M' para Masculino): ");
        char genero = scanner.next().charAt(0);
        scanner.nextLine();
		
		Pessoa c  = new Pessoa(nome, telefone, genero, data);
		pessoas.add(c);
		System.out.println("Novo contato adicionado!");
	}

	public void imprimirClientes() {
		Collections.sort(pessoas);
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa.toString());
		}
	}
	
	public void imprimirClientesPorGenero() {
		Collections.sort(pessoas);
		System.out.println("Clientes do gênero feminino:");
		for (Pessoa pessoa : pessoas) {
			if(pessoa.getGenero() == 'F') {
				System.out.println(pessoa.toString());
			} 
		}
		
		System.out.println("Clientes do gênero masculino:");
		for (Pessoa pessoa : pessoas) {
			if(pessoa.getGenero() == 'M') {
				System.out.println(pessoa.toString());
			} 
		}
	}
	
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
		int mediaf = idadesf/counterf;
		int mediam = idadesm/counterm;
		System.out.println("Idade média feminina:\n" + mediaf);
		System.out.println("Idade média masculina:\n" + mediam);
	}
	
	public void editarClientes() {
		String nome = scanner.next();
		
		for (Pessoa pessoa : pessoas) {
			if(pessoa.getNome().equals(nome))
				System.out.println("Existe");
		}
	}
	
	public void excluirClientes() {
		String nome = scanner.next();
		
		for (Pessoa pessoa : pessoas) {
			if(pessoa.getNome().equals(nome))
				System.out.println("Existe");
		}
	}

	
}

