package br.com.modelo.fatec;

public class Endereco {
	private String cidade;
	private String rua;
	private String bairro;
	private String estado;
	private String CEP;

	public Endereco(String cidade, String rua, String bairro, String estado, String CEP) {
		this.cidade = cidade;
		this.rua = rua;
		this.bairro = bairro;
		this.estado = estado;
		this.CEP = CEP;
	}
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
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
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado= estado;
	}
	
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String CEP) {
		this.CEP = CEP;
	}
	
	
}
