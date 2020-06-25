package br.com.modelo.fatec;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Atendimento implements Serializable{
	private Cliente cliente;
	private Profissional profissional;
	private Animal animal;
	private Date date;
	public Atendimento(Cliente cliente,Profissional profissional,Animal animal, String date) {
		this.profissional = profissional;
		this.cliente = cliente;
		this.animal = animal;
		try {
			this.date = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Date getDate() {
		return date;
	}
	public Animal getAnimal() {
		return animal;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public Profissional getProfissional() {
		return profissional;
	}

}
