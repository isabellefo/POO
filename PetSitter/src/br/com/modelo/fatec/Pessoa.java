package br.com.modelo.fatec;

import java.io.Serializable;

public class Pessoa implements Serializable{
	
	private Telefone telefone;
	private Endereço endereço;
	private String nome;
	private String CPF;
	
	public Pessoa(Telefone telefone, Endereço endereço, String nome, String CPF) {
		this.telefone = telefone;
		this.endereço = endereço;
		this.nome=nome;
		this.CPF = CPF;
	}
	
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public Endereço getEndereço() {
		return endereço;
	}
	public void setEndereço(Endereço endereço) {
		this.endereço = endereço;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	public Telefone getTelefone() {
		return telefone;
	}
	

}
