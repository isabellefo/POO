package br.com.model.fatec;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Options {
	public List<Client> clients = new ArrayList<Client>();
	public Scanner scanner = new Scanner(System.in);
	public void createClient(){
		//Nome
		System.out.println("Insira o nome do cliente:");
		String name = scanner.nextLine();
		
		// Dados de contato
		System.out.println("Insira o telefone do cliente:");
		String number = scanner.nextLine();
		Phone phone = new Phone(number);
		
		// Dados de endereço
		System.out.println("Insira o endereço do cliente:");
		String neighborhood = scanner.nextLine();
		Address address = new Address(neighborhood);
        
        //CPF	
        System.out.println("Insira o CPF do cliente");
        String cpf = scanner.nextLine();
        scanner.nextLine();
		
		Client c  = new Client(name, phone, address, cpf);
		clients.add(c);
		System.out.println("Novo cliente adicionado!");
	}
}
