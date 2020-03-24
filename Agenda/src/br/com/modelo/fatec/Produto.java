package br.com.modelo.fatec;

public class Produto {
	
	private Pessoa pessoa;
	private int quantidade;
	//private String[] produtos = {"Corte de cabelo","Pintura de cabelo","Manicure","Pedicure","Corte de barba","Shampoo Antiqueda"};
	private String produto;
	
	public Produto(Pessoa pessoa, int quantidade) {
		this.pessoa = pessoa;
		this.quantidade = quantidade;
	}

}
