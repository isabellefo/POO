package br.com.model.fatec;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Options {
	public List<Client> clients = new ArrayList<Client>();
	public List<Schedule> schedules = new ArrayList<Schedule>();
	SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
	public Scanner scanner = new Scanner(System.in);
	int idS = 0;
	int idC = 0;
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
		c.setIdClient(idC);
		idC++;
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
	
	System.out.println("Selecione o dono do veículo (pelo id): ");
	for (Client cli : clients) {
		System.out.println("[ "+cli.getIdClient()+" ] - " +"NOME: " +cli.getName() + "\n" +
		"CPF: " + cli.getCpf());
	}
	
	int idCli = Integer.parseInt(scanner.nextLine());
	for (Client cli : clients) {
		if(cli.getIdClient() == idCli) {
			cli.setVehicle(v);
		}
	}
	
		
	}
	
	
	//Falta exceções
	public void scheduleReview() {
		
		//Data
		System.out.println("Insira a data da revisão:");
		String data = scanner.nextLine();
		//Serviço
		System.out.println("Insira qual serviço será feito na revisão:");
		String service = scanner.nextLine();
		
		//Cliente
		System.out.println("Digite o nome do cliente que deseja fazer agendar uma revisão: ");
		String cl = scanner.nextLine();
		Client cls = null;
		for (Client cli : clients) {
			if(cli.getName().equals(cl)) {
				cls = cli;
			}else {
				System.out.println("Cliente não encontrado");
			}
		}
		
		Schedule sch = new Schedule(service, data,cls);
		
		sch.setId(idS);
		idS++;
		
		schedules.add(sch);
	}
	
	public void printSchedule() {
		for (Schedule sche : schedules) {
			System.out.println(sche.getClient().getName());
			System.out.println(sche.getDate());

		}
	}
	
	//Falta exceções
	public void changeSchedule() {
		System.out.println("Selecione o agendamento que deseja alterar (pelo id)");
		for (Schedule schedule : schedules) {
			System.out.println("[ "+schedule.getIdSchedule()+" ] - NOME DO CLIENTE: "+schedule.getClient().getName()+"\n"+
			"DATA DO AGENDAMENTO: "+f.format(schedule.getDate()));
			
		}
		int idClient = Integer.parseInt(scanner.nextLine());
		for (Schedule schedule : schedules) {
			if(schedule.getIdSchedule() == idClient) {
				schedule.editSchedule();
			}
		}
	}
	
	//Falta exceções
	public void deleteSchedule() {
		System.out.println("Selecione o agendamento que deseja cancelar (pelo id)");
		for (Schedule schedule : schedules) {
			System.out.println("[ "+schedule.getIdSchedule()+" ] - NOME DO CLIENTE: "+schedule.getClient().getName()+"\n"+
			"CPF: " + schedule.getClient().getCpf() + 		
			"DATA DO AGENDAMENTO: "+f.format(schedule.getDate()));
			
		}
		int idSchedule = Integer.parseInt(scanner.nextLine());
		for (Schedule schedule : schedules) {
			if(schedule.getIdSchedule() == idSchedule) {
				schedules.remove(schedule);
				System.out.println("Agendamento cancelado");
			}
		}
		
		
	}

	
	
	
}
