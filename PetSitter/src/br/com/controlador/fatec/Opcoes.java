package br.com.controlador.fatec;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.modelo.fatec.Animal;
import br.com.modelo.fatec.Atendimento;
import br.com.modelo.fatec.Cliente;
import br.com.modelo.fatec.Endereço;
import br.com.modelo.fatec.Profissional;
import br.com.modelo.fatec.Telefone;

public class Opcoes {
	
	public List<Profissional> profissionais = new ArrayList<Profissional>();
	public List<Cliente> clientes = new ArrayList<Cliente>();
	public List<Atendimento> atendimentos = new ArrayList<Atendimento>();
	public Scanner scanner = new Scanner(System.in);
	int idP = 0;
	int idC = 0;
	
	public void createProfissional(){
		//Nome
		System.out.println("Insira o nome do profissional:");
		String name = scanner.nextLine();
		
		// Dados de telefone
		System.out.println("Insira o telefone do profissional:");
		String number = scanner.nextLine();
		Telefone phone = new Telefone(number);
		
		// Dados de endereco
		System.out.printf("Insira a cidade: ");
		String cidade = scanner.nextLine();
		System.out.printf("Insira a rua: ");
		String rua = scanner.nextLine();
		System.out.printf("Insira o bairro: ");
		String bairro = scanner.nextLine();
		System.out.printf("Insira o estado: ");
		String estado = scanner.nextLine();
		System.out.printf("Insira o CEP: ");
		String cep = scanner.nextLine();
		Endereço address = new Endereço(rua, bairro, cidade, estado, cep);
		
        
        //CPF	
        System.out.println("Insira o CPF do profissional");
        String cpf = scanner.nextLine();
		
		Profissional p  = new Profissional(phone, address, name, cpf);
		p.setIdProfissional(idP);
		idP++;
		profissionais.add(p);
		System.out.println("Novo Profissional adicionado!");
		
	}
	
	public void createCliente() {
		//Nome
		System.out.println("Insira o nome do cliente:");
		String name = scanner.nextLine();
				
		// Dados de telefone
		System.out.println("Insira o telefone do cliente:");
		String number = scanner.nextLine();
		Telefone phone = new Telefone(number);
				
		// Dados de endereco
		System.out.printf("Insira a cidade: ");
		String cidade = scanner.nextLine();
		System.out.printf("Insira a rua: ");
		String rua = scanner.nextLine();
		System.out.printf("Insira o bairro: ");
		String bairro = scanner.nextLine();
		System.out.printf("Insira o estado: ");
		String estado = scanner.nextLine();
		System.out.printf("Insira o CEP: ");
		String cep = scanner.nextLine();
		Endereço address = new Endereço(rua, bairro, cidade, estado, cep);
				
		        
		//CPF	
		System.out.println("Insira o CPF do cliente");
		String cpf = scanner.nextLine();
		List<Animal> animais = new ArrayList<Animal>();
		
		boolean oneMore = true;
		int cont = 0;
		do{
			System.out.println("Cadastro do seu pet");
			System.out.println("Insira o nome do seu pet:");
			String namePet = scanner.nextLine();
			
			System.out.println("Insira o raça do seu pet:");
			String breed = scanner.nextLine();
			
			System.out.println("Insira a idade do seu pet:");
			String age = scanner.nextLine();
			
			System.out.println("Insira o gênero do seu pet('F'/'M'): ");
	        String Sgenre = scanner.nextLine();
	        char genre = Sgenre.charAt(0);
	        while((genre!='F') && (genre!='M')) {
	        	System.out.println("Digite uma opção válida");
	        	Sgenre = scanner.nextLine();
		        genre = Sgenre.charAt(0);
	        }
			
			Animal _animal = new Animal(namePet, breed, genre, age);
			
			animais.add(_animal);
			
			System.out.println("Deseja cadastrar mais um pet ? SIM(1) / NÃO(2) : ");
			String val = scanner.nextLine();
			oneMore = (val.equals("1")) ? true : false;
			cont++;
			System.out.println(cont);
			
		 }while(oneMore && cont < 5);
		
		Cliente c  = new Cliente(phone, address, name, cpf, animais);
		c.setIdClient(idC);
		idC++;
		clientes.add(c);
		System.out.println("Cliente e seus pets adicionado *-* !");
		
	}
	
	public void createAtendimento() {
		int i=0;
		for (Profissional p : profissionais) {
			System.out.println(p.getNome());
		}
		for (Cliente c : clientes) {
			System.out.println(c.getNome());
			for(i=0; i<c.getAnimal().size();i++) {
				System.out.println(c.getAnimal().get(i).getNome());
			}
		}
	}
}
