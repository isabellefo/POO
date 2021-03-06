package br.com.modelo.fatec;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fluxo {
	
	private Usuario usuario;
	private double valor;
	private Date data;
	private int grupo;
	
	public Fluxo(Usuario usuario, double valor, String data, int grupo) {
		this.usuario = usuario;
		this.valor = valor;
		try {
			this.data = new SimpleDateFormat("dd/MM/yyyy").parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.grupo = grupo;
	}
	
	public Date getData() {
		return data;
	}
	
	public int getGrupo() {
		return grupo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	
	 public double getValor() {
		return valor;
	}
	 
	public void setData(Date data) {
		this.data = data;
	}
	
	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}

}
