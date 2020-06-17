package br.com.modelo.fatec;

public class Profissional extends Pessoa{
	private int idProfissional;
	public Profissional(Telefone telefone, Endere�o endere�o, String nome, String CPF) {
		super(telefone, endere�o, nome, CPF);
	}
	
	public int getIdProfissional() {
		return idProfissional;
	}
	
	public void setIdProfissional(int idProfissional) {
		this.idProfissional = idProfissional;
	}
	


}
