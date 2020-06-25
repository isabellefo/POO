package br.com.modelo.fatec;

import java.io.Serializable;

public class Endereço implements Serializable{
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private String CEP;
	
	public Endereço(String rua, String bairro, String cidade, String estado, String CEP) {
		this.rua = rua; 
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.CEP = CEP;
	}
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	
	
	

}
