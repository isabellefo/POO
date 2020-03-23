package br.com.model.fatec;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Schedule {
	public Scanner scanner = new Scanner(System.in);
	
	private String _service;
	private Date _date;
	private Client _client;
	private int _idSchedule;
	
	public Schedule(String service, String date, Client client) {
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
	
	public String getService() {
		return _service;
	}
	
	public void setDate(Date date) {
		this._date = date;
	}
	
	public void setService(String service) {
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
	
	public void changeService(){
		System.out.println("Digite o novo serviço a ser feito:");
		String service = scanner.nextLine();
		this.setService(service);
		System.out.println("Serviço alterado!");
	}
	
	public void editSchedule(){
		System.out.println("1- Mudar data.");
		System.out.println("2- Editar serviço.");
		int opt = scanner.nextInt();
		scanner.nextLine();/*Chamando o nextLine para evitar futuros erros de entrada devido o nextInt*/
		switch(opt){
		case 1:
			changeDate();
			break;
		
		case 2:
			changeService();
			break;
	
		}
		
	}

}
