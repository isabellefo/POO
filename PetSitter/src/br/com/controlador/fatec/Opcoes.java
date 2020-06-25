package br.com.controlador.fatec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.com.modelo.fatec.Animal;
import br.com.modelo.fatec.Atendimento;
import br.com.modelo.fatec.Banco;
import br.com.modelo.fatec.Cliente;
import br.com.modelo.fatec.Dados;
import br.com.modelo.fatec.Endere�o;
import br.com.modelo.fatec.Profissional;
import br.com.modelo.fatec.Telefone;
import static java.util.stream.Collectors.*;

import java.text.SimpleDateFormat;
public class Opcoes {
	
	public List<Profissional> profissionais = new ArrayList<Profissional>();
	public List<Cliente> clientes = new ArrayList<Cliente>();
	public List<Atendimento> atendimentos = new ArrayList<Atendimento>();
	public List<Animal> totalAnimais = new ArrayList<Animal>();
	SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
	public Scanner scanner = new Scanner(System.in);
	
	public Banco b = new Banco(System.getProperty("user.dir"));
	int idP = 0;
	int idC = 0;
	Dados d = new Dados();
	
	//M�todo para leitura de dados
	public void leitura() throws Exception {
		d = (Dados) b.ler();
		clientes = d.clientes;
		atendimentos = d.atendimentos;
		profissionais = d.profissionais;
		totalAnimais = d.animais;
	}
	
	//M�todo para salvar dados
	public void salvar() throws Exception {
		d.clientes = clientes;
		d.atendimentos = atendimentos;
		d.profissionais = profissionais;
		d.animais = totalAnimais;
		b.escrever(d);
	}
	
	//Cadastro de profissionais
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
		Endere�o address = new Endere�o(rua, bairro, cidade, estado, cep);
		
        
        //CPF	
        System.out.println("Insira o CPF do profissional");
        String cpf = scanner.nextLine();
		
