package br.com.modelo.fatec;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;



public class Pessoa implements Comparable<Pessoa>{ 
	private String nome;
	private Telefone telefone;
	private char genero;
	private Date dataNascimento;
	
	private int[] qtdProdutos = new int[6];
	
	SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
	public Scanner scanner = new Scanner(System.in);
	
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


	public char getGenero() {
		return genero;
	}
	
	public void setGenero(char genero) {
		this.genero = genero;
	}
	
	@SuppressWarnings("deprecation")
	public int getIdade() {
		GregorianCalendar agora = new GregorianCalendar();
		
		//Data atual
 		int ano = 0, mes = 0, dia = 0;
 		
 		//Data de nascimento
 		int anoNasc = 0, mesNasc = 0, diaNasc = 0;
 		
 		//Idade
 		int idade = 0;
 		
 		if(dataNascimento != null){
 	 		
 			ano = agora.get(Calendar.YEAR);
 	 		mes = agora.get(Calendar.MONTH) + 1;
 	 		dia = agora.get(Calendar.DAY_OF_MONTH);
 	 		
 	 		anoNasc = dataNascimento.getYear() + 1900;
 	 		mesNasc = dataNascimento.getMonth() + 1;
 	 		diaNasc = dataNascimento.getDay();
 	 		
 	 		idade = ano - anoNasc;
 	 		
 	 		// Calculando diferencas de mes e dia.
 	 		if(mes < mesNasc) {
 	 			idade--;
 	 		} else {
 	 			if(dia < diaNasc) {
 	 				idade--;
 	 			}
 	 		}
 	 		
 	 	// Ultimo teste, idade "negativa".
 	 		if(idade < 0) {
 	 			idade = 0;
 	 		}
 	 		
 		}
 		
 		return idade;
 		
	}

	//Sobrescrever o método compareTo para ordenar pelo nome
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
	"Idade: "+getIdade()+ "\n"+
	"Gênero: " + genero;
		return info;
	}
	
	public void alteraNome(){
		System.out.println("Digite o novo nome:");
		String nome = scanner.nextLine();
		this.setNome(nome);
		System.out.println("Nome alterado!");
	}
	
	public void alteraTelefone(){
		System.out.println("Digite o novo telefone:");
		String tel = scanner.nextLine();
		Telefone telefone = new Telefone(tel);
		this.setTelefone(telefone);
		System.out.println("Telefone alterado!");
	}
	
	public void alteraNascimento(){
		System.out.println("Insira a nova data de nascimento:");
		String dataNova = scanner.nextLine(); 
	    Date dataFormatada = null;
		try {
			dataFormatada = f.parse(dataNova);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		this.setDataNascimento(dataFormatada);
		System.out.println("Data de nascimento alterado!");
		
	}
	
	public void alteraGenero(){
		System.out.println("Digite o gênero novo('F' para Feminino e 'M' para Masculino): ");
        char genero = scanner.next().charAt(0);
        scanner.nextLine();
        this.setGenero(genero);
        System.out.println("Gênero alterado!");
	}
	
	public void editaCliente(){
		System.out.println("1- Editar o nome.");
		System.out.println("2- Editar o telefone.");
		System.out.println("3- Editar a data de nascimento");
		System.out.println("4- Editar o gênero");
		int opt = scanner.nextInt();
		scanner.nextLine();/*Chamando o nextLine para evitar futuros erros de entrada devido o nextInt*/
		switch(opt){
		case 1:
			alteraNome();
			break;
		
		case 2:
			alteraTelefone();
			break;
		
		case 3:
			alteraNascimento();
			break;
		
		case 4:
			alteraGenero();
			break;
		
		}
		
	}
	
	public void setQtdProdutos(int i, int qtd) {
		this.qtdProdutos[i] = qtd;
	}
	
	public int getQtdProdutos(int i) {
		return qtdProdutos[i];
	}
	
}