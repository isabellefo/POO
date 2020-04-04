package br.com.model.fatec;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Schedule {
	public Scanner scanner = new Scanner(System.in);
	public List<String> _service = new ArrayList<String>();
	private Date _date;
	private Client _client;
	private int _idSchedule;
	
	public Schedule(List<String> service, String date, Client client) {
		_service  = service;
		try {
			_date = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		_client = client;
	}
	
	public Date getDate() {
		return _date;
	}
	
	public List<String> getService() {
		return _service;
	}
	
	public void setDate(Date date) {
		this._date = date;
	}
	
	public void setService(List<String> service) {
		this._service = service;
	}
	
	public Client getClient() {
		return _client;
	}
	
	public void setClient(Client client) {
		this._client = client;
	}
	
	public int getIdSchedule() {
		return _idSchedule;
	}
	
	public void setId(int id) {
		this._idSchedule = id;
	}

	
	public void changeDate(){
		System.out.println("Insira a nova data de agendamento de revisão:");
		String dataNova = scanner.nextLine(); 
	    Date dataFormatada = null;
		try {
			dataFormatada = new SimpleDateFormat("dd/MM/yyyy").parse(dataNova);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		this.setDate(dataFormatada);
		System.out.println("Data da revisão alterada!");
		
	}
	
	public void changeService(List<Service> services){
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
		this.setService(descriptionService);
		System.out.println("Serviço alterado!");
	}
	
	public void editSchedule(List<Service> services){
		System.out.println("1- Mudar data.");
		System.out.println("2- Editar serviço.");
		int opt = scanner.nextInt();
		scanner.nextLine();/*Chamando o nextLine para evitar futuros erros de entrada devido o nextInt*/
		switch(opt){
		case 1:
			changeDate();
			break;
		
		case 2:
			changeService(services);
			break;
	
		}
		
	}

}
