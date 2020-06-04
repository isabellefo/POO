package br.com.modelo.fatec;

public class Cliente extends Pessoa{
	private Animal[] animal = new Animal[5];
	public Cliente(Telefone telefone, Endereço endereço, String nome, String CPF) {
		super(telefone, endereço, nome, CPF);
	}
	
	public void setAnimal(Animal[] animal) {
		this.animal = animal;
	}
	
	public Animal[] getAnimal() {
		return animal;
	}
		
}
