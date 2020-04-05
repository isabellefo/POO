package br.com.model.fatec;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Options {
	public List<Client> clients = new ArrayList<Client>();
	public List<Schedule> schedules = new ArrayList<Schedule>();
	public List<Service> services = new ArrayList<Service>();
	SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
	public Scanner scanner = new Scanner(System.in);
	int idS = 0;
	int idService = 0;
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
		
		Client c  = new Client(name, phone, address, cpf);
		c.setIdClient(idC);
		idC++;
		clients.add(c);
		System.out.println("Novo cliente adicionado!");
		
	}
	
	public void createVehicle() {
		
		if(clients.isEmpty()!=true) {
	
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
				if(cli.getVehicle() == null) {
					System.out.println("[ "+cli.getIdClient()+" ] - " +"NOME: " +cli.getName() + "\n" +
					"CPF: " + cli.getCpf());
				}
			}
			
			int idCli = Integer.parseInt(scanner.nextLine());
			for (Client cli : clients) {
				if(cli.getIdClient() == idCli) {
					cli.setVehicle(v);
				}else {
					System.out.println("Cliente não encontrado! Tente novamente");
					return;
				}
			}
			
			System.out.println("Novo veiculo adicionado!");
		}else {
			System.out.println("Por favor cadastre um cliente antes de cadstrar o veículo!");
		}
	
		
	}
	
	public void createService(){
		//Nome
		System.out.println("Insira a descrição do serviço:");
		String description = scanner.nextLine();
		
		Service s = new Service(idService, description);
		idService++;
		services.add(s);
		System.out.println("Novo serviço adicionado!");
		
	}
	
	
	public void scheduleReview() {
		
		if(services.isEmpty()!=true) {
			if(clients.isEmpty()!=true) {
		
				//Data
				System.out.println("Insira a data da revisão:");
				String data = scanner.nextLine();
				
				List<String> descriptionService = new ArrayList<String>();
				int resp = 1;
				while(resp == 1) {
					//Serviço
					System.out.println("Selecione o serviço (pelo id): ");
					for (Service service : services) {
						System.out.println("[ "+service.getId()+" ] - " +"DESCRIÇÃO: " +service.getDescription());
					}
					int idSer = Integer.parseInt(scanner.nextLine());
					for (Service service : services) {
						if(service.getId() == idSer) {
							descriptionService.add((String) service.getDescription());
						}
					}
					System.out.println("Serviço adicionado");
					System.out.println("Deseja adicionar mais um serviço ? SIM(1), NÃO(2)");
					resp = Integer.parseInt(scanner.nextLine());
				}
				
				//Cliente
				System.out.println("Digite o cpf do cliente que deseja fazer agendar uma revisão: ");
				String cl = scanner.nextLine();
				Client cls = null;
				for (Client cli : clients) {
					if(cli.getCpf().equals(cl) && cli.getVehicle() != null) {
						cls = cli;
					}else {
						System.out.println("Cliente não encontrado ou não possui veiculo");
						return;
					}
				}
				
				
				Schedule sch = new Schedule(descriptionService, data,cls);
				
				sch.setId(idS);
				idS++;
				
				schedules.add(sch);
				
				System.out.println("Agendamento realizado com sucesso!");
			}else {
				System.out.println("Por favor cadastre um cliente antes de realizar um agendamento!");
			}
		}else {
			System.out.println("Por favor cadastre os serviços antes de realizar um agendamento!");
		}
	}
	
	public void printSchedule() {
		if(schedules.isEmpty()!=true) {
		System.out.println("Selecione o agendamento que deseja gerar o relatorio (pelo id)");
		for (Schedule schedule : schedules) {
			System.out.println("[ "+schedule.getIdSchedule()+" ] - NOME DO CLIENTE: "+schedule.getClient().getName()+"\n"+
			"DATA DO AGENDAMENTO: "+f.format(schedule.getDate()));
		}
		int idClient = Integer.parseInt(scanner.nextLine());
		for (Schedule sch : schedules) {
			if(sch.getIdSchedule() == idClient) {
				System.out.println("Agendamento feito para o/a: "+sch.getClient().getName());
				System.out.println("Placa do carro: "+sch.getClient().getVehicle().getPlateNumber());
				System.out.println("Modelo : "+sch.getClient().getVehicle().getVersion());
				System.out.println("Ano : "+sch.getClient().getVehicle().getYearManufacture());
				System.out.println("No dia: "+f.format(sch.getDate()));
				System.out.println("Contendo os seguintes serviços: ");
				List<String> services = sch.getService();
				for(String service : services) {
					System.out.println(service);
				}
			}else {
				System.out.println("ID do cliente não encontrado! Tente novamente");
			}
		}
		
		}else {
			System.out.println("Primeiro faça um agendamento!");
		}
	}
	
	public void changeSchedule() {
		if(schedules.isEmpty()!=true) {
			System.out.println("Selecione o agendamento que deseja alterar (pelo id)");
			for (Schedule schedule : schedules) {
				System.out.println("[ "+schedule.getIdSchedule()+" ] - NOME DO CLIENTE: "+schedule.getClient().getName()+"\n"+
				"DATA DO AGENDAMENTO: "+f.format(schedule.getDate()));
				
			}
			int idClient = Integer.parseInt(scanner.nextLine());
			for (Schedule schedule : schedules) {
				if(schedule.getIdSchedule() == idClient) {
					schedule.editSchedule(services);
				}else {
					System.out.println("ID de agendamento não encontrado! Tente novamente");
				}
			}
		}else {
			System.out.println("Primeiro faça um agendamento!");
		}
	}
	
	public void deleteSchedule() {
		if(schedules.isEmpty()!=true) {
			System.out.println("Selecione o agendamento que deseja cancelar (pelo id)");
			for (Schedule schedule : schedules) {
				System.out.println("[ "+schedule.getIdSchedule()+" ] - NOME DO CLIENTE: "+schedule.getClient().getName()+"\n"+
				"CPF: " + schedule.getClient().getCpf() + 	"\n"	+
				"DATA DO AGENDAMENTO: "+f.format(schedule.getDate()));
				
			}
			int idSchedule = Integer.parseInt(scanner.nextLine());
			for (Schedule schedule : schedules) {
				if(schedule.getIdSchedule() == idSchedule) {
					schedules.remove(schedule);
					System.out.println("Agendamento cancelado");
					return;
				}else {
					System.out.println("ID de agendamento não encontrado! Tente novamente");
				}
			}
		
		}else {
			System.out.println("Primeiro faça um agendamento!");
		}
		
	}

	
	
	
}
