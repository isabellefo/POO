package br.com.modelo.fatec;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;



public class Pessoa implements Comparable<Pessoa>{ 
	private String nome;
	private Telefone telefone;
	private char genero;
	private Date dataNascimento;
	
	SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
	
	public Pessoa(String nome, Telefone telefone, char genero, String dataNascimento) {
		this.nome = nome;
		this.genero = genero;
		this.telefone = telefone;
		try {
			this.dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Telefone getTelefone() {
		return telefone;
	}
	
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	
	/*public int getIdade() {
		LocalDate start = LocalDate.of();
		int idade = Period.between(start,LocalDate.now()).getYears();
		System.out.println(dataNascimento.getYear());
		System.out.println("Idade dentro da função:" + idade);
		return idade;
	}*/

	public char getGenero() {
		return genero;
	}
	
	public void setGenero(char genero) {
		this.genero = genero;
	}


	@Override
	public int compareTo(Pessoa o) {
		return this.nome.compareTo(o.nome);
	}
	
	
	//Sobrescrevi a função toString()
	//Dessa forma, quando eu chama-lá para o objeto do tipo Pessoa, o resultado será a formatação que eu determinei
	@Override
	public String toString() {
		String info = "Nome: "+ this.nome+"\n"+
	"Telefone: " + telefone.getNumero() +"\n"+
	"Data de Nascimento: "+f.format(dataNascimento) +"\n"+
	"Gênero: " + genero + "\n";
		return info;
	}
}