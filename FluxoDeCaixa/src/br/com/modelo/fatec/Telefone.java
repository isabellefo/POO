package br.com.modelo.fatec;

public class Telefone {
	private String numero;
	
	public Telefone(String numero) {
		this.numero = numero;
	}
	
	public String getNumero() {
		String n = this.numero.substring(0, 5) + "-";
		n += this.numero.substring(5);
		return n;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}

}
