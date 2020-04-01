package br.com.modelo.fatec;

public class Usuario {
	private String user;
	private String senha;
	private String nome;
	
	private Telefone telefone;
	private Endereco endereco;
	
	private String email;
	
	private int tipo;
	
	private boolean logado = false;
	
	public Usuario(String user, String senha, String nome, Telefone telefone, Endereco endereco, String email, int tipo) {
		this.user = user;
		this.senha = senha;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		this.tipo = tipo;
	}
	
	public String getUser() {
		return this.user;
	}
	public String getSenha() {
		return this.senha;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
	
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	public Telefone getTelefone() {
		return this.telefone;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Endereco getEndereco() {
		return this.endereco;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return this.email;
	}
	
	public void setTipo(int tipo) {
		this.tipo= tipo;
	}
	public int getTipo() {
		return this.tipo;
	}
	
	public void setLogado(boolean logado) {
		this.logado= logado;
	}
	public boolean getLogado() {
		return this.logado;
	}
	
}
