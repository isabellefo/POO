package br.com.modelo.fatec;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa implements Serializable{
	private List<Animal> animal = new ArrayList<Animal>();
	private int idCliente;  
	public Cliente(Telefone telefone, Endereço endereço, String nome, String CPF, List<Animal> animal) {
		super(telefone, endereço, nome, CPF);
		this.animal = animal;
	}
	
	public void setAnimal(List<Animal> animal) {
		this.animal = animal;
	}
	
	public List<Animal> getAnimal() {
		return animal;
	}
		
	public int getIdClient() {
		return idCliente;
	}
	
	public void setIdClient(int idCliente) {
		this.idCliente = idCliente;
	}
}
