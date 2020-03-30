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
	
		//N�mero da placa
		System.out.println("Insira a placa do carro:");
		String plate = scanner.nextLine();
	
		//Modelo
		System.out.println("Insira o modelo do carro:");
		String version = scanner.nextLine();
	
		//Ano de fabrica��o
		System.out.println("Insira o ano de fabrica��o:");
		int year = Integer.parseInt(scanner.nextLine());
		
		//Valor de compra
		System.out.println("Insira o valor de compra:");
		double value = Double.parseDouble(scanner.nextLine());
			
		Vehicle v = new Vehicle(plate, version, year, value);
		
		System.out.println("Selecione o dono do ve�culo (pelo id): ");
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
			}
		}
		
		System.out.println("Novo veiculo adicionado!");
	
		
	}
	
	public void createService(){
		//Nome
		System.out.println("Insira a descri��o do servi�o:");
		String description = scanner.nextLine();
		
		Service s = new Service(idService, description);
		idService++;
		services.add(s);
		System.out.println("Novo servi�o adicionado!");
		
	}
	
	
	//Falta exce��es
	public void scheduleReview() {
		
		//Data
		System.out.println("Insira a data da revis�o:");
		String data = scanner.nextLine();
		
		//Servi�o
		System.out.println("Selecione o servi�o (pelo id): ");
		for (Service service : services) {
			System.out.println("[ "+service.getId()+" ] - " +"DESCRI��O: " +service.getDescription());
		}
		
		String descriptionService = "";
		int idSer = Integer.parseInt(scanner.nextLine());
		for (Service service : services) {
			if(service.getId() == idSer) {
				descriptionService = service.getDescription();
			}
		}
		
		//Cliente
		System.out.println("Digite o cpf do cliente que deseja fazer agendar uma revis�o: ");
		String cl = scanner.nextLine();
		Client cls = null;
		for (Client cli : clients) {
			if(cli.getCpf().equals(cl) && cli.getVehicle() != null) {
				cls = cli;
			}else {
				System.out.println("Cliente n�o encontrado ou n�o possue veiculo");
			}
		}
		
		
		
		Schedule sch = new Schedule(descriptionService, data,cls);
		
		sch.setId(idS);
		idS++;
		
		schedules.add(sch);
		
		System.out.println("Agendamento realizado com sucesso!");
	}
	
	public void printSchedule() {
		//Cliente
		System.out.println("Digite o cpf do cliente que deseja gerar o relat�rio: ");
		String cl = scanner.nextLine();
		for (Schedule sche : schedules) {
			if(sche.getClient().getCpf() == cl) {
				System.out.println("Agendamento feito para o/a: "+sche.getClient().getName());
				System.out.println("No dia: "+sche.getDate());
				System.out.println("Contento o seguinte servi�o: "+sche.getService());
			}
		}
	}
	
	//Falta exce��es
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
	
	//Falta exce��es
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
