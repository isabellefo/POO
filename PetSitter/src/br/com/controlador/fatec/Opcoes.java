package br.com.controlador.fatec;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.modelo.fatec.Endereço;
import br.com.modelo.fatec.Profissional;
import br.com.modelo.fatec.Telefone;

public class Opcoes {
	
	public List<Profissional> profissionais = new ArrayList<Profissional>();
	public Scanner scanner = new Scanner(System.in);
	int idP = 0;
	
	public void createProfissional(){
		//Nome
		System.out.println("Insira o nome do profissional:");
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
		
		Profissional p  = new Profissional(phone, address, name, cpf);
		p.setIdProfissional(idP);
		idP++;
		profissionais.add(p);
		System.out.println("Novo Profissional adicionado!");
		
	}
	
	public void createCliente() {
		
	}
}
