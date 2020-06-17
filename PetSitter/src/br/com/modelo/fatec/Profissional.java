package br.com.modelo.fatec;

public class Profissional extends Pessoa{
	private int idProfissional;
	public Profissional(Telefone telefone, Endereço endereço, String nome, String CPF) {
		super(telefone, endereço, nome, CPF);
	}
	
	public int getIdProfissional() {
		return idProfissional;
	}
	
	public void setIdProfissional(int idProfissional) {
		this.idProfissional = idProfissional;
	}
	


}