		Profissional p  = new Profissional(phone, address, name, cpf);
		p.setIdProfissional(idP);
		idP++;
		profissionais.add(p);
		System.out.println("Novo Profissional adicionado!");
		
	}
	
	//Cadastro de cliente e seus animais
	public void createCliente() throws Exception {
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
		Endere�o address = new Endere�o(rua, bairro, cidade, estado, cep);
				
		        
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
			
			System.out.println("Insira o ra�a do seu pet:");
			String breed = scanner.nextLine();
			
			System.out.println("Insira a idade do seu pet:");
			String age = scanner.nextLine();
			
			System.out.println("Insira o g�nero do seu pet('F'/'M'): ");
	        String Sgenre = scanner.nextLine();
	        char genre = Sgenre.charAt(0);
	        while((genre!='F') && (genre!='M')) {
	        	System.out.println("Digite uma op��o v�lida");
	        	Sgenre = scanner.nextLine();
		        genre = Sgenre.charAt(0);
	        }
			
			Animal _animal = new Animal(namePet, breed, genre, age);
			_animal.setIdPet(cont);
			
			animais.add(_animal);
			totalAnimais.add(_animal);
			System.out.println("Deseja cadastrar mais um pet ? SIM(1) / N�O(2) : ");
			String val = scanner.nextLine();
			oneMore = (val.equals("1")) ? true : false;
			cont++;
			
		 }while(oneMore && cont < 5);
		
		Cliente c  = new Cliente(phone, address, name, cpf, animais);
		c.setIdClient(idC);
		idC++;
		clientes.add(c);
		System.out.println("Cliente e seus pets adicionado *-* !");
		
	}
	
	//Cadastro de atendimento
	public void createAtendimento() {
		Profissional pr = null;
		Cliente cl = null;
		Animal an = null;
		
		for (Profissional p : profissionais) {
			System.out.println("["+p.getIdProfissional()+"]"+p.getNome());
		}
		System.out.println("Selecione o profissional pelo seu ID:");
		int idPr = Integer.parseInt(scanner.nextLine());

		for (Profissional p : profissionais) {
			if(p.getIdProfissional() == idPr) {
				pr = p;
				break;
			}
		}	
		
		for (Cliente c : clientes) {
			System.out.println("["+c.getIdClient()+"]"+c.getNome());
			
		}
		
		System.out.println("Selecione o cliente pelo seu ID:");
		int idCl = Integer.parseInt(scanner.nextLine());
		
		for (Cliente c : clientes) {
			if(c.getIdClient() == idCl) {
				cl = c;
				break;
			}
		}
		
		for (Animal a : cl.getAnimal()) {
			System.out.println("["+a.getIdPet()+"]"+a.getNome());
		}
		
		System.out.println("Selecione o pet do cliente pelo seu ID:");
		int idA = Integer.parseInt(scanner.nextLine());
		
		for (Animal a : cl.getAnimal()) {
			if(a.getIdPet() == idA) {
				an = a;
				break;
			}
		}
		
		System.out.println("Insira a data do agendamento(dd/mm/aaaa):");
		String date = scanner.nextLine();
		
		Atendimento _atendimento = new Atendimento(cl, pr, an, date);
		atendimentos.add(_atendimento);		
		System.out.println("Atendimento marcado para a(o) " + an.getNome()+ " !");
		
		
	}
	
	//Relat�rio de hist�rico de atendimento
	public void historicoAtendimento() {
		for (Profissional p : profissionais) {
			System.out.println("["+p.getIdProfissional()+"]"+p.getNome());
		}
		System.out.println("Selecione o profissional pelo seu ID:");
		int idPr = Integer.parseInt(scanner.nextLine());
		for (Atendimento atendimento : atendimentos) {
			if(atendimento.getProfissional().getIdProfissional() == idPr) {
				System.out.println("Dia do atendimento:" + f.format(atendimento.getDate()));
				System.out.println("Nome do Profissional: "+ atendimento.getProfissional().getNome());
				System.out.println("CPF do Profissional:" + atendimento.getProfissional().getCPF());
				System.out.println("Nome do Cliente: "+ atendimento.getCliente().getNome());
				System.out.println("CPF do Cliente:" + atendimento.getCliente().getCPF());
				System.out.println("Nome do Pet:" + atendimento.getAnimal().getNome());
				System.out.println("---------------------------------------");
			}
		}
	}
	
	//Relat�rio de racking de ra�as
	public void ranckingRaca() {
		Map<String, Integer> racas = new HashMap<>();
		System.out.println(totalAnimais.size());
		for (Animal a : totalAnimais) {
			 Integer j = racas.get(a.getRa�a()); 
			 racas.put(a.getRa�a(), (j == null) ? 1 : j + 1); 
		}
		
		 Map<String, Integer> orded = 
		racas.entrySet()
		  .stream()
		  .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
		  .collect(
		            toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
		                    LinkedHashMap::new));
		
		 int k = 1;
		 for (Map.Entry<String,Integer> pair : orded.entrySet()) {
			 if(k<11)
				 System.out.println(k+"�- "+pair.getKey()+": "+pair.getValue());
			 else
				 break;
			 k++;
		}
	}
	
	//Relat�rio de g�nero preferido
	public void generoPreferido() {
		int fem = 0;
		int masc = 0;
		for (Animal a : totalAnimais) {
			if(a.getGenero() == 'F') {
				fem++;
			}else {
				masc++;
			}
		}
		
		System.out.println("Animais do g�nero feminino:" + fem);
		System.out.println("Animais do g�nero masculino:" + masc);
		
		if(fem>masc) {
			System.out.println("O g�nero preferido � o feminino");
		}else if(masc>fem) {
			System.out.println("O g�nero preferido � o masculino");
		}else if(masc == fem){
			System.out.println("N�o h� prefer�ncia de g�nero");
		}
		
	}
}
