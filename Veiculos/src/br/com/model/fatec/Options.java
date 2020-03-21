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
		
		// Dados de endereco
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
		Address address = new Address(cidade, rua, bairro, estado, cep);
		
        
        //CPF	
        System.out.println("Insira o CPF do cliente");
        String cpf = scanner.nextLine();
        scanner.nextLine();
		
		Client c  = new Client(name, phone, address, cpf);
		clients.add(c);
		System.out.println("Novo cliente adicionado!");
		
	}
	
	public void createVehicle() {
	
	//Número da placa
	System.out.println("Insira a placa do carro:");
	String plate = scanner.nextLine();
	
	//Modelo
	System.out.println("Insira o modelo do carro:");
	String version = scanner.nextLine();
	
	//Ano de fabricação
	System.out.println("Insira o ano de fabricação:");
	int year = Integer.parseInt(scanner.nextLine());
	
	//Valor de compra
	System.out.println("Insira o valor de compra:");
	double value = Double.parseDouble(scanner.nextLine());
		
	Vehicle v = new Vehicle(plate, version, year, value);
	
	//TERMINAR PARTE DE ADICIONAR VEÍCULO AO CLIENTE
	
	/*System.out.println("Selecione pelo id o cliente que deseja cadastrar o veículo: ");
	int cont = 1;
	for (Client cli : clients) {
		System.out.println("[ "+cont+" ] -" + cli.getName() );
		cont++;
	}*/
	
		
	}

	
	
	
}
