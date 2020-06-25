package br.com.modelo.fatec;

import java.io.Serializable;

public class Animal implements Serializable{
	private int idPet;
	private String nome;
	private String raça;
	private char genero;
	private String idade;
	public Animal(String nome,String raça, char genero, String idade) {
		this.nome = nome;
		this.raça = raça;
		this.genero = genero;
		this.idade = idade;
	}
	
	public char getGenero() {
		return genero;
	}
	public String getIdade() {
		return idade;
	}
	public String getNome() {
		return nome;
	}
	public String getRaça() {
		return raça;
	}
	public void setGenero(char genero) {
		this.genero = genero;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setRaça(String raça) {
		this.raça = raça;
	}
	public int getIdPet() {
		return idPet;
	}
	
	public void setIdPet(int idPet) {
		this.idPet = idPet;
	}
	
	
	

}
